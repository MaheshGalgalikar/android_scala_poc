package roid.com.bluey.activity;

import android.app.Activity;
import android.os.Bundle;

import roid.com.bluey.R;


public class BlueyActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bluey);
    setTitle("Bluey");
  }
}
