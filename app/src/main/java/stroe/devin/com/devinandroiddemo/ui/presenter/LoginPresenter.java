package stroe.devin.com.devinandroiddemo.ui.presenter;

import java.util.Map;

import stroe.devin.com.devinandroiddemo.ui.contract.Contract;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class LoginPresenter extends Contract.LoginPresenter {
    @Override
    public void onStart() {

    }

    @Override
    public void initData(String user,String pass) {
        mRxManager.add(mModel.getData(user,pass).subscribe(flashBean -> mView.showContent(flashBean), throwable -> mView.showError("数据加载失败ヽ(≧Д≦)ノ")));
    }
}
