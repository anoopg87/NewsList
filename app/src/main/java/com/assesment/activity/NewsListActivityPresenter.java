package com.assesment.activity;

import com.assesment.interfaces.NewsRepositoryImpl;
import com.assesment.magazineapp.R;
import com.assesment.model.Facts;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Whizz on 8/2/18.
 */

public class NewsListActivityPresenter {

    private NewsListActivityView view;


    public NewsListActivityPresenter(NewsListActivityView view) {
        this.view = view;

    }

    public void loadNews(){
       NewsRepositoryImpl newsRepository=new NewsRepositoryImpl();
       Flowable<Facts> facts=newsRepository.loadNews();
        facts.observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe(fact->{
                   view.setTitle(fact.getTitle());
                   view.displayNews(fact.getRows());
               },throwable -> view.showErrorMessage(R.string.something_went_wrong));
    }
}
