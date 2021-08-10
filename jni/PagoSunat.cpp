#include<jni.h>
#include<string.h>
jstring Java_com_example_storemanager_MainActivity_helloWorld(JNIEnv* env, jobject obj){
class
    return (*env) ->NewStringUTF(env, "Helloworld");
}

