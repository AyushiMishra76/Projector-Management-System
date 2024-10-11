package projector.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class Remotes extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Remotes(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //date label
        JLabel l1 = new JLabel("Date");
        l1.setBounds(60, 10, 100, 20);
        add(l1);
        //
        JLabel l2 = new JLabel("Block");
        l2.setBounds(150, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Floor");
        l3.setBounds(250, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Venue");
        l4.setBounds(350, 10, 100, 20);
        add(l4);
        //available
        JLabel l5 = new JLabel("Availability");
        l5.setBounds(450, 10, 100, 20);
        add(l5);
        //adding table 
        table = new JTable();
        table.setBounds(40,40,500,4000);
        add(table);
        //try and catch block
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from available");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        //adding back button
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(100,100,120,30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Booking();
    }
    public static void main(String [] args){
        new Remotes();
    } 
}
