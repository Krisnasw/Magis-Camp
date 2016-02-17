package id.luwakdev.magiscamp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.io.IOException;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by OutAttacker on 2/3/2016.
 */
public class pley extends Activity {
    /** Called when the activity is first created. */

    private ImageButton btnPlay;
    private ImageButton btnPause;
    private ImageButton btnStop;
    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playaudio);

        mp = new MediaPlayer();

        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnPause = (ImageButton) findViewById(R.id.btnPause);
        btnStop = (ImageButton) findViewById(R.id.btnStop);

        stateAwal();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
    }

    /** State Awal / Pertama Dijalankan */
    public void stateAwal(){
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    /** Dijalankan Oleh Tombol Play */
    private void play() {
        /** Memanggil File MP3 "watchme.mp3" */
        mp = MediaPlayer.create(this, R.raw.watchme);

        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Mendajalankan Audio */
        mp.start();

        /** Penanganan Ketika Suara Berakhir */
        mp.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    /** Dijalankan Oleh Tombol Pause */
    public void pause(){
        if(mp.isPlaying()){
            if(mp!=null){
                mp.pause();
                btnPause.setImageResource(R.drawable.next);
            }
        } else {
            if(mp!=null){
                mp.start();
                btnPause.setImageResource(R.drawable.pause);
            }
        }
    }

    /** Dijalankan Oleh Tombol Stop */
    public void stop(){
        mp.stop();

        try{
            mp.prepare();
            mp.seekTo(0);
        }catch (Throwable t) {
            t.printStackTrace();
        }

        stateAwal();
    }
}
