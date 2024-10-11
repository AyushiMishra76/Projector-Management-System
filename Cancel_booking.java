package projector.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Cancel_booking extends JFrame implements ActionListener {
    Choice ccustomer;
    JComboBox cbblock,cbfloor;
    JTextField tfvenue;
    JLabel lblid,lblblock,lblfloor,lblvenue;
    JButton cancel,back;
    Cancel_booking(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Cancel Booking");
        text.setBounds(150,20,200,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        lblid = new JLabel("Booking id");
        lblid.setBounds(100,80,100,30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        ccustomer = new Choice();
        ccustomer.setBounds(250,85,150,25);
        add(ccustomer);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from booking");
            while(rs.next()){
                ccustomer.add(rs.getString("booking_id"));
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //keeping previous things
        lblblock = new JLabel("Block");
        lblblock.setFont(new Font("raleway",Font.PLAIN, 16));
        lblblock.setBounds(100,120,300,30);
        add(lblblock);
        //adding it like combo options
       
        String str[] = {"Select","CB","AB1","AB2"};
        cbblock = new JComboBox(str);
        cbblock.setBounds(250, 120, 150, 30);
        cbblock.setBackground(Color.white);
        add(cbblock);
        //adding floors
        lblfloor = new JLabel("Floor");
        lblfloor.setFont(new Font("raleway",Font.PLAIN, 16));
        lblfloor.setBounds(100,160,300,30);
        add(lblfloor);
        
        //adding combo buttons
        String str1[] = {"Select....","Ground","1","2","3","4","5","6"};
        cbfloor = new JComboBox(str1);
        cbfloor.setBounds(250, 165, 150, 30);
        cbfloor.setBackground(Color.white);
        add(cbfloor);
        //label for venue
        lblvenue = new JLabel("Venue");
        lblvenue.setFont(new Font("raleway",Font.PLAIN, 16));
        lblvenue.setBounds(100,210,300,30);
        add(lblvenue);
        //text field
        tfvenue = new JTextField();
        tfvenue.setBounds(250,210,150,30);
        add(tfvenue);
        //cancel and back button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(150, 310, 120, 30);
        cancel.addActionListener(this);
        add(cancel);
        back = new JButton("Back");
        back .setBackground(Color.BLACK);
        back .setForeground(Color.WHITE);
        back .setBounds(400, 310, 120, 30);
        back.addActionListener(this);
        add(back );
        setBounds(300,250,800,400);
        setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== cancel){
            String query1 = "delete from remote_1 where booking_id = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update available set availability = 'Available' where booking_id = '"+lblid.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Booking cancelled" );
                setVisible(false);
                new Booking();
            }catch(Exception e){
                e.printStackTrace();;
            }
        }else{
            setVisible(false);
            new Booking();
        }
    }
    public static void main(String [] args){
        new Cancel_booking();
    }
}
