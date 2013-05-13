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

public class WorkActivity extends FragmentActivity {

	public static void startActivity (Context context) {
		Intent intent = new Intent(context, WorkActivity.class);
//		Bundle bundle = new Bundle();
//		bundle.putString(BUNDLE_KEY_USERNAME, username);
//		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button proceed = (Button) findViewById(R.id.proceed);
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				WorkActivity.this.finish();
			}
		});
        
        proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				WorkActivity.this.finish();
			}
		});         
        NumberPicker fromNPHour = (NumberPicker) findViewById(R.id.work_from_picker1);
        fromNPHour.setMaxValue(23);
        fromNPHour.setMinValue(0);
        fromNPHour.setFocusable(true);
        fromNPHour.setFocusableInTouchMode(true);
        
        NumberPicker fromNPMinute = (NumberPicker) findViewById(R.id.work_from_picker2);
        fromNPMinute.setMaxValue(59);
        fromNPMinute.setMinValue(0);
        fromNPMinute.setFocusable(true);
        fromNPMinute.setFocusableInTouchMode(true);
        
        NumberPicker toNPHour = (NumberPicker) findViewById(R.id.work_to_picker1);
        toNPHour.setMaxValue(23);
        toNPHour.setMinValue(0);
        toNPHour.setFocusable(true);
        toNPHour.setFocusableInTouchMode(true);
        
        NumberPicker toNPMinute = (NumberPicker) findViewById(R.id.work_to_picker2);
        toNPMinute.setMaxValue(59);
        toNPMinute.setMinValue(0);
        toNPMinute.setFocusable(true);
        toNPMinute.setFocusableInTouchMode(true);
    }

}
