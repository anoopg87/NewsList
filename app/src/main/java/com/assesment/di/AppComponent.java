package com.assesment.di;

import com.assesment.NewsApp;
import com.assesment.adapter.FactsAdapter;
import com.assesment.interfaces.NewsRepositoryImpl;

import dagger.Component;

/**
 * Created by Whizz on 25/1/18.
 */
@AppScope
@Component(modules = {AppModule.class,OkHttpModule.class,RetrofitModule.class,WebServiceModule.class})
public interface AppComponent {
    void inject(NewsApp app);
    void inject(NewsRepositoryImpl newsRepository);
    void inject(FactsAdapter adapter);
}
