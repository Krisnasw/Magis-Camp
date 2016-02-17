package id.luwakdev.magiscamp;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton tts = (ImageButton) findViewById(R.id.tts);
        ImageButton src = (ImageButton) findViewById(R.id.src);
        ImageButton play = (ImageButton) findViewById(R.id.play);

        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                Intent keli = new Intent(MainActivity.this, textto.class);
                startActivity(keli);
            }
        });

        src.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //TODO Auto-generated method stub
                Intent ggwp = new Intent(MainActivity.this, speech.class);
                startActivity(ggwp);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                Intent main = new Intent(MainActivity.this, pley.class);
                startActivity(main);
            }
        });
    }
}
