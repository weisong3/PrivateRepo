package com.sns_sample;

import android.os.Bundle;
import android.view.Menu;

public class LoginActivity extends BaseActivity {

    public LoginActivity() {
		super(R.string.app_name);
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
