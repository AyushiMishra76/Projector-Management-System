package projector.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);
        
        setLayout(null);
        //creating an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        //writing text on image
        JLabel text = new JLabel("WELCOME");
        text.setBounds(550,420,1500,100);
        text.setFont(new Font("Tahoma",Font.PLAIN,100));
        text.setForeground(Color.black);
        image.add(text);
        //creating a menu bar
        JMenuBar mb =new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        //creating a menu
        JMenu projector = new JMenu("Projector Management");
        projector.setForeground(Color.red);
        mb.add(projector);
        //adding booking drop down menu
        JMenuItem book = new JMenuItem("Booking");
        book.addActionListener(this);
        projector.add(book);
        //menu for badmin
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.blue);
        mb.add(admin);
        //adding drop down menu for admin
        JMenuItem addFaculty = new JMenuItem("Add Faculty");
        addFaculty.addActionListener(this);
        admin.add(addFaculty);
        JMenuItem addRemotes = new JMenuItem("Add Remotes");
        addRemotes.addActionListener(this);
        admin.add(addRemotes);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Faculty")){
            new AddFaculty();
        }else if(ae.getActionCommand().equals("Add Remotes")){
            new AddRemotes();
        }else if(ae.getActionCommand().equals("Booking")){
            new Booking();
        }
    }
    public static void main(String [] args){
        new Dashboard();
    }
}
