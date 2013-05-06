package com.sns_sample.dialog;

import android.content.Context;
import android.os.HandlerThread;

import com.sns_sample.dialogs.util.DialogFactory;
import com.sns_sample.dialogs.util.DialogHandler;
import com.sns_sample.dialogs.util.DialogResult;

public class LoginDialogFactory extends DialogFactory {
	

	@Override
	public LoginDialogHandler createDialogHandler(Context context, String threadName,
			DialogResult caller) {
		HandlerThread uiThread = new HandlerThread(threadName);
		uiThread.start();
		
		if (caller instanceof LoginDialogResult)
			return new LoginDialogHandler(uiThread.getLooper(),
					context, (LoginDialogResult) caller);
		else
			return null;
	}
	
}
