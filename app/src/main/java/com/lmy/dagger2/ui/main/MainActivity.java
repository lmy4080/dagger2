package com.lmy.dagger2.ui.main;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.lmy.dagger2.BaseActivity;
import com.lmy.dagger2.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
    }
}
