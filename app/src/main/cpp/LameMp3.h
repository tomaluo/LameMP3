//
// Created by Toma on 2017/12/26.
//

#ifndef LAME_LAMEMP3_H
#define LAME_LAMEMP3_H

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com.toma.lame
 * Method:    init
 * Signature: (IIIII)V
 */
JNIEXPORT void JNICALL Java_com_toma_lame_LameMp3_init
  (JNIEnv *, jclass, jint, jint, jint, jint, jint);

/*
 * Class:     com.toma.lame
 * Method:    encode
 * Signature: ([S[SI[B)I
 */
JNIEXPORT jint JNICALL Java_com_toma_lame_LameMp3_encode
  (JNIEnv *, jclass, jshortArray, jshortArray, jint, jbyteArray);

/*
 * Class:     com.toma.lame
 * Method:    flush
 * Signature: ([B)I
 */
JNIEXPORT jint JNICALL Java_com_toma_lame_LameMp3_flush
  (JNIEnv *, jclass, jbyteArray);

/*
 * Class:     com.toma.lame
 * Method:    close
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_toma_lame_LameMp3_close
  (JNIEnv *, jclass);
#ifdef __cplusplus
}
#endif //LAME_LAMEMP3_H
#endif