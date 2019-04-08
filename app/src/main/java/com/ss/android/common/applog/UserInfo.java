package com.ss.android.common.applog;

public class UserInfo {

    static {
        try {
            System.loadLibrary("cms");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static native String a();

    public static native String getDescription();

    public static native String getFile();

    public static native String getFingerprint();

    public static native void getPackage(String str);

    public static native String getS();

    public static native byte[] getT();

    public static native int getTemperature();

    public static native int getType();

    public static native String getUserInfo(int i, String str, String[] strArr);

    public static native String getUserInfo(int i, String str, String[] strArr, String str2);

    public static native String getUserInfo(int i, String[] strArr, String[] strArr2, String str);

    public static native String getUserInfoSkipGet(int i, String str, String[] strArr);

    public static native int initUser(String str);

    public static native int isR();

    public static native void setAppId(int i);
}
