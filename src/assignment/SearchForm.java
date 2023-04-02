
package assignment;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
/*Abdulrahman Ali*/
public class SearchForm extends JFrame implements ActionListener
{

    private JLabel L1,L2,L3,L4,L5,L6;
    private JTextField Model,Year,maxSpeed,Color,gearBox,Brand;
    private JButton findFastestCar,Clear;
      SearchForm(){
      setLayout(null);
      setSize(630,175);
      setDefaultCloseOperation(EXIT_ON_CLOSE);  
      setLocationRelativeTo(null);     
    getContentPane().setBackground(new Color(214,217,223));
       
    L1=new JLabel("Brand");
    L1.setFont(new Font("Veradana",Font.BOLD,15));
    L1.setBounds(30, 10, 50, 20);
    L2=new JLabel("GearBox");
    L2.setFont(new Font("Veradana",Font.BOLD,15));
    L2.setBounds(130,10,80,20);
      
     L3=new JLabel("Model");
     L3.setFont(new Font("Veradana",Font.BOLD,15));
    L3.setBounds(240,10,50,20);
     L4=new JLabel("Year");
     L4.setFont(new Font("Veradana",Font.BOLD,15));
    L4.setBounds(350,10,50,20);
     L5=new JLabel("Max Speed");
     L5.setFont(new Font("Veradana",Font.BOLD,15));
    L5.setBounds(420,10,150,20);
     L6=new JLabel("Color");
     L6.setFont(new Font("Veradana",Font.BOLD,15));
    L6.setBounds(560,10,50,20);
    Brand=new JTextField(8);
    Brand.setBounds(10,35,90,40);
    gearBox=new JTextField(8);
    gearBox.setBounds(120,35,90,40);
    Model=new JTextField(8);
    Model.setBounds(220,35,90,40);
    Year=new JTextField(8);
    Year.setBounds(320,35,90,40);
    maxSpeed=new JTextField(8);
    maxSpeed.setBounds(420,35,90,40);
    Color=new JTextField(8);
    Color.setBounds(520,35,90,40);
    this.findFastestCar=new JButton("find Fastest Car");
    findFastestCar.setFont(new Font("Veradana",Font.BOLD,15));
    findFastestCar.setBounds(10,85,500,30);
    findFastestCar.setBackground(new Color(223,255,223));
      findFastestCar.setForeground(new Color(153,0,51));
    Clear=new JButton("Clear");
    Clear.setFont(new Font("Veradana",Font.BOLD,15));
    Clear.setBounds(520,85,90,30);
    Clear.setBackground(new Color(223,255,223));
      Clear.setForeground(new Color(153,0,51));
    
     
    add(L1);
    add(L2);
    add(L3);
    add(L4);
    add(L5);
    add(L6);
    add(Brand);
    add(gearBox);
    add(Model);
    add(Year);
    add(maxSpeed);
    add(Color);
    add(findFastestCar);
    add(Clear);
    findFastestCar.addActionListener(this);
    Clear.addActionListener(this);
    this.setVisible(true);
     }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==findFastestCar){
    try {
   double fastesCar=0;     
  Scanner Reader = new Scanner(new File("Cars.txt"));
      while (Reader.hasNext()) 
      {
   Brand.setText(Reader.next());
   gearBox.setText(Reader.next());
   Model.setText(Reader.next());
   Year.setText(Reader.next());
   maxSpeed.setText(Reader.next());
   if(Double.parseDouble(maxSpeed.getText())>fastesCar)
   {
      fastesCar=Double.parseDouble(maxSpeed.getText());
   }
    Color.setText(Reader.next());
      }
       Scanner Reader2 = new Scanner(new File("Cars.txt"));
    while (Reader2.hasNext()){
    Brand.setText(Reader2.next());
   gearBox.setText(Reader2.next());
   Model.setText(Reader2.next());
   Year.setText(Reader2.next());
   maxSpeed.setText(Reader2.next());
   Color.setText(Reader2.next());
   if(Double.parseDouble(maxSpeed.getText())==fastesCar)
   break;
      }
      Reader2.close();
    } catch (FileNotFoundException ee) {
JOptionPane.showMessageDialog(null,"An Error Accur !!", "Error",
        JOptionPane.ERROR_MESSAGE);
      ee.printStackTrace();
    }
  }else{
    Brand.setText("");
    gearBox.setText("");
    Model.setText("");
    Year.setText("");
    maxSpeed.setText("");
    Color.setText("");
        }
    }
}
