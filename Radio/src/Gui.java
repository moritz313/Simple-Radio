


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Gui extends JPanel 
{
    /**
	 * 
	 */
	
	public static int c = 0;
	private static final long serialVersionUID = 1L;
	private JButton Play;
	private JButton Stop;
	private JButton Next;
	private JButton Custom;
	private JButton VolUp;
	private JButton VolDown;
	
	private JTextField CustomUrl;
	public static JLabel status;
	public static JLabel Title;
	
 
	
	
	
  
    
    public Gui() {
       
        this.setBackground(Color.BLACK);
        this.Play = new JButton("▷ Play");
        this.Stop = new JButton("⏸ Stop");
        this.Next = new JButton("⏭ Next");
        this.Custom = new JButton("Set Custom Url");
        this.VolUp = new JButton("Volume Up +");
        this.VolDown = new JButton("Volume Down -");
     
        this.setCustomUrl(new JTextField());
        this.setStatus(new JLabel("Wellcome!"));
        this.setTitle(new JLabel("Radio by Moritz ♩ ♪ ♫ ♬"));
       
        this.setPreferredSize(new Dimension(330, 250));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.add(this.Play);
        this.add(this.Stop);
        this.add(this.Next);
        this.add(this.Custom);
        this.add(this.VolUp);
        this.add(this.VolDown);
       
        this.add(this.getCustomUrl());
        this.add(this.getStatus());
        this.add(this.getTitle());
           
        this.Play.setForeground(Color.WHITE);     
        this.Stop.setForeground(Color.WHITE);       
        this.Next.setForeground(Color.WHITE);        
        this.Custom.setForeground(Color.WHITE); 
        this.VolUp.setForeground(Color.WHITE);        
        this.VolDown.setForeground(Color.WHITE); 
     
        this.getStatus().setForeground(Color.RED);
        this.getTitle().setForeground(Color.RED);
		Play.setBackground(new Color(245, 90, 66));
		Stop.setBackground(new Color(245, 90, 66));	
		Next.setBackground(new Color(245, 90, 66));
		Custom.setBackground(new Color(245, 90, 66));
		VolUp.setBackground(new Color(245, 90, 66));
		VolDown.setBackground(new Color(245, 90, 66));
        
        
        final int h = 30;
        this.Play.setBounds(10, h + 30, 150, 25);
        this.Stop.setBounds(10, h + 60, 150, 25);
        this.Next.setBounds(10, h + 90, 310, 25);
        this.Custom.setBounds(170, h + 60, 150, 25);
        this.VolUp.setBounds(10, h + 120, 150, 25);
        this.VolDown.setBounds(170, h + 120, 150, 25);
        
        this.getStatus().setBounds(10, h + 150, 300, 25);
        this.getCustomUrl().setText("");       
        this.getCustomUrl().setBounds(170, h + 30, 150, 25);
  
        
        Font labelFont = this.getTitle().getFont();        
        this.getTitle().setFont(new Font(labelFont.getName(), Font.PLAIN, 30));        
        this.getTitle().setBounds(10, 2, 400, 50);
     
         
        
        
        this.VolUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RadioPlayer.Volume = RadioPlayer.Volume + 10f;
				RadioPlayer.setGain();
				
			}
		});

        this.VolDown.addActionListener(new ActionListener() {
	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		RadioPlayer.Volume = RadioPlayer.Volume - 10f;
        		RadioPlayer.setGain();
        	}
        });
     
        
        
        this.Play.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				RadioPlayer.start();
				
			}
		});
        
        
        
        
       this.Stop.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		RadioPlayer.stop();	
	
			
		}
	});
       
       
       this.Next.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			RadioPlayer.next();
   			
   		}
   	});
       
       this.Custom.addActionListener(new ActionListener() {
    	 
      		@Override
      		public void actionPerformed(ActionEvent e) {
      		RadioPlayer.setCustomUrl(CustomUrl.getText());
      		}
      	});
       
    }
    
   
    
 



	public JLabel getStatus() {
		return status;
	}
	public JLabel getTitle() {
		return Title;
	}

	@SuppressWarnings("static-access")
	public void setStatus(JLabel status) {
		this.status = status;
	}
	@SuppressWarnings("static-access")
	public void setTitle(JLabel status) {
		this.Title = status;
	}



	public JTextField getCustomUrl() {
		return CustomUrl;
	}



	public void setCustomUrl(JTextField username) {
		this.CustomUrl = username;
	}
	
	
	 
        
}
