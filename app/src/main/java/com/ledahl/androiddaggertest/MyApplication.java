package com.ledahl.androiddaggertest;

import android.app.Application;

import com.ledahl.androiddaggertest.injector.component.AppComponent;
import com.ledahl.androiddaggertest.injector.component.DaggerAppComponent;
import com.ledahl.androiddaggertest.injector.module.RestServiceModule;

public class MyApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        buildInjector();
    }

    private void buildInjector() {
        appComponent = DaggerAppComponent.builder()
                .restServiceModule(new RestServiceModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
