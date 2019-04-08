#include <jni.h>
#include <android/log.h>
#include <unistd.h>
#include <cerrno>
#include <cstring>
#include <pthread.h>
#include <sys/syscall.h>

#include <com_herbwen_myjnitest_MainActivity.h>
//#include <com_herbwen_myjnitest_RegisterNativeHook.h>

#include<cstdlib>
#include<cstdio>
#include<sys/types.h>
#include<sys/sysinfo.h>
#include<unistd.h>

#include<sched.h>
#include<cctype>
#include<include/inlineHook.h>


#define TAG "Attack"
#define DEBUG 1

#ifdef DEBUG
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)
#else
#define LOGD(...) ((void)0)
#define LOGE(...) ((void)0)
#endif

JNINativeInterface nativeInterface;

int hook();
int unHook();

jint (*old_RegisterNatives)(JNIEnv*, jclass, const JNINativeMethod*, jint) = nullptr;

jint new_RegisterNatives(JNIEnv *env, jclass clazz, const JNINativeMethod* methods, jint nMethods) {
    jclass RegisterNativeHookClass = env -> FindClass("com/herbwen/myjnitest/RegisterNativeHook");
    jmethodID RNCContruct = env -> GetMethodID(RegisterNativeHookClass, "<init>", "()V");
    jobject RNCObject = env -> NewObject(RegisterNativeHookClass, RNCContruct);
    LOGD("=======================================");
    LOGD("env:%p, class:%p, methods:%p, methods_num:%d", env, clazz, methods, nMethods);
    LOGD("=======================================");

    //Get Class Name
    jmethodID getClassName = (env) -> GetStaticMethodID(RegisterNativeHookClass, "getClassName", "(Ljava/lang/Class;)V");
    env -> CallStaticVoidMethod(RegisterNativeHookClass, getClassName, clazz);
    LOGD("=======================================");

//    char* hookSoName = getHookSoName(env);
//    LOGD("so file maps base address:0x%s", getSoBaseAddress(hookSoName));
//    LOGD("=======================================");

    // print method signature info
    for (int i = 0; i < nMethods; i++) {
        LOGD("name:%s, sign:%s, address:%p", methods[i].name, methods[i].signature, methods[i].fnPtr);
    }
    LOGD("=======================================");

    jint result = old_RegisterNatives(env, clazz, methods, nMethods);
    LOGD("register result:%d", result);

    //unHook();
    //hook();
    return 1;
}


int hook()
{
    if (registerInlineHook((uintptr_t) nativeInterface.RegisterNatives, (uintptr_t) new_RegisterNatives, (uint32_t **) &old_RegisterNatives) != ELE7EN_OK) {
        return -1;
    }
    if (inlineHook((uintptr_t) nativeInterface.RegisterNatives) != ELE7EN_OK) {
        return -1;
    }

    return 0;
}

int unHook()
{
    if (inlineUnHook((uintptr_t) nativeInterface.RegisterNatives) != ELE7EN_OK) {
        return -1;
    }

    return 0;
}

int (*old_puts)(const char *) = nullptr;

int new_puts(const char *string)
{
    LOGD("%s1", string);
    return 1;
}

int hook_puts()
{
    if (registerInlineHook((uint32_t) puts, (uint32_t) new_puts, (uint32_t **) &old_puts) != ELE7EN_OK) {
        return -1;
    }
    if (inlineHook((uint32_t) puts) != ELE7EN_OK) {
        return -1;
    }

    return 0;
}

int unHook_puts()
{
    if (inlineUnHook((uint32_t) puts) != ELE7EN_OK) {
        return -1;
    }

    return 0;
}

JNIEXPORT void JNICALL Java_com_herbwen_myjnitest_MainActivity_hookPuts(JNIEnv *env, jobject jobject1){
    puts("test1");
    LOGD("test1");
    hook_puts();
    puts("test2");
    LOGD("test2");
    //unHook_puts();
    puts("test3");
    LOGD("test3");
}


JNIEXPORT void JNICALL Java_com_herbwen_myjnitest_MainActivity_hook(JNIEnv *env, jobject jobject1){
    int hook_result = hook();
    LOGD("hook result:%d", hook_result);
}

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved){
    JNIEnv* env = nullptr;
    vm->GetEnv((void**) &env, JNI_VERSION_1_6);
    nativeInterface = *env->functions;
    LOGD("Init is finished.");
    return JNI_VERSION_1_6;
}

