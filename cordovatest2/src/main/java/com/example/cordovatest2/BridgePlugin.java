package com.example.cordovatest2;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by gzhuo on 2016/8/1.
 */
public class BridgePlugin extends CordovaPlugin {
    private CallbackContext mCallbackContext;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d("gaozhuo", "initialize");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d("gaozhuo", "execute action=" + action);
        mCallbackContext = callbackContext;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mCallbackContext.success("调用成功");

            }
        }).start();

        //mCallbackContext.success("调用成功");

        return true;
    }

    @Override
    public Boolean shouldAllowBridgeAccess(String url) {
        Log.d("gaozhuo", "shouldAllowBridgeAccess");
        return true;
    }

}
