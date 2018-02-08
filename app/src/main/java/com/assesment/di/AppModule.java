package com.assesment.di;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.annotation.Nonnull;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Whizz on 25/1/18.
 */

@Module
public class AppModule {
    private Context appContext;

    public AppModule(@Nonnull Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @AppScope
    Context provideContext(){
        return appContext;
    }


    @Provides
    @AppScope
    Picasso providePicasso(Context context){
        return Picasso.with(context);
    }


}
