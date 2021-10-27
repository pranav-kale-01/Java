import java.awt.*; 
import java.awt.event.*; 
import java.util.Random;

class PopupDialog extends Dialog implements ActionListener {
    public PopupDialog( Window obj ) {
        super( obj );

        this.setLayout( new GridLayout(2,1) );
        Label lb1 = new Label("You Won!"); 
        add( lb1 );

        Button OkButton = new Button("OK");
        OkButton.setSize( 100, 100 );
        OkButton.addActionListener( this );

        add( lb1 );
        add( OkButton );

        this.setSize( 200, 200 );
    }


    public void showDialog() {
        this.setVisible(true);
    }

    public void actionPerformed( ActionEvent ae ) {
        this.dispose();
    }
}


class MainPanel extends Panel {
    int fWidth, fHeight; 
    Button array[];
    MainPanel currentFrame;
    Frame mainFrame;
    boolean flag = true;
    boolean openDialog = false;
    static final int limit = 3;

    public MainPanel( Frame mainFrame ) {
        Font large = new Font("Times New Roman", Font.PLAIN, 38 );
        this.mainFrame = mainFrame;
        currentFrame = this;
        array = new Button[9];

        this.setLayout( new GridLayout( 3, 3, 3, 3) );

        for( int i=0; i<8; i++ ) {
            Button btn = new Button("" + (i+1));
            btn.setSize( 100, 100 );
            btn.setLocation( 10, 200 );
            btn.addMouseListener( new Slide() );
            btn.setFont( large );
            array[i] = btn;
            this.add( array[i] );
        }

        this.shuffleButtons();
    }

    class Slide extends MouseAdapter{
        boolean changed = false;

        public void mouseEntered( MouseEvent me ) {
            if( flag == true ) {
                Dimension windowSize = currentFrame.getSize();
                double height = ( windowSize.height ) / 3.0, width = ( windowSize.width  +  2) / 3.0;
                int count = 0; 

                Button temp = (Button)me.getSource();
                Point location = temp.getLocation();

                Button currentButton = (Button) me.getSource();
                for( int i=0; i<array.length; i++ ){
                    if( array[i] == currentButton ) {
                        break;
                    }
                    count++;
                }

                int x_pos = count / 3; 
                int y_pos = count % 3;

                if( x_pos-1 >= 0 ) {
                    if( array[ (3*(x_pos-1) ) + y_pos ] == null ) {
                        array[ (3*(x_pos-1) ) + y_pos ] = array[count];
                        array[count] = null;
                        
                        for( double i=0; i<= height; i+= height/50 ) {
                            try{
                                Thread.sleep( 1 );
                            }catch( Exception e ) {}
                            temp.setLocation( location.x, ( location.y ) - (int) i );
                        }
                    }
                }
                if( x_pos+1 < 3 ) {   
                    if( array[ ( (3*(x_pos+1) ) + y_pos ) ]== null ) {
                        array[ ( (3*(x_pos+1) ) + y_pos ) ] = array[count];
                        array[count] = null;
                        
                        for( double i=0; i<= height; i+= height/50 ) {
                            try{
                                Thread.sleep( 1 );
                            }catch( Exception e ) {}
                            temp.setLocation( location.x, ( location.y ) + (int) i );
                        }
                    }
                }
                if( y_pos-1 >= 0 ) {
                    
                    if( array[ ( (3*x_pos) + (y_pos-1) ) ]== null ) {
                        array[ ( (3*x_pos) + (y_pos-1) ) ] = array[count];
                        array[count] = null;

                        for( double i=0; i<= width; i+= width/50 ) {
                            try{
                                Thread.sleep( 1 );
                            }catch( Exception e ) {}
                            temp.setLocation( location.x - (int) i, location.y );
                        }
                    }
                }
                if( y_pos+1 < 3 ) {

                    if( array[ ( (3*x_pos) + (y_pos+1) ) ]== null ) {
                        array[ ( (3*x_pos) + (y_pos+1) ) ] = array[count];
                        array[count] = null;

                        for( double i=0; i<= width; i+= width/50 ) {
                            try{
                                Thread.sleep( 1 );
                            }catch( Exception e ) {}
                            temp.setLocation( location.x + (int)i, location.y );
                        }
                    }
                }

                // checking if won
                count=1;
                boolean won = true;

                for( Button i :  array ) {
                    if( i != null ){
                        if( Integer.parseInt( i.getLabel() ) != count ) {
                            won = false;
                            openDialog = true;
                            break;
                        }
                    }
                    count++;
                }      

                if( won == true && openDialog == true ) {
                    PopupDialog d = new PopupDialog( mainFrame );

                    flag = false;
                    openDialog = false;
                    d.showDialog();
    
                    System.out.println("You Won!");
                    return;
                }
               
                // System.out.print("[[");
                // for( int i=0; i<9; i++ ) {
                //     if( array[i] != null ){
                //         System.out.print( array[i].getLabel() + ", " );
                //     }
                //     else{
                //         System.out.print( "null, " );
                //     }

                //     if( (i+1)%3 == 0 ) {
                //         System.out.print( i == 8 ? "]" : "]\n[ " );
                //     }
                // }
                // System.out.println("]");
            }
        }
    }

