package stroe.devin.com.devinandroiddemo.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import stroe.devin.com.devinandroiddemo.ui.model.flash.FlashBean;
import stroe.devin.com.devinandroiddemo.ui.model.login.LoginBean;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public interface BaseApi {
    @POST("rest/model/com/yatang/appStartAd/APPStartAdActor/queryAPPStartAd")
    Observable<FlashBean> getFlashData();

    @FormUrlEncoded
    @POST("rest/model/atg/userprofiling/ProfileActor/login")
    Observable<LoginBean> login(@Field("login") String no,@Field("encryptedPassword") String pass,@Field("_dynSessConf") String _dynSessConf);
}
