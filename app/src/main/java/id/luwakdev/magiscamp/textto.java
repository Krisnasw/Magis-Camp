package id.luwakdev.magiscamp;

/**
 * Created by OutAttacker on 2/3/2016.
 */
import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class textto extends Activity implements TextToSpeech.OnInitListener {
/** Called when the activity is first created. */

private TextToSpeech tts;
private ImageButton btnSpeak;
private EditText txtText;

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tts);

        tts = new TextToSpeech(this, this);

        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

        txtText = (EditText) findViewById(R.id.txtText);

        // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {

public void onClick(View arg0) {
        speakOut();
        }

        });
        }

@Override
public void onDestroy() {
        // Untuk Matikan
        if (tts != null) {
        tts.stop();
        tts.shutdown();
        }
        super.onDestroy();
        }

public void onInit(int status) {
        // TODO Auto-generated method stub

        if (status == TextToSpeech.SUCCESS) {

        int result = tts.setLanguage(Locale.US);

        // tts.setPitch(3); // set pitch level

        // tts.setSpeechRate(2); // set speech speed rate

        if (result == TextToSpeech.LANG_MISSING_DATA
        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        Log.e("TTS", "Language is not supported");
        } else {
        btnSpeak.setEnabled(true);
        speakOut();
        }

        } else {
        Log.e("TTS", "Initilization Failed");
        }

        }

private void speakOut() {

        String text = txtText.getText().toString();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
        }