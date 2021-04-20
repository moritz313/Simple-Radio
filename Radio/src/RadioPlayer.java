import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.FloatControl;

public class RadioPlayer {
		public static String NowPlaying = "NCS Sounds";	    
	    public static String URL = "http://stream.laut.fm/my-webradio";
	    public static Radio radio = new Radio();
	    public static float Volume = -40f;
	    public static int count = 1; 
	    
	    public static void start() {
	    	try {
				radio.setStream(new java.net.URL(URL).openStream());
				
			} catch (MalformedURLException e) {			
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
	    	
	    	Gui.status.setText("Now Playing: "+NowPlaying);
          	radio.start();	
          	
	    }
	    
	    public static void stop() {
	    	radio.stop();
	    	Gui.status.setText("Stopped :) ");
	    }
	    
	    public static void setGain() {
	    	radio.setVolume(Volume);
	    }
	    
	    public static void setCustomUrl(String url) {
	    	URL = url;	
	    	
	    	if(radio.isRunning()) {
	    		radio.stop();
	    		start();
	    	}
	    	
	    	Gui.status.setText("Custom Url set");
	    }
	    
	    public static void next() {
	    	if(count == 1) {
	    		radio.stop();
	    		URL = "http://stream.laut.fm/nightcoremusic";
	    		NowPlaying = "Nightcore";
	    		start();
	    		count++;
	    		System.out.println("Sender 2");
	    	}
	    	else if(count == 2) {
	    		stop();
	    		URL = "http://stream.laut.fm/lofi";
	    		NowPlaying = "Lofi";
	    		start();
	    		count++;
	    		System.out.println("Sender 3");
	    	}
	    	else if(count == 3) {
	    		stop();
	    		URL = "http://stream.laut.fm/eurobeat";
	    		NowPlaying = "Eurobeat";
	    		start();
	    		count++;
	    		System.out.println("Sender 4");
	    	}
	    	else if(count == 4) {
	    		stop();
	    		URL = "http://stream.laut.fm/my-webradio";
	    		NowPlaying = "NCS Sounds";
	    		start();
	    		count = 1;
	    		System.out.println("Sender 1");
	    	}
	    }
	    
	    
	   
}
