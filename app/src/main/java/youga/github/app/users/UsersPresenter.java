package youga.github.app.users;


import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import youga.github.app.api.ApiClient;
import youga.github.app.api.ApiStores;
import youga.github.app.api.ErrorConsumer;
import youga.github.app.bean.Repository;
import youga.github.app.bean.User;
import youga.github.app.bean.UserForm;

/**
 * Created by YougaKing on 2017/3/3.
 */

public class UsersPresenter implements UsersContract.Presenter {

    CompositeDisposable mDisposable;
    ApiStores mApiStores;
    UsersContract.View mView;

    public UsersPresenter(@NonNull UsersContract.View view) {
        mView = view;
        mApiStores = ApiClient.retrofit().create(ApiStores.class);
        mDisposable = new CompositeDisposable();
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        mDisposable.clear();
    }

    @Override
    public void searchUsers(String terms) {
        mView.setLoadingIndicator(true);
        mDisposable.add(mApiStores.searchUsers(terms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userForm -> {
                    if (userForm.getItems() == null || userForm.getItems().isEmpty()) {
                        mView.showNoUsers();
                    } else {
                        getRepositories(userForm);
                        mView.showUsers(userForm.getItems());
                    }
                }, new ErrorConsumer() {
                    @Override
                    public void onError(String error, boolean reappear) {
                        mView.showLoadingUsersError(error);
                        if (reappear) searchUsers(terms);
                    }
                }, () -> mView.setLoadingIndicator(false)));
    }


    private void getRepositories(UserForm userForm) {

        mDisposable.add(Observable.fromIterable(userForm.getItems())
                .filter(user -> user.getReference_language() == null)
                .concatMap(new Function<User, ObservableSource<User>>() {
                    @Override
                    public ObservableSource<User> apply(@NonNull User user) throws Exception {
                        return mApiStores.getRepositories(user.getLogin())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .zipWith(Observable.fromCallable(() -> user), (repositories, o) -> {
                                    user.setRepositories(repositories);
                                    Map<String, Integer> map = new HashMap<>();
                                    Observable.fromIterable(repositories)
                                            .filter(repository -> repository.getLanguage() != null)
                                            .map(Repository::getLanguage)
                                            .subscribe(s -> {
                                                if (map.get(s) != null) {
                                                    map.put(s, map.get(s) + 1);
                                                } else {
                                                    map.put(s, 1);
                                                }
                                            });
                                    Observable.fromIterable(map.keySet())
                                            .scan((s, s2) -> map.get(s) > map.get(s2) ? s : s2)
                                            .lastElement()
                                            .subscribe(user::setReference_language);
                                    return user;
                                });
                    }
                }).map(user -> {
                    if (user.getRepositories().isEmpty() || user.getReference_language().isEmpty())
                        user.setReference_language("No Repository");
                    return user;
                }).subscribe(user -> mView.notifyItem(user),
                        new ErrorConsumer() {
                            @Override
                            public void onError(String error, boolean reappear) {
                                Logger.d(error);
                                if (reappear) getRepositories(userForm);
                            }
                        }));
    }
}