    /*
    * refreshes the screen
    */
    private void resetScreen() {

        // removing and re-adding to parent window 
        // mainFrame.remove( this );
        // mainFrame.add( this );

        // removing all the elements from the grid and adding them again
        for( Button i : array ) {
            if( i != null ) {
                this.remove( i );
            }
        }

        for( Button i : array ) {
            if( i!= null ) {
                this.add( i );
            }
        }

        
    }

    /*
    * shuffles the current puzzle.. 
    */
    public void shuffleButtons() {
        // if the null button is not on index 8 then getting it to index 8         
        int count=0; 

        while( array[count] != null && count <8 ) 
        {
            count++;
        }

        if( count != 8 ) {
            while( count!= 8 ) {
                Point location = new Point( (count%3) * 200 , (count/3) * 200 );

                array[count] = array[count+1];
                array[count].setLocation( location );
                array[count+1] = null;

                count++;
            }
            
            resetScreen();
        }   
    
        // randomly swapping the buttons 
        Random r = new Random();

        int limit = r.nextInt(1000);

        if( limit%2 != 0 ) {
            limit+=1;
        }
    
        for( int i=0; i<limit; i++ ) {
            int first = r.nextInt(7);
        
            String temp = array[first+1].getLabel();
            array[first+1].setLabel( array[first].getLabel() );
            array[first].setLabel( temp );
        }
    }

    private void moveUp( int null_index ) {
        System.out.print("Move Up");
        int null_vertical = null_index/3; 
        int null_horizontal = null_index%3;

        if( null_vertical == 0 ) {
            return;
        }

        // moving the null down by one, by swapping 
        int swapping_index = limit * (null_vertical-1) + null_horizontal;
        double height = ( currentFrame.getSize().height +2 ) / 3.0, width = ( currentFrame.getSize().width + 2) / 3.0;
        
        for( double i=0 ; i< height; i+=height/50 ) {
            try{
                Thread.sleep( 1 );
            }
            catch( Exception e ) {}
            if( array[swapping_index] == null ) {
                break;
            }
            array[swapping_index].setLocation( null_horizontal * 200, (null_vertical-1)*200 + (int) i );
        }

        array[null_index] = array[swapping_index];
        array[swapping_index] = null;            
    }

    private void moveDown( int null_index ) {
        System.out.print("Move Down ");
        int null_vertical = null_index/3; 
        int null_horizontal = null_index%3;

        // moving the null down by one, by swapping 
        int swapping_index = limit * (null_vertical+1) + null_horizontal;
        double height = ( currentFrame.getSize().height +2 ) / 3.0, width = (  currentFrame.getSize().width  +  2) / 3.0;

        for( double i=0 ; i< height; i+=height/50 ) {
            try{
                Thread.sleep( 1 );
            }
            catch( Exception e ) {}
            array[swapping_index].setLocation( null_horizontal * 200, (null_vertical+1)*200 - (int) i  );
        }

        array[null_index] = array[swapping_index];
        array[swapping_index] = null;            
    }

