import java.awt.*;
import java.awt.event.*; 

public class Question15 extends Frame { 
    TextField tf1, tf2, tf3, tf4;
    TicTacPanel t;

    class TicTacPanel extends Panel implements ActionListener {
        int player_turn=0;
        Button[] arr = new Button[9];
        int p1_wins=0, p2_wins=0, draw=0, gameCount=0;
        boolean gameOver = false;

        public TicTacPanel() {
            Font f = new Font("Times New Roman", Font.ITALIC, 75 );

            this.setLayout( new GridLayout( 3, 3, 5, 5 ) );

            Button b1 = new Button("");
            b1.setFont( f );
            b1.addActionListener( this );
            arr[0] = b1;

            Button b2 = new Button("");
            b2.setFont( f ); 
            b2.addActionListener( this );
            arr[1] = b2;

            Button b3 = new Button("");
            b3.setFont( f ); 
            b3.addActionListener( this );
            arr[2] = b3;

            Button b4 = new Button("");
            b4.setFont( f );
            b4.addActionListener( this );
            arr[3] = b4;

            Button b5 = new Button("");
            b5.setFont( f );
            b5.addActionListener( this );
            arr[4] = b5;

            Button b6 = new Button("");
            b6.setFont( f );
            b6.addActionListener( this );
            arr[5] = b6; 

            Button b7 = new Button("");
            b7.setFont( f );
            b7.addActionListener( this );
            arr[6] = b7; 

            Button b8 = new Button("");
            b8.setFont( f );
            b8.addActionListener( this );
            arr[7] = b8;

            Button b9 = new Button("");
            b9.setFont( f );
            b9.addActionListener( this );
            arr[8] = b9;

            add( b1 ); add( b2 ); add( b3 ); 
            add( b4 ); add( b5 ); add( b6 ); 
            add( b7 ); add( b8 ); add( b9 );
        }

        public void actionPerformed( ActionEvent ae ) {
            if( this.gameOver == true ) {
                return;
            }

            Button b = (Button) ae.getSource();

            if( b.getLabel().equals("") ) {
                if( this.player_turn == 0 ) {
                    b.setLabel( "X" );
                    this.player_turn = 1;
                }
                else { 
                    b.setLabel( "O" );
                    this.player_turn = 0;
                }

                // checking for draws 
                boolean flag= true;

                for( Button i : arr ) {
                    if( i.getLabel().equals("") ) {
                        flag= false;
                    }
                }
                
                if( flag == true ) {
                    this.gameOver = true;
                    resetMatrix();
                    
                    gameCount++;
                    draw++;

                    setDraw();
                    setGameCount();

                    return;
                }

                // checking if anyone of the two players won 

                // horizontal check
                for( int i=0; i<3; i++ ) { 
                    String temp = arr[ (3*i) ].getLabel(); 
                    flag = true; 

                    if( temp.equals("") ) {
                        continue;
                    }

                    for( int j=1; j<3; j++ ) {
                        if( temp != arr[ (3*i) + j ].getLabel() ) {
                            flag = false;
                            break;
                        }
                    }

                    if( flag == true ) {
                        if( temp == "X" ) {
                            p1_wins++;
                            setP1Wins();
                        }
                        else {
                            p2_wins++;
                            setP2Wins();
                        }

                        this.gameOver = true;
                        resetMatrix();
                        setGameCount();
                        gameCount++;
                    }
                }

                // vertical check
                for( int i=0; i<3; i++ ) { 
                    String temp = arr[ i ].getLabel(); 
                    flag = true; 

                    if( temp.equals("") ) {
                        continue;
                    }

                    for( int j=1; j<3; j++ ) {
                        if( temp != arr[ (3*j) + i ].getLabel() ) {
                            flag = false;
                            break;
                        }
                    }

                    if( flag == true ) {
                        if( temp == "X" ) {
                            p1_wins++;
                            setP1Wins();
                        }
                        else {
                            p2_wins++;
                            setP2Wins();
                        }

                        this.gameOver = true;
                        resetMatrix();
                        setGameCount();
                        gameCount++;
                    }
                }

                flag = false;
                String temp= arr[ 0 ].getLabel();

                // diagonal check 
                for( int i=0; i<3; i++ ) { 
                    if( temp.equals("") ) {
                        break;
                    }

                    flag = true; 

                    if( temp != arr[ (3*i) + i ].getLabel() ) {
                        flag = false;
                        break;
                    }
                }
                
                if( flag == true ) {
                    if( temp == "X" ) {
                        p1_wins++;
                        setP1Wins();
                    }
                    else {
                        p2_wins++;
                        setP2Wins();
                    }

                    this.gameOver = true;
                    resetMatrix();
                    setGameCount();
                    gameCount++;
                }

                flag = false;
                temp= arr[ 2 ].getLabel();

                // diagonal check 
                for( int i=0; i<3; i++ ) { 
                    if( temp.equals("") ) {
                        break;
                    }

                    flag = true; 

                    if( temp != arr[ (3*i) + (2-i) ].getLabel() ) {
                        flag = false;
                        break;
                    }
                }
                
                if( flag == true ) {
                    if( temp == "X" ) {
                        p1_wins++;
                        setP1Wins();
                    }
                    else {
                        p2_wins++;
                        setP2Wins();
                    }

                    this.gameOver = true;
                    resetMatrix();
                    setGameCount();
                    gameCount++;
                }
            }
        }

