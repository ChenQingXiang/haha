import java.awt.Color;
  2 import java.awt.Container;
  3 import java.awt.Dimension;
  4 import java.awt.FlowLayout;
  5 import java.awt.Font;
  6 import java.awt.Graphics;
  7 import java.awt.GridLayout;
  8 import java.awt.Image;
  9 import java.awt.Toolkit;
 10 import java.awt.event.ActionEvent;
 11 import java.awt.event.ActionListener;
 12 import java.text.NumberFormat;
 13 
 14 import javax.swing.AbstractButton;
 15 import javax.swing.ImageIcon;
 16 import javax.swing.JButton;
 17 import javax.swing.JFrame;
 18 import javax.swing.JLabel;
 19 import javax.swing.JOptionPane;
 20 import javax.swing.JPanel;
 21 import javax.swing.JScrollPane;
 22 import javax.swing.JTextArea;
 23 import javax.swing.JTextField;
 24 import javax.swing.border.LineBorder;
 25 
 26 
 27 public class Interest  extends JFrame
 28 {
 29 private JLabel a1;
 30 private JLabel a2;
 31 private JLabel a3;
 32 private JLabel a4;
 33 private JTextField b1;
 34 private JTextField b2;
 35 private JTextField b3;
 36 private JTextField b4;
 37 private JButton c1;
 38 private JButton c2;
 39 private JButton c3;
 40 private JTextArea text;
 41 private JPanel toolbar = new JPanel();
 42 public Interest()
 43 {
 44 creatComponents()    ;
 45 layoutComponents();
 46 registerHandlers1();
 47 setTitle("复利存款计算器");
 48 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 49 pack();
 50 }
 51 
 52  
 53 
 54 private void  creatComponents()    
 55 {
 56 a1=new JLabel("本  金 ");
 57 a1.setFont(new Font("宋体",Font.BOLD,18));
 58 a2=new JLabel("年利率 ");
 59 a2.setFont(new Font("宋体",Font.BOLD,18));
 60 a3=new JLabel("年 数 ");
 61 a3.setFont(new Font("宋体",Font.BOLD,18));
 62 a4=new JLabel("期望值 ");
 63 a4.setFont(new Font("宋体",Font.BOLD,18));
 64 b1=new JTextField(10);
 65 b2=new JTextField(10);
 66 b3=new JTextField(10);
 67 b4=new JTextField(10);
 68 c1=new JButton("计算");
 69 c1.setFont(new Font("宋体",Font.BOLD,15));
 70 c3=new JButton("");
 71 c3.setBackground(Color.GREEN);
 72 c3.setToolTipText("LOVE YOU FOREVER");
 73 c3.setBorder(new LineBorder(Color.RED,3));
 74 c3.setFont(new Font("宋体",Font.BOLD,20));
 75 c3.setForeground(Color.YELLOW);
 76 c2=new JButton("清除");
 77 c2.setFont(new Font("宋体",Font.BOLD,15));
 78 text=new JTextArea();
 79 }
 80 private void layoutComponents()
 81 {
 82 //Container c=this.getContentPane();    
 83 setLayout(new FlowLayout());
 84 JPanel panel1=new JPanel();
 85 panel1.add(a1);
 86 panel1.add(b1);
 87 JPanel panel2=new JPanel();
 88 panel2.add(a2);
 89 panel2.add(b2);
 90 JPanel panel3=new JPanel();
 91 panel3.add(a3);
 92 panel3.add(b3);
 93 JPanel panel4=new JPanel();
 94 panel4.add(c1);
 95 panel4.add(c3);
 96 panel4.add(c2);
 97 JPanel panel6=new JPanel();
 98 panel6.add(a4);
 99 panel6.add(b4);
100 
101 
102 JPanel  leftpanel=new JPanel(new GridLayout(4,1));
103 leftpanel.add(panel1);
104 leftpanel.add(panel2);
105 leftpanel.add(panel3);
106 leftpanel.add(panel4);
107 leftpanel.add(panel6);
108 JScrollPane panel5=new JScrollPane(text);
109 panel5.setPreferredSize(new Dimension(200,150));
110 add(leftpanel);
111 add(panel5);
112 }
113 private  void registerHandlers1()
114 {
115     c1ActionEventHander hander1=new  c1ActionEventHander();
116     c1.addActionListener(hander1);
117     c2ActionEventHander hander2=new  c2ActionEventHander();
118     c2.addActionListener(hander2);
119 c3ActionEventHander hander3=new  c3ActionEventHander();
120    c3.addActionListener(hander3);
121      
122 }
123 private class c1ActionEventHander implements ActionListener
124 {
125 public void actionPerformed(ActionEvent e)
126 {
127     double principal;
128     double amount;
129     double rate;
130     int n;
131     NumberFormat currencyformatter=NumberFormat.getCurrencyInstance();
132     String output="年"+"/t"+"复利存款"+"/n";
133      int year =1;
134      principal=Double.parseDouble(b1.getText());
135      rate=Double.parseDouble(b2.getText()); 
136      n=Integer.parseInt(b3.getText());
137      amount = Double.parseDouble(b4.getText());
138      
139      
140 //   rate = Double.parseDouble(b2.getText());
141 //   n = Integer.parseInt(b3.getText());
142      if (b1.getText().equals("")&& b2.getText() != null
143              && b3.getText() != null && b4.getText() != null) {
144          
145          rate = Double.parseDouble(b2.getText());
146          n = Integer.parseInt(b3.getText());
147              amount = Double.parseDouble(b4.getText());
148              principal = 0;
149              while (year <= n) {
150                  principal = amount / (Math.pow(1 + rate, year));
151                  year = year + 1;
152              }
153 
154              output = "本金" + currencyformatter.format(principal) + "\n";
155              text.setText(output);
156      }
157      text.setText(output);
158     if (b2.getText().equals("") && b1.getText() != null
159              && b3.getText() != null && b4.getText() != null) // 求利率
160      {
161          principal = Double.parseDouble(b1.getText()); // b1本金
162          rate =0;
163          n = Integer.parseInt(b3.getText()); // b3年份
164          amount = Double.parseDouble(b4.getText()); // b4期望值
165          rate = java.lang.StrictMath.pow(amount / principal, 1.0 / n) - 1;
166          output = "利率" + rate + "\n";
167          text.setText(output);
168      }
169 
170      else if (b3.getText().equals("") && b1.getText() != null
171              && b2.getText() != null && b4.getText() != null) // 求年份
172      {
173          principal = Double.parseDouble(b1.getText()); // b1本金
174          amount = Double.parseDouble(b4.getText()); // b4期望值
175          rate = Double.parseDouble(b2.getText());
176          int n2=1;
177            while(principal<amount){
178                principal=principal * Math.pow(1 + rate, n2);
179                n2+=1;
180            }
181            output = "至少年数" + n2+"\n";
182            text.setText(output);
183      }
184 
185      else if (b4.getText().equals("") && b1.getText() != null
186              && b3.getText() != null && b2.getText() != null) // 求期望值
187      {
188          rate = Double.parseDouble(b2.getText());
189          n = Integer.parseInt(b3.getText());
190          principal = Double.parseDouble(b1.getText()); // b1本金
191          while (year <= n) {
192                  amount = principal * Math.pow(1 + rate, year);
193                  output += String.valueOf(year) + "\t\t\t"
194                          + currencyformatter.format(amount) + "\n";
195                  year = year + 1;
196              }
197 
198              text.setText(output);
199      }
200  }
201 
202 }
203 
204 class  c2ActionEventHander implements ActionListener
205 {
206       private class c1ActionEventHander implements ActionListener {
207             public void actionPerformed(ActionEvent e) {
208                 b1.setText("");
209                 b2.setText("");
210                 b3.setText("");
211                 text.setText("");
212             }
213         }
214 
215     @Override
216     public void actionPerformed(ActionEvent e) {
217         // TODO Auto-generated method stub
218         
219     }
220 
221 }
222 class c3ActionEventHander implements ActionListener
223 {
224 public c3ActionEventHander() {
225         // TODO Auto-generated constructor stub
226     }
227 public void actionPerformed(ActionEvent e)
228 {
229     b1.setText("");
230     b2.setText("");
231     b3.setText("");
232 }
233 }
234 
235 
236     
237 
238 
239 public static void main(String[] args)
240 {
241      Interest frame=new Interest();
242     frame.setVisible(true);
243      int Windowswidth = 500;
244      int Windowsheight = 400;
245      int width = Toolkit.getDefaultToolkit().getScreenSize().width;
246      int height = Toolkit.getDefaultToolkit().getScreenSize().height;
247   frame.setResizable(false);
248   frame.setLocation((width - Windowswidth) / 2,
249           (height - Windowsheight) / 2); // 窗口居中
250 }
251 }
