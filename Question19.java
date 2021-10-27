import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

class Shape {
    int start_x;
    int start_y;
    int width;
    int height;
    Color color;
    String type;

    public void showValues() {
        System.out.println( start_x + ", " + start_y + ", " + width + ", " + height );
    }
}

class ShapePallete extends Panel {
    public ShapePallete( ) {
        this.setLayout( new GridLayout( 3, 1, 10, 10 ) );
        this.setBounds( 50, 50, 300, 140 );

        Button penButton = new Button("Pen"); 
        penButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                Canvas.tool = "pen";
            }
        });
        this.add( penButton );

        Button squareButton = new Button("Square"); 
        squareButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                Canvas.tool = "square";
            }
        });
        this.add( squareButton );

        Button ovalButton = new Button("Oval"); 
        ovalButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                Canvas.tool = "oval";
            }
        });
        this.add( ovalButton);
    }
}

class ToolBar extends Panel {
    Color selectedColor;
    int selectedThickness;
    Button currentColorButton1, currentColorButton2; 
    Panel MyCanvas;

    public ToolBar( Panel _canvas ) {
        this.MyCanvas = _canvas;
        this.setLayout( null );
        this.setBackground( new Color( 209, 209, 209) );

        Color colors[] = { Color.BLACK, Color.BLUE, Color.DARK_GRAY, Color.RED, Color.PINK, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.CYAN }; 

        // addding shapes pallete
        ShapePallete shapePallete = new ShapePallete( );
        this.add( shapePallete );

        // adding a pallete to show the current Color 
        Panel currentColor =  new Panel( );
        currentColor.setLayout( new GridLayout( 4, 1, 10, 10 ) );
        currentColor.setBounds( 375, 50, 100, 140 );

        // color 1
        Label l1 = new Label("Color 1");
        l1.setFont( new Font("Times New Roman", Font.PLAIN, 24 ) );
        l1.setAlignment( Label.CENTER );
        currentColor.add( l1 );

        currentColorButton1 = new Button();
        currentColorButton1.setBackground( Color.BLACK );
        currentColor.add( currentColorButton1 );

        // color 2 
        Label l2 = new Label("Color 2");
        l2.setFont( new Font("Times New Roman", Font.PLAIN, 24 ) );
        l2.setAlignment( Label.CENTER );
        currentColor.add( l2 );

        currentColorButton2 = new Button();
        currentColorButton2.setBackground( Color.WHITE );
        currentColor.add( currentColorButton2 );

        this.add( currentColor );

        // adding color pallete
        JPanel colorPallete = new JPanel();
        colorPallete.setLayout( new GridLayout( 3, 1, 10, 10) );
        // colorPallete.setBounds( 500 , 50, 300, 150 );

        for( int i=0; i< 10; i++) {
            Button btn = new Button("");
            btn.setBackground( colors[i] );
            btn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent ae ) 
                {
                    Button btn = (Button) ae.getSource();
                    selectedColor = btn.getBackground();

                    currentColorButton1.setBackground( selectedColor );
                    Canvas.penColor = selectedColor;
                }
            });
            colorPallete.add( btn );
        }

        JScrollPane jsp = new JScrollPane( colorPallete );
        jsp.setBounds( 500 , 50, 300, 140 );

        this.add( jsp );

        // adding thickness Pallete
        Label sizeLabel = new Label("Pen Size");
        sizeLabel.setBounds( 850, 50, 100, 40 );
        sizeLabel.setFont( new Font("Times New Roman", Font.PLAIN, 24 ) );

        Choice sizeChoice = new Choice();
        sizeChoice.setBounds( 850, 100, 100, 40 );
        sizeChoice.setFont( new Font("Times New Roman", Font.PLAIN, 24 ) );
        sizeChoice.addItemListener( new ItemListener() {
            public void itemStateChanged( ItemEvent ie ) 
            {
                String temp = ie.getItem().toString().substring(0,1);
                selectedThickness = Integer.parseInt( temp );
                Canvas.penThickness = selectedThickness;
            }
        });
        sizeChoice.add("1px");
        sizeChoice.add("2px");
        sizeChoice.add("3px");
        sizeChoice.add("4px");

        this.add( sizeChoice );
        this.add( sizeLabel );

        // clear all button
        Button clearAllButton = new Button("Clear all");
        clearAllButton.setBounds( 1000, 50, 100, 50 );
        clearAllButton.setFont( new Font("Times New Roman", Font.PLAIN, 24 ) );

        clearAllButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                MyCanvas.repaint();
                Canvas.shapes.clear();
            }
        });

        this.add( clearAllButton );
    }
}

