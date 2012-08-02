package cc.co.ratan.www;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Syllabus extends Activity {
	
	WebView mWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://ratan.co.cc/syllabus.html");
    }
}


