package com.haryad.smart12;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;
import android.webkit.*;
public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(Color.rgb(7,18,37));getWindow().setNavigationBarColor(Color.rgb(5,9,20));web=new WebView(this);setContentView(web);WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setDatabaseEnabled(true);s.setAllowFileAccess(true);s.setAllowContentAccess(true);web.setBackgroundColor(Color.rgb(5,9,20));web.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){Uri u=r.getUrl();if("file".equals(u.getScheme()))return false;startActivity(new Intent(Intent.ACTION_VIEW,u));return true;}@Override public boolean shouldOverrideUrlLoading(WebView v,String url){Uri u=Uri.parse(url);if("file".equals(u.getScheme()))return false;startActivity(new Intent(Intent.ACTION_VIEW,u));return true;}});web.loadUrl("file:///android_asset/index.html");}
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
}
