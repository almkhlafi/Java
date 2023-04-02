package assignment;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
/*Abdulrahman Ali*/
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class CarInfo extends JFrame implements ActionListener
{        
private JLabel L1,L2,L3,L4,L5,L6,L7;
private JComboBox CB;
private JRadioButton Manual,Automatic;
private ButtonGroup BG;
private JTextField Model,Year,maxSpeed,Color;
private JButton addCar,searchCar;
CarInfo(String title) 
{
    
    
      setTitle(title);
      setLayout(null);
      setSize(360,400);
      setDefaultCloseOperation(EXIT_ON_CLOSE);  
      setLocationRelativeTo(null);
      getContentPane().setBackground(new Color(214,217,223));
      
      L7=new JLabel("Enter the Car's Information",JLabel.CENTER);
      L7.setFont(new Font("Arial", Font.BOLD, 15));
      L7.setBounds(40,5,250,20); 
      L7.setForeground(new Color(13,54,203));
      L6=new JLabel("Choose the Brand:",JLabel.LEFT);
      L6.setFont(new Font("Veradana",Font.BOLD,13)); 
      L6.setBounds(20,40,250,20);
      CB=new JComboBox();
      CB.addItem("Choose");
      CB.addItem("Mercedes");
      CB.addItem("BMW");
      CB.addItem("HONDA");
      CB.addItem("Mazda");
      CB.addItem("Suzuki");
      CB.addItem("Hyundai");
      CB.setBounds(170,40,150,20);
      CB.setBackground(new Color(255,255,255));
      CB.setFont(new Font("Veradana",Font.BOLD,13));
      L1=new JLabel("Choose the GearBox:");
      L1.setFont(new Font("Veradana",Font.BOLD,13));
      L1.setBounds(20,70,250,20);
      Manual=new JRadioButton("Manual");
      Manual.setFont(new Font("Veradana",Font.BOLD,13));
       Manual.setBackground(new Color(214,217,223));
      Manual.setBounds(174,70,75,20);
      Automatic=new JRadioButton("Automatic");
      Automatic.setFont(new Font("Veradana",Font.BOLD,13));
      Automatic.setBackground(new Color(214,217,223));
      Automatic.setBounds(248,70,100,20);
      BG=new ButtonGroup();
      BG.add(Manual);
      BG.add(Automatic);
    
      L2=new JLabel("Enter the Model:");
      L2.setBounds(20,110,250,20);
      L2.setFont(new Font("Veradana",Font.BOLD,13));
      Model=new JTextField(15);
      Model.setBounds(170,110,160,25);
        
      L3=new JLabel("Enter the Year:");
      L3.setFont(new Font("Veradana",Font.BOLD,13));
      L3.setBounds(20,150,250,15);
      Year=new JTextField(10);
      Year.setBounds(170,150,160,25);
      
      
     L4=new JLabel("Enter the MaxSpeed:");
     L4.setBounds(20,190,250,15);
     L4.setFont(new Font("Veradana",Font.BOLD,13));
     maxSpeed=new JTextField(15);
     maxSpeed.setBounds(170,190,160,25);
     
     
     L5=new JLabel("Enter the Color:");
     L5.setBounds(20,230,220,15);
     L5.setFont(new Font("Veradana",Font.BOLD,13));
      Color=new JTextField(10);
      Color.setBounds(170,230,160,25);
      
      addCar=new JButton("Add Car to the File");
      addCar.setBounds(25,280,300,25);
      addCar.setFont(new Font("Veradana",Font.BOLD,13));
      addCar.setBackground(new Color(223,255,223));
      addCar.setForeground(new Color(153,0,51));
      searchCar=new JButton("Open Search Form");
      searchCar.setBounds(25,320,300,25);
      searchCar.setFont(new Font("Veradana",Font.BOLD,13));
      searchCar.setBackground(new Color(223,255,223));
      searchCar.setForeground(new Color(153,0,51));
      add(L7);
      add(L6);
      add(CB);
      add(L1);
      add(Manual);
      add(Automatic);
      add(L2);
      add(Model);
      add(L3);
      add(Year);
      add(L4);
      add(maxSpeed);
      add(L5);
      add(Color);
      add(addCar);
      add(searchCar);
     addCar.addActionListener(this);
     searchCar.addActionListener(this);
   setVisible(true);  
}
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==addCar)
    {
        if(Manual.isSelected()==false && Automatic.isSelected()==false || CB.getSelectedIndex()==0 || Model.getText()=="" || Year.getText()=="" || maxSpeed.getText()=="" || Color.getText()=="" )
        {
            JOptionPane.showMessageDialog(null, "Fill In The Empty Sections","Empty Field !!",JOptionPane.WARNING_MESSAGE);
        }else
        try {
           FileWriter writer = new FileWriter ("Cars.txt",true);
            writer.write(CB.getSelectedItem()+"\t");
            if(Manual.isSelected())
                writer.write("Manual\t");
            else  writer.write("Automatic\t");
            writer.write(Model.getText()+"\t");
            writer.write(Year.getText()+"\t");
            writer.write(maxSpeed.getText()+"\t");
            writer.write(Color.getText()+"\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Car has been added");
            BG.clearSelection();
            CB.setSelectedIndex(0);
            Model.setText("");
            Year.setText("");
            maxSpeed.setText("");
            Color.setText("");
        } catch (IOException ex) {
            Logger.getLogger(CarInfo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    else
    {  
    new SearchForm();
    this.dispose();
    }
}
}

