package com.example.cordovatest2;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;

public class MainActivity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        //loadUrl("http://192.168.3.46:8081/community/www/index.html");
        //loadUrl("http://192.168.3.40:8080/www/index.html");
    }

}
