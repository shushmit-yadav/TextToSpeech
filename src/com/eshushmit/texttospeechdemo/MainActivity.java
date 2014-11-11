package com.eshushmit.texttospeechdemo;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText etText;
	TextToSpeech tts;
	
	
	public void speakText(View view){
	      String toSpeak = etText.getText().toString();
	      Toast.makeText(getApplicationContext(), toSpeak, 
	      Toast.LENGTH_SHORT).show();
	      tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

	   }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etText = (EditText) findViewById(R.id.etText);
		tts=new TextToSpeech(getApplicationContext(), 
			      new TextToSpeech.OnInitListener() {
			      @Override
			      public void onInit(int status) {
			         if(status != TextToSpeech.ERROR){
			        	 tts.setLanguage(Locale.getDefault());
			            }				
			         }
			      });
	}

	@Override
	protected void onPause() {
		if(tts !=null){
			tts.stop();
	         tts.shutdown();
	      }
		super.onPause();
	}
	@Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }
	
}