        public void resetMatrix( ) {
            for( Button i : arr ) {
                i.setLabel("");
            }

            this.gameOver = false;
        }
    }
    
    public Question15() {
        Font large = new Font("Segoe UI", Font.BOLD, 28 );

        t = new TicTacPanel(); 
        t.setBounds( 50, 170, 500, 500 );

        Button resetButton = new Button("Reset Matrix");
        resetButton.setBounds( 50, 50, 500, 100 );
        resetButton.addActionListener( new ActionListener( ) {
            public void actionPerformed( ActionEvent ae ) {
                t.resetMatrix();
            }
        });

        Label l1 = new Label("Game Count");
        l1.setBounds( 600, 50, 300, 40 );
        l1.setFont( large );

        tf1 = new TextField( "0" );
        tf1.setBounds( 600, 100, 300, 40 );
        tf1.setFont( large );
        tf1.setEditable( false );

        Label l2 = new Label("Player-1 (X)");
        l2.setBounds( 600, 150, 300, 40 );
        l2.setFont( large );

        tf2 = new TextField( "0" );
        tf2.setBounds( 600, 200, 300, 40 );
        tf2.setFont( large );
        tf2.setEditable( false );

        Label l3 = new Label("Player-2 (Y)");
        l3.setBounds( 600, 250, 300, 40 );
        l3.setFont( large );

        tf3 = new TextField( "0" );
        tf3.setBounds( 600, 300, 300, 40 );
        tf3.setFont( large );
        tf3.setEditable( false );

        Label l4 = new Label("Draw");
        l4.setBounds( 600, 350, 300, 40 );
        l4.setFont( large );

        tf4 = new TextField( "0"); 
        tf4.setBounds( 600, 400, 300, 40 );
        tf4.setFont( large );
        tf4.setEditable( false );

        Button resetGame = new Button( "Reset Game");
        resetGame.setBounds( 600, 500, 300, 50 );
        resetGame.setFont( large );
        resetGame.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                t.gameCount=0;
                t.p1_wins=0; 
                t.p2_wins=0; 
                t.draw=0; 

                t.resetMatrix();

                setGameCount();
                setP1Wins(); 
                setP2Wins();
                setDraw();
            }
        });

        this.setLayout( null );

        this.add( resetButton );
        this.add( t );
        this.add( l1 );
        this.add( l2 ); 
        this.add( l3 ); 
        this.add( l4 );
        this.add( tf1 );
        this.add( tf2 );
        this.add( tf3 );
        this.add( tf4 );
        this.add( resetGame );
    }

    public void setGameCount() {
        tf1.setText( "" + t.gameCount );
    }

    public void setP1Wins() {
        tf2.setText( "" + t.p1_wins );
    }

    public void setP2Wins() {
        tf3.setText( "" + t.p2_wins );
    }

    public void setDraw() {
        tf4.setText( "" + t.draw );
    }

    public static void main( String ar[] ) {
        Question15 q = new Question15(); 
        q.setSize( 1600, 1000 ); 
        q.setVisible( true ); 
        q.setTitle("TIC TAC TOE");
    }
}


