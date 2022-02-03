package com.example.kotlindemo._07_functions.lambdas;

import android.os.Build;

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
}
