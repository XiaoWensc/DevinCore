package stroe.devin.com.devinandroiddemo.ui.presenter.flashpresenter;

import rx.functions.Action1;
import stroe.devin.com.devinandroiddemo.ui.contract.Contract;
import stroe.devin.com.devinandroiddemo.ui.model.flash.FlashBean;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class FlashPresenter extends Contract.FlashPresenter {

    @Override
    public void onStart() {
        initData();
    }

    @Override
    public void initData() {
        mRxManager.add(mModel.getData().subscribe(flashBean -> mView.showContent(flashBean), throwable -> mView.showError("数据加载失败ヽ(≧Д≦)ノ")
        ));
    }
}
