package projector.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class Booking extends JFrame implements ActionListener {
    JButton new_book ,availability,cancel_booking,log_out ;
    Booking(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //heading
        JLabel heading = new JLabel("BOOKING");
        heading.setFont(new Font("monteserrat",Font.BOLD, 20));
        heading.setBounds(150,20,400,60);
        add(heading);
        //booking form button
        new_book = new JButton("New Booking");
        new_book.setBounds(40,100,160,50);
        new_book.setBackground(Color.BLACK);
        new_book.setForeground(Color.white);
        new_book.addActionListener(this);
        add(new_book);
       
        
  
        //check for availabe time slots
        availability= new JButton("Availabilty");
        availability.setBounds(40,180,160,50);
        availability.setBackground(Color.BLACK);
        availability.setForeground(Color.white);
        availability.addActionListener(this);
        add(availability);
        //cancel booking button
        cancel_booking = new JButton("Cancel Booking");
        cancel_booking.setBounds(40,260,160,50);
        cancel_booking.setBackground(Color.BLACK);
        cancel_booking.setForeground(Color.white);
        add(cancel_booking);
        //log out button
        log_out = new JButton("Log Out");
        log_out.setBounds(40,340,160,50);
        log_out.setBackground(Color.BLACK);
        log_out.setForeground(Color.white);
        log_out.addActionListener(this);
        add(log_out);
        //keeping an image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,30,500,470);
        add(image);
        //frame lengths
        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== new_book){
            setVisible(false);
            new AddBooking();
        }else if(ae.getSource()== availability){
            setVisible(false);
            new Available();
        }else if(ae.getSource()== cancel_booking){
            setVisible(false);
            new Available();
        }else if(ae.getSource()==log_out){
            setVisible(false);
            System.exit(0);
        }
        
   }
    
    public static void main(String [] args){
        new Booking();
    }
    
}
