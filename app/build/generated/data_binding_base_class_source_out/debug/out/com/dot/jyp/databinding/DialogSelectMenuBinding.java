// Generated by view binder compiler. Do not edit!
package com.dot.jyp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.dot.jyp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogSelectMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView recyclerSelectMenuDialog;

  private DialogSelectMenuBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView recyclerSelectMenuDialog) {
    this.rootView = rootView;
    this.recyclerSelectMenuDialog = recyclerSelectMenuDialog;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogSelectMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogSelectMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_select_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogSelectMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recycler_select_menu_dialog;
      RecyclerView recyclerSelectMenuDialog = rootView.findViewById(id);
      if (recyclerSelectMenuDialog == null) {
        break missingId;
      }

      return new DialogSelectMenuBinding((ConstraintLayout) rootView, recyclerSelectMenuDialog);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
