package com.herbwen.myjnitest;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.herbwen.loadcms.LoadTes;

public class MainActivity extends AppCompatActivity {

    public static String error;

    static {
//        try{
//            System.loadLibrary("cms");
//        }catch (Exception e){
//            error = e.toString();
//        }
        System.loadLibrary("JniTest");
        System.loadLibrary("JniAttack");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hook();
        System.loadLibrary("cms");
//        System.loadLibrary("JniTest");
        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hookPuts();
                Toast.makeText(MainActivity.this, getThirdString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public native String getThirdString();

    public native void hook();

    public native void hookPuts();

}
