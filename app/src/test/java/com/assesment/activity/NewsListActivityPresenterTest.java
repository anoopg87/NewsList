package com.assesment.activity;

import com.assesment.interfaces.NewsRepository;
import com.assesment.magazineapp.R;
import com.assesment.model.Facts;
import com.assesment.model.Row;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import io.reactivex.Flowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Whizz on 8/2/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class NewsListActivityPresenterTest {


    @Mock
    NewsRepository newsRepository;

    @Mock
    NewsListActivityView newsListActivityView;



    @Test public void shouldPassTitleToView()  {

        Facts facts=new Facts();
        facts.setTitle("title");
        facts.setRows(Arrays.asList(new Row(),new Row(),new Row()));
        Flowable<Facts> fac=Flowable.just(facts);

        NewsListActivityPresenter presenter=new NewsListActivityPresenter(newsListActivityView);


        Mockito.when(newsRepository.loadNews()).thenReturn(fac);

        presenter.loadNews();

        Mockito.verify(newsListActivityView).setTitle("Title");

    }

    @Test public void shouldPassNewsToView() {

        Facts facts=new Facts();
        facts.setTitle("title");
        facts.setRows(Arrays.asList(new Row(),new Row(),new Row()));
        Flowable<Facts> fac=Flowable.just(facts);

        NewsListActivityPresenter presenter=new NewsListActivityPresenter(newsListActivityView, Schedulers.trampoline());
        RxJavaPlugins.setIoSchedulerHandler(schedules-> Schedulers.io());

        Mockito.when(newsRepository.loadNews()).thenReturn(fac);

        presenter.loadNews();

        Mockito.verify(newsListActivityView).displayNews(Arrays.asList(new Row(),new Row(),new Row()));

    }

    @Test public void shouldPassErrorMessageToView()  {

        NewsListActivityPresenter presenter=new NewsListActivityPresenter(newsListActivityView, Schedulers.trampoline());
        RxJavaPlugins.setIoSchedulerHandler(schedules-> Schedulers.io());

        Mockito.when(newsRepository.loadNews()).thenThrow(new Throwable());

        presenter.loadNews();

        Mockito.verify(newsListActivityView).showErrorMessage(R.string.something_went_wrong);
    }


}