import java.awt.*; 
import java.awt.event.*; 
import java.util.Scanner; 

import java.io.File;
import java.io.IOException;
import java.io.FilenameFilter;

import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.stage.Stage;  


class JavaFXInitializer { 
    private String fileName;

    public void setFileName( String fileName ) {
        this.fileName = fileName ;
    }

    public void playMusic( MediaPlayer mediaPlayer ) {
        mediaPlayer.play();
    }

    public void pauseMusic( MediaPlayer mediaPlayer ) {
        mediaPlayer.pause();
    }
}

class MusicList extends Panel implements MouseWheelListener, ActionListener {
    Button btn; 
    Button[] arr;
    Label songName;

    
    int width, height; 
    int btnWidth, btnHeight;
    File directoryPath;
    JavaFXInitializer JFXInit; 
    MediaPlayer mediaPlayer;

    public MusicList( int width, int height, int btnWidth, int btnHeight) {
        this.JFXInit = new JavaFXInitializer();
        this.mediaPlayer = mediaPlayer;

        this.width = width; 
        this.height = height;

        this.btnHeight = btnHeight;
        this.btnWidth = btnWidth;

        Font large = new Font( "Times New Roman", Font.PLAIN, 24 );
        Panel list = new Panel();
        list.setLayout( null );
        list.setBounds( 30, 10, 1540, 800 );
        list.addMouseWheelListener( this );

        // getting all the files from the given folder
        directoryPath = new File("C:\\Users\\Lenovo\\Downloads");
        
        FilenameFilter filefilter = new FilenameFilter(){
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".mp3") || lowercaseName.endsWith(".wav") ) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        String contents[] = directoryPath.list( filefilter );

        arr = new Button[contents.length]; 

        int y= this.btnHeight ;
        for( int i=0; i<contents.length; i++ ) {
            Button btn = new Button( contents[i] ); 
            btn.setFont( large );
            btn.setBackground( Color.WHITE );
            btn.setSize( this.width, this.btnHeight );
            btn.setLocation( 0, y );

            btn.addActionListener( this );

            arr[i] = btn;
            list.add( btn );
            y+=this.btnHeight;
        }

        Panel controls = new Panel();
        controls.setBounds( 30, 800, 1540, 200 );
        controls.setLayout( null );

        Button playBtn = new Button("PLAY");
        playBtn.setFont( large );
        playBtn.addActionListener( this );
        playBtn.setBounds( 600, 30 , 150, 50 );

        Button pauseBtn = new Button("PAUSE");
        pauseBtn.setFont( large );
        pauseBtn.addActionListener( this );
        pauseBtn.setBounds( 800, 30 , 150, 50 );

        songName = new Label("");
        songName.setFont( large ) ;
        songName.setBounds( 100, 100, 1400, 50 );

        controls.add( playBtn );
        controls.add( pauseBtn );
        controls.add( songName );

        this.setLayout( null );
        this.add( list );
        this.add( controls );
    } 

    public void actionPerformed( ActionEvent ae ) {
        String s = ae.getActionCommand();

        if( s.equals("PLAY") ) {
            this.mediaPlayer.play();
        }
        else if( s.equals("PAUSE") ) {
            this.mediaPlayer.pause();
        }
        else {
            // checking if any previous instance of mediaPlayer is running 
            if( mediaPlayer != null ) {
                mediaPlayer.pause();
            }

            String fileName =  directoryPath.getPath()  + "\\" + s;

            if( s.endsWith(".mp3") ) {
                this.JFXInit.setFileName( fileName );

                // creating a new MediaPlayer 
                Media media = new Media( new File( fileName ).toURI().toString() );
                MediaPlayer mediaPlayer = new MediaPlayer( media );
                this.mediaPlayer = mediaPlayer;

                // playing the music 
                this.JFXInit.playMusic( mediaPlayer );  

                // changing the label to current song name
                songName.setText( s );
            }
            else if( s.endsWith(".wav") ) { 

            }
        }        
    }

    public void mouseWheelMoved( MouseWheelEvent mwe ) {
        Dimension d = this.getSize(); 

        if( mwe.getWheelRotation() < 0 ){
             if( arr[0].getLocation().y > 0 ) {
                return;
            }

            for( Button i : arr ){
                Point p1 = i.getLocation();
                i.setLocation( 0 , p1.y + this.btnHeight );
            }
        }
        else{
            if( arr[arr.length -1 ].getLocation().y < this.height ) {
                return;
            }

            for( Button i : arr ){
                Point p1 = i.getLocation();
                i.setLocation( 0 , p1.y - this.btnHeight );
            }
        }
    }
}

public class Java06 extends Application {
    @Override
    public void start( Stage stage ) throws Exception {
        
    }

    public static void main( String ar[] ) {
        try {
            Frame f1 = new Frame();
            
            MusicList obj = new MusicList( 1540, 800, 1540, 50 ); 
            f1.add( obj );

            f1.setSize( 1600, 1000 );
            f1.setVisible( true );

            // launching the Application
            launch( ar );
        }
        catch( Exception e ) {
            System.out.println( e.getCause().toString() );
            e.printStackTrace();
        }
    }

}