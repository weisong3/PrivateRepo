package com.sns_sample;

import java.util.ArrayList;

import com.sns_sample.adapters.ActionGridViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	private static final String BUNDLE_KEY_USERNAME = "username";
	private static final int USER_ROLE_SUPERUSER = 0;
	private static final int USER_ROLE_CUSTOMER = 1;
	private static final int USER_ROLE_WORKER = 2;
	private static final int USER_ROLE_MANAGER = 3;
	private static final String[] ACTION_ARRAY_GENERAL = {
		"Browe My Profile"};
	private static final String[] ACTION_ARRAY_CUSTOMER = {
		"Invite People Over",
		"Make An Future Appointment"};
	private static final String[] ACTION_ARRAY_WORKER = {
		"Work For Money"};
	private static final String[] ACTION_ARRAY_MANAGER = {
		"Manage Appointments"};

	private GridView actionGridView;
	private TextView greetingTextView;
	
	private ActionGridViewAdapter adapter;

//	public MainActivity() {
//		super(R.string.app_name);
//		// TODO Auto-generated constructor stub
//	}

	public static void startActivity (String username, Context context) {
		Intent intent = new Intent(context, MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString(BUNDLE_KEY_USERNAME, username);
		intent.putExtras(bundle);
		context.startActivity(intent);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		setIntent(intent);
		super.onNewIntent(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionGridView = (GridView) findViewById(R.id.main_gridView_action);
		greetingTextView = (TextView) findViewById(R.id.main_textView_greeting);
	}

	@Override
	protected void onResume() {
		super.onResume();
		String username = getIntent().getExtras().getString(BUNDLE_KEY_USERNAME);
		greetingTextView.setText(getResources().getString(R.string.main_greeting_1)
				+ username
				+ getResources().getString(R.string.main_greeting_2));
		
		if(adapter == null) {
			adapter = new ActionGridViewAdapter(getUsersActionList(username), this);
			actionGridView.setAdapter(adapter);
		} else {
			adapter.updateActionList(getUsersActionList(username));
		}
	}
	
	private ArrayList<String> getUsersActionList(String username){
		//for demo
		int userRole = USER_ROLE_SUPERUSER;//superuser
		if (username == "1") {//for customer
			userRole = USER_ROLE_CUSTOMER;
		} else if (username == "2") {// for worker
			userRole = USER_ROLE_WORKER;
		} else if (username == "3") {// for manager
			userRole = USER_ROLE_MANAGER;
		}
		
		ArrayList<String> actionList = new ArrayList<String>();
		for(int i = 0; i < ACTION_ARRAY_GENERAL.length; ++i) {
			actionList.add(ACTION_ARRAY_GENERAL[i]);
		}
		if(userRole == USER_ROLE_CUSTOMER) {
			for(int i = 0; i < ACTION_ARRAY_CUSTOMER.length; ++i) {
				actionList.add(ACTION_ARRAY_CUSTOMER[i]);
			}
		}else if(userRole == USER_ROLE_WORKER) {
			for(int i = 0; i < ACTION_ARRAY_WORKER.length; ++i) {
				actionList.add(ACTION_ARRAY_WORKER[i]);
			}
		}else if(userRole == USER_ROLE_MANAGER) {
			for(int i = 0; i < ACTION_ARRAY_MANAGER.length; ++i) {
				actionList.add(ACTION_ARRAY_MANAGER[i]);
			}
		}else if(userRole == USER_ROLE_SUPERUSER) {
			for(int i = 0; i < ACTION_ARRAY_CUSTOMER.length; ++i) {
				actionList.add(ACTION_ARRAY_CUSTOMER[i]);
			}
			for(int i = 0; i < ACTION_ARRAY_WORKER.length; ++i) {
				actionList.add(ACTION_ARRAY_WORKER[i]);
			}
			for(int i = 0; i < ACTION_ARRAY_MANAGER.length; ++i) {
				actionList.add(ACTION_ARRAY_MANAGER[i]);
			}
		}
		return actionList;
	}
	
}
