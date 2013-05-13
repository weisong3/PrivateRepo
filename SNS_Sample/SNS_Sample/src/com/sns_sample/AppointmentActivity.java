package com.sns_sample;

import net.simonvt.numberpicker.NumberPicker;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class AppointmentActivity extends FragmentActivity {

	public static void startActivity (Context context) {
		Intent intent = new Intent(context, AppointmentActivity.class);
//		Bundle bundle = new Bundle();
//		bundle.putString(BUNDLE_KEY_USERNAME, username);
//		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        
        Button cancel = (Button) findViewById(R.id.cancel);
        Button proceed = (Button) findViewById(R.id.proceed);
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AppointmentActivity.this.finish();
			}
		});
        
        proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AppointmentActivity.this.finish();
			}
		});
        
        NumberPicker amountNP1 = (NumberPicker) findViewById(R.id.appointment_amount_picker1);
        amountNP1.setMaxValue(9);
        amountNP1.setMinValue(0);
        amountNP1.setFocusable(true);
        amountNP1.setFocusableInTouchMode(true);
        
        NumberPicker amountNP2 = (NumberPicker) findViewById(R.id.appointment_amount_picker2);
        amountNP2.setMaxValue(9);
        amountNP2.setMinValue(0);
        amountNP2.setFocusable(true);
        amountNP2.setFocusableInTouchMode(true);
        
        NumberPicker fromNPHour = (NumberPicker) findViewById(R.id.appointment_from_picker1);
        fromNPHour.setMaxValue(23);
        fromNPHour.setMinValue(0);
        fromNPHour.setFocusable(true);
        fromNPHour.setFocusableInTouchMode(true);
        
        NumberPicker fromNPMinute = (NumberPicker) findViewById(R.id.appointment_from_picker2);
        fromNPMinute.setMaxValue(59);
        fromNPMinute.setMinValue(0);
        fromNPMinute.setFocusable(true);
        fromNPMinute.setFocusableInTouchMode(true);
        
        NumberPicker toNPHour = (NumberPicker) findViewById(R.id.appointment_to_picker1);
        toNPHour.setMaxValue(23);
        toNPHour.setMinValue(0);
        toNPHour.setFocusable(true);
        toNPHour.setFocusableInTouchMode(true);
        
        NumberPicker toNPMinute = (NumberPicker) findViewById(R.id.appointment_to_picker2);
        toNPMinute.setMaxValue(59);
        toNPMinute.setMinValue(0);
        toNPMinute.setFocusable(true);
        toNPMinute.setFocusableInTouchMode(true);
        
        Spinner membershipSpinner = (Spinner) findViewById(R.id.appointment_membership_spinner);
        membershipSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				String str = parent.getItemAtPosition(pos).toString();
				if (str.equals(AppointmentActivity.this.getResources().getString(R.string.profile_member_free))) {
					AppointmentActivity.this.findViewById(R.id.appointment_view_members_profile).setVisibility(View.GONE);
				} else if (str.equals(AppointmentActivity.this.getResources().getString(R.string.profile_member_monthly))) {
					AppointmentActivity.this.findViewById(R.id.appointment_view_members_profile).setVisibility(View.VISIBLE);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

}
