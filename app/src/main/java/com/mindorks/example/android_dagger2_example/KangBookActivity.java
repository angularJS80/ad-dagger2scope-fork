package com.mindorks.example.android_dagger2_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.example.android_dagger2_example.di.SeoulActivity;
import com.mindorks.example.android_dagger2_example.di.component.ActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.DaggerActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.DaggerSeoulActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.SeoulActivityComponent;
import com.mindorks.example.android_dagger2_example.di.module.ActivityModule;

public class KangBookActivity extends AppCompatActivity {

    private SeoulActivityComponent seoulActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kang_book);

        getSeoulActivityComponent().inject(this);
    }

    public SeoulActivityComponent getSeoulActivityComponent() {
        if (seoulActivityComponent == null) {

            seoulActivityComponent = DaggerSeoulActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();


        }
        return seoulActivityComponent;
    }
}
