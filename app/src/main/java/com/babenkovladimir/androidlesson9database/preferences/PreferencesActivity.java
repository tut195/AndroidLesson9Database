package com.babenkovladimir.androidlesson9database.preferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.babenkovladimir.androidlesson9database.R;
import com.babenkovladimir.androidlesson9database.preferences.PrefHelper;

public class PreferencesActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_preferences);

    PrefHelper.setVal("Key", "Value");
  }
}