    private void moveRight( int null_index ) {
        System.out.print("Move Right ");
        int null_vertical = null_index/3; 
        int null_horizontal = null_index%3;

        // moving the null down by one, by swapping 
        int swapping_index = limit *null_vertical + (null_horizontal+1);
        double height = ( currentFrame.getSize().height +2 ) / 3.0, width = (  currentFrame.getSize().width  +  2) / 3.0;

        for( double i=0 ; i< height; i+=height/50 ) {
            try{
                Thread.sleep( 1 );
            }
            catch( Exception e ) {}
            array[swapping_index].setLocation( (null_horizontal+1)*200 - (int)i, null_vertical*200  );
        }

        array[null_index] = array[swapping_index];
        array[swapping_index] = null;   
    }

    private void moveLeft( int null_index ) {
        System.out.print("Move Left ");
        int null_vertical = null_index/3; 
        int null_horizontal = null_index%3;

        // moving the null down by one, by swapping 
        int swapping_index = limit*null_vertical + (null_horizontal-1);

        System.out.println( swapping_index );
        double height = ( currentFrame.getSize().height +2 ) / 3.0, width = (  currentFrame.getSize().width  +  2) / 3.0;

        for( double i=0 ; i< height; i+=height/50 ) {
            try{
                Thread.sleep( 1 );
            }
            catch( Exception e ) {}
            array[swapping_index].setLocation( (null_horizontal-1)* 200 + (int)i, null_vertical*200  );
        }

        array[null_index] = array[swapping_index];
        array[swapping_index] = null;   
    }


    private void moveBlockToLeft( int to_move ) {
        int null_index=0; 
        int null_vertical, null_horizontal;
        int to_move_index=0;
        int to_move_vertical, to_move_horizontal;

        // finding on which index is currenly null located 
        for( Button b : array ) {
            if( b == null ) {
                break;
            }
            null_index++;
        }
    
        null_vertical = null_index/3; 
        null_horizontal = null_index%3;

        // finding on what is the to_move number is present 
        for( Button b : array ) {
            if( b != null && b.getLabel().equals(""+to_move) ) {
                break;
            }
            to_move_index++;
        }

        // getting to horizontal lane which is either one less than or more than the to_move's horizontal lane 
        to_move_horizontal = to_move_index % limit;
        to_move_vertical = to_move_index / limit;
        
        int difference = to_move_vertical - null_vertical;

        while( difference != -1 && difference != 1 ) {
            if( difference <= 0 && (null_vertical) != 0 ) {
                moveUp( null_index );
                null_index = limit * (null_vertical-1) + (null_horizontal);
                difference++;
            }
            else if( difference >= 0 && null_vertical != limit-1 ) {
                moveDown( null_index );
                null_index = limit* (null_vertical+1) + (null_horizontal);
                difference--;
            }
            else {
                break;
            }
        }

        // if the block is not on the left most vertical pane then getting to the lane to its left, it it's on the left most horizontal lane then returning 
        if( to_move_horizontal == 0 ){
            return;
        }
        else {  
            null_index =0;
            // finding on which index is currenly null located 
            for( Button b : array ) {
                if( b == null ) {
                    break;
                }
                null_index++;
            }
        
            null_vertical = null_index/3; 
            null_horizontal = null_index%3;

            difference = to_move_horizontal - null_horizontal; 

            while( difference != 1 ) {
                if(difference >= 1 ) {
                    difference--;
                    moveRight( null_index );
                    null_index = limit* (null_vertical) + (null_horizontal+1);

                    System.out.println( null_index );
                }
                else if( difference <=0 ) {
                    difference++;
                    moveLeft( null_index );
                    null_index = limit*(null_vertical) + (null_horizontal-1);
                }
            }

            // checking if null_block is below or above to_move block

            null_index =0;
            // finding on which index is currenly null located 
            for( Button b : array ) {
                if( b == null ) {
                    break;
                }
                null_index++;
            }
        
            null_vertical = null_index/3; 
            null_horizontal = null_index%3;

            difference = to_move_vertical - null_vertical ;

            if( difference == -1 ) {
                difference++; 
                moveUp( null_index );
                null_index = limit*(null_vertical-1) + (null_horizontal);
            }
            else if( difference == 1 ) {
                difference--; 
                moveDown( null_index );
                null_index = limit*(null_vertical+1) + (null_horizontal);
            }

            // swapping the element to it's right ( which will always be the to_move block )
            moveRight( null_index );
        }
    }

