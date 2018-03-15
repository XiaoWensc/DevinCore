package stroe.devin.com.devinandroiddemo.ui.model.login;

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import java.util.Map;

import rx.Observable;
import stroe.devin.com.devinandroiddemo.App;
import stroe.devin.com.devinandroiddemo.api.BaseApi;
import stroe.devin.com.devinandroiddemo.ui.contract.Contract;

/**
 * Created by zengxiaowen on 2018/2/6.
 */

public class LoginModel implements Contract.LoginModel {
    @Override
    public Observable<LoginBean> getData(String user,String pass) {
        return RxService.createApi(BaseApi.class).login(user,pass, App._dynSessConf).compose(RxUtil.rxSchedulerHelper());
    }

}
