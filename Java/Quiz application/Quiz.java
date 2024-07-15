package quiz;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Quiz extends JFrame implements ActionListener{
    String questions[][]=new String[10][5];
    String answers[]=new String[10],user[]=new String[10];
    JRadioButton opt[]=new JRadioButton[4];
    JLabel qNo,qn;
    JButton next,life,submit;
    public static int time=15,count=0;
    public int ans=0,score=0;
    ButtonGroup grp;
    String name;
    Quiz(String name){
        super("Quiz");
        this.name=name;
        setSize(1200,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icons/quiz.jpg"));
        JLabel l=new JLabel(img);
        l.setBounds(0,0,1200,300);
        add(l);
        
        qNo=new JLabel();
        qNo.setBounds(40,340,30,30);
        qNo.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qNo);
        
        qn=new JLabel();
        qn.setBounds(70,340,1200,30);
        qn.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qn);
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0] = "JDB";
        answers[1] = "int";
        answers[2] = "java.util package";
        answers[3] = "Marker Interface";
        answers[4] = "Heap memory";
        answers[5] = "Remote interface";
        answers[6] = "import";
        answers[7] = "Java Archive";
        answers[8] = "java.lang.StringBuilder";
        answers[9] = "Bytecode is executed by JVM";
        int x=0;
        grp=new ButtonGroup();
        for(int i=0;i<4;i++){
            opt[i]=new JRadioButton();
            opt[i].setFont(new Font("Tahoma",Font.PLAIN,20));
            opt[i].setBounds(80,390+x,500,30);
            x+=40;
            grp.add(opt[i]);
            opt[i].setBackground(Color.WHITE);
            opt[i].setFocusable(false);
            add(opt[i]);
        }
        
        start(count);
        
        next=new JButton("Next");
        next.setFont(new Font("Tahoma",Font.PLAIN,20));
        next.setBackground(new Color(50,150,250));
        next.setFocusable(false);
        next.setForeground(Color.WHITE);
        next.setBounds(900,400,180,30);
        next.addActionListener(this);
        add(next);
        
        life=new JButton("50-50 lifeline");
        life.setFont(new Font("Tahoma",Font.PLAIN,20));
        life.setBackground(new Color(50,150,250));
        life.setFocusable(false);
        life.setForeground(Color.WHITE);
        life.setBounds(900,470,180,30);
        life.addActionListener(this);
        add(life);
        
        submit=new JButton("Submit");
        submit.setFont(new Font("Tahoma",Font.PLAIN,20));
        submit.setBackground(new Color(50,150,250));
        submit.setFocusable(false);
        submit.setForeground(Color.WHITE);
        submit.setBounds(900,540,180,30);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
                
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
  
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
            repaint();
            for(JRadioButton i:opt)
                i.setEnabled(true);
            life.setEnabled(true);
            time=15;
            ans=1;
            user[count]="";
            for(JRadioButton i:opt)
                if(i.isSelected())
                    user[count]=i.getText(); 
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count); 
        }else if(e.getSource()==life){
            for(JRadioButton i:opt)
                i.setSelected(false);
            if(count%2==0 || count==9){
                opt[1].setEnabled(false);
                opt[2].setEnabled(false);
            }else{
                opt[0].setEnabled(false);
                opt[3].setEnabled(false);
            }
            life.setEnabled(false);
        }else if(e.getSource()==submit){
            user[count]="";
                for(JRadioButton i:opt)
                    if(i.isSelected()){
                        user[count]=i.getText(); 
                        break;
                    }
                for(JRadioButton i:opt)
                    i.setEnabled(true);
                for(int i=0;i<10;i++){
                    if(user[i].equals(answers[i]))
                        score+=10;
                }
                setVisible(false);
                new Score(name,score).setVisible(true);
            }
        }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        String disp="Time left - "+time+" seconds";
        g.setFont(new Font("Tahoma",Font.PLAIN,20));
        if(time>0){
            g.drawString(disp, 900, 390);
        }else{
            g.drawString("Times up!!!", 900, 390);
        }
        time--;
                try{
            Thread.sleep(1000);
            repaint();
        }catch(InterruptedException ex){System.out.println(ex);}
        if(ans==1){
            ans=0;
        }else if(time<0){
            time=15;
            life.setEnabled(true);
            if(count==8){
                submit.setEnabled(true);
                next.setEnabled(false);
            }
            if(count==9){
                user[count]="";
                for(JRadioButton i:opt)
                    if(i.isSelected()){
                        user[count]=i.getText(); 
                        break;
                    }
                for(JRadioButton i:opt)
                    i.setEnabled(true);
                for(int i=0;i<10;i++){
                    if(user[i].equals(answers[i]))
                        score+=10;
                }
                setVisible(false);
                new Score(name,score);
            }else{
                user[count]="";
                for(JRadioButton i:opt)
                    if(i.isSelected()){
                        user[count]=i.getText(); 
                        break;
                    }
                for(JRadioButton i:opt)
                    i.setEnabled(true);
            }
            count++;
            start(count);
        }
    }
    public void start(int num){
        qNo.setText(""+(num+1)+".");
        qn.setText(questions[num][0]);
        for(int i=0;i<4;i++)
            opt[i].setText(questions[num][i+1]);
        grp.clearSelection();
    }
    public static void main(String[] args) {
        new Quiz("");
    }
}
