package com.ryoma.coolwanandroid.view.person;

import android.app.Instrumentation;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.SpeedDialog.dialog.SpeedDialog;
import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.base.fragment.BaseMvpFragment;
import com.ryoma.coolwanandroid.contract.person.RegisterFragmentContract;
import com.ryoma.coolwanandroid.di.component.fragment.DaggerRegisterFragmentComponent;
import com.ryoma.coolwanandroid.presenter.person.RegisterFragmentPresenter;
import com.ryoma.coolwanandroid.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * @author eco-ryoma
 * @date 2019/01/25
 * @description 注册fragment
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class RegisterFragment extends BaseMvpFragment<RegisterFragmentPresenter>
        implements RegisterFragmentContract.View {

    @Inject
    RegisterFragmentPresenter mPresenter;
    @BindView(R.id.usernameEdit)
    EditText usernameEdit;
    @BindView(R.id.passwordEdit)
    EditText passwordEdit;
    @BindView(R.id.passwordRepeatEdit)
    EditText passwordRepeatEdit;
    @BindView(R.id.loginBtn)
    TextView loginBtn;
    @BindView(R.id.registerBtn)
    RippleView registerBtn;

    private SpeedDialog dialog;//加载框


    @Override
    protected void inject() {
        DaggerRegisterFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected RegisterFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        registerBtn.setOnRippleCompleteListener(
                v -> {
                    showLoading();
                    mPresenter.register(getEditText(usernameEdit),
                            getEditText(passwordEdit),
                            getEditText(passwordRepeatEdit));
                });
        loginBtn.setOnClickListener(v -> toLoginFragment());
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showLoading() {
        dialog = new SpeedDialog(mActivity, SpeedDialog.PROGRESS_TYPE);
        dialog.setProgressColor(CommonUtils.randomTagColor()).setProgressText("加载中...").show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }


    @Override
    public void showSuccess() {
        dialog.cancel();
        CommonUtils.toastShow(mActivity.getString(R.string.person_register_success));
        toLoginFragment();
    }

    @Override
    public void showErrorView() {
        super.showErrorView();
        dialog.cancel();
    }

    @Override
    public void toLoginFragment() {
        //模拟返回键
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public String getEditText(EditText editText) {
        return editText.getText().toString();
    }

    public static Fragment newInstance() {
        return new RegisterFragment();
    }

}
