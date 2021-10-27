import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Calculator {

    static int change=0;
    private static Frame calculator;
    private static Panel calciPanel;
    private static TextField afield,bfield,ansfield;
    static Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bmul,bsub,bdiv,bcl;

    public static void addComponenetToCalculator()
    {

	//code for calci panel

        calciPanel=new Panel();
        calciPanel.setBounds(25,50,350,135);
        calciPanel.setBackground(Color.LIGHT_GRAY);
        calciPanel.setVisible(true);
        calciPanel.setLayout(null);
        calculator.add(calciPanel);

        //adding component to calci panel

        Label al=new Label("a :");
        al.setBounds(50,10,40,30);
        al.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,25));
        calciPanel.add(al);
        afield=new TextField();
        afield.setBounds(100,10,200,30);
        afield.setFont(new Font("Arial",Font.ITALIC,25));
        afield.setEditable(false);
        afield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                change=0;
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        calciPanel.add(afield);

        Label bl=new Label("b :");
        bl.setBounds(50,50,40,30);
        bl.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,25));
        calciPanel.add(bl);
        bfield=new TextField();
        bfield.setBounds(100,50,200,30);
        bfield.setFont(new Font("Arial",Font.ITALIC,25));
        bfield.setEditable(false);
        bfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                change=1;
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        calciPanel.add(bfield);

        Label ansl=new Label("Ans :");
        ansl.setBounds(20,90,70,30);
        ansl.setFont(new Font("Arial",Font.ITALIC | Font.BOLD,25));
        calciPanel.add(ansl);
        ansfield=new TextField();
        ansfield.setBounds(100,90,200,30);
        ansfield.setFont(new Font("Arial",Font.ITALIC,25));
        ansfield.setEditable(false);
        calciPanel.add(ansfield);


        //code for button panel

        Panel p=new Panel();
        //p.setLocation(450,80);
        GridLayout gr=new GridLayout(5,3);
        p.setLayout(gr);
        gr.setVgap(5);
        gr.setHgap(5);
        p.setBackground(Color.LIGHT_GRAY);
        //p.setSize(300,400);
        p.setBounds(25,200,350,375);
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        b6=new Button("6");
        b7=new Button("7");
        b8=new Button("8");
        b9=new Button("9");
        bcl=new Button("AC");
        b0=new Button("0");
        badd=new Button("+");
        bsub=new Button("--");
        bmul=new Button("X");
        bdiv=new Button("/");

        bcl.setFont(new Font("Ariel",Font.BOLD,18));
        bcl.setBackground(Color.RED);
        badd.setFont(new Font("Ariel",Font.BOLD,30));
        badd.setBackground(Color.GREEN);
        bsub.setFont(new Font("Ariel",Font.BOLD,30));
        bsub.setBackground(Color.YELLOW);
        bmul.setFont(new Font("Ariel",Font.BOLD,20));
        bmul.setBackground(Color.PINK);
        bdiv.setFont(new Font("Ariel",Font.BOLD,30));
        bdiv.setBackground(Color.CYAN);

        b1.setFont(new Font("Ariel",Font.BOLD,18));
        b2.setFont(new Font("Ariel",Font.BOLD,18));
        b3.setFont(new Font("Ariel",Font.BOLD,18));
        b4.setFont(new Font("Ariel",Font.BOLD,18));
        b5.setFont(new Font("Ariel",Font.BOLD,18));
        b6.setFont(new Font("Ariel",Font.BOLD,18));
        b7.setFont(new Font("Ariel",Font.BOLD,18));
        b8.setFont(new Font("Ariel",Font.BOLD,18));
        b9.setFont(new Font("Ariel",Font.BOLD,18));
        b0.setFont(new Font("Ariel",Font.BOLD,18));

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bcl);
        p.add(b0);
        p.add(badd);
        p.add(bdiv);
        p.add(bmul);
        p.add(bsub);
        calculator.add(p);

        /*************** IMPLEMENTING BUTTONS ******************/

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "1");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"1");
                }
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "2");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"2");
                }
            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "3");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"3");
                }
            }
        });

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "4");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"4");
                }
            }
        });

        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "5");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"5");
                }
            }
        });

        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "6");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"6");
                }
            }
        });

        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "7");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"7");
                }
            }
        });

        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "8");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"8");
                }
            }
        });

        b9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "9");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"9");
                }
            }
        });

        b0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(change==0) {
                    afield.setText(afield.getText() + "0");
                }
                else if(change==1)
                {
                    bfield.setText(bfield.getText()+"0");
                }
            }
        });

        bcl.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                afield.setText("");
                bfield.setText("");
                ansfield.setText("");
                change=0;
            }
        });

        badd.addActionListener(new ActionListener() {
                                  public void actionPerformed(ActionEvent e) {
                                      ansfield.setText(""+(Integer.parseInt(afield.getText())+Integer.parseInt(bfield.getText())));
                                  }
                              });

        bsub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ansfield.setText(""+(Integer.parseInt(afield.getText())-Integer.parseInt(bfield.getText())));
            }
        });

        bmul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ansfield.setText(""+(Integer.parseInt(afield.getText())*Integer.parseInt(bfield.getText())));
            }
        });

        bdiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ansfield.setText(""+(Double.parseDouble(afield.getText())/Double.parseDouble(bfield.getText())));
            }
        });
    }

    public static void main(String argc[])
    {
        calculator=new Frame();
        calculator.setLayout(null);
        calculator.setVisible(true);
        calculator.setTitle("CALCULATOR");
        calculator.setSize(400,600);
        calculator.setBackground(Color.GRAY);
        addComponenetToCalculator();
    }
}
