package com.mindorks.example.android_dagger2_example.webview;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.mindorks.example.android_dagger2_example.KangBookActivity;

/**
 * Created by yongbeom on 2018. 6. 2..
 */

public class AppCallByJs {
    Context mContext;

    public AppCallByJs(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void doAndroidToast(String keyword) {
        Log.d("javascriptCalled",keyword);
        Toast.makeText(mContext,"Android Toast",Toast.LENGTH_LONG);
    }

}
