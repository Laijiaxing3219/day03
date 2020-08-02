package com.example.day03mvpchouqu.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;



import com.example.day03mvpchouqu.R;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class LoadingDialog extends Dialog {
    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
    }
}
