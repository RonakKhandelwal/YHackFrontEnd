package com.example.leetcoderecommendation.ui.notifications;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.applozic.mobicomkit.api.account.register.RegistrationResponse;
import com.applozic.mobicomkit.uiwidgets.uilistener.KmActionCallback;
import com.example.leetcoderecommendation.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KMLoginHandler;
import io.kommunicate.callbacks.KmCallback;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private static final String INVALID_APP_ID = "INVALID_APPLICATIONID";

    private static final String TAG = "NotificationsFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        FloatingActionButton fab_chat = root.findViewById(R.id.fb_new_chat);
        fab_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Logging in..");
                progressDialog.setMessage("Please wait...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                Kommunicate.loginAsVisitor(getActivity(), new KMLoginHandler() {

                    @Override
                    public void onSuccess(RegistrationResponse registrationResponse, Context context) {
                        progressDialog.dismiss();
                        Kommunicate.openConversation(context, new KmCallback() {
                            @Override
                            public void onSuccess(Object message) {
                                Log.d(TAG, "onSuccess() called with: message = [" + message + "]");
                            }

                            @Override
                            public void onFailure(Object error) {
                                Log.d(TAG, "onFailure() called with: error = [" + error + "]");
                            }
                        });
                    }

                    @Override
                    public void onFailure(RegistrationResponse registrationResponse, Exception exception) {
                        progressDialog.dismiss();
                        createLoginErrorDialog(registrationResponse, exception);
                    }
                });
            }
        });
        return root;
    }

    public void createLoginErrorDialog(RegistrationResponse registrationResponse, Exception exception) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setCancelable(true);
        StringBuilder message = new StringBuilder(getString(R.string.some_error_occured));
        if (registrationResponse != null) {
            if (!TextUtils.isEmpty(getInvalidAppIdError(registrationResponse))) {
                message.append(" : ");
                message.append(getInvalidAppIdError(registrationResponse));
            }
        } else if (exception != null) {
            message.append(" : ");
            message.append(exception.getMessage());
        }

        dialogBuilder.setMessage(message.toString());
        dialogBuilder.show();
    }

    public String getInvalidAppIdError(RegistrationResponse registrationResponse) {
        if (registrationResponse != null) {
            if (registrationResponse.getMessage() != null && INVALID_APP_ID.equals(registrationResponse.getMessage())) {
                return getString(R.string.inavild_app_id_error);
            } else {
                return registrationResponse.getMessage();
            }
        }
        return "";
    }
}