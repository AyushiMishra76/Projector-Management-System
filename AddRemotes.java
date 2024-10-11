package projector.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddRemotes extends JFrame implements ActionListener {
    JButton submit1;
    JTextField tfvenue,tfremote;
    JComboBox cbblock,cbfloor;
 
    AddRemotes(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        //heading
        JLabel heading = new JLabel("Add Remotes");
        heading.setFont(new Font("monteserrat",Font.PLAIN, 18));
        heading.setBounds(150,20,200,20);
        add(heading);
        //remote_id
        JLabel lblremote_no = new JLabel("Remote No");
        lblremote_no.setFont(new Font("monteserrat",Font.PLAIN, 16));
        lblremote_no.setBounds(60,80,120,20);
        add(lblremote_no);
        //block label
        tfremote = new JTextField();
        tfremote.setBounds(200,80,150,30);
        add(tfremote);
        JLabel lblblock = new JLabel("Block");
        lblblock.setFont(new Font("monteserrat",Font.PLAIN, 16));
        lblblock.setBounds(60,140,120,20);
        add(lblblock);
        //adding it like combo options
        String str[] = {"Select","CB","AB1","AB2"};
        cbblock = new JComboBox(str);
        cbblock.setBounds(200, 140, 150, 30);
        cbblock.setBackground(Color.white);
        add(cbblock);
        //adding floors
        JLabel lblfloor = new JLabel("Floor");
        lblfloor.setFont(new Font("monteserrat",Font.PLAIN, 16));
        lblfloor.setBounds(60,200,120,20);
        add(lblfloor);
        //adding combo buttons
        String str1[] = {"Select....","Ground","1","2","3","4","5","6"};
        cbfloor = new JComboBox(str1);
        cbfloor.setBounds(200, 200, 150, 30);
        cbfloor.setBackground(Color.white);
        add(cbfloor);
        //label for venue
        JLabel lblvenue = new JLabel("Venue");
        lblvenue.setFont(new Font("monteserrat",Font.PLAIN, 16));
        lblvenue.setBounds(60,260,120,20);
        add(lblvenue);
        //text field
        tfvenue = new JTextField();
        tfvenue.setBounds(200,260,150,30);
        add(tfvenue);
        //total remotes added
        JLabel lblremote = new JLabel("Remotes");
        lblremote.setFont(new Font("monteserrat",Font.PLAIN, 16));
        lblremote.setBounds(60,320,120,20);
        add(lblremote);
        //text field for total remotes
        tfremote = new JTextField();
        tfremote.setBounds(200,320,150,30);
        add(tfremote);
        //submit button
        submit1 = new JButton("Submit");
        submit1.setBackground(Color.BLACK);
        submit1.setForeground(Color.WHITE);
        submit1.setBounds(180,380,150,30);
        submit1.addActionListener(this);
        add(submit1);
        //keeping an image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/remote.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280,30,450,370);
        add(image);        
    
        setBounds(416,200,650,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String block = (String) cbblock.getSelectedItem();
        String floor = (String) cbfloor.getSelectedItem();
        String venue = tfvenue.getText();
        String remote = tfremote.getText();
        try{
            Conn conn = new Conn();
            String query = "insert into remote values('" + block + "','" + floor + "','" + venue + "','" + remote + "')";
            conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Remote added");
                setVisible(false);
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    public static void main(String [] args){
        new AddRemotes();
    }
    
}
