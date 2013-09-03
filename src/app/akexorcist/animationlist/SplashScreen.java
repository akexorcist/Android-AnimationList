package app.akexorcist.animationlist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;

public class SplashScreen extends Activity {
	AnimationDrawable splash;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        splash = (AnimationDrawable) image.getBackground();
        /*
		new Thread(new Runnable() {
			public void run() {
	        	try {
					Thread.sleep(3000);
				} catch (InterruptedException e) { }
	        	Intent intent = new Intent(getApplicationContext(), Main.class);
	  		  	startActivity(intent);
			}
		}).start();*/
        image.post(new Starter());
    }
    
    class Starter implements Runnable {
        public void run() {
        	splash.start();
        }
    }    
    
    public boolean onTouchEvent(MotionEvent event) {
    	  if (event.getAction() == MotionEvent.ACTION_DOWN) {
    		  Intent intent = new Intent(getApplicationContext(), Main.class);
    		  startActivity(intent);
    		  this.finish();
    		  return true;
    	  }
    	  return super.onTouchEvent(event);
    }
}
