package com.ryoma.coolwanandroid.view.person;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.SpeedDialog.dialog.SpeedDialog;
import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.app.Constant;
import com.ryoma.coolwanandroid.app.User;
import com.ryoma.coolwanandroid.base.fragment.BaseMvpFragment;
import com.ryoma.coolwanandroid.contract.person.PersonFragmentContract;
import com.ryoma.coolwanandroid.presenter.person.PersonFragmentPresenter;
import com.ryoma.coolwanandroid.utils.StatusBarUtil;
import com.ryoma.coolwanandroid.view.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import info.hoang8f.widget.FButton;

import static android.app.Activity.RESULT_OK;

/**
 * @author eco-ryoma
 * @date 2019/01/24
 * @description 个人模块
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class PersonFragment extends BaseMvpFragment<PersonFragmentPresenter> implements PersonFragmentContract.View {

    @Inject
    PersonFragmentPresenter mPresenter;
    @BindView(R.id.personLoginButton)
    FButton mPersonLoginButton;
    @BindView(R.id.personUsernameTv)
    TextView mPersonUsernameTv;
    @BindView(R.id.personLogout)
    TextView mPersonLogout;
    @BindView(R.id.collectionRelative)
    RelativeLayout mCollectionRelative;
    @BindView(R.id.settingRelative)
    RelativeLayout mSettingRelative;
    @BindView(R.id.aboutUsRelative)
    RelativeLayout mAboutUsRelative;

    @Override
    protected void inject() {
        ((MainActivity) getActivity())
                .getComponent()
                .getPersonFragmentComponent()
                .inject(this);
    }

    @Override
    protected PersonFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        if (User.getInstance().isLoginStatus()) {
            showLogin();
        } else {
            showLogout();
        }
        mPersonLoginButton.setButtonColor(getResources().getColor(R.color.colorPrimaryDark));
        mPersonLoginButton.setOnClickListener(v -> startActivity(new Intent(mActivity, LoginActivity.class)));
        mPersonLogout.setOnClickListener(v -> logout());
        mCollectionRelative.setOnClickListener(v -> {
            if (User.getInstance().isLoginStatus()) {
                startActivity(new Intent(mActivity, CollectionActivity.class));
            } else {
                LoginActivity.startActivityForResultByFragment(mActivity, this, Constant.REQUEST_COLLECTION_ACTIVITY);
                showToast(getString(R.string.first_login));
            }
        });
        mSettingRelative.setOnClickListener(v -> startActivity(new Intent(mActivity, SettingActivity.class)));
        mAboutUsRelative.setOnClickListener(v -> startActivity(new Intent(mActivity, AboutUsActivity.class)));

    }

    @Override
    protected void loadData() {
        mPresenter.subscribeEvent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav_person;
    }

    @Override
    public void setStatusBarColor() {
        StatusBarUtil.immersiveInFragments(mActivity, Color.TRANSPARENT, 1);
    }

    @Override
    public void showLogin() {
        mPersonLoginButton.setVisibility(View.GONE);
        mPersonUsernameTv.setVisibility(View.VISIBLE);
        mPersonLogout.setVisibility(View.VISIBLE);
        mPersonUsernameTv.setText(User.getInstance().getUsername());
    }

    @Override
    public void showLogout() {
        mPersonLoginButton.setVisibility(View.VISIBLE);
        mPersonLogout.setVisibility(View.GONE);
        mPersonUsernameTv.setVisibility(View.GONE);
    }

    private void logout() {
        new SpeedDialog(mActivity).setTitle(getString(R.string.dialog_title))
                .setMessage(getString(R.string.dialog_text))
                .setSureClickListener(dialog -> mPresenter.logout())
                .show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;
        switch (requestCode) {
            case Constant.REQUEST_COLLECTION_ACTIVITY:
                startActivity(new Intent(mActivity, CollectionActivity.class));
                break;
            default:
                break;
        }
    }


}
