package youga.github.app.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import youga.github.app.bean.Repository;
import youga.github.app.bean.UserForm;

/**
 * Created by liuwei on 2017/3/3.
 */

public interface ApiStores {

    String API_SERVER_URL = "https://api.github.com/";

    @GET("search/users")
    Observable<UserForm> searchUsers(@Query("q") String terms);

    @GET("users/{loginName}/repos")
    Observable<List<Repository>> getRepositories(@Path("loginName") String loginName);

}
