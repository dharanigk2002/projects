package quiz;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    JTextField nameText;
    JButton rules,back;
    Login(){
        super("Login page");
        setSize(1200,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icons/login.jpeg"));
        JLabel l=new JLabel(img);
        l.setBounds(0,0,600,500);
        add(l);
        
        JLabel heading=new JLabel("Quiz time");
        heading.setFont(new Font("MV Boli",Font.BOLD,50));
        heading.setForeground(new Color(50,150,250));
        heading.setBounds(800,35,300,35);
        add(heading);
        
        JLabel name=new JLabel("Enter your name");
        name.setFont(new Font("Sans serif",Font.BOLD,20));
        name.setForeground(new Color(50,150,250));
        name.setBounds(815,140,180,30);
        add(name);
        
        nameText=new JTextField("User");
        nameText.setFont(new Font("Sans serif",Font.PLAIN,14));
        nameText.setBounds(730,180,350,25);
        add(nameText);
        
        rules=new JButton("Rules");
        rules.setBackground(new Color(50,150,250));
        rules.setFont(new Font("Sans serif",Font.BOLD,14));
        rules.setBounds(730,230,80,30);
        rules.setForeground(Color.WHITE);
        rules.setFocusable(false);
        rules.addActionListener(this);
        add(rules);
        
        back=new JButton("Back");
        back.setBackground(new Color(50,150,250));
        back.setFont(new Font("Sans serif",Font.BOLD,14));
        back.setBounds(1000,230,80,30);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==rules){
            String name=nameText.getText();
            setVisible(false);
            new Rules(name).setVisible(true);
        }
        if(e.getSource()==back){
            System.exit(0);
        }
    }    
    public static void main(String[] args) {
        new Login();
    }
    
}
