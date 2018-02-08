package com.assesment.interfaces;

import com.assesment.NewsApp;
import com.assesment.model.Facts;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Whizz on 8/2/18.
 */

public class NewsRepositoryImpl implements NewsRepository {

    @Inject
    NewsServiceAPI newsServiceAPI;

    public NewsRepositoryImpl() {

        NewsApp.getInstance().appComponent.inject(this);
    }

    @Override
    public Flowable<Facts> loadNews(){
        return Flowable.fromCallable(() -> newsServiceAPI.getFacts().execute().body());
    }


}
