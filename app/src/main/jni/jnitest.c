##include "com_stxpy_jni_Jtest.h"

using namespace std;

JNIEXPORT void JNICALL Java_com_stxpy_jni_Jtest_sayHello
  (JNIEnv *, jobject){
      cout <<"Hello World"<<endl;
  }
