package com.example.kotlindemo.functions.lambdas;

import static android.view.View.GONE;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import java.util.function.Consumer;

public class LambdaJava {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void processResponse(String response, Consumer<ResponseEnum> callback) {
        if (!response.trim().isEmpty()) {
            callback.accept(ResponseEnum.SUCCESS);
        } else {
            callback.accept(ResponseEnum.FAILURE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){
        processResponse("", new Consumer<ResponseEnum>() {
            @Override
            public void accept(ResponseEnum responseEnum) {
                System.out.println(responseEnum);
            }
        });
//        processResponse("", new Callback<ResponseEnum>() {
//            @Override
//            public void onResponseParsed(ResponseEnum responseEnum) {
//                System.out.println(responseEnum);
//            }
//        });
    }

    interface Callback<T> {
        public void onResponseParsed(T t);
    }






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
