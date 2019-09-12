package com.ryoma.coolwanandroid.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.component.RxBus;
import com.ryoma.coolwanandroid.event.UpdateEvent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 版本更新弹窗
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class VersionUpdateDialog extends DialogFragment {

    private String mContentText = "";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_version_update, null);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setCancelable(false)
                .create();
        // 设置点击屏幕Dialog不消失
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener((dialog1, keyCode, event) -> keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0);
        TextView updateLater = view.findViewById(R.id.updateLaterTv);
        TextView updateNow = view.findViewById(R.id.updateNowTv);
        TextView content = view.findViewById(R.id.versionContentTv);
        content.setText(mContentText);
        updateLater.setOnClickListener(v -> dialog.dismiss());
        updateNow.setOnClickListener(v -> {
            dialog.dismiss();
            RxBus.getInstance().post(new UpdateEvent());
        });
        return dialog;
    }

    public void setContentText(String content) {
        mContentText = content;
    }
}
