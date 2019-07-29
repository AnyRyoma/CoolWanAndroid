package com.example.coolwanandroid.view.person;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.SpeedDialog.dialog.SpeedDialog;
import com.example.coolwanandroid.R;
import com.example.coolwanandroid.app.App;
import com.example.coolwanandroid.base.fragment.BaseMvpFragment;
import com.example.coolwanandroid.contract.person.LoginFragmentContract;
import com.example.coolwanandroid.di.component.fragment.DaggerLoginFragmentComponent;
import com.example.coolwanandroid.presenter.person.LoginFragmentPresenter;
import com.example.coolwanandroid.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author eco-ryoma
 * @date 2019/01/24
 * @description 登录fragment
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class LoginFragment extends BaseMvpFragment<LoginFragmentPresenter>
        implements LoginFragmentContract.View {


    @Inject
    LoginFragmentPresenter mPresenter;
    @BindView(R.id.usernameEdit)
    EditText mUsernameEdit;
    @BindView(R.id.passwordEdit)
    EditText mPasswordEdit;
    @BindView(R.id.loginBtn)
    RippleView mLoginBtn;
    @BindView(R.id.registerBtn)
    TextView mRegisterBtn;

    private SpeedDialog dialog;

    @Override
    public void showLoading() {
        dialog = new SpeedDialog(mActivity, SpeedDialog.PROGRESS_TYPE);
        dialog.setProgressColor(CommonUtils.randomTagColor()).setProgressText("加载中...").show();
    }

    @Override
    protected void inject() {
        DaggerLoginFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected LoginFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        //触摸反馈结束后执行
        mLoginBtn.setOnRippleCompleteListener(rippleView -> {
            if (TextUtils.isEmpty(getEditText(mUsernameEdit))) {
                showToast(mActivity.getString(R.string.login_username_empty));
            } else if (TextUtils.isEmpty(getEditText(mPasswordEdit))) {
                showToast(mActivity.getString(R.string.login_password_empty));
            } else {
                showLoading();
                mPresenter.login(getEditText(mUsernameEdit), getEditText(mPasswordEdit));
            }
        });
        mRegisterBtn.setOnClickListener(v -> ((LoginActivity) getActivity()).toRegisterFragment());
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showErrorView() {
        super.showErrorView();
        dialog.cancel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void showLoginSuccess() {
        dialog.cancel();
        showToast(getString(R.string.person_login_success));
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public String getEditText(EditText editText) {
        return editText.getText().toString();
    }

    public static Fragment newInstance() {
        return new LoginFragment();
    }
}
