import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;

public class voter implements ActionListener{
   JFrame frame=new JFrame("Voter id registration");
   JLabel name,com,age,aadhar,gender,rel,a1,a2,a3;
   JTextField t1,t3;
   JRadioButton h,s,j,b,o,m,f,tg;
   JComboBox c,age1;
   String[] str={"OBC","BC","MBC","SC/ST","Others"};
   static String ageArray[]=new String[90];
   static void init(){
     for(int i=18;i<=100;i++)
        ageArray[i-18]=String.valueOf(i);
   }
   JButton reset,submit;
   voter(){
    gender=new JLabel("Gender:");
    m=new JRadioButton("Male");
    f=new JRadioButton("Female");
    tg=new JRadioButton("Others");
    name=new JLabel("Name:");
    t1=new JTextField(50);
    reset=new JButton("Reset");
    init();
    submit=new JButton("Submit");
    t1.setBounds(60, 15, 150, 30);
    name.setBounds(10, 15, 90, 30);
    age=new JLabel("Age:");
    age1=new JComboBox(ageArray);
    age1.setBounds(50, 75, 70, 30);
    age.setBounds(10, 75, 90, 30);
    aadhar=new JLabel("Enter aadhar number:");
    aadhar.setFont(new Font("Times New Roman",Font.BOLD,15));
    age.setFont(new Font("Times New Roman",Font.BOLD,15));
    t3=new JTextField(12);
    t3.setBounds(160, 165, 150, 30);
    aadhar.setBounds(10, 165, 150, 30);
    rel=new JLabel("Religion:");
    rel.setFont(new Font("Times New Roman",Font.BOLD,15));
    h=new JRadioButton("Hindu");
    s=new JRadioButton("Sikh");
    j=new JRadioButton("Jain");
    b=new JRadioButton("Buddhism");
    o=new JRadioButton("Others");
    a3=new JLabel();
    a3.setBounds(60, 45, 120, 20);
    rel.setBounds(10, 255, 90, 30);
    h.setBounds(90, 255, 90, 30);
    s.setBounds(180, 255, 90, 30);
    j.setBounds(270, 255, 90, 30);
    b.setBounds(360, 255, 90, 30);
    o.setBounds(460, 255, 90, 30);
    gender.setBounds(10, 345, 90, 30);
    m.setBounds(90, 345, 90, 30);
    f.setBounds(180, 345, 90, 30);
    tg.setBounds(270, 345, 90, 30);
    a2=new JLabel();
    a2.setBounds(100, 200, 340, 20);
    com=new JLabel("Community:");
    gender.setFont(new Font("Times New Roman",Font.BOLD,15));
    com.setFont(new Font("Times New Roman",Font.BOLD,15));
    a1=new JLabel();
    c=new JComboBox(str);
    name.setFont(new Font("Times New Roman",Font.BOLD,15));
    com.setBounds(10, 435, 90, 30);
    c.setBounds(100, 435, 90, 30);
    reset.setBounds(30,650,90,30);
    submit.setBounds(230, 650, 90, 30);
    a1.setBounds(100,100,340,20);
    reset.addActionListener(this);
    submit.addActionListener(this);
    frame.add(name);
    frame.add(t1);
    frame.add(a3);
    frame.add(age);
    frame.add(age1);
    frame.add(aadhar);
    frame.add(t3);
    frame.add(a2);
    frame.add(rel);
    frame.add(h);
    frame.add(s);
    frame.add(j);
    frame.add(b);
    frame.add(o);
    frame.add(gender);
    frame.add(m);
    frame.add(f);
    frame.add(tg);
    frame.add(com);
    frame.add(c);
    frame.add(reset);
    frame.add(submit);
    frame.add(a1);
    frame.setLayout(null);
    frame.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
    frame.setSize(800,800);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    public void actionPerformed(ActionEvent e){
     String str=t1.getText().replaceAll("\\s", "");
     if(e.getSource()==reset){
      t1.setText("");
      t3.setText("");
      h.setSelected(false);
      s.setSelected(false);
      j.setSelected(false);
      b.setSelected(false);
      o.setSelected(false);
      m.setSelected(false);
      f.setSelected(false);
      tg.setSelected(false);
      a1.setText("");
      a2.setText("");
      a3.setText("");
      age1.setSelectedIndex(0);
      c.setSelectedIndex(0);
      return;
     }
     if(e.getSource()==submit){
      if(t3.getText().length()>12 || t3.getText().length()<12 || check2(t3.getText().toCharArray()) ){
      a2.setForeground(Color.red);
      a2.setText("Aadhar number is invalid");
      }
     else if(str.isEmpty() || check(str.toCharArray())){
       a3.setForeground(Color.red);
       a3.setText("Invalid name");
     }else if((h.isSelected() || s.isSelected() || j.isSelected() || b.isSelected() || o.isSelected()) && (m.isSelected() || f.isSelected() || tg.isSelected()) && (str.length()>0 && t3.getText().length()>0)){
     a2.setText("");
     a3.setText("");
         JOptionPane.showMessageDialog(null,"SUCCESSFULLY REGISTERED!!!");
     }
     }
    }
    boolean check(char[] ch){
    
     for(char i:ch){
      if(!Character.isAlphabetic(i))
          return true;
     }
     return false;
    }
    boolean check2(char[] ch){
     for(char i:ch){
      if(Character.isAlphabetic(i))
          return true;
     }
     return false;
    }
   public static void main(String[] args){
    new voter();
   }
}