    private void moveBlockToUp( int to_move ) {
        // finding where the block with specified label is in the grid
        int to_move_index = 0; 
        int to_move_horizontal, to_move_vertical; 

        for( Button i : array ) {
            if( i != null && i.getLabel().equals("" + to_move) ) {
                break;
            }
            to_move_index++;
        }

        to_move_vertical = to_move /3;
        to_move_horizontal = to_move %3;

        // if the destination block's horizontal lane is 0 
        if( to_move_horizontal == 0 ) {
            return;
        }
        else {
            int null_index =0;

            // finding on which index is currenly null located 
            for( Button b : array ) {
                if( b == null ) {
                    break;
                }
                null_index++;
            }
        
            int null_vertical = null_index /3; 
            int null_horizontal = null_index %3;

            // if the null block is below the destination block 
            if( null_horizontal - to_move_horizontal > 0 ) {
                System.out.println( "\ntest"  );
                System.out.println( "\n" +  (null_horizontal - to_move_horizontal) );
                int temp = null_vertical - to_move_vertical ;

                while( temp != 0 ) { 
                    if( temp > 1 ) {
                        moveLeft( null_index );
                        null_index = (limit*null_horizontal-1) + null_vertical;
                        temp--;
                    }
                    else {
                        moveRight( null_index );
                        null_index = (limit*null_horizontal+1) + null_vertical;
                        temp++;
                    }
                }
            }
            
        }
    }

    /*
    * Solves only 3x3 puzzle...
    */
    public void autoSolve( ) {
        int block_to_move =1; 

        // getting the block with label 1 to the left most position
        int block_index =0, block_vertical, block_horizontal;

        // checking if on which vertical lane the block currently lies
        for( Button i : array ) {
            if( i != null && i.getLabel().equals("" + block_to_move ) ) {
                break;
            }
            block_index++;
        }

        block_vertical = block_index /3;
        block_horizontal = block_index %3;

        System.out.println( "Step 2");

        while( block_horizontal > 0 ) {
            moveBlockToLeft( block_to_move );
            block_horizontal--;
        }
        

        // getting the block to the top-most position on the grid
        moveBlockToUp( block_to_move );
    }
}

public class Question12 extends Frame implements ActionListener {
    MainPanel mp;

    public Question12() {
        this.setLayout( null );

        mp = new MainPanel( this );
        mp.setBounds( 150, 150 , 600, 600  );

        Button resetButton  = new Button("RESET");
        resetButton.setBounds( 150, 800, 200, 40);
        resetButton.addActionListener( this );

        Button autoButton = new Button("AUTO SOLVE"); 
        autoButton.setBounds( 500, 800, 200, 40 );
        autoButton.addActionListener( this );

        this.add( mp );
        this.add( resetButton );
        this.add( autoButton );
    } 


    public void actionPerformed( ActionEvent ae ) {
        String command = ae.getActionCommand();

        if( command.equals("RESET") ) {
            mp.shuffleButtons();
            mp.flag = true ;
        }
        else if( command.equals("AUTO SOLVE") ) {
            mp.autoSolve();
        }
    }

    public static void main(String ar[] ) {
        Question12 q12 = new Question12( );
        q12.setSize( 1600 , 1000 );
        q12.setVisible( true );
    }
}