import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.event.*;

class ShapePallete extends Panel {
    public ShapePallete( ) {
        this.setLayout( new GridLayout( 3, 1, 10, 10 ) );
        this.setBounds( 50, 50, 300, 140 );

        Button lineButton = new Button("Square"); 
        lineButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                Canvas.tool = "sqaure";
            }
        });
        this.add(lineButton);
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
            }
        });

        this.add( clearAllButton );
    }
}

class Canvas extends Panel {
    Graphics g; 
    static String tool = "pen";
    static Color penColor = Color.BLACK;
    static int penThickness = 1;
    boolean first = true;
    int previous_x, previous_y;
    int initial_x, initial_y;

    class MyListener extends MouseInputAdapter {
        public void mouseDragged( MouseEvent me ) {
            g = getGraphics();
            g.setColor( penColor );

            if( first ) {
                initial_x = me.getX(); 
                initial_y = me.getY();

                previous_x = me.getX();
                previous_y = me.getY();
                first = false;
            }

            if( tool.equals( "pen" ) ) {
                g.drawLine( previous_x, previous_y, me.getX(), me.getY() );

                if( penThickness >= 2 ) {
                    g.drawLine( previous_x+1, previous_y-1, me.getX()+1, me.getY()-1 );
                }
                if( penThickness >= 3 ) {
                    g.drawLine( previous_x-1, previous_y+1, me.getX()-1, me.getY()+1 );
                }
                if( penThickness >= 4 ) {
                    g.drawLine( previous_x-2, previous_y+2, me.getX()-2, me.getY()+2 );
                }
                
                previous_x = me.getX();
                previous_y = me.getY();
            }
            else if( tool.equals("sqaure") ) {
                System.out.println("Square");

                g.setColor( penColor );
                g.drawRect( initial_x, initial_y, me.getX() - previous_x, me.getY() - previous_y );

                g.setColor( Color.WHITE );
                g.drawRect( initial_x, initial_y, previous_x - initial_x, previous_y - initial_y );
            }

        }

        public void mouseReleased( MouseEvent me ) {
            first = true;
        }
    }

    public Canvas() {
        g = getGraphics();
        
        MyListener myListener = new MyListener();
        this.addMouseListener( myListener);
        this.addMouseMotionListener( myListener );
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
        c.setBounds( 0, currentDimension.height / 5, currentDimension.width, currentDimension.height - currentDimension.height/5 );

        // adding the componenets 
        add( t );
        add( c );
    }

    public static void main(String ar[] ){
        Question19 q = new Question19(); 
        
        q.setVisible(true);
    }
}