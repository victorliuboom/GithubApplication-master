package youga.github.app.api;

import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeoutException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

/**
 * Created by liuwei on 2017/3/3.
 */

public abstract class ErrorConsumer implements Consumer<Throwable> {

    public abstract void onError(String error, boolean reappear);

    @Override
    public void accept(@NonNull Throwable e) {
        e.printStackTrace();

        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            Logger.d("code=" + code);
            boolean reappear = false;
            if (code == 504) {
                msg = "网络不给力";
                reappear = true;
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
                reappear = true;
            }
            onError(msg, reappear);
        } else if (e instanceof TimeoutException) {
            onError("网络链接超时", true);
        } else {
            onError(e.getMessage(), false);
        }
    }
}
