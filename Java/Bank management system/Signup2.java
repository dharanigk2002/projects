package atm_sim;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener{
    int a;
    String formno;
    JTextField PAN,AADHAR;
    JComboBox religion,category,income,education,occupation;
    JButton next;
    JRadioButton yes,no,yes1,no1;
    Signup2(String formno){
        super("NEW ACCOUNT APPLICATION FORM PAGE 2");
        this.formno=formno;
        getContentPane().setBackground(Color.WHITE);

        JLabel addDetails=new JLabel("Page 2: Additional details");
        addDetails.setFont(new Font("Raleway",Font.BOLD,20));
        addDetails.setBounds(320,50,400,40);
        add(addDetails);
        
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,120,150,30);
        add(rel);

        religion=new JComboBox(new String[]{"Hindu","Muslim","Christian","Sikh","Jain"});
        religion.setFocusable(false);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,120,330,30);
        add(religion);
        
        JLabel cat=new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,160,150,30);
        add(cat);
        
        category=new JComboBox(new String[]{"General","OBC","SC","ST","Other"});
        category.setBounds(300,160,330,30);
        category.setFocusable(false);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc=new JLabel("Income:");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,200,150,30);
        add(inc);
        
        income=new JComboBox(new String[]{"< 1,00,000","< 2,00,000","< 5,00,000","upto 10,00,000"});
        income.setBounds(300,200,330,30);
        income.setFocusable(false);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel edu=new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,250,150,30);
        add(edu);
        
        JLabel quali=new JLabel("Qualification:");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds(100,280,150,30);
        add(quali);
        
        education=new JComboBox(new String[]{"Non-graduate","Graduate","Post-graduate","Others"});
        education.setBounds(300,280,330,30);
        education.setFocusable(false);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occu=new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBounds(100,320,150,30);
        add(occu);
        
        occupation=new JComboBox(new String[]{"Salaried","Self-employed","Business","Retired"});
        occupation.setBounds(300,320,330,30);
        occupation.setFocusable(false);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel pan=new JLabel("PAN number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,360,150,30);
        add(pan);
        
        PAN=new JTextField();
        PAN.setBounds(300,360,330,30);
        add(PAN);
        
        
        JLabel aadhar=new JLabel("Aadhar number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,400,180,30);
        add(aadhar);
        
        AADHAR=new JTextField();
        AADHAR.setBounds(300,400,330,30);
        AADHAR.setFont(new Font("Raleway",Font.PLAIN,14));
        add(AADHAR);
        
        JLabel senior=new JLabel("Senior citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,440,150,30);
        add(senior);
        
        ButtonGroup bg=new ButtonGroup();
        yes=new JRadioButton("Yes");
        yes.setBounds(300,440,50,30);
        yes.setFont(new Font("Raleway",Font.PLAIN,14));
        yes.setBackground(Color.WHITE);
        yes.setFocusable(false);
        add(yes);
        bg.add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(490,440,50,30);
        no.setFont(new Font("Raleway",Font.PLAIN,14));
        no.setFocusable(false);
        no.setBackground(Color.WHITE);
        add(no);
        bg.add(no);
        
        JLabel exist=new JLabel("Existing account:");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBounds(100,480,180,30);
        add(exist);
        
        ButtonGroup bg1=new ButtonGroup();
        yes1=new JRadioButton("Yes");
        yes1.setBounds(300,480,50,30);
        yes1.setFont(new Font("Raleway",Font.PLAIN,14));
        yes1.setBackground(Color.WHITE);
        yes1.setFocusable(false);
        add(yes1);
        bg1.add(yes1);
        
        no1=new JRadioButton("No");
        no1.setBounds(490,480,50,30);
        no1.setFont(new Font("Raleway",Font.PLAIN,14));
        no1.setFocusable(false);
        no1.setBackground(Color.WHITE);
        add(no1);
        bg1.add(no1);
        
        next=new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFocusable(false);
        next.setBounds(550,530,80,30);
        add(next);
        next.addActionListener(this);
        
        setLayout(null);
        setSize(850,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String sreligion=String.valueOf(religion.getSelectedItem());
        String scategory=String.valueOf(category.getSelectedItem());
        String sincome=String.valueOf(income.getSelectedItem());
        String seducation=String.valueOf(education.getSelectedItem());
        String soccupation=String.valueOf(occupation.getSelectedItem());
        String senior=(yes.isSelected())?"Yes":"No";
        String eAcc=(yes1.isSelected())?"Yes":"No";
        String pan=PAN.getText();
        String aadhar=AADHAR.getText();
        try{
          Conn c=new Conn();
          String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"
            +seducation+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+eAcc+"');";
          c.s.executeUpdate(query);
          setVisible(false);
          new Signup3(formno).setVisible(true);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new Signup2("");
    }
}
