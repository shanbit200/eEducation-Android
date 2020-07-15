package io.agora.education.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import io.agora.base.ToastManager;
import io.agora.base.annotation.OS;
import io.agora.base.annotation.Terminal;
import io.agora.base.callback.ThrowableCallback;
import io.agora.education.BuildConfig;
import io.agora.education.EduApplication;
import io.agora.education.R;
import io.agora.education.widget.ConfirmDialog;
import io.agora.log.LogManager;
import io.agora.log.UploadManager;

public class LogUtil {

    public static void upload(@NonNull FragmentActivity context, @Nullable String roomId) {
        UploadManager.upload(context, new UploadManager.UploadParam(
                BuildConfig.API_BASE_URL,
                "edu/v1/log/params?osType=" + OS.ANDROID + "&terminalType=" + Terminal.PHONE,
                EduApplication.getAppId(),
                BuildConfig.CODE,
                BuildConfig.VERSION_NAME,
                roomId,
                LogManager.getPath().getAbsolutePath(),
                "edu/v1/log/sts/callback"
        ) {{
            host = BuildConfig.API_BASE_URL;
            if (TextUtils.isEmpty(EduApplication.getAppId())) {
                appId = "default";
            } else {
                appId = EduApplication.getAppId();
            }
            appCode = BuildConfig.CODE;
            appVersion = BuildConfig.VERSION_NAME;
            uploadPath = LogManager.getPath().getAbsolutePath();
        }}, new ThrowableCallback<String>() {
            @Override
            public void onSuccess(String res) {
                ConfirmDialog.single(context.getString(R.string.upload_success) + "\n" + res, confirm -> {
                    if (confirm) {
                        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        if (manager != null) {
                            manager.setPrimaryClip(ClipData.newPlainText("LogNumber", res));
                            ToastManager.showShort(context.getString(R.string.clipboard));
                        }
                    }
                }).show(context.getSupportFragmentManager(), null);
            }

            @Override
            public void onFailure(Throwable throwable) {
                ToastManager.showShort(throwable.getMessage());
            }
        });
    }

}
