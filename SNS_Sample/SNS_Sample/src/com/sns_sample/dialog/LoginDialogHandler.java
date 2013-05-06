package com.sns_sample.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.sns_sample.R;
import com.sns_sample.dialogs.util.DialogFactory;
import com.sns_sample.dialogs.util.DialogHandler;

public class LoginDialogHandler extends DialogHandler {

	private Dialog dialog;
	private Context mContext;
	private LoginDialogResult caller;
	private int id = 0;

	public LoginDialogHandler(Looper looper, Context context, LoginDialogResult caller) {
		super(looper);
		this.mContext = context;
		this.caller = caller;
	}
	
	
	
	public void setContext(Context mContext) {
		this.mContext = mContext;
	}
	
	
	
	public void setCaller(LoginDialogResult caller) {
		this.caller = caller;
	}
	
	

	@Override
	public void handleMessage(final Message msg) {
		Bundle data = msg.getData();
		switch (msg.what) {
		case DISPLAY_DIALOG:
			Log.i(getClass().getName(), "displaying dialog");
			AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
			builder.setTitle(data.getString(DialogFactory.title));
			if(msg.getData().getString(DialogFactory.message) != null) {
				builder.setMessage(msg.getData().getString(DialogFactory.message));
			}
			
			LayoutInflater factory = LayoutInflater.from(getContext());
			final View view = factory.inflate(R.layout.fragment_login, null);
			final EditText usernameEditText = (EditText) view.findViewById(R.id.login_username_edittext);
			final EditText passwordEditText = (EditText) view.findViewById(R.id.login_password_edittext);
			
			this.id = data.getInt(DialogFactory.id);
			
			builder.setView(view);
			String positiveText = data.getString(DialogFactory.positiveBtn);
			if (positiveText == null) {
				positiveText = getContext().getResources().getString(R.string.login_submit); 
			}
			builder.setPositiveButton(positiveText, new OnClickListener() {
				public void onClick(DialogInterface dialog, int arg1) {
					dialog.dismiss();
					caller.onSignIn(id, usernameEditText.getText(), passwordEditText.getText());
				}
			});
			String negativeText = data.getString(DialogFactory.negativeBtn);
			if (null == negativeText) {
				negativeText = getContext().getResources().getString(R.string.login_register);
			}
			builder.setNegativeButton(negativeText, new OnClickListener() {
				public void onClick(DialogInterface dialog, int arg1) {
					dialog.dismiss();
					caller.onRegister(id);
				}
			});
			builder.setCancelable(false);
			dialog = builder.create();
			dialog.show();
			break;
		case DISMISS_DIALOG:
			if (dialog != null) {
				dialog.dismiss();
			}
			break;
		default:
			break;
		}
	}
	
	public Context getContext() {
		return this.mContext;
	}
	
	public LoginDialogResult getCallback() {
		return this.caller;
	}
}
