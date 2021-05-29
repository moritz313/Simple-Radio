import java.io.InputStream;
import java.util.Objects;

import javax.sound.sampled.FloatControl;

import javazoom.jl.decoder.JavaLayerException;
import java.lang.reflect.Field;
import javax.sound.sampled.SourceDataLine;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.advanced.*;

public class Radio {
	 private AudioDevice device;
	private AdvancedPlayer player;
	private Thread thread;
	 private FloatControl volControl;
	
	
	

	public void setStream(InputStream inputStream) {
		try {
		     this.device = FactoryRegistry.systemRegistry().createAudioDevice();
	            this.player = new AdvancedPlayer( inputStream, device);			
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean isRunning() {
		return thread !=null;		
	}
	
	public void start() {
		Objects.requireNonNull(player);				
		thread = new Thread(() -> {
			try {
				player.play();				
			} catch (JavaLayerException e) {				
				e.printStackTrace();
			}
		});
		thread.start();	


	}
	
	public void stop() {
		if(isRunning()) {
			thread.interrupt();
			thread = null;											
			if(player != null) {				
				player.close();				
			}
		}
	}
	
	
    public void setVolume(float gain){
        if(this.volControl == null) {
            Class<JavaSoundAudioDevice> clazz = JavaSoundAudioDevice.class;
            Field[] fields = clazz.getDeclaredFields();
            try{
                SourceDataLine source = null;
                for(Field field : fields) {
                    if("source".equals(field.getName())) {
                        field.setAccessible(true);
                        source = (SourceDataLine) field.get(this.device);
                        field.setAccessible(false);
                        this.volControl = (FloatControl) source.getControl(FloatControl.Type.MASTER_GAIN);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.volControl != null) {
            float newGain = Math.min(Math.max(gain, volControl.getMinimum()), volControl.getMaximum());
            System.out.println("Was: " + volControl.getValue() + " Will be: " + newGain);

            volControl.setValue(newGain);
        }
    }
	
	public void setLineGain(float gain)
	{
	   
	}
	
	
}