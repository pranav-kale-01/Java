import java.awt.*; 
import java.awt.event.*; 

public class Question14 extends Frame { 
    public Question14() {
        Font large = new Font("Times New Roman", Font.PLAIN, 24 );

        // Main Frame
        TextField tf1 = new TextField(); 
        tf1.setBounds( 50, 100, 300, 40 );
        tf1.setFont( large );
        
        TextField tf2 = new TextField(); 
        tf2.setBounds( 50, 150, 300, 40 );
        tf2.setFont( large );
        

        TextField tf3 = new TextField();
        tf3.setBounds( 50, 200, 300, 40 );
        tf3.setFont( large );
        tf3.setEditable( false );

        // adding mouselistener to clear the fields when mouse enters 
        tf1.addMouseListener( new MouseAdapter( ) {
            public void mouseEntered( MouseEvent me ) {
                tf1.setText(" ");
                tf2.setText(" ");
                tf3.setText(" ");
            } 
        }); 

        this.setLayout( null );

        this.add( tf1 );
        this.add( tf2 ); 
        this.add( tf3 );

        // setting the menubar 
        MenuBar mb1 = new MenuBar();

        Menu m1 = new Menu( "Arithmetic" );
        Menu m2 = new Menu( "Comparison" );

        mb1.add( m1 ); 
        mb1.add( m2 );

        // Arithmetic operations 
        MenuItem mi1 = new MenuItem("Addition"); 
        mi1.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        tf3.setText( "" + ( Double.parseDouble( tf1.getText() ) + Double.parseDouble( tf2.getText() ) ) );
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        MenuItem mi2 = new MenuItem("Substraction"); 
        mi2.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        tf3.setText( "" + ( Double.parseDouble( tf1.getText() ) - Double.parseDouble( tf2.getText() ) ) );
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        MenuItem mi3 = new MenuItem("Division"); 
        mi3.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        tf3.setText( "" + ( Double.parseDouble( tf1.getText() ) / Double.parseDouble( tf2.getText() ) ) );
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        MenuItem mi4 = new MenuItem("Multiplication");
        mi4.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        tf3.setText( "" + ( Double.parseDouble( tf1.getText() ) * Double.parseDouble( tf2.getText() ) ) );
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        m1.add( mi1 );
        m1.add( mi2 );
        m1.add( mi3 );
        m1.add( mi4 );

        // Comparison Operations 
        MenuItem mi5 = new MenuItem("Largest"); 
        mi5.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        if( Double.parseDouble( tf1.getText() ) < Double.parseDouble( tf2.getText() ) ) {
                            
                            tf3.setText( tf2.getText() );
                        }
                        else {
                            tf3.setText( tf1.getText() );
                        }
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });
        
        MenuItem mi6 = new MenuItem("Smallest"); 
        mi6.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        if( Double.parseDouble( tf1.getText() ) > Double.parseDouble( tf2.getText() ) ) {
                            
                            tf3.setText( tf2.getText() );
                        }
                        else {
                            tf3.setText( tf1.getText() );
                        }
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        MenuItem mi7 = new MenuItem("Equals") ;
        mi7.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        if( Double.parseDouble( tf1.getText() ) == Double.parseDouble( tf2.getText() ) ) {
                            
                            tf3.setText( "true" );
                        }
                        else {
                            tf3.setText( "false" );
                        }
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        MenuItem mi8 = new MenuItem("Not Equals");
        mi8.addActionListener( new ActionListener() { 
            public void actionPerformed( ActionEvent ae ) {
                // checking if textField1 and textField2 are not empty
                if( tf1.getText().equals("") || tf2.getText().equals("") ){ 
                    return;
                }
                else{
                    try{ 
                        if( Double.parseDouble( tf1.getText() ) != Double.parseDouble( tf2.getText() ) ) {
                            
                            tf3.setText( "true" );
                        }
                        else {
                            tf3.setText( "false" );
                        }
                    } 
                    catch( Exception e ) {
                        tf1.setText("");
                        tf2.setText("");
                        tf2.setText("");
                    }
                }
            }
        });

        m2.add( mi5 );
        m2.add( mi6 );
        m2.add( mi7 );
        m2.add( mi8 );

        this.setMenuBar( mb1 );
    }

    public static void main( String ar[] ) {
        Question14 q = new Question14(); 
        q.setSize( 400, 400 ); 
        q.setVisible( true );   
    }
}