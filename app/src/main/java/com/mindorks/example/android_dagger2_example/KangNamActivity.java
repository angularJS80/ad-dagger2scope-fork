package com.mindorks.example.android_dagger2_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.example.android_dagger2_example.di.component.SeoulActivityComponent;

public class KangNamActivity extends AppCompatActivity {
    private SeoulActivityComponent seoulActivityComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kang_nam);
    }
}
