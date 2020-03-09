package io.agora.education.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;
import java.util.Map;

import io.agora.base.Callback;
import io.agora.base.ToastManager;
import io.agora.base.network.BusinessException;
import io.agora.base.network.RetrofitManager;
import io.agora.education.EduApplication;
import io.agora.education.service.bean.ResponseBody;

public class BaseCallback<T> extends RetrofitManager.Callback<ResponseBody<T>> {

    public BaseCallback(@NonNull SuccessCallback<T> callback) {
        super(0, new Callback<ResponseBody<T>>() {
            @Override
            public void onSuccess(ResponseBody<T> res) {
                callback.onSuccess(res.data);
            }

            @Override
            public void onFailure(Throwable throwable) {
                checkError(throwable);
            }
        });
    }

    public BaseCallback(@NonNull SuccessCallback<T> success, @Nullable FailureCallback failure) {
        super(0, new Callback<ResponseBody<T>>() {
            @Override
            public void onSuccess(ResponseBody<T> res) {
                success.onSuccess(res.data);
            }

            @Override
            public void onFailure(Throwable throwable) {
                checkError(throwable);
                if (failure != null) {
                    failure.onFailure(throwable);
                }
            }
        });
    }

    private static void checkError(Throwable throwable) {
        if (throwable instanceof BusinessException) {
            Locale locale = Locale.getDefault();
            if (!Locale.SIMPLIFIED_CHINESE.toString().equals(locale.toString())) {
                locale = Locale.US;
            }
            Map<String, Map<Integer, String>> languages = EduApplication.instance.config.multiLanguage;
            if (languages != null) {
                String key = String.format("%s-%s", locale.getLanguage(), locale.getCountry()).toLowerCase();
                Map<Integer, String> stringMap = languages.get(key);
                if (stringMap != null) {
                    String message = stringMap.get(((BusinessException) throwable).getCode());
                    ToastManager.showShort(message);
                }
            }
        }
    }

    public interface SuccessCallback<T> {
        void onSuccess(T data);
    }

    public interface FailureCallback {
        void onFailure(Throwable throwable);
    }

}
