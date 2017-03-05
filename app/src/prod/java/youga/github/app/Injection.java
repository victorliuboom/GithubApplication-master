package youga.github.app;

import youga.github.app.api.ApiClient;
import youga.github.app.api.ApiStores;

/**
 * Created by YougaKing on 2017/3/3.
 */

public class Injection {


    public static ApiStores provideApiStores() {
        return ApiClient.retrofit().create(ApiStores.class);
    }

}
