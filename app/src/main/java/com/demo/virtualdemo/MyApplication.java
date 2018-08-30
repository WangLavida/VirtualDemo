package com.demo.virtualdemo;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.didi.virtualapk.PluginManager;

import java.io.File;

/**
 * Created by W.J on 2018/8/30.
 */

public class MyApplication extends Application{
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
        PluginManager pluginManager = PluginManager.getInstance(base);
        File plugin = new File(Environment.getExternalStorageDirectory(),"com.demo.virtualplugin.apk");
        if(plugin.exists()){
            Log.i("存在","存在");
        }else {
            Log.i("不存在","不存在");
        }
        try {
            pluginManager.loadPlugin(plugin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
