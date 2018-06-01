package com.mindorks.example.android_dagger2_example.di.component;

import android.app.Application;
import android.content.Context;

import com.mindorks.example.android_dagger2_example.DemoApplication;
import com.mindorks.example.android_dagger2_example.data.DataManager;
import com.mindorks.example.android_dagger2_example.data.DbHelper;
import com.mindorks.example.android_dagger2_example.data.SharedPrefsHelper;
import com.mindorks.example.android_dagger2_example.di.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext // 어플리케이션 컨텍스트를 찾아보니 범위를 지정하는 스코프였다. 그렇다면 이범위에 들어와 있는 컨텍스트 세터가 있을것이다.
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
