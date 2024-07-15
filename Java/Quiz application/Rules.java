package quiz;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener{
    String name;
    JButton back,start;
    Rules(String name){
        super("Rules");
        this.name=name;
        setSize(800,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JLabel wel=new JLabel("Welcome "+name+" to quiz time");
        wel.setFont(new Font("Ink Free",Font.BOLD,30));
        wel.setForeground(new Color(50,150,250));
        wel.setBounds(40,45,560,35);
        add(wel);
        
        JLabel rule=new JLabel();
        rule.setFont(new Font("System",Font.BOLD,16));
        rule.setBounds(40,10,700,500);
        rule.setText("<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>");
        add(rule);
        
        start=new JButton("Start");
        start.setBackground(new Color(50,150,250));
        start.setFont(new Font("Sans serif",Font.BOLD,14));
        start.setBounds(430,450,80,30);
        start.setForeground(Color.WHITE);
        start.setFocusable(false);
        start.addActionListener(this);
        add(start);
        
        back=new JButton("Back");
        back.setBackground(new Color(50,150,250));
        back.setFont(new Font("Sans serif",Font.BOLD,14));
        back.setBounds(330,450,80,30);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }else{
            setVisible(false);
            new Quiz(name).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Rules("user");
    }
}