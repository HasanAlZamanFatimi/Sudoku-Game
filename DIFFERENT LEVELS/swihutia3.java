import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class swihutia3 extends JFrame implements ActionListener
{

FlowLayout f1,f2;
JPanel p1,p2;
JLabel l;

JButton b,b1,b2,b3,b4,b5,b6,b7,b8,bs;

 public static final int GRID_SIZE = 9;    
   public static final int SUBGRID_SIZE = 3; 
 
   
   public static final int CELL_SIZE = 60;   
   public static final int CANVAS_WIDTH  = CELL_SIZE * GRID_SIZE;
   public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
                                       
   public static final Color OPEN_CELL_BGCOLOR = Color.YELLOW;
   public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  
   public static final Color CLOSED_CELL_BGCOLOR = Color.WHITE;
   public static final Color OPEN_CELL_TEXT_NO = new Color(240, 240, 240); 
   public static final Color CLOSED_CELL_TEXT = Color.BLACK;
   public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
 
  
   private JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];
 
   
    int[][] puzzle =
      { {5, 3, 4, 6, 7, 8, 9, 1, 2},
       {6, 7, 2, 1, 9, 5, 3, 4, 8},
       {1, 9, 8, 3, 4, 2, 5, 6, 7},
       {2, 8, 7, 4, 1, 9, 6, 3, 5},
       {4, 2, 6, 8, 5, 3, 7, 9, 1},
       {3, 4, 5, 2, 8, 6, 1, 7, 9},
       {9, 6, 1, 5, 3, 7, 2, 8, 4},
      {8, 5, 9, 7, 6, 1, 4, 2, 3},
       {7, 1, 3, 9, 2, 4, 8, 5, 6}};
  
    boolean[][] masks =
      {{false, false, false, false, true, false, true, false, false},
       {false, false, true, true, false, false, false, true, false},
       {true, false, false, false, false, true, false, false, true},
       {true, false, false, false, true, false, false, false, false},
       {false, false, true, true, false, false, false, true, false},
       {false, false, false, false, false, true, false, false, true},
       {true, false , false, true, false, false, false, true, false},
       {false, true, false, false, false, true, false, false, false},
       {false, false, true, false, true, false, false, false, true}};
 

swihutia3()
{
setLayout(null);
f1=new FlowLayout(FlowLayout.RIGHT);
f2=new FlowLayout(FlowLayout.LEFT);
bs=new JButton("submit");
b=new JButton("1");
b1=new JButton("2");
b2=new JButton("3");
b3=new JButton("4");
b4=new JButton("5");
b5=new JButton("6");
b6=new JButton("7");
b7=new JButton("8");
b8=new JButton("9");

bs.addActionListener(this);
/*b.addActionListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);*/
p1=new JPanel();
p2=new JPanel();
//p2.setLayout(f2);
//p1.setLayout(f1);

p2.setBounds(800,190,200,200);
/*p2.add(b);
p2.add(b1);
p2.add(b2);
p2.add(b3);
p2.add(b4);
p2.add(b5);
p2.add(b6);
p2.add(b7);
p2.add(b8);*/
p2.add(bs);
//m1.add(m11); m1.add(m12); m1.add(m13);
//jmb.add(m1);
//setJMenuBar(jmb);
add(p2);
 
      p1.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE)); 
 
     
 
      
      for (int row = 0; row < GRID_SIZE; ++row) {
      for (int col = 0; col < GRID_SIZE; ++col) {
         tfCells[row][col] = new JTextField(1);
            p1.add(tfCells[row][col]);   
            if (masks[row][col]) {
               tfCells[row][col].setText("");     
               tfCells[row][col].setEditable(true);
               tfCells[row][col].setBackground(OPEN_CELL_BGCOLOR);
 
              
            } 
else {
               tfCells[row][col].setText(puzzle[row][col] + "");
               tfCells[row][col].setEditable(false);
               tfCells[row][col].setBackground(CLOSED_CELL_BGCOLOR);
               tfCells[row][col].setForeground(CLOSED_CELL_TEXT);
            }
            
            tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
            tfCells[row][col].setFont(FONT_NUMBERS);
         }
      }
 
     
      p1.setPreferredSize(new Dimension (CANVAS_WIDTH, CANVAS_HEIGHT));
      pack();
p1.setBounds(50,20,650,650);
add(p1);
l=new JLabel(new ImageIcon("hzf3.jpg"));
l.setBounds(0,0,1366,760);
add(l);
setSize(1366,760);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

}
public  void actionPerformed(ActionEvent ae)
{
try
{/*
if (ae.getActionCommand().equals("1"))
{
}
if (ae.getActionCommand().equals("2"))
{
}
if (ae.getActionCommand().equals("3"))
{
}
if (ae.getActionCommand().equals("4"))
{
}
if (ae.getActionCommand().equals("5"))
{
}
if (ae.getActionCommand().equals("6"))
{
}
if (ae.getActionCommand().equals("7"))
{
}
if (ae.getActionCommand().equals("8"))
{
}
if (ae.getActionCommand().equals("9"))
{
}*/
if (ae.getActionCommand().equals("submit"))
{

for (int row = 0; row < GRID_SIZE; ++row) {
      for (int col = 0; col < GRID_SIZE; ++col) {
        
            if (masks[row][col]) {
                
               
               int x=Integer.parseInt(tfCells[row][col].getText());
if( x==puzzle[row][col])
{
               tfCells[row][col].setBackground(Color.GREEN);
 }
else
{
  tfCells[row][col].setBackground(Color.RED);
}
}
               
             
}
}

int d=(int)(Math.random()*255);
int d1=(int)(Math.random()*255);
int d2=(int)(Math.random()*255);
Color c=new Color(d,d1,d2);

p2.setBackground(c);

}

  }catch(Throwable e){System.out.println("Wanna Play Again");}
}

public static void main (String args[])
{
new swihutia3();
}
}
