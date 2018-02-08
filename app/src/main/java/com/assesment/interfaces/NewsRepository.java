package com.assesment.interfaces;

import com.assesment.model.Facts;

import io.reactivex.Flowable;

/**
 * Created by Whizz on 8/2/18.
 */

public interface NewsRepository {

    Flowable<Facts> loadNews();
}
