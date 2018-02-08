package com.assesment.activity;

import com.assesment.model.Row;

import java.util.List;

/**
 * Created by Whizz on 8/2/18.
 */

public interface NewsListActivityView {

    void setTitle(String title);

    void displayNews(List<Row> rows);

    void showErrorMessage(int strId);

}
