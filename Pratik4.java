import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


class MyCanvas extends Canvas{  
        
    public MyCanvas() {
        try {
            
        }
        catch( Exception e ){
            System.out.println( e.toString() );
        }
    }
}  

class Frame01 extends JFrame implements ActionListener
{
	Button btn1,btn2,btn3;
	Long currentFrame;
    Clip clip;
	  
    AudioInputStream audioInputStream;
    static String filePath;

	public Frame01() 
	{
        this.setLayout( null );

        btn1 = new Button("Play");
        btn1.setBackground( Color.CYAN ); 
        btn1.setForeground( Color.BLACK ); 

        btn2 = new Button("Pause");
        btn2.setBackground( Color.RED ); 
        btn2.setForeground( Color.BLACK ); 

        btn3 = new Button("Resume");
        btn3.setBackground( Color.MAGENTA ); 
        btn3.setForeground( Color.BLACK ); 

        btn1.setBounds(50, 310, 80, 25); 
        btn2.setBounds(140, 310, 80, 25); 
        btn3.setBounds(230, 310, 80, 25); 

        btn1.addActionListener( this );
        btn2.addActionListener( this );
        btn3.addActionListener( this );
        
        try {
            MyCanvas m = new MyCanvas();
            BufferedImage img=ImageIO.read(new File("C:\\Users\\Lenovo\\Downloads\\party.jpg"));
            ImageIcon icon=new ImageIcon(img);
            JLabel lbl=new JLabel();

            lbl.setBounds( 25 , 0, 300 , 300);

            lbl.setIcon(icon);
            this.add( lbl );

            add(m);
        } 
        catch( Exception e ) {

        }

        add(btn1);
        add(btn2);
        add(btn3);
	}

	public void play() 
    {
            try {
            filePath = "C:\\Users\\Lenovo\\Downloads\\file_example_WAV_1MG.wav";

            File F = new File(filePath).getAbsoluteFile(); 

            System.out.println( F.getAbsoluteFile() );

            audioInputStream = AudioSystem.getAudioInputStream( F );
            clip = AudioSystem.getClip();
        
            clip.open(audioInputStream);
        
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        
        }	
        catch( Exception e ) {
            System.out.println( e.toString() );
        }
    }

	public void pause() 
    {
        
            this.currentFrame = 
            this.clip.getMicrosecondPosition();
            clip.stop();
    
    }
    public void resume() 
    {
        
        clip.start();
    
    }

	public  void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();
		if (ob == btn1)
		{
			play(); 
		}
		else if (ob == btn2)
		{
			pause();
		}
        else if (ob == btn3)
		{
			resume();
		}
	}


	public static void main(String arr[]) 
	{
		Frame01 f11 = new Frame01();	
		f11.setSize( 375, 450 );
        f11.setVisible( true );
	}
}   