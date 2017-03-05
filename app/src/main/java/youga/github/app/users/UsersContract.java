package youga.github.app.users;

import java.util.List;

import youga.github.app.BasePresenter;
import youga.github.app.BaseView;
import youga.github.app.bean.User;

/**
 * Created by YougaKing on 2017/3/3.
 */

public class UsersContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showUsers(List<User> tasks);

        void showLoadingUsersError(String error);

        void showNoUsers();

        void notifyItem(User user);

    }

    interface Presenter extends BasePresenter {

        void searchUsers(String terms);
    }
}
