import java.awt.*; 

public class Frame02 extends Frame { 
    public Frame02() {
        Font medium = new Font("Segoe UI", Font.PLAIN, 16);

        // creating a mew Font 
        Font large = new Font("Segoe UI", Font.PLAIN, 24 );

        MenuBar mb1 = new MenuBar(); 
        mb1.setFont( medium );

        Menu m1 = new Menu("File");
        m1.setFont( medium );
        Menu m2 = new Menu("Edit"); 
        m2.setFont( medium );
        Menu m3 = new Menu("Format"); 
        m3.setFont( medium );
        Menu m4 = new Menu("View"); 
        m4.setFont( medium );
        Menu m5 = new Menu("Help");
        m5.setFont( medium );

        mb1.add( m1 );
        mb1.add( m2 );
        mb1.add( m3 );
        mb1.add( m4 );
        mb1.add( m5 );

        // File menu 
        MenuItem mi1 = new MenuItem("New"); 
        MenuItem mi2 = new MenuItem("New Window"); 
        MenuItem mi3 = new MenuItem("Open...");         
        MenuItem mi4 = new MenuItem("Save"); 
        MenuItem mi5 = new MenuItem("Save As..."); 
        MenuItem mi6 = new MenuItem("Page Setup"); 
        MenuItem mi7 = new MenuItem("Print..."); 
        MenuItem mi8 = new MenuItem("Exit"); 

        // Edit menu
        MenuItem mi9 = new MenuItem("Undo"); 
        MenuItem mi10 = new MenuItem("Cut"); 
        MenuItem mi11 = new MenuItem("Copy"); 
        MenuItem mi12 = new MenuItem("Paste");         
        MenuItem mi13 = new MenuItem("Delete"); 
        MenuItem mi14 = new MenuItem("Search With Bing...");         
        MenuItem mi15 = new MenuItem("Find");         
        MenuItem mi16 = new MenuItem("Find Next"); 
        MenuItem mi17 = new MenuItem("Find Previous"); 
        MenuItem mi18 = new MenuItem("Replace..."); 
        MenuItem mi19 = new MenuItem("Go to...");         
        MenuItem mi20 = new MenuItem("Select All");         
        MenuItem mi21 = new MenuItem("Time/Date");         

        // Format menu 
        CheckboxMenuItem mi22 = new CheckboxMenuItem("Word Wrap");         
        MenuItem mi23 = new MenuItem("Font...");                 

        // View menu 
        Menu m6 = new Menu("Zoom");        
        MenuItem mi24 = new MenuItem("Zoom In");         
        MenuItem mi25 = new MenuItem("Zoom Out");         
        MenuItem mi26 = new MenuItem("Restore Default Zoom");         
        CheckboxMenuItem mi27 = new CheckboxMenuItem("Status Bar");                

        // Help menu 
        MenuItem mi28 = new MenuItem("View Help");        
        MenuItem mi29 = new MenuItem("Send Feedback");        
        MenuItem mi30 = new MenuItem("About Notepad");
        
        m1.add( mi1 );
        m1.add( mi2 );
        m1.add( mi3 );
        m1.add( mi4 );
        m1.add( mi5 );
        m1.add( mi6 );
        m1.add( mi7 );
        m1.add( mi8 );
        m2.add( mi9 );
        m2.add( mi10 );
        m2.add( mi11 );
        m2.add( mi12 );
        m2.add( mi13 );
        m2.add( mi14 );
        m2.add( mi15 );
        m2.add( mi16 );
        m2.add( mi17 );
        m2.add( mi18 );
        m2.add( mi19 );
        m2.add( mi20 );
        m2.add( mi21 );
        m3.add( mi22 );
        m3.add( mi23 );
        m4.add( m6 );
        m6.add( mi24 );
        m6.add( mi25 );
        m6.add( mi26 );
        m4.add( mi27 );
        m5.add( mi28 );
        m5.add( mi29 );
        m5.add( mi30 );


        // adding a TextArea
        TextArea ta1 = new TextArea(); 
        ta1.setFont( large ); 
        add( ta1 );

        this.setMenuBar( mb1 ); 
        this.setVisible( true );
    }

    public static void main(String ar[] ) {
        Frame02 f = new Frame02(); 

        f.setSize( 400, 300 ); 
        f.setVisible( true ); 
    }
}