class Canvas extends Panel {
    Graphics g; 

    // variables required for drawing using pen
    static String tool = "pen";
    static Color penColor = Color.BLACK;
    static int penThickness = 1;
    
    // variables required for drawing shapes
    boolean first = true;
    int previous_x, previous_y;
    int currentX, currentY;
    int initial_x, initial_y;
    String previousDirection="";

    boolean penInput = true;
    static Vector<Shape> shapes = new Vector<Shape>();
    Shape shape;

    // variables required for key Events
    boolean ControlPressed = false;

    class MyListener extends MouseInputAdapter {
        public void mouseDragged( MouseEvent me ) {
            penInput = false;
            g = getGraphics();
            g.setColor( penColor );

            shape = new Shape();

            currentX = me.getX();
            currentY = me.getY();

            if( first ) {
                initial_x = me.getX(); 
                initial_y = me.getY();

                previous_x = me.getX();
                previous_y = me.getY();
                first = false;
            }

            if( tool.equals( "pen" ) ) 
            {
                penInput = true;
                g.drawLine( previous_x, previous_y, currentX, currentY );

                if( penThickness >= 2 ) {
                    g.drawLine( previous_x+1, previous_y-1, currentX+1, currentY-1 );
                }
                if( penThickness >= 3 ) {
                    g.drawLine( previous_x-1, previous_y+1, currentX-1, currentY+1 );
                }
                if( penThickness >= 4 ) {
                    g.drawLine( previous_x-2, previous_y+2, currentX-2, currentY+2 );
                }  
            }
            else if( tool.equals("square") ) 
            {
                if( previousDirection.equals( "NE" ) ) {
                    g.setColor( Color.WHITE);
                    g.drawRect( previous_x, previous_y, initial_x - previous_x, initial_y - previous_y );
                }
                else if( previousDirection.equals( "SE" ) ) {
                    g.setColor( Color.WHITE );
                    g.drawRect( previous_x, initial_y, initial_x - previous_x, previous_y - initial_y );
                }
                else if( previousDirection.equals( "NW" ) ) {
                    g.setColor( Color.WHITE);
                    g.drawRect( initial_x, previous_y, previous_x - initial_x, initial_y - previous_y );
                }
                else if( previousDirection.equals( "SW" ) ) {
                    g.setColor( Color.WHITE );
                    g.drawRect( initial_x, initial_y, previous_x - initial_x , previous_y - initial_y );
                }

                if( currentX < initial_x && currentY < initial_y ) {
                    g.setColor( Color.WHITE);
                    g.drawRect( previous_x, previous_y, initial_x - previous_x, initial_y - previous_y );

                    g.setColor( penColor );
                    g.drawRect( currentX, currentY, initial_x - currentX, initial_y - currentY) ;                

                    shape.start_x = currentX; 
                    shape.start_y = currentY; 
                    shape.width = initial_x - currentX;
                    shape.height = initial_y - currentY;
                    shape.color = penColor;
                    shape.type = "rect";

                    previousDirection = "NE";
                }
                if( currentX < initial_x && currentY > initial_y ) {
                    g.setColor( Color.WHITE );
                    g.drawRect( previous_x, initial_y, initial_x - previous_x, previous_y - initial_y );

                    g.setColor( penColor );
                    g.drawRect( currentX, initial_y, initial_x - currentX, currentY - initial_y) ;                

                    shape.start_x = currentX; 
                    shape.start_y = initial_y; 
                    shape.width = initial_x - currentX;
                    shape.height = currentY - initial_y;
                    shape.color = penColor;
                    shape.type = "rect";

                    previousDirection = "SE";
                }
                if( currentX > initial_x && currentY < initial_y ) {
                    g.setColor( Color.WHITE);
                    g.drawRect( initial_x, previous_y, previous_x - initial_x, initial_y - previous_y );

                    g.setColor( penColor );
                    g.drawRect( initial_x, currentY, currentX - initial_x, initial_y - currentY) ;                

                    shape.start_x = initial_x; 
                    shape.start_y = currentY; 
                    shape.width = currentX - initial_x;
                    shape.height = initial_y - currentY;
                    shape.color = penColor;
                    shape.type = "rect";

                    previousDirection = "NW";
                }
                if( currentX > initial_x && currentY > initial_y ) {
                    g.setColor( Color.WHITE);
                    g.drawRect( initial_x, initial_y, previous_x - initial_x , previous_y - initial_y );

                    g.setColor( penColor );
                    g.drawRect( initial_x, initial_y, currentX - initial_x, currentY - initial_y );                

                    shape.start_x = initial_x; 
                    shape.start_y = initial_y; 
                    shape.width = currentX - initial_x;
                    shape.height = currentY - initial_y;
                    shape.color = penColor;
                    shape.type = "rect";

                    previousDirection = "SW";
                }
            }
            else if( tool.equals("oval") ) 
            {
                currentX = me.getX();
                currentY = me.getY();

                if( previousDirection.equals( "NE" ) ) {
                    g.setColor( Color.WHITE);
                    g.drawOval( previous_x, previous_y, initial_x - previous_x, initial_y - previous_y );
                }
                else if( previousDirection.equals( "SE" ) ) {
                    g.setColor( Color.WHITE );
                    g.drawOval( previous_x, initial_y, initial_x - previous_x, previous_y - initial_y );

                }
                else if( previousDirection.equals( "NW" ) ) {
                    g.setColor( Color.WHITE);
                    g.drawOval( initial_x, previous_y, previous_x - initial_x, initial_y - previous_y );
                }
                else if( previousDirection.equals( "SW" ) ) {
                    g.setColor( Color.WHITE );
                    g.drawOval( initial_x, initial_y, previous_x - initial_x , previous_y - initial_y );
                }

                if( currentX < initial_x && currentY < initial_y ) {
                    g.setColor( Color.WHITE);
                    g.drawOval( previous_x, previous_y, initial_x - previous_x, initial_y - previous_y );

                    g.setColor( penColor );
                    g.drawOval( currentX, currentY, initial_x - currentX, initial_y - currentY) ;                

                    shape.start_x = currentX; 
                    shape.start_y = currentY; 
                    shape.width = initial_x - currentX;
                    shape.height =  initial_y - currentY;
                    shape.color = penColor;
                    shape.type = "oval";

                    previousDirection = "NE";
                }
                if( currentX < initial_x && currentY > initial_y ) {
                    g.setColor( Color.WHITE );
                    g.drawOval( previous_x, initial_y, initial_x - previous_x, previous_y - initial_y );

                    g.setColor( penColor );
                    g.drawOval( currentX, initial_y, initial_x - currentX, currentY - initial_y) ;                

                    shape.start_x = currentX; 
                    shape.start_y = initial_y; 
                    shape.width = initial_x - currentX;
                    shape.height = currentY - initial_y;
                    shape.color = penColor;
                    shape.type = "oval";

                    previousDirection = "SE";
                }
                if( currentX > initial_x && currentY < initial_y ) {
                    g.setColor( Color.WHITE);
                    g.drawOval( initial_x, previous_y, previous_x - initial_x, initial_y - previous_y );

                    g.setColor( penColor );
                    g.drawOval( initial_x, currentY, currentX - initial_x, initial_y - currentY) ;                

                    shape.start_x = initial_x; 
                    shape.start_y = currentY; 
                    shape.width = currentX - initial_x;
                    shape.height = initial_y - currentY;
                    shape.color = penColor;
                    shape.type = "oval";

                    previousDirection = "NW";
                }
                if( currentX > initial_x && currentY > initial_y ) {
                    g.setColor( Color.WHITE);
                    g.drawOval( initial_x, initial_y, previous_x - initial_x , previous_y - initial_y );

                    g.setColor( penColor );
                    g.drawOval( initial_x, initial_y, currentX - initial_x, currentY - initial_y );                

                    shape.start_x = initial_x; 
                    shape.start_y = initial_y; 
                    shape.width = currentX - initial_x;
                    shape.height = currentY - initial_y;
                    shape.color = penColor;
                    shape.type = "oval";

                    previousDirection = "SW";
                }
            }

            previous_x = me.getX();
            previous_y = me.getY();
            
        }   

