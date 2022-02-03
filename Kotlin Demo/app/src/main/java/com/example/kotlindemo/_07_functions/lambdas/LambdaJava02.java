package com.example.kotlindemo._07_functions.lambdas;

import static android.view.View.GONE;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

public class LambdaJava02 {

    Button button;
    Spinner spinner;

    // Java Style
    View.OnLongClickListener onLongClickListener = v -> {
        v.setVisibility(GONE);
        return true;
    };

    @RequiresApi(Build.VERSION_CODES.M)
    public void setListener(){
        button.setOnLongClickListener(onLongClickListener);
//        button.setOnContextClickListener(onLongClickListener)
    }
}
