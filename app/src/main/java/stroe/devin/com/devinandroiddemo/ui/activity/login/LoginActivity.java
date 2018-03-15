package stroe.devin.com.devinandroiddemo.ui.activity.login;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Observable;
import stroe.devin.com.devinandroiddemo.R;
import stroe.devin.com.devinandroiddemo.ui.contract.Contract;
import stroe.devin.com.devinandroiddemo.ui.model.login.LoginBean;
import stroe.devin.com.devinandroiddemo.ui.model.login.LoginModel;
import stroe.devin.com.devinandroiddemo.ui.presenter.LoginPresenter;
import stroe.devin.com.devinandroiddemo.utils.ToolPassEncry;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class LoginActivity extends CoreBaseActivity<LoginPresenter,LoginModel> implements Contract.DailyView<LoginBean>{

    @BindView(R.id.til_account)
    private TextInputLayout til_account;
    @BindView(R.id.til_password)
    private TextInputLayout til_password;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        til_account = findViewById(R.id.til_account);
        til_password = findViewById(R.id.til_password);
        setToolBar(toolbar,"登录");
        findViewById(R.id.sign_in_button).setOnClickListener(view -> {
            String account = til_account.getEditText().getText().toString();
            String password = til_password.getEditText().getText().toString();

            til_account.setErrorEnabled(false);
            til_password.setErrorEnabled(false);

            //验证用户名和密码
            if(validateAccount(account)&&validatePassword(password)){
                mPresenter.initData(account,ToolPassEncry.YLPWDEncrypt(password));
            }

        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(LoginBean info) {
        LogUtil.d(info.toString());
    }

    /**
     * 显示错误提示，并获取焦点
     * @param textInputLayout
     * @param error
     */
    private void showError(TextInputLayout textInputLayout, String error){
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    /**
     * 验证用户名
     * @param account
     * @return
     */
    private boolean validateAccount(String account){
        if(TextUtils.isEmpty(account)){
            showError(til_account,"用户名不能为空");
            return false;
        }
        return true;
    }

    /**
     * 验证密码
     * @param password
     * @return
     */
    private boolean validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            showError(til_password,"密码不能为空");
            return false;
        }

        if (password.length() < 6 || password.length() > 18) {
            showError(til_password,"密码长度为6-18位");
            return false;
        }

        return true;
    }
}
