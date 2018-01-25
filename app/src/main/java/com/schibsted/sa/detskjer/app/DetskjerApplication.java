package com.schibsted.sa.detskjer.app;

import android.app.Application;

import com.schibsted.sa.detskjer.dagger.AppComponent;
import com.schibsted.sa.detskjer.dagger.AppModule;
import com.schibsted.sa.detskjer.dagger.DaggerAppComponent;

public class DetskjerApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(DetskjerApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
