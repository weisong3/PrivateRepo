package com.sns_sample.dialog;

import android.content.Context;
import android.os.HandlerThread;

import com.sns_sample.dialogs.util.DialogFactory;
import com.sns_sample.dialogs.util.DialogHandler;
import com.sns_sample.dialogs.util.DialogResult;

public class RegisterDialogFactory extends DialogFactory {
	

	@Override
	public RegisterDialogHandler createDialogHandler(Context context, String threadName,
			DialogResult caller) {
		HandlerThread uiThread = new HandlerThread(threadName);
		uiThread.start();
		
		if (caller instanceof RegisterDialogResult)
			return new RegisterDialogHandler(uiThread.getLooper(),
					context, (RegisterDialogResult) caller);
		else
			return null;
	}
	
}
