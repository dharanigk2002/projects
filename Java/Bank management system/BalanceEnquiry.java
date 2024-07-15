package atm_sim;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinno;
    JButton back;
    public BalanceEnquiry(String pinno){
        super("BALANCE ENQUIRY");
        this.pinno=pinno;
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        JLabel img=new JLabel(new ImageIcon(i1));
        img.setBounds(0,0,800,800);
        add(img);
        
        Conn c=new Conn();
        String query="select * from bank where pin='"+pinno+"';";  
        int balance=0;
            try{
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("type").equals("deposit"))
                    balance+=Integer.parseInt(rs.getString("amount"));
                else
                    balance-=Integer.parseInt(rs.getString("amount"));
            }
            }catch(Exception e){
                    System.out.println(e);
            }
        JLabel notify=new JLabel("Your current account balance is Rs."+balance);
        notify.setForeground(Color.WHITE);
        notify.setFont(new Font("System",Font.BOLD,14));
        notify.setBounds(140,280,300,30);
        img.add(notify);
        
        back=new JButton("Back");
        back.setBounds(316,457,140,30);
        back.setFocusable(false);
        img.add(back);
        back.addActionListener(this);
        
        setSize(800,800);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        dispose();
        new Transaction(pinno).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
