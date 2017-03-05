package youga.github.app.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuwei on 2017/3/3.
 */

public class ApiClient {

    private static Retrofit mRetrofit;

    public static synchronized Retrofit retrofit() {
        if (mRetrofit == null) {
            synchronized (ApiClient.class) {
                if (mRetrofit == null) {
                    OkHttpClient okHttpClient = new OkHttpClient
                            .Builder()
                            .addInterceptor(new LogInterceptor())
                            .build();

                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(ApiStores.API_SERVER_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(okHttpClient)
                            .build();
                }
            }
        }
        return mRetrofit;
    }
}
