package com.mindorks.example.android_dagger2_example.di.component;

import com.mindorks.example.android_dagger2_example.KangBookActivity;
import com.mindorks.example.android_dagger2_example.KangNamActivity;
import com.mindorks.example.android_dagger2_example.MainActivity;
import com.mindorks.example.android_dagger2_example.di.PerActivity;
import com.mindorks.example.android_dagger2_example.di.SeoulActivity;
import com.mindorks.example.android_dagger2_example.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by janisharali on 08/12/16.
 */

@SeoulActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface SeoulActivityComponent {

    void inject(KangBookActivity kangBookActivity);

    void inject(KangNamActivity kangNamActivity);
}
