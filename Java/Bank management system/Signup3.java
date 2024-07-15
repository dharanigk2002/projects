package atm_sim;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    JRadioButton accType[]=new JRadioButton[4];
    JCheckBox service[]=new JCheckBox[6];
    String[] ser={"ATM card","Internet banking","Mobile banking","EMAIL & SMS alert","Cheque book","E-statement"};
    JCheckBox dec;
    String formno;
    JButton submit,cancel;
    Signup3(String formno){
        super("NEW ACCOUNT APPLICATION FORM PAGE 3");
        this.formno=formno;
        JLabel addDetails=new JLabel("Page 3: Account details");
        addDetails.setFont(new Font("Raleway",Font.BOLD,20));
        addDetails.setBounds(325,30,400,40);
        add(addDetails);
        
        JLabel acc=new JLabel("Account type:");
        acc.setFont(new Font("Raleway",Font.BOLD,25));
        acc.setBounds(100,120,200,30);
        add(acc);
        
        ButtonGroup bg=new ButtonGroup();
        accType[0]=new JRadioButton("Savings account");
        accType[0].setBounds(100,150,130,30);
        accType[0].setFocusable(false);
        accType[0].setBackground(Color.WHITE);
        accType[0].setFont(new Font("Sans serif",Font.PLAIN,14));
        add(accType[0]);
        
        accType[1]=new JRadioButton("Current account");
        accType[1].setBounds(100,180,130,30);
        accType[1].setFocusable(false);
        accType[1].setBackground(Color.WHITE);
        accType[1].setFont(new Font("Sans serif",Font.PLAIN,14));
        add(accType[1]);
        
        accType[2]=new JRadioButton("Fixed deposit account");
        accType[2].setBounds(350,150,180,30);
        accType[2].setFocusable(false);
        accType[2].setBackground(Color.WHITE);
        accType[2].setFont(new Font("Sans serif",Font.PLAIN,14));
        add(accType[2]);
        
        accType[3]=new JRadioButton("Recurring deposit account");
        accType[3].setBounds(350,180,200,30);
        accType[3].setFocusable(false);
        accType[3].setBackground(Color.WHITE);
        accType[3].setFont(new Font("Sans serif",Font.PLAIN,14));
        add(accType[3]);
        
        for(JRadioButton i:accType)
            bg.add(i);
        
        JLabel cardNo=new JLabel("Card number:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,25));
        cardNo.setBounds(100,250,250,20);
        add(cardNo);
        
        JLabel notify=new JLabel("Your 16-digit card number");
        notify.setFont(new Font("Raleway",Font.PLAIN,14));
        notify.setForeground(Color.red);
        notify.setBounds(100,265,250,30);
        add(notify);
        
        JLabel card=new JLabel("XXXX-XXXX-XXXX-4184");
        card.setFont(new Font("Raleway",Font.BOLD,25));
        card.setBounds(350,250,300,30);
        add(card);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(100,320,250,20);
        add(pin);
        
        JLabel notify1=new JLabel("Your 4-digit password");
        notify1.setFont(new Font("Raleway",Font.PLAIN,14));
        notify1.setForeground(Color.red);
        notify1.setBounds(100,340,250,30);
        add(notify1);
        
        JLabel PIN=new JLabel("XXXX");
        PIN.setFont(new Font("Raleway",Font.BOLD,25));
        PIN.setBounds(350,320,300,30);
        add(PIN);
        
        JLabel serv=new JLabel("Services required:");
        serv.setFont(new Font("Raleway",Font.BOLD,25));
        serv.setBounds(100,400,250,30);
        add(serv);
        int sum=0,sum1=0;
        for(int i=0;i<6;i++){
            service[i]=new JCheckBox(ser[i]);
            service[i].setFocusable(false);
            service[i].setBackground(Color.WHITE);
            service[i].setFont(new Font("Sans serif",Font.PLAIN,14));
            if(i%2==0){
                service[i].setBounds(100,450+sum,150,30);
                sum+=40;
            }else{
                service[i].setBounds(400,450+sum1,150,30);
                sum1+=40;
            }
            add(service[i]);
        }
        
        
        dec=new JCheckBox("I hereby declare that above entered details are correct");
        dec.setBackground(Color.WHITE);
        dec.setFocusable(false);
        dec.setBounds(100,600,340,20);
        add(dec);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,650,80,30);
        submit.setFocusable(false);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350,650,80,30);
        cancel.setFocusable(false);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String account="";
        if(e.getSource()==submit){
            for(JRadioButton i:accType)
                if(i.isSelected())
                    account=i.getText();
            Random rand=new Random();
            String cardNo=""+Math.abs((rand.nextLong()%90000000L)+5478829300000000L);
            String pinNo=""+Math.abs((rand.nextLong()%9000L)+1000L);
            String facility="";
            for(JCheckBox i:service)
                if(i.isSelected())
                    facility+=i.getText()+" ";
            try{
                if(dec.isSelected()){
                    if(account.equals(""))
                        JOptionPane.showMessageDialog(this, "Account details required","Warning",JOptionPane.WARNING_MESSAGE);
                    else{
                        Conn c=new Conn();
                        String query="insert into signup3 values('"+formno+"','"+account+"','"+cardNo+"','"+pinNo+"','"+facility+"');";
                        String query1="insert into login values('"+formno+"','"+cardNo+"','"+pinNo+"');";
                        c.s.executeUpdate(query);
                        c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(this, "Card number: "+cardNo+"\nPin number: "+pinNo);
                        setVisible(false);
                        new Deposit(pinNo).setVisible(true);
                    }   
                }else{
                   JOptionPane.showMessageDialog(this, "Acknowledge with the check box given below","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Signup3("");
    }
}
