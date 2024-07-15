package atm_sim;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
public class Signup1 extends JFrame implements ActionListener{
    int a;
    JTextField nameText,fnameText,em,ad,ct,st,pc;
    JDateChooser date;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    Signup1(){
        super("NEW ACCOUNT APPLICATION FORM PAGE 1");
        Random rand=new Random();
        a=Math.abs((rand.nextInt()%9000)+1000);
        JLabel appNo=new JLabel("Application No. : "+a);
        appNo.setFont(new Font("Sans Serif",Font.BOLD,38));
        appNo.setForeground(Color.red);
        appNo.setBounds(230,10,400,40);
        getContentPane().setBackground(Color.WHITE);
        add(appNo);
        JLabel pers=new JLabel("Page 1: Personal details");
        pers.setFont(new Font("Raleway",Font.BOLD,20));
        pers.setBounds(320,50,400,40);
        add(pers);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,150,30);
        add(name);
        
        nameText=new JTextField();
        nameText.setBounds(300,120,330,30);
        nameText.setFont(new Font("Raleway",Font.PLAIN,14));
        add(nameText);
        
        JLabel fname=new JLabel("Father's name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,160,150,30);
        add(fname);
        
        fnameText=new JTextField();
        fnameText.setBounds(300,160,330,30);
        fnameText.setFont(new Font("Raleway",Font.PLAIN,14));
        add(fnameText);
        
        JLabel dob=new JLabel("Date of birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,200,150,30);
        add(dob);
        
        date=new JDateChooser();
        date.setFont(new Font("Sans Serif",Font.PLAIN,16));
        date.setBounds(300,200,330,30);
        add(date);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,240,150,30);
        add(gender);
        
        ButtonGroup bg=new ButtonGroup();
        male=new JRadioButton("Male");
        male.setFont(new Font("Raleway",Font.PLAIN,14));
        male.setBounds(300,240,80,30);
        bg.add(male);
        
        female=new JRadioButton("Female");
        female.setFont(new Font("Raleway",Font.PLAIN,14));
        female.setBounds(400,240,100,30);
        bg.add(female);
        
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        male.setFocusable(false);
        female.setFocusable(false);
        add(male);
        add(female);
        
        JLabel email=new JLabel("E-mail address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,280,150,30);
        add(email);
        
        em=new JTextField();
        em.setBounds(300,280,330,30);
        em.setFont(new Font("Raleway",Font.PLAIN,14));
        add(em);
        
        JLabel addr=new JLabel("Address:");
        addr.setFont(new Font("Raleway",Font.BOLD,20));
        addr.setBounds(100,320,150,30);
        add(addr);
        
        ad=new JTextField();
        ad.setBounds(300,320,330,30);
        ad.setFont(new Font("Raleway",Font.PLAIN,14));
        add(ad);
        
        JLabel mstatus=new JLabel("Marital status:");
        mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,360,150,30);
        add(mstatus);
        ButtonGroup bg1=new ButtonGroup();
        married=new JRadioButton("Married");
        married.setFont(new Font("Raleway",Font.PLAIN,14));
        married.setBounds(300,360,80,30);
        add(married);
        bg1.add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway",Font.PLAIN,14));
        unmarried.setBounds(400,360,100,30);
        add(unmarried);
        bg1.add(unmarried);
        
        other=new JRadioButton("Other");
        other.setFont(new Font("Raleway",Font.PLAIN,14));
        other.setBounds(500,360,100,30);
        add(other);
        bg1.add(other);
        other.setFocusable(false);
        other.setBackground(Color.WHITE);
        
        married.setBackground(Color.WHITE);
        married.setFocusable(false);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFocusable(false);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,400,150,30);
        add(city);
        
        ct=new JTextField();
        ct.setBounds(300,400,330,30);
        ct.setFont(new Font("Raleway",Font.PLAIN,14));
        add(ct);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,440,150,30);
        add(state);
        
        st=new JTextField();
        st.setBounds(300,440,330,30);
        st.setFont(new Font("Raleway",Font.PLAIN,14));
        add(st);
        
        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,480,150,30);
        add(pincode);
        
        pc=new JTextField();
        pc.setBounds(300,480,330,30);
        pc.setFont(new Font("Raleway",Font.PLAIN,14));
        add(pc);
        
        next=new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFocusable(false);
        next.setBounds(550,530,80,30);
        add(next);
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        add(appNo);
        setLayout(null);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String number=""+a;
        String name=nameText.getText();
        String fname=fnameText.getText();
        String email=em.getText();
        String address=ad.getText();
        String state=st.getText();
        String city=ct.getText();
        String pin=pc.getText();
        String gender=(male.isSelected())?"Male":"Femail";
        String marital="";
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        if(married.isSelected())
            marital="Married";
        else if(unmarried.isSelected())
            marital="Unmarried";
        else
            marital="Other";
        try{
        if(name.equals(""))
            JOptionPane.showMessageDialog(this, "Please enter your name properly","Message",JOptionPane.WARNING_MESSAGE);
        if(!email.contains("@gmail.com"))
            JOptionPane.showMessageDialog(this, "Check your email");
        if(pin.length()!=6)
            JOptionPane.showMessageDialog(this, "Invalid pin code");
        if((2023-Integer.parseInt(dob.substring(dob.length()-4, dob.length())))<18)
            JOptionPane.showMessageDialog(this, "Check your date of birth");
        else{
          Conn c=new Conn();
          String query="insert into signup values('"+number+"','"+name+"','"+fname+"','"+dob+"','"
            +gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
          c.s.executeUpdate(query);
          setVisible(false);
          new Signup2(number).setVisible(true);
        }
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new Signup1();
    }
}
