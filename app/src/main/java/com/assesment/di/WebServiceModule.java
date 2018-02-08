package com.assesment.di;

import com.assesment.interfaces.NewsServiceAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Whizz on 8/2/18.
 */
@Module
public class WebServiceModule {

    @Provides
    @AppScope
    NewsServiceAPI newsServiceAPI(Retrofit retrofit){
        return retrofit.create(NewsServiceAPI.class);
    }

}
