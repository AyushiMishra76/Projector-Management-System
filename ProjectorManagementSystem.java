package projector.management.system;
import java.awt.Color;
import java.awt.Font;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.awt.event.*;
public class ProjectorManagementSystem extends JFrame implements ActionListener {
    ProjectorManagementSystem(){
        //setSize(1366,565);
        //setLocation(100,100);
        setBounds(100,100,1366,565);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);   //locationx,locationy,length,breadth
        add(image);
        
        JLabel text = new JLabel("Projector Management System");
        text.setBounds(200, 350, 1000, 90);
        text.setForeground(Color.pink);
        image.add(text);
        text.setFont(new Font("monteserrat",Font.ITALIC, 50));
        
        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.white);
        next.setForeground(Color.MAGENTA);
        next.setFont(new Font("roboto",Font.PLAIN , 24));
        next.addActionListener(this);   //for going to another page
        image.add(next);
                
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e){  //created abstract class
        setVisible(false);   //when clicked 
        new Login();           //redirects to login page
        
    }
    public static void main(String[] args) {
        new ProjectorManagementSystem();
        
    }
    
}
