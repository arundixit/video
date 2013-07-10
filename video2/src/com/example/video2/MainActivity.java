package com.example.video2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity implements OnClickListener, android.view.View.OnClickListener {
	//public static final String MOVIE_URL="https://webbie.orgyoutube/skeleton.mp4";
	private WebView wv;
	//rtsp://wms.ardigitalmedia.com:1935/html5/111/mainstream?id=qJm5nBjN3xd9gm4gl1US
	String customHtml = "<iframe src='http://docs.google.com/viewer?url=http://www.iasted.org/conferences/formatting/presentations-tips.ppt&embedded=true' width='100%' height='100%' style='border: none;'></iframe>";
	
	//String customHtml = "<iframe src='http://www.ardigitalmedia.com/embed?scheme=embedChannel&channelId=107&showChat=0&pwidth=620&pheight=375&autoplay=yes' width='100%' height="375"></iframe>";
	
	Button bplay;
	Button bpause;
	MediaPlayer mpAudio;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		wv = (WebView)findViewById(R.id.webView); 
	    wv.getSettings().setJavaScriptEnabled(true);
	        wv.loadDataWithBaseURL("", customHtml , "text/html",  "UTF-8", "");
		
		
		LinearLayout layout=new LinearLayout(this);
		bplay=new Button(this);
		bplay.setText("Play");
		bplay.setOnClickListener(this);
		 bpause=new Button(this);
		bpause.setText("Pause");
		bpause.setOnClickListener(this);
		layout.addView(bplay);
		layout.addView(bpause);
		setContentView(layout);
		mpAudio=MediaPlayer.create(this, R.raw.audio);
		mpAudio.setLooping(true);
		
		
		/*VideoView vid=(VideoView) findViewById(R.id.videoView);
		
		//vid.setVideoPath("https://www.youtube.com/watch?v=OZJalBmtGnQ");
		Uri video=Uri.parse(MOVIE_URL);
		
		vid.setMediaController(new MediaController(this));
		
		vid.setVideoURI(video);
		vid.start();
		vid.requestFocus();*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v==bplay){
			
			mpAudio.start();
		}else if (v==bpause){
			mpAudio.pause();
			
		}
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	

}
