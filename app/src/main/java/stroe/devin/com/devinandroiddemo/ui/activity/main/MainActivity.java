package stroe.devin.com.devinandroiddemo.ui.activity.main;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.hpw.mvpframe.base.CoreBaseActivity;

import butterknife.BindView;
import stroe.devin.com.devinandroiddemo.R;
import stroe.devin.com.devinandroiddemo.ui.fragment.home.HomeFragment;

public class MainActivity extends CoreBaseActivity {
    @BindView(R.id.home_radio_button_group)
    private RadioGroup radioGroup;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            loadRootFragment(R.id.main_viewPager, new HomeFragment());
        }
//        ((RadioGroup)findViewById(R.id.home_radio_button_group)).setOnCheckedChangeListener((radioGroup, i) -> {
//            loadRootFragment(R.id.main_viewPager, new HomeFragment());
//        });
    }
}