        public void mouseMoved( MouseEvent me ) {
            g = getGraphics();

            for( int i=0; i<shapes.size(); i++ ) {
                Shape s = shapes.elementAt( i );

                g.setColor( s.color );
                if( s.type.equals("rect") ) {
                    g.drawRect( s.start_x, s.start_y, s.width, s.height );
                }
                else if( s.type.equals("oval") ){ 
                    g.drawOval( s.start_x, s.start_y, s.width, s.height );
                }
            }     
        }

        public void mouseReleased( MouseEvent me ) {
            first = true;
            g = getGraphics(); 
    
            if( !penInput ) {
                shapes.add( shape );
            }
            
            for( int i=0; i<shapes.size(); i++ ) {
                Shape s = shapes.elementAt( i );

                g.setColor( s.color );
                if( s.type.equals("rect") ) {
                    g.drawRect( s.start_x, s.start_y, s.width, s.height );
                }
                else if( s.type.equals("oval") ){ 
                    g.drawOval( s.start_x, s.start_y, s.width, s.height );
                }
            }
        }
    }

    public void temp() {
        repaint();
        g = getGraphics();        

        for( int i=0; i<shapes.size(); i++ ) {
            Shape s = shapes.elementAt( i );

            g.setColor( s.color );
            if( s.type.equals("rect") ) {
                g.drawRect( s.start_x, s.start_y, s.width, s.height );
            }
            else if( s.type.equals("oval") ){ 
                g.drawOval( s.start_x, s.start_y, s.width, s.height );
            }
        }     
    }

