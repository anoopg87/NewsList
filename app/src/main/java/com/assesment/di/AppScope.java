package com.assesment.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Whizz on 25/1/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
