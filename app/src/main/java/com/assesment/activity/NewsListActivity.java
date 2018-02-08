package com.assesment.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.assesment.adapter.FactsAdapter;
import com.assesment.magazineapp.R;
import com.assesment.model.Row;
import com.assesment.util.ConnectionLookup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Whizz on 8/2/18.
 */

public class NewsListActivity extends AppCompatActivity implements NewsListActivityView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.itemsRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    FactsAdapter factsAdapter;

    NewsListActivityPresenter newsListActivityPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list_activity);
        ButterKnife.bind(this);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        setupNewsList();
        newsListActivityPresenter=new NewsListActivityPresenter(this);
        swipeRefreshLayout.post(() -> {
            swipeRefreshLayout.setRefreshing(true);
           loadNews();
        });
        swipeRefreshLayout.setOnRefreshListener(this::loadNews);

    }

    private void loadNews(){
        if(ConnectionLookup.isConnectingToInternet(this)) {
            newsListActivityPresenter.loadNews();
        }else showErrorMessage(R.string.connection_error);
    }

    private void setupNewsList() {
        factsAdapter=new FactsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(factsAdapter);
    }

    @Override
    public void setTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void displayNews(List<Row> rows) {
        swipeRefreshLayout.setRefreshing(false);
        if(null==factsAdapter)factsAdapter=new FactsAdapter();
        factsAdapter.addFacts(rows);
    }

    @Override
    public void showErrorMessage(int strId) {
        swipeRefreshLayout.setRefreshing(false);
        Snackbar.make(findViewById(android.R.id.content),getString(R.string.something_went_wrong),Snackbar.LENGTH_LONG).show();
    }
}

