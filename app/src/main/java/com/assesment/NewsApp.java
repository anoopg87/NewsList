package com.assesment;

import android.app.Application;

import com.assesment.di.AppComponent;
import com.assesment.di.AppModule;
import com.assesment.di.DaggerAppComponent;
import com.assesment.di.OkHttpModule;
import com.assesment.di.RetrofitModule;
import com.assesment.di.WebServiceModule;
import com.assesment.util.Constant;


public class NewsApp extends Application {

    public static NewsApp mInstance;

    public AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(mInstance))
                .okHttpModule(new OkHttpModule())
                .retrofitModule(new RetrofitModule(Constant.BASE_URL))
                .webServiceModule(new WebServiceModule()).build();

    }

    public static NewsApp getInstance()
    {
        return mInstance;
    }


}
