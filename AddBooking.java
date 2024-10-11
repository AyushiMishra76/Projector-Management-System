package projector.management.system;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class AddBooking extends JFrame implements ActionListener {
    JComboBox cbblock,cbfloor;
    JTextField tfid,tfvenue;
    AddBooking(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //heading
        JLabel text = new JLabel("Book Your Remote");
        text.setBounds(150, 20, 300, 30);
        text.setFont(new Font("raleway",Font.BOLD, 20));
        text.setForeground(Color.red);
        add(text);
        //jlabel for id
        JLabel lblid = new JLabel("Booking_Id");
        lblid.setBounds(50, 100, 300, 30);
        lblid.setFont(new Font("raleway",Font.BOLD, 18));
        add(lblid);
        //adding text field
        tfid = new JTextField();
        tfid.setBounds(250,100,150,30);
        add(tfid);
        //all other attributes
        //block label
        JLabel lblblock = new JLabel("Block");
        lblblock.setFont(new Font("raleway",Font.BOLD, 18));
        lblblock.setBounds(50,150,300,30);
        add(lblblock);
        //adding it like combo options
        String str[] = {"Select","CB","AB1","AB2"};
        cbblock = new JComboBox(str);
        cbblock.setBounds(250, 150, 150, 30);
        cbblock.setBackground(Color.white);
        add(cbblock);
        //adding floors
        JLabel lblfloor = new JLabel("Floor");
        lblfloor.setFont(new Font("raleway",Font.BOLD, 18));
        lblfloor.setBounds(50,200,300,30);
        add(lblfloor);
        //adding combo buttons
        String str1[] = {"Select....","Ground","1","2","3","4","5","6"};
        cbfloor = new JComboBox(str1);
        cbfloor.setBounds(250, 200, 150, 30);
        cbfloor.setBackground(Color.white);
        add(cbfloor);
        //label for venue
        JLabel lblvenue = new JLabel("Venue");
        lblvenue.setFont(new Font("raleway",Font.BOLD, 18));
        lblvenue.setBounds(50,250,300,30);
        add(lblvenue);
        //text field
        tfvenue = new JTextField();
        tfvenue.setBounds(250,250,150,30);
        add(tfvenue);
        setBounds(350,200,800,550);
        setVisible(true);
        
        JButton submit = new JButton("Book");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,330,150,30);
        submit.addActionListener(this);
        add(submit);
    }
    public void actionPerformed(ActionEvent ae){
        String booking_id = tfid.getText();
        String block = (String) cbblock.getSelectedItem();
        String floor = (String) cbfloor.getSelectedItem();
        String venue = tfvenue.getText();
        
        try{
            Conn conn = new Conn();
            String query = "insert into booking values('" +booking_id +"','" + block + "','" + floor + "','" + venue + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Booking is successful");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    
    public static void main(String [] args){
        new AddBooking();
    }
}
