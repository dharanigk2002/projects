package atm_sim;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePin extends JFrame implements ActionListener{
    JPasswordField pin,rpin;
    JButton change,back;
    String pinno;
    public ChangePin(String pinno){
        super("PIN CHANGE");
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        JLabel img=new JLabel(new ImageIcon(i1));
        img.setBounds(0,0,800,800);
        add(img);
        
        JLabel label=new JLabel("CHANGE YOUR PIN");
        label.setForeground(Color.WHITE);
        label.setFont((new Font("System",Font.BOLD,20)));
        label.setBounds(200,260,200,25);
        img.add(label);
        
        JLabel epin=new JLabel("Enter new PIN:");
        epin.setForeground(Color.WHITE);
        epin.setFont((new Font("System",Font.BOLD,16)));
        epin.setBounds(140,310,170,25);
        img.add(epin);
        
        pin=new JPasswordField(4);
        pin.setBounds(300,310,156,20);
        pin.setFont(new Font("System",Font.BOLD,20));
        img.add(pin);
        
        JLabel repin=new JLabel("Re-enter new PIN:");
        repin.setForeground(Color.WHITE);
        repin.setFont((new Font("System",Font.BOLD,16)));
        repin.setBounds(140,360,170,25);
        img.add(repin);
        
        rpin=new JPasswordField(4);
        rpin.setBounds(300,360,156,20);
        rpin.setFont(new Font("System",Font.BOLD,20));
        img.add(rpin);
        
        change=new JButton("Change");
        change.setBounds(316,424,140,30);
        change.setFocusable(false);
        img.add(change);
        change.setFont(new Font("System",Font.BOLD,14));
        change.addActionListener(this);
        
        back=new JButton("Back");
        back.setBounds(316,457,140,30);
        back.setFocusable(false);
        img.add(back);
        back.setFont(new Font("System",Font.BOLD,14));
        back.addActionListener(this);
        
        setVisible(true);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String pinNo=pin.getText();
        String rpinNo=rpin.getText();
        if(e.getSource()==change){
            if(!pinNo.equals(rpinNo)){
                JOptionPane.showMessageDialog(this,"Entered pin doesn't match");
                return;
            }
            if(pinNo.equals("") || rpinNo.equals("")){
                JOptionPane.showMessageDialog(this,"Fill all fields","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                Conn c=new Conn();
                String query="update bank set pin='"+rpinNo+"' where pin='"+pinno+"';";
                String query1="update login set pin='"+rpinNo+"' where pin='"+pinno+"';";
                String query2="update signup3 set pin='"+rpinNo+"' where pin='"+pinno+"';";
                try{
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(this,"PIN changed successfully");
                    setVisible(false);
                    new Transaction(rpinNo).setVisible(true);
                }catch(Exception ex){System.out.println(ex);
            }
        }
    }else{
            setVisible(false);
            new Transaction(pinNo).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new ChangePin("");
    }
}
