package com.demo.virtualdemo;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.LoadedPlugin;

import java.io.File;

public class MainActivity extends AppCompatActivity {
   private Button btn2A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity_main);
        btn2A = findViewById(R.id.btn_toA);

        btn2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadedPlugin loadedPlugin =PluginManager.getInstance(MainActivity.this).getLoadedPlugin("com.demo.virtualplugin");
                if(loadedPlugin == null){
                    Toast.makeText(MainActivity.this,"apk加载失败",Toast.LENGTH_LONG).show();
                    return;
                }
                Log.i("插件版本:",loadedPlugin.getPackageInfo().versionCode+"");
                Intent intent = new Intent();
                intent.setClassName("com.demo.virtualplugin", "com.demo.virtualplugin.MainActivity");
                startActivity(intent);
            }
        });
    }
}
