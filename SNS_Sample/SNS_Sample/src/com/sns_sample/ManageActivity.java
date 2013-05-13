package com.sns_sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sns_sample.dialog.LoginDialogFactory;
import com.sns_sample.dialog.LoginDialogHandler;
import com.sns_sample.dialog.LoginDialogResult;

public class ManageActivity extends FragmentActivity {

	public static void startActivity (Context context) {
		Intent intent = new Intent(context, ManageActivity.class);
//		Bundle bundle = new Bundle();
//		bundle.putString(BUNDLE_KEY_USERNAME, username);
//		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        
        Button cancel = (Button) findViewById(R.id.cancel);
        Button proceed = (Button) findViewById(R.id.proceed);
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ManageActivity.this.finish();
			}
		});
        
        proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ManageActivity.this.finish();
			}
		});       
    }

}
