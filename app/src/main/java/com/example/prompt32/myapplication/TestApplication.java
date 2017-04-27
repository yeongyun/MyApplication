package com.example.prompt32.myapplication;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by prompt32 on 2017-04-26.
 */

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
