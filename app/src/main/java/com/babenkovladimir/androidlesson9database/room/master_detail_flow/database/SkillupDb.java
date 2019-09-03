package com.babenkovladimir.androidlesson9database.room.master_detail_flow.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.babenkovladimir.MyDatabaseApplication;
import com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.entity.BankCardR;

@Database(entities = {BankCardR.class}, version = 1)
public abstract class SkillupDb extends RoomDatabase {

  private static SkillupDb INSTANCE;

  public static SkillupDb getAppDatabase() {
    if (INSTANCE == null) {
      INSTANCE =
          Room.databaseBuilder(MyDatabaseApplication.getAppContext(), SkillupDb.class, "skillup.db")
              // allow queries on the main thread.
              // Don't do this on a real app! See PersistenceBasicSample for an example.
              .allowMainThreadQueries()
              .build();
    }
    return INSTANCE;
  }

  public abstract BankCardDao bankCardDao();
}