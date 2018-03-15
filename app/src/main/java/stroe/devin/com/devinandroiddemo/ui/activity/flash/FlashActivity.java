package stroe.devin.com.devinandroiddemo.ui.activity.flash;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.LogUtil;
import com.hpw.mvpframe.utils.SnackbarUtil;

import butterknife.BindView;
import stroe.devin.com.devinandroiddemo.App;
import stroe.devin.com.devinandroiddemo.R;
import stroe.devin.com.devinandroiddemo.ui.activity.login.LoginActivity;
import stroe.devin.com.devinandroiddemo.ui.activity.main.MainActivity;
import stroe.devin.com.devinandroiddemo.ui.contract.Contract;
import stroe.devin.com.devinandroiddemo.ui.model.flash.FlashBean;
import stroe.devin.com.devinandroiddemo.ui.model.flash.FlashModel;
import stroe.devin.com.devinandroiddemo.ui.presenter.flashpresenter.FlashPresenter;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class FlashActivity extends CoreBaseActivity<FlashPresenter,FlashModel> implements Contract.DailyView<FlashBean>{
    @BindView(R.id.launcher)
    private ImageView imageView;
    @BindView(R.id.tvTime)
    private TextView tvTime;
    private CountDownTimer timer;
    private boolean reme = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_flash;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        (imageView = findViewById(R.id.launcher)).setOnClickListener(view -> {
            reme = true;
            timer.cancel();
//            getOperation().addParameter("link",date[1]);
//            getOperation().forward(BaseWebViewActivity.class);
        });
        //设置透明度
        (tvTime = findViewById(R.id.tvTime)).getBackground().setAlpha(100);
        timer = new CountDownTimer(5*1000,1000) {
            @Override
            public void onTick(long l) {
                tvTime.setText("跳过："+l/1000);
            }

            @Override
            public void onFinish() {
                startActivity(LoginActivity.class);
                finish();
            }
        };
        tvTime.setOnClickListener(view -> timer.onFinish());
//        mPresenter.initData();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.showShort(getWindow().getDecorView(),msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null) timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (reme) {
            startActivity(MainActivity.class);
            finish();
        }
    }

    @Override
    public void showContent(FlashBean info) {
        App._dynSessConf = info.getSessionConfirmationNumber();
        Glide.with(this).load(info.getAppStartAd().get(0).getImgUrl()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                timer.onFinish();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                imageView.setVisibility(View.VISIBLE);
                tvTime.setVisibility(View.VISIBLE);
                timer.start();
                return false;
            }
        }).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                imageView.setImageDrawable(resource);
            }
        });
        LogUtil.d(info.toString());
    }
}
