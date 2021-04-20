import java.awt.Color;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		 final JFrame frame = new JFrame("Radio");
		 
	        frame.getContentPane().add(new Gui());
	        frame.pack();
	        frame.setVisible(true);
	        frame.setIconImage(null);
	        frame.setBackground(Color.WHITE);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        try {
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(new URL("https://i.imgur.com/0yPc3XN.png")));
			} catch (MalformedURLException e) {
				
			}
	}

}
