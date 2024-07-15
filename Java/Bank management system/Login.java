package atm_sim;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton clear,signin,signup;
    JPasswordField pinText;
    JTextField cardText;
    Login(){
        super("AUTOMATED TELLER MACHINE");
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i=img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel l=new JLabel(new ImageIcon(i));
        l.setBounds(100,25,100,100);
        add(l);
        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200,62,400,40);
        text.setFont(new Font("Oswalt",Font.BOLD,38));
        text.setForeground(Color.red);
        
        JLabel cardno=new JLabel("Card number:");
        cardno.setBounds(120,150,190,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardText=new JTextField();
        cardText.setBounds(320,150,250,30);
        cardText.setFont(new Font("Raleway",Font.BOLD,14));
        JLabel pin=new JLabel("PIN number:");
        pin.setBounds(120,210,190,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pinText=new JPasswordField();
        pinText.setBounds(320,210,250,30);
        pinText.setFont(new Font("Raleway",Font.BOLD,14));
        signin=new JButton("Sign in");
        signin.setBounds(320,280,100,35);
        signin.setFont(new Font("Raleway",Font.PLAIN,20));
        signin.setFocusable(false);
        clear=new JButton("Clear");
        clear.setBounds(470,280,100,35);
        clear.setFont(new Font("Raleway",Font.PLAIN,20));
        clear.setFocusable(false);
        signup=new JButton("Sign up");
        signup.setBounds(320,330,250,35);
        signup.setFont(new Font("Raleway",Font.PLAIN,20));
        signup.setFocusable(false);
        signin.setForeground(Color.WHITE);
        signin.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        signin.addActionListener(this);
        signup.addActionListener(this);
        add(clear);
        add(signin);
        add(signup);
        add(text);
        add(cardno);
        add(cardText);
        add(pinText);
        add(pin);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            pinText.setText("");
            cardText.setText("");
        }else if(e.getSource()==signin){
            Conn c=new Conn();
            String pin=pinText.getText();
            String card=cardText.getText();
            String query="Select * from login where cardno='"+card+"' and pin='"+pin+"';";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else
                    JOptionPane.showMessageDialog(this, "Pin or card number is invalid","Error",JOptionPane.ERROR_MESSAGE);
                    
            }catch(Exception ex){}
        }else{
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
    
}
