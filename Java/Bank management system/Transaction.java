package atm_sim;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    JButton btn[]=new JButton[7];
    String pinno;
    public Transaction(String pinno){
        super("ATM");
        this.pinno=pinno;
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i1=i.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        JLabel img=new JLabel(new ImageIcon(i1));
        img.setBounds(0,0,800,800);
        add(img);
        
        JLabel label=new JLabel("Please select your transaction");
        label.setForeground(Color.WHITE);
        label.setFont((new Font("System",Font.BOLD,20)));
        label.setBounds(150,280,300,25);
        img.add(label);
        
        btn[0]=new JButton("Deposit");
        btn[0].setBounds(140,368,100,30);
        btn[0].setFocusable(false);
        img.add(btn[0]);
        
        btn[1]=new JButton("Fast cash");
        btn[1].setBounds(140,400,100,30);
        btn[1].setFocusable(false);
        img.add(btn[1]);
        
        btn[2]=new JButton("Pin change");
        btn[2].setBounds(140,432,100,30);
        btn[2].setFocusable(false);
        img.add(btn[2]);
        
        btn[3]=new JButton("Cash withdrawal");
        btn[3].setBounds(316,368,140,30);
        btn[3].setFocusable(false);
        img.add(btn[3]);
        
        btn[4]=new JButton("Mini statement");
        btn[4].setBounds(316,400,140,30);
        btn[4].setFocusable(false);
        img.add(btn[4]);
        
        btn[5]=new JButton("Balance enquiry");
        btn[5].setBounds(316,432,140,30);
        btn[5].setFocusable(false);
        img.add(btn[5]);
        
        btn[6]=new JButton("Exit");
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
        if(e.getSource()==btn[6])
            dispose();
        else if(e.getSource()==btn[0]){
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        }else if(e.getSource()==btn[3]){
            setVisible(false);
            new Withdraw(pinno).setVisible(true);
        }else if(e.getSource()==btn[1]){
            setVisible(false);
            new FastCash(pinno).setVisible(true);
        }else if(e.getSource()==btn[2]){
            setVisible(false);
            new ChangePin(pinno).setVisible(true);
        }else if(e.getSource()==btn[5]){
            setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        }else if(e.getSource()==btn[4]){
            new MiniStatement(pinno).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transaction("");
    }
}
