import java.awt.*; 
import java.awt.event.*;

class myDialog extends Dialog {
    public myDialog( Frame invoking ) {
        super( invoking );

        this.setLocation( invoking.getLocation() );

        this.setSize( 400, 400 );
        this.setLayout( null );

        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent we ) {
                dispose();
            }
        });

        Label l1 = new Label("This is Dialog");
        l1.setAlignment( Label.CENTER );
        l1.setBounds( 50, 50, 300, 50 );

        Button btn = new Button("OK");
        btn.setBounds( 50, 150, 300, 50 );
        btn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                dispose();
            }
        });
        

        add( l1 );  add( btn );
    }
}

public class Question17 extends Frame{ 
    Frame currentFrame; 

    public Question17() {
        this.setLayout( null ) ;
        currentFrame = this;

        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent we ) {
                dispose();
            }
        });

        Label l1 = new Label("This is Frame");
        l1.setAlignment( Label.CENTER );
        l1.setBounds( 50,50, 300, 50 );
        

        Button btn = new Button("Show Dialog");
        btn.setBounds( 50, 150, 300, 50 );
        btn.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // popping the dialog
                myDialog d = new myDialog( currentFrame );
                d.setVisible( true );
            }
        });


        add(l1); add( btn );
    }

    public static void main(String ar[] ) {
        Question17 q = new Question17(); 
        q.setSize(400, 400 );
        q.setVisible( true );
    }
}