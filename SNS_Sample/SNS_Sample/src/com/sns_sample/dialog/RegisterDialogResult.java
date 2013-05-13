package com.sns_sample.dialog;

import android.text.Editable;

import com.sns_sample.dialogs.util.DialogResult;

public interface RegisterDialogResult extends DialogResult {
  public void onRegister(int id, Editable username, Editable password, Editable repassword);
  public void onCancell(int id);
}
