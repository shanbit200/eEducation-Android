package io.agora.education.classroom.bean.msg;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.agora.education.classroom.bean.JsonBean;

public class PeerMsg extends JsonBean {

    @Type
    @SerializedName("cmd")
    public int type;
    public String data;

    public PeerMsg(@NonNull SubMsg data) {
        this.type = data.type;
        this.data = data.toJsonString();
    }

    @IntDef({Type.CO_VIDEO})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        int CO_VIDEO = 1; // co-video msg
    }

    public static abstract class SubMsg extends JsonBean {
        @ChannelMsg.Type
        public transient int type;
    }

    public static class CoVideoMsg extends SubMsg {
        @Cmd
        @SerializedName("operate")
        public int cmd;
        public String account;

        @IntDef({Cmd.APPLY_CO_VIDEO, Cmd.REJECT_CO_VIDEO})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Cmd {
            int APPLY_CO_VIDEO = 105;
            int REJECT_CO_VIDEO = 107;
        }

        public CoVideoMsg(@Cmd int cmd, String account) {
            this.type = Type.CO_VIDEO;
            this.cmd = cmd;
            this.account = account;
        }
    }

    public <T extends SubMsg> T getMsg() {
        TypeToken<T> typeToken = new TypeToken<T>() {
        };
        return new Gson().fromJson(data, typeToken.getType());
    }

}
