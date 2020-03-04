package com.whitney.nyaradzowalkathon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;

public class Website extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private WebView mWebView;
    private CoordinatorLayout coordinatorLayout;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        mWebView = findViewById(R.id.activity_main_webview);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(Website.this);
        swipeRefreshLayout.setProgressViewOffset(false,
                getResources().getDimensionPixelSize(R.dimen.refresher_offset),
                getResources().getDimensionPixelSize(R.dimen.refresher_offset_end));
        coordinatorLayout = findViewById(R.id.container);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                swipeRefreshLayout.setRefreshing(true);
            }

            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        mWebView.setWebViewClient(new Callback());
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        loadWebsite();
    }

    private void loadWebsite() {
        ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            mWebView.loadUrl("http://www.friendsoftheenvironment.co.zw");
        } else {
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please check your internet connection.", Snackbar.LENGTH_LONG);
            snackbar.show();
            swipeRefreshLayout.setRefreshing(false);
            TextView valueTV = new TextView(this);
            valueTV.setText(R.string.no_internet_connection);
            valueTV.setGravity(Gravity.CENTER);
            valueTV.setLayoutParams(new CoordinatorLayout.LayoutParams(
                    CoordinatorLayout.LayoutParams.FILL_PARENT,
                    CoordinatorLayout.LayoutParams.WRAP_CONTENT));
            coordinatorLayout.addView(valueTV);
        }
    }

    @Override
    public void onRefresh() {
        mWebView.reload();
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public class Callback extends WebViewClient {
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(getApplicationContext(), "Failed loading app!", Toast.LENGTH_SHORT).show();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.endsWith(".pdf")) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                return true;
            } else if (url.contains("mailto:")) {
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                return true;
            } else if (url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                startActivity(intent);
                return true;
            } else {
                view.loadUrl(url);
                return true;
            }
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            swipeRefreshLayout.setRefreshing(true);
        }

        public void onPageFinished(WebView view, String url) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}