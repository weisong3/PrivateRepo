package com.sns_sample.dialogs.util;

import android.os.Handler;
import android.os.Looper;

public class DialogHandler extends Handler {

	public static final int DISPLAY_DIALOG = 0;
	public static final int DISMISS_DIALOG = 1;
	
	public DialogHandler(Looper looper) {
		super(looper);
	}
	
}
