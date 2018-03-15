package stroe.devin.com.devinandroiddemo.ui.model.flash;

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;
import rx.Observable;
import stroe.devin.com.devinandroiddemo.api.BaseApi;
import stroe.devin.com.devinandroiddemo.ui.contract.Contract;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class FlashModel implements Contract.FlashModel {


    @Override
    public Observable<FlashBean> getData() {
        return RxService.createApi(BaseApi.class).getFlashData().compose(RxUtil.rxSchedulerHelper());
    }
}
