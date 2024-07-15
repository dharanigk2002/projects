package atm_sim;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{
    JButton btn[]=new JButton[7];
    String pinno;
    public FastCash(String pinno){
        super("ATM");
        this.pinno=pinno;
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        JLabel img=new JLabel(new ImageIcon(i1));
        img.setBounds(0,0,800,800);
        add(img);
        
        JLabel label=new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setForeground(Color.WHITE);
        label.setFont((new Font("System",Font.BOLD,20)));
        label.setBounds(145,280,350,25);
        img.add(label);
        
        btn[0]=new JButton("Rs.100");
        btn[0].setBounds(140,368,100,30);
        btn[0].setFocusable(false);
        img.add(btn[0]);
        
        btn[1]=new JButton("Rs.500");
        btn[1].setBounds(140,400,100,30);
        btn[1].setFocusable(false);
        img.add(btn[1]);
        
        btn[2]=new JButton("Rs.1000");
        btn[2].setBounds(140,432,100,30);
        btn[2].setFocusable(false);
        img.add(btn[2]);
        
        btn[3]=new JButton("Rs.2000");
        btn[3].setBounds(316,368,140,30);
        btn[3].setFocusable(false);
        img.add(btn[3]);
        
        btn[4]=new JButton("Rs.5000");
        btn[4].setBounds(316,400,140,30);
        btn[4].setFocusable(false);
        img.add(btn[4]);
        
        btn[5]=new JButton("Rs.10000");
        btn[5].setBounds(316,432,140,30);
        btn[5].setFocusable(false);
        img.add(btn[5]);
        
        btn[6]=new JButton("BACK");
        btn[6].setBounds(316,464,140,25);
        btn[6].setFocusable(false);
        img.add(btn[6]);
        for(JButton j:btn)
            j.addActionListener(this);
        setLayout(null);
        setSize(800,800);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn[6]){
            new Transaction(pinno).setVisible(true);
            setVisible(false);
        }
        else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();
            String query="select * from bank where pin='"+pinno+"';";
            
            try{
            int balance=0;
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("type").equals("deposit"))
                    balance+=Integer.parseInt(rs.getString("amount"));
                else
                    balance-=Integer.parseInt(rs.getString("amount"));
            }
            if(balance < Integer.parseInt(amount))
                JOptionPane.showMessageDialog(this, "Insufficient balance","Warning",JOptionPane.WARNING_MESSAGE);
            else{
            JOptionPane.showMessageDialog(this, amount+" withdrawn successfully","Warning",JOptionPane.WARNING_MESSAGE);
            java.util.Date date=new java.util.Date();
            String query1="insert into bank values('"+pinno+"','"+date+"','withdraw','"+amount+"');";
            c.s.executeUpdate(query1);
            dispose();
            new Transaction(pinno).setVisible(true);
            }
            }
            catch(Exception ex){System.out.println(ex);}
            
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
