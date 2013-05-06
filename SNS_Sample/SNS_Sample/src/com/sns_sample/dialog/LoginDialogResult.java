package com.sns_sample.dialog;

import android.text.Editable;

import com.sns_sample.dialogs.util.DialogResult;

public interface LoginDialogResult extends DialogResult {
  public void onSignIn(int id, Editable username, Editable password);
  public void onRegister(int id);
}
