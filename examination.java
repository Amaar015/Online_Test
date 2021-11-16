package mypackage;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

public class examination implements ActionListener  
{  
    JFrame jl,jfl;
    Panel ll,dl,rl,ul,pf1;
    JLabel l,l1,l2,l3,L; 
    Panel Ls;
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,lb1;  
    ButtonGroup bg;  
    JTextField t1,t2;
    JPasswordField p3;
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
   void examinations()  
    {  
        jl=new JFrame("Online testing System");
        jl.setSize(600, 600);
        jl.setLayout(null);
        jl.setVisible(true);
        jl.getContentPane().setBackground(Color.LIGHT_GRAY);
        jl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        L=new JLabel("Online Testing System");
        L.setBounds(50, 350, 200, 20);
        L.setForeground(Color.GRAY);
        L.setBackground(Color.MAGENTA);
        jl.add(L);
        l=new JLabel();  
        jl.add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        { jb[i]=new JRadioButton();     
          jl.add(jb[i]);  
          bg.add(jb[i]);}  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        jl.add(b1);jl.add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
         
    }  
    public void actionPerformed(ActionEvent e)  
    {  if(e.getSource()==b1)  
        {   if(check())  
            count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {b1.setEnabled(false);  
            b2.setText("Result");} }  
        if(e.getActionCommand().equals("Bookmark"))  
        {   JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            jl.add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
            b2.setText("Result");  
            jl.setVisible(false);  
            jl.setVisible(true); }  
        for(int i=0,y=1;i<x;i++,y++)  
        {   if(e.getActionCommand().equals("Bookmark"+y))  
        {   if(check())  
            count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;     }  }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            System.out.println("correct ans="+count);  
           JOptionPane.showMessageDialog(jl,"Your Marks="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Empty set is denoted by?");  
            jb[0].setText("phay");jb[1].setText("{}");jb[2].setText("{0}");jb[3].setText("Both a & b");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Multiplication of matrix order(mxn=pxq) is possible when ?");  
            jb[0].setText("m=q");jb[1].setText("n=p");jb[2].setText("m=n");jb[3].setText("p=m");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which of the following is row matrix?");  
            jb[0].setText("1x2");jb[1].setText("1x4");jb[2].setText("2x1");jb[3].setText("Both a & b");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Quantity having direction and Magnitude is called?");  
            jb[0].setText("Vector");jb[1].setText("Scalar");jb[2].setText("Velocity");jb[3].setText("Non of these");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Value of i^34?");  
            jb[0].setText("i");jb[1].setText("-1");jb[2].setText("-i");jb[3].setText("1");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: tan60=?");  
            jb[0].setText("1");jb[1].setText("1/3^1/3");jb[2].setText("3^1/3");jb[3].setText("0");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Sinx=? ");  
            jb[0].setText("perp/hypo");jb[1].setText("base/perp");jb[2].setText("hypo/perp");  
                        jb[3].setText("base/hypo");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: 3x^2-12x-15=0 what is the value of x?");  
            jb[0].setText("{5,-1}");jb[1].setText("{1,5}");jb[2].setText("{-5,1}");  
                        jb[3].setText("-1,-5");         
        }  
        if(current==8)  
        {l.setText("Que9: sin(x+y)=?");  
         jb[0].setText("sinxcosy-sinycosx");jb[1].setText("sinxcosy+sinycosx");
         jb[2].setText("sinxsiny+cosxcosy");jb[3].setText("sinxsiny-cosxcosy"); }  
         if(current==9)  
        { l.setText("Que10: if f(x)=3x+4 then find f(f(x))=?");  
         jb[0].setText("16x+9");jb[1].setText("6x+3");jb[2].setText("9x+9");  
         jb[3].setText("non of these");}  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[3].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[3].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[0].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
    return false;  
    }
    public void Login(){
         
            jfl=new JFrame("Login");
            jfl.setSize(600,600);
            jfl.setVisible(true);
            jfl.setLayout(null);
            jfl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ll=new Panel();
        
            l1=new JLabel("User name");
            l1.setBounds(50, 50, 100, 30);
            jfl.add(l1);
            t1=new JTextField();
            t1.setBounds(200, 50, 200, 20);
            jfl.add(t1);
            l2=new JLabel("National Identity:");
            l2.setBounds(50, 100, 100, 30);
            jfl.add(l2);
            t2=new JTextField();
            t2.setBounds(200, 100, 200, 20);
            jfl.add(t2);
            l3=new JLabel("Password:");
            l3.setBounds(50, 150, 100, 30);
            jfl.add(l3);
           
            p3=new JPasswordField();
            p3.setBounds(200, 150, 200, 20);
            jfl.add(p3);
            
            lb1=new JButton("Login");
            lb1.setBounds(150, 250, 100, 30);
            lb1.setForeground(Color.blue);
            lb1.setBackground(Color.GREEN);
            lb1.setBorder(null);
            jfl.add(lb1);
            jfl.getContentPane().setBackground(Color.LIGHT_GRAY);
            lb1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(e.getSource()==lb1){
                       String name=t1.getText();
                       String nic=t2.getText();
             String Pass=String.valueOf(p3.getPassword());
             
             if(name.equals("Amaar") && Pass.equals("42909388")&& nic.equals("4540404855551")){
                 JOptionPane.showMessageDialog(null, "Login Successful");
                 examinations();
                 set();
                 check();
                 
             }
             else{
                     JOptionPane.showMessageDialog(null, "Login Error");
             }
                        }}catch(Exception ar){System.out.println(ar); }
          }
       });
          //                  Voting vt=new Voting();
        
       
    }
    public static void main(String s[])  
    {  
      examination ex=new examination();
      ex.Login();
      
    }  
}  
    

