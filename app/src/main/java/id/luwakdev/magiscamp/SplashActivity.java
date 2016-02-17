package id.luwakdev.magiscamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class SplashActivity extends Activity {
	//Waktu SplashScreen *Detik
	private static final int SPLASH_TIME = 3000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		//Splash Screen Berjalan
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}

		}, SPLASH_TIME);
	}

	public boolean onCreateOptionsLayout(View view) {
		// Inflate layout, untuk menambahkan item ke action bar.
		getLayoutInflater().inflate(R.layout.activity_main, null);
		return true;
	}

}