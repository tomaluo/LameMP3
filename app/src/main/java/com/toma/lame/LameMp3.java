package com.toma.lame;

/**
 * Created by user on 2017/12/26.
 */

public class LameMp3 {

    static {
        System.loadLibrary("LameMp3");
    }

    /**
     * 初始化录制参数
     *
     * @param inSamplerate  pcm格式音频采样率
     * @param outChannel    pcm格式音频通道数量
     * @param outSamplerate mp3格式音频采样率
     * @param outBitrate    mp3格式音频比特率
     * @param quality       mp3格式音频质量，0~9，最慢最差~最快最好
     */
    public native static void init(int inSamplerate, int outChannel,
                                   int outSamplerate, int outBitrate, int quality);

    /**
     * pcm 编码成 mp3
     *
     * @param buffer_l 左pcm数据
     * @param buffer_r 右pcm数据，如果是单声道，则一致
     * @param samples  读入的pcm字节大小
     * @param mp3buf   存放mp3数据缓存
     * @return 编码数据字节长度
     */
    public native static int encode(short[] buffer_l, short[] buffer_r,
                                    int samples, byte[] mp3buf);

    /**
     * 保存mp3音频流到文件
     *
     * @param mp3buf mp3数据流
     * @return 数据流长度rty
     */
    public native static int flush(byte[] mp3buf);

    /**
     * 释放lame库资源
     */
    public native static void close();

}
