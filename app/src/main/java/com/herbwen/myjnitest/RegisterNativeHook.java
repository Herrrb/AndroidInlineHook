package com.herbwen.myjnitest;

import android.support.annotation.CallSuper;
import android.util.Log;

public class RegisterNativeHook {
//    public native static void hook();

    public RegisterNativeHook(){
        Log.d("test", "herbwen");
    }

    @SuppressWarnings("rawtypes")
    public static void getClassName(Class clazz){

        String className = clazz.getCanonicalName();
        Log.d("herbwen", className);

    }

    public static String getHookSoName() {
        return "libcms.so";
    }
}
