package atm_sim;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{
    JTextField amt;
    JButton withdraw,back;
    String pinno;
    Withdraw(String pinno){
        super("Withdraw");
        this.pinno=pinno;
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        JLabel img=new JLabel(new ImageIcon(i1));
        img.setBounds(0,0,800,800);
        add(img);
        
        JLabel label=new JLabel("Enter amount you want to withdraw:");
        label.setForeground(Color.WHITE);
        label.setFont((new Font("System",Font.BOLD,16)));
        label.setBounds(165,250,300,25);
        img.add(label);
        
        amt=new JTextField();
        amt.setBounds(165,295,270,30);
        amt.setFont(new Font("System",Font.PLAIN,25));
        img.add(amt);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(316,427,140,30);
        withdraw.setFocusable(false);
        img.add(withdraw);
        withdraw.addActionListener(this);
        
        back=new JButton("Back");
        back.setBounds(316,457,140,30);
        back.setFocusable(false);
        img.add(back);
        back.addActionListener(this);
        
        setSize(800,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==withdraw){
            String amount=amt.getText();
            java.util.Date date=new java.util.Date();
            if(amount.equals(""))
                JOptionPane.showMessageDialog(this, "Enter amount you want to withdraw");
            else{
                Conn c=new Conn();
                String query="insert into bank values('"+pinno+"','"+date+"','withdraw','"+amount+"');";
                try{
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Rs."+amount+" withdrawn successfully");
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }else {
            new Transaction(pinno).setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}
