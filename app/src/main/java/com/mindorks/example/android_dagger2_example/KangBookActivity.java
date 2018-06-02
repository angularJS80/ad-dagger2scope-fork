package com.mindorks.example.android_dagger2_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.mindorks.example.android_dagger2_example.di.component.DaggerSeoulActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.SeoulActivityComponent;
import com.mindorks.example.android_dagger2_example.di.module.ActivityModule;
import com.mindorks.example.android_dagger2_example.webview.AppCallByJs;

import java.util.HashMap;
import java.util.Map;

public class KangBookActivity extends AppCompatActivity {

    private SeoulActivityComponent seoulActivityComponent;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kang_book);
        getSeoulActivityComponent().inject(this);
        settingWebView();
        //testJsCall();


    }

    public void settingWebView(){
        webView = (WebView) findViewById(R.id.webView); //webview statement
        webView.getSettings().setJavaScriptEnabled(true); // javascript 와 연동하게 하는 옵션
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true); // 돔에서 사용중인 스토리지를 사용하게 해주는 옵션 (웹쿠키 저장등
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new AppCallByJs(this),"appCallByJs");

        webView.loadUrl("https://m.daemyungresort.com/");
        //webView.loadUrl("http://211.249.60.229");
        //webView.loadUrl("http://172.30.1.16:4200/filelist");

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

    public void testJsCall(){
        Map map = new HashMap();
        map.put("name","Android");
        JsCallByAndroid(this.webView,map);
    }
    public void JsCallByAndroid(final WebView webView, final Map paramMap) {
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                Gson gson = new Gson();
                String dataString = gson.toJson(paramMap);
                view.loadUrl("javascript:alert('" + dataString +"')");

                view.loadUrl("javascript:appCallByJs.doAndroidToast('" + dataString +"')");


            }
        });
    }

}
