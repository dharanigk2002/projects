package atm_sim;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class MiniStatement extends JFrame{
    String pinno;
    public MiniStatement(String pinno){
        super("MINI STATEMENT");
        this.pinno=pinno;
        String str="INDIAN NATIONAL BANK";
        JLabel label=new JLabel(str);
        label.setFont(new Font("Times new roman",Font.BOLD,20));
        label.setBounds(100,20,300,30);
        add(label);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,30);
        card.setFont(new Font("Raleway",Font.BOLD,16));
        add(card);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,200,480,100);
        mini.setFont(new Font("Raleway",Font.BOLD,16));
        add(mini);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,140,400,30);
        balance.setFont(new Font("Raleway",Font.BOLD,16));
        add(balance);
        try{
            int bal=0;
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinno+"';");
            if(rs.next()){
                card.setText("Card number: "+rs.getString("cardNo").substring(0,4)+"-XXXX-XXXX-XXXX");
            }
            rs=c.s.executeQuery("select * from bank where pin='"+pinno+"';");
            while(rs.next()){
                if(rs.getString("type").equals("deposit"))
                    bal+=Integer.parseInt(rs.getString("amount"));
                else
                    bal-=Integer.parseInt(rs.getString("amount"));
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs."+rs.getString("amount")+"<br><br>");
            }
            balance.setText("Available balance is Rs."+bal);
        }catch(Exception ex){System.out.println(ex);}
        
        setLayout(null);
        setSize(450,800);
        setLocation(0,0);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
