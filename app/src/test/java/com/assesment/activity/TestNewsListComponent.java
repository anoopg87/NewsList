package com.assesment.activity;

import com.assesment.di.AppComponent;

/**
 * Created by Whizz on 9/2/18.
 */


public abstract class TestNewsListComponent implements AppComponent {

     abstract void inject(NewsListActivityPresenterTest presenterTest);

}
