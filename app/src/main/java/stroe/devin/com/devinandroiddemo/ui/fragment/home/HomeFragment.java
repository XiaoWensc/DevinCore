package stroe.devin.com.devinandroiddemo.ui.fragment.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hpw.mvpframe.CoreApp;
import com.hpw.mvpframe.base.CoreBaseFragment;

import butterknife.BindView;
import stroe.devin.com.devinandroiddemo.App;
import stroe.devin.com.devinandroiddemo.R;
import stroe.devin.com.devinandroiddemo.widget.webview.UIWebView;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class HomeFragment extends CoreBaseFragment {

    @BindView(R.id.uiWebView)
    private UIWebView uiWebView;
    @BindView(R.id.iv_sao_sao)
    private ImageView iv_sao_sao;
    @BindView(R.id.search_layout)
    private TextView search_layout;
    @BindView(R.id.index_myLocation)
    private TextView index_myLocation;
    @BindView(R.id.container_view)
    private View container_view;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
//        container_view.getBackground().setAlpha(0);
//        search_layout.getBackground().setAlpha(200);
//        uiWebView.setOnScrollChangedCallback((dx, dy) -> {
//            //这里我们根据dx和dy参数做自己想做的事情
//            container_view.getBackground().setAlpha(dy / 2 > 255 ? 255 : dy / 2);
//            if (dy > 200) {
//                iv_sao_sao.setImageResource(R.mipmap.ic_saoma_b);
//                search_layout.getBackground().setAlpha(255);
//                index_myLocation.setTextColor(Color.parseColor("#000000"));
//            } else {
//                iv_sao_sao.setImageResource(R.mipmap.ic_saoma);
//                index_myLocation.setTextColor(getResources().getColor(R.color.white));
//                search_layout.getBackground().setAlpha(200);
//            }
//        });
//
//        uiWebView.loadUrl(App.getInstance().setBaseUrl()+"ym/home/");
    }
}