    class UndoEvent extends KeyAdapter {
        public void keyPressed( KeyEvent ke ) 
        {
            if( ke.getKeyCode() == KeyEvent.VK_CONTROL ) {
                ControlPressed = true;
            }
            else if( ControlPressed ) {
                if( ke.getKeyCode() == KeyEvent.VK_Z ) {
                    if( shapes.size() == 0 ){
                        return;
                    }
                    shapes.setSize( shapes.size()-1 );      
                    repaint();
                } 
            }
            else {
                ControlPressed = false;
            }
        }
    }

    public Canvas() {
        MyListener myListener = new MyListener();
        this.addMouseListener( myListener);
        this.addMouseMotionListener( myListener );
        this.addKeyListener( new UndoEvent() );
    }
}

public class Question19 extends Frame {
    Canvas c;

    public Question19() {
        this.setSize( 1600, 1000 ); 
        this.setLayout( null );
        Dimension currentDimension = this.getSize();
        
        // ratio of toolbar to canavas 3:10
        c = new Canvas( );
        ToolBar t = new ToolBar( c );

        t.setBounds( 0, 55, currentDimension.width, currentDimension.height / 5 );
        c.setBounds( 0, currentDimension.height / 4 , currentDimension.width, currentDimension.height - currentDimension.height/5 );

        // adding the componenets 
        add( t );
        add( c );
    }

    public static void main(String ar[] ){
        Question19 q = new Question19(); 
        
        q.setVisible(true);
    }
}