package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class Score extends JFrame implements ActionListener{
    String name;
    public static int score=0;
    JButton next;
    Score(String name,int score){
        super("Score");
        this.score=score;
        this.name=name;
        setSize(750,550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icons/score.png"));
        Image i2=img.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        JLabel l=new JLabel(new ImageIcon(i2));
        l.setBounds(0,200,300,250);
        add(l);
        
        JLabel l1=new JLabel("Thank you "+name+" for playing Quiz times");
        l1.setBounds(200,40,480,30);
        l1.setFont(new Font("System",Font.PLAIN,25));
        add(l1);
        
        JLabel sc=new JLabel("Your score is "+score);
        sc.setBounds(320,225,400,30);
        sc.setFont(new Font("System",Font.PLAIN,25));
        add(sc);
        
        next=new JButton("Play again");
        next.setFont(new Font("Tahoma",Font.PLAIN,14));
        next.setBackground(new Color(50,150,250));
        next.setFocusable(false);
        next.setForeground(Color.WHITE);
        next.setBounds(340,280,140,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
            setVisible(false);
            new Login();
        }
    } 
    public static void main(String[] args) {
        new Score("user",0);
    }
}
