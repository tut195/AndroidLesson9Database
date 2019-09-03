package com.babenkovladimir.androidlesson9database;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.androidlesson9database.preferences.PreferencesActivity;
import com.babenkovladimir.androidlesson9database.room.master_detail_flow.RoomActivity;
import com.babenkovladimir.androidlesson9database.sqlite.SqliteActivity;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.btPrefsActivity)
  Button btPrefs;

  @BindView(R.id.btSqliteActivity)
  Button btSqlite;

  @BindView(R.id.btRoom)
  Button btRoom;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    btPrefs.setOnClickListener(view -> startActivity(new Intent(this, PreferencesActivity.class)));
    btSqlite.setOnClickListener(view -> startActivity(new Intent(this, SqliteActivity.class)));
    btRoom.setOnClickListener(view -> startActivity(new Intent(this, RoomActivity.class)));
  }
}