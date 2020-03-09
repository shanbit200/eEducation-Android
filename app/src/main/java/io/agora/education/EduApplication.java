package io.agora.education;

import android.app.Application;

import io.agora.base.LogManager;
import io.agora.base.PreferenceManager;
import io.agora.base.ToastManager;
import io.agora.education.service.bean.response.AppConfig;

public class EduApplication extends Application {

    public static EduApplication instance;

    public AppConfig config = new AppConfig() {{
        one2OneStudentLimit = 1;
        smallClassStudentLimit = 16;
    }};

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        PreferenceManager.init(this);
        ToastManager.init(this);
        LogManager.setTagPre("education_");
    }

}
