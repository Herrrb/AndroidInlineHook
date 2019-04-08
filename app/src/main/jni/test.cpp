//
// Created by Herrrb on 2019/2/27.
//
#include <jni.h>
#include <cstdlib>
#include <Android/log.h>
#define TAG "MainActivity"
#include "com_herbwen_myjnitest_MainActivity.h"

JNIEXPORT jstring JNICALL Java_com_herbwen_myjnitest_MainActivity_getFirString
    (JNIEnv * env, jobject object) {
  return env -> NewStringUTF("This is First String");
  }

/*
 * Class:     com_herbwen_myjnitest_MainActivity
 * Method:    getSecString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_herbwen_myjnitest_MainActivity_getSecString
  (JNIEnv * env, jclass clazz){
  return env -> NewStringUTF("This is Second String");
  }

jstring native_String(JNIEnv *env, jobject object) {
    return env -> NewStringUTF("This is Third String");
}

static JNINativeMethod getMethods[] =
    {{"getThirdString", "()Ljava/lang/String;", (void *) native_String}};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv *env = nullptr;
    jint result = JNI_FALSE;

    if(vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK)
        return result;

    if(env == nullptr)
        return result;

    jclass clazz = env -> FindClass("com/herbwen/myjnitest/MainActivity");
    if(clazz == nullptr)
        return result;


    if(env -> RegisterNatives(clazz, getMethods, sizeof(getMethods) / sizeof(getMethods[0])) < 0)
        return result;

    result = JNI_VERSION_1_6;
    return result;
}
