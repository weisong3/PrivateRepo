package com.sns_sample;

import net.simonvt.numberpicker.NumberPicker;
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

public class ProfileActivity extends FragmentActivity {

	public static void startActivity (Context context) {
		Intent intent = new Intent(context, ProfileActivity.class);
//		Bundle bundle = new Bundle();
//		bundle.putString(BUNDLE_KEY_USERNAME, username);
//		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        Button cancel = (Button) findViewById(R.id.cancel);
        Button proceed = (Button) findViewById(R.id.proceed);
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProfileActivity.this.finish();
			}
		});
        
        proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProfileActivity.this.finish();
			}
		});        
        NumberPicker np1 = (NumberPicker) findViewById(R.id.profile_agepicker1);
        np1.setMaxValue(9);
        np1.setMinValue(0);
        np1.setFocusable(true);
        np1.setFocusableInTouchMode(true);
        
        NumberPicker np2 = (NumberPicker) findViewById(R.id.profile_agepicker2);
        np2.setMaxValue(9);
        np2.setMinValue(0);
        np2.setFocusable(true);
        np2.setFocusableInTouchMode(true);
    }

}
