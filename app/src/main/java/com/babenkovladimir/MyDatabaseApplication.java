package com.babenkovladimir;

import android.app.Application;
import android.content.Context;
import com.babenkovladimir.androidlesson9database.preferences.PrefHelper;

public class MyDatabaseApplication extends Application {

  private static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();

    PrefHelper.initHelper(this);
  }

  public static Context getAppContext() {
    return MyDatabaseApplication.context;
  }
}
