package com.sns_sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;

import com.sns_sample.dialog.LoginDialogFactory;
import com.sns_sample.dialog.LoginDialogHandler;
import com.sns_sample.dialog.LoginDialogResult;

public class LoginActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        LoginDialogHandler handler = new LoginDialogFactory().createDialogHandler(this, "login fragment", new LoginDialogResult() {
			
			@Override
			public void onSignIn(int id, Editable username, Editable password) {
				MainActivity.startActivity(username.toString(), LoginActivity.this);
			}
			
			@Override
			public void onRegister(int id) {
				// TODO Auto-generated method stub
				
			}
		});
        LoginDialogFactory.showDialog(handler, getResources().getString(R.string.login_title), null, "", 0);
    }

}
