import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Interest  extends JFrame
{
private JLabel a1;
private JLabel a2;
private JLabel a3;
private JLabel a4;
private JTextField b1;
private JTextField b2;
private JTextField b3;
private JTextField b4;
private JButton c1;
private JButton c2;
private JButton c3;
private JTextArea text;
private JPanel toolbar = new JPanel();
public Interest()
{
creatComponents()    ;
layoutComponents();
registerHandlers1();
setTitle("复利存款计算器");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pack();
}

 

private void  creatComponents()    
{
a1=new JLabel("本  金 ");
a1.setFont(new Font("宋体",Font.BOLD,18));
a2=new JLabel("年利率 ");
a2.setFont(new Font("宋体",Font.BOLD,18));
a3=new JLabel("年 数 ");
a3.setFont(new Font("宋体",Font.BOLD,18));
a4=new JLabel("期望值 ");
a4.setFont(new Font("宋体",Font.BOLD,18));
b1=new JTextField(10);
b2=new JTextField(10);
b3=new JTextField(10);
b4=new JTextField(10);
c1=new JButton("计算");
c1.setFont(new Font("宋体",Font.BOLD,15));
c3=new JButton("");
c3.setBackground(Color.GREEN);
c3.setToolTipText("LOVE YOU FOREVER");
c3.setBorder(new LineBorder(Color.RED,3));
c3.setFont(new Font("宋体",Font.BOLD,20));
c3.setForeground(Color.YELLOW);
c2=new JButton("清除");
c2.setFont(new Font("宋体",Font.BOLD,15));
text=new JTextArea();
}
private void layoutComponents()
{
//Container c=this.getContentPane();    
setLayout(new FlowLayout());
JPanel panel1=new JPanel();
panel1.add(a1);
panel1.add(b1);
JPanel panel2=new JPanel();
panel2.add(a2);
panel2.add(b2);
JPanel panel3=new JPanel();
panel3.add(a3);
panel3.add(b3);
JPanel panel4=new JPanel();
panel4.add(c1);
panel4.add(c3);
panel4.add(c2);
JPanel panel6=new JPanel();
panel6.add(a4);
panel6.add(b4);


JPanel  leftpanel=new JPanel(new GridLayout(4,1));
leftpanel.add(panel1);
leftpanel.add(panel2);
leftpanel.add(panel3);
leftpanel.add(panel4);
leftpanel.add(panel6);
JScrollPane panel5=new JScrollPane(text);
panel5.setPreferredSize(new Dimension(200,150));
add(leftpanel);
add(panel5);
}
private  void registerHandlers1()
{
    c1ActionEventHander hander1=new  c1ActionEventHander();
    c1.addActionListener(hander1);
    c2ActionEventHander hander2=new  c2ActionEventHander();
    c2.addActionListener(hander2);
c3ActionEventHander hander3=new  c3ActionEventHander();
   c3.addActionListener(hander3);
     
}
private class c1ActionEventHander implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
    double principal;
    double amount;
    double rate;
    int n;
    NumberFormat currencyformatter=NumberFormat.getCurrencyInstance();
    String output="年"+"/t"+"复利存款"+"/n";
     int year =1;
     principal=Double.parseDouble(b1.getText());
     rate=Double.parseDouble(b2.getText()); 
     n=Integer.parseInt(b3.getText());
     amount = Double.parseDouble(b4.getText());
     
     
//   rate = Double.parseDouble(b2.getText());
//   n = Integer.parseInt(b3.getText());
     if (b1.getText().equals("")&& b2.getText() != null
             && b3.getText() != null && b4.getText() != null) {
         
         rate = Double.parseDouble(b2.getText());
         n = Integer.parseInt(b3.getText());
             amount = Double.parseDouble(b4.getText());
             principal = 0;
             while (year <= n) {
                 principal = amount / (Math.pow(1 + rate, year));
                 year = year + 1;
             }

             output = "本金" + currencyformatter.format(principal) + "\n";
             text.setText(output);
     }
     text.setText(output);
    if (b2.getText().equals("") && b1.getText() != null
             && b3.getText() != null && b4.getText() != null) // 求利率
     {
         principal = Double.parseDouble(b1.getText()); // b1本金
         rate =0;
         n = Integer.parseInt(b3.getText()); // b3年份
         amount = Double.parseDouble(b4.getText()); // b4期望值
         rate = java.lang.StrictMath.pow(amount / principal, 1.0 / n) - 1;
         output = "利率" + rate + "\n";
         text.setText(output);
     }

     else if (b3.getText().equals("") && b1.getText() != null
             && b2.getText() != null && b4.getText() != null) // 求年份
     {
         principal = Double.parseDouble(b1.getText()); // b1本金
         amount = Double.parseDouble(b4.getText()); // b4期望值
         rate = Double.parseDouble(b2.getText());
         int n2=1;
           while(principal<amount){
               principal=principal * Math.pow(1 + rate, n2);
               n2+=1;
           }
           output = "至少年数" + n2+"\n";
           text.setText(output);
     }

     else if (b4.getText().equals("") && b1.getText() != null
             && b3.getText() != null && b2.getText() != null) // 求期望值
     {
         rate = Double.parseDouble(b2.getText());
         n = Integer.parseInt(b3.getText());
         principal = Double.parseDouble(b1.getText()); // b1本金
         while (year <= n) {
                 amount = principal * Math.pow(1 + rate, year);
                 output += String.valueOf(year) + "\t\t\t"
                         + currencyformatter.format(amount) + "\n";
                 year = year + 1;
             }

             text.setText(output);
     }
 }

}

class  c2ActionEventHander implements ActionListener
{
      private class c1ActionEventHander implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                b1.setText("");
                b2.setText("");
                b3.setText("");
                text.setText("");
            }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
class c3ActionEventHander implements ActionListener
{
public c3ActionEventHander() {
        // TODO Auto-generated constructor stub
    }
public void actionPerformed(ActionEvent e)
{
    b1.setText("");
    b2.setText("");
    b3.setText("");
}
}


    


public static void main(String[] args)
{
     Interest frame=new Interest();
    frame.setVisible(true);
     int Windowswidth = 500;
     int Windowsheight = 400;
     int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     int height = Toolkit.getDefaultToolkit().getScreenSize().height;
  frame.setResizable(false);
  frame.setLocation((width - Windowswidth) / 2,
          (height - Windowsheight) / 2); // 窗口居中
}
}
