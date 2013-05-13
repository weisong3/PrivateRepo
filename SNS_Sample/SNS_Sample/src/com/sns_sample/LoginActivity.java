package com.sns_sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;

import com.sns_sample.dialog.LoginDialogFactory;
import com.sns_sample.dialog.LoginDialogHandler;
import com.sns_sample.dialog.LoginDialogResult;
import com.sns_sample.dialog.RegisterDialogFactory;
import com.sns_sample.dialog.RegisterDialogHandler;
import com.sns_sample.dialog.RegisterDialogResult;

public class LoginActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        showLoginDialog();
    }

	private void showLoginDialog() {
		 LoginDialogHandler handler = new LoginDialogFactory().createDialogHandler(this, "login fragment", new LoginDialogResult() {
				
				@Override
				public void onSignIn(int id, Editable username, Editable password) {
					MainActivity.startActivity(username.toString(), LoginActivity.this);
				}
				
				@Override
				public void onRegister(int id) {
					showRegisterDialog();
				}
			});
	        LoginDialogFactory.showDialog(handler, getResources().getString(R.string.login_title), null, "", 0);
	}

	protected void showRegisterDialog() {
		RegisterDialogHandler regHandler = new RegisterDialogFactory().createDialogHandler(this, "register fragment", new RegisterDialogResult() {
			
			@Override
			public void onRegister(int id, Editable username, Editable password,
					Editable repassword) {
				showLoginDialog();
			}
			
			@Override
			public void onCancell(int id) {
				showLoginDialog();
			}
		});
		RegisterDialogFactory.showDialog(regHandler, getResources().getString(R.string.login_register), null, "", 0);
	}

}
