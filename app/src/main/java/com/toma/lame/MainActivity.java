package com.toma.lame;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public AudioHandler audioHandler;

    private final class AudioHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            //TODO 各种信息通信与回调处理
            switch (msg.what) {
                case MP3Recorder.MSG_ERROR_CREATE_FILE: {
//                    removeMessages(MSG_DO_SOME);
//
//                    if (mPlayer != null && isPlaying()) {
//                        if (timeMap != null && timeMap.get((int) (mPlayer.getContentPosition() / 1000)) != null) {
//                            int checkTime = AudioUtil.timeToSec(mPlayer.getCurrentPosition());
//                            if (checkTime <= mainAudio.duration) {
//                                mainAudio.playing_time = checkTime;
//                                AudioUtil.setAudioToMedia(mainAudio, mEntity);
//                                mOnStatueListener.onSendToService();
//                            }
//                        }
//                        sendEmptyMessageDelayed(MSG_DO_SOME, 1000);
//                    } else {
//                        removeMessages(MSG_DO_SOME);
//                    }
                }
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String voicePath = Environment.getExternalStorageDirectory() + "/audio";
        final MP3Recorder recorder = new MP3Recorder(8000);
        recorder.setFilePath(voicePath);//录音保存目录
        recorder.getVoiceLevel();

        audioHandler = new AudioHandler();
        recorder.setHandle(audioHandler);

        Button btnStare = (Button)findViewById(R.id.stare);

        Button btnPause = (Button)findViewById(R.id.pause);

        Button btnRestate = (Button)findViewById(R.id.restate);

        btnStare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder.start();//开始录音
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder.stop();//录音结束
            }
        });

        btnRestate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder.restore();//继续录音
            }
        });
    }
}
