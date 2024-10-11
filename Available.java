package projector.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
public class Available extends JFrame implements ActionListener {
    JButton submit;
    JTextField tfvenue;
    JComboBox cbblock,cbfloor;

    Available(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //heading
        JLabel text = new JLabel("Check Availability");
        text.setBounds(150, 20, 300, 30);
        text.setFont(new Font("raleway",Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        add(text);
        //ADDING LABELS
        JLabel lbldate = new JLabel("DATE");
        lbldate.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        lbldate.setBounds(60,80,120,20);
        add(lbldate);
        //FIELD FOR DATE
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(180,80,150,20);
        add(dateChooser);
        //block
        JLabel lblblock = new JLabel("Block");
        lblblock.setFont(new Font("tahoma",Font.PLAIN, 16));
        lblblock.setBounds(60,120,120,20);
        add(lblblock);
        //adding it like combo options
        String str[] = {"Select","CB","AB1","AB2"};
        cbblock = new JComboBox(str);
        cbblock.setBounds(180, 120, 150, 25);
        cbblock.setBackground(Color.white);
        add(cbblock);
        //floor 
        //adding floors
        JLabel lblfloor = new JLabel("Floor");
        lblfloor.setFont(new Font("tahma",Font.PLAIN, 16));
        lblfloor.setBounds(60,160,120,20);
        add(lblfloor);
        //adding combo buttons
        String str1[] = {"Select....","Ground","1","2","3","4","5","6"};
        cbfloor = new JComboBox(str1);
        cbfloor.setBounds(180, 160, 150, 25);
        cbfloor.setBackground(Color.white);
        add(cbfloor);
        //venue
        //label for venue
        JLabel lblvenue = new JLabel("Venue");
        lblvenue.setFont(new Font("tahoma",Font.PLAIN, 16));
        lblvenue.setBounds(60,200,120,20);
        add(lblvenue);
        //text field
        tfvenue = new JTextField();
        tfvenue.setBounds(180,200,150,30);
        add(tfvenue);
        //keeping an image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/avail_1.png"));
        Image i2 = i1.getImage().getScaledInstance(250,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,70,200,250);
        add(image);
        //keeping labels
        submit = new JButton("Check");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150,280,150,30);
        submit.addActionListener(this);
        add(submit);
             
        setBounds(300,200,700,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      
        setVisible(false);
         new Remotes();
        
    }
    public static void main(String [] args){
        new Available();
    }
}
