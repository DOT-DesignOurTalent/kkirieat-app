// Generated by view binder compiler. Do not edit!
package com.dot.jyp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.dot.jyp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button loginAutoBtn;

  @NonNull
  public final ImageView loginAutoImg;

  @NonNull
  public final LinearLayout loginAutoLl;

  @NonNull
  public final Button loginBtn;

  @NonNull
  public final EditText loginEmailEdittext;

  @NonNull
  public final Button loginFindPwdBtn;

  @NonNull
  public final ImageView loginLogoImg;

  @NonNull
  public final TextView loginNoAccountText;

  @NonNull
  public final Button loginNonMemberBtn;

  @NonNull
  public final EditText loginPwdEdittext;

  @NonNull
  public final Button loginRegisterBtn;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button loginAutoBtn,
      @NonNull ImageView loginAutoImg, @NonNull LinearLayout loginAutoLl, @NonNull Button loginBtn,
      @NonNull EditText loginEmailEdittext, @NonNull Button loginFindPwdBtn,
      @NonNull ImageView loginLogoImg, @NonNull TextView loginNoAccountText,
      @NonNull Button loginNonMemberBtn, @NonNull EditText loginPwdEdittext,
      @NonNull Button loginRegisterBtn) {
    this.rootView = rootView;
    this.loginAutoBtn = loginAutoBtn;
    this.loginAutoImg = loginAutoImg;
    this.loginAutoLl = loginAutoLl;
    this.loginBtn = loginBtn;
    this.loginEmailEdittext = loginEmailEdittext;
    this.loginFindPwdBtn = loginFindPwdBtn;
    this.loginLogoImg = loginLogoImg;
    this.loginNoAccountText = loginNoAccountText;
    this.loginNonMemberBtn = loginNonMemberBtn;
    this.loginPwdEdittext = loginPwdEdittext;
    this.loginRegisterBtn = loginRegisterBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.login_auto_btn;
      Button loginAutoBtn = rootView.findViewById(id);
      if (loginAutoBtn == null) {
        break missingId;
      }

      id = R.id.login_auto_img;
      ImageView loginAutoImg = rootView.findViewById(id);
      if (loginAutoImg == null) {
        break missingId;
      }

      id = R.id.login_auto_ll;
      LinearLayout loginAutoLl = rootView.findViewById(id);
      if (loginAutoLl == null) {
        break missingId;
      }

      id = R.id.login_btn;
      Button loginBtn = rootView.findViewById(id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.login_email_edittext;
      EditText loginEmailEdittext = rootView.findViewById(id);
      if (loginEmailEdittext == null) {
        break missingId;
      }

      id = R.id.login_find_pwd_btn;
      Button loginFindPwdBtn = rootView.findViewById(id);
      if (loginFindPwdBtn == null) {
        break missingId;
      }

      id = R.id.login_logo_img;
      ImageView loginLogoImg = rootView.findViewById(id);
      if (loginLogoImg == null) {
        break missingId;
      }

      id = R.id.login_no_account_text;
      TextView loginNoAccountText = rootView.findViewById(id);
      if (loginNoAccountText == null) {
        break missingId;
      }

      id = R.id.login_non_member_btn;
      Button loginNonMemberBtn = rootView.findViewById(id);
      if (loginNonMemberBtn == null) {
        break missingId;
      }

      id = R.id.login_pwd_edittext;
      EditText loginPwdEdittext = rootView.findViewById(id);
      if (loginPwdEdittext == null) {
        break missingId;
      }

      id = R.id.login_register_btn;
      Button loginRegisterBtn = rootView.findViewById(id);
      if (loginRegisterBtn == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, loginAutoBtn, loginAutoImg,
          loginAutoLl, loginBtn, loginEmailEdittext, loginFindPwdBtn, loginLogoImg,
          loginNoAccountText, loginNonMemberBtn, loginPwdEdittext, loginRegisterBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}