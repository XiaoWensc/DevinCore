package stroe.devin.com.devinandroiddemo.ui.contract;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

import java.util.Map;

import rx.Observable;
import stroe.devin.com.devinandroiddemo.ui.model.flash.FlashBean;
import stroe.devin.com.devinandroiddemo.ui.model.login.LoginBean;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public interface Contract {
    //启动页接口
    abstract class FlashPresenter extends CoreBasePresenter<FlashModel,DailyView<FlashBean>>{
        public abstract void initData();
    }

    //登陆
    abstract class LoginPresenter extends CoreBasePresenter<LoginModel,DailyView<LoginBean>>{
        public abstract void initData(String user,String pass);
    }

    interface LoginModel extends CoreBaseModel {
        Observable<LoginBean> getData(String user,String pass);
    }

    interface FlashModel extends CoreBaseModel {
        Observable<FlashBean> getData();
    }

    interface DailyView<T> extends CoreBaseView {
        void showContent(T info);
    }
}
