package com.lmy.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.lmy.dagger2.models.User;
import com.lmy.dagger2.ui.auth.AuthActivity;
import com.lmy.dagger2.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    SessionManager sessionManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        subscribeObservers();
    }

    private void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if(userAuthResource != null) {
                    switch (userAuthResource.status) {

                        case LOADING:{
                            break;
                        }

                        case AUTHENTICATED:{
                            Log.d(TAG, "onChanged: LOGIN SUCCESS: " + userAuthResource.data.getEmail());
                            break;
                        }

                        case ERROR:{
                            Log.e(TAG, "onChanged: " + userAuthResource.message);
                            break;
                        }

                        case NOT_AUTHENTICATED:{
                            navLoginScreen();
                            break;
                        }
                    }
                }
            }
        });
    }

    private void navLoginScreen() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
