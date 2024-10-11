package projector.management.system;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class AddFaculty extends JFrame implements ActionListener {
    JTextField tfname, tfage,tfphone,tfemail;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    AddFaculty(){
        setLayout(null);
        //adding text field name and label as name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("monteserrat",Font.PLAIN, 18));
        add(lblname);
        //text field
        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        //age
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("monteserrat",Font.PLAIN, 18));
        add(lblage);
        //text field
        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("monteserrat",Font.PLAIN, 18));
        add(lblgender);
        //male radio button
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("monteserrat",Font.PLAIN, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        //female radio button
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        //label for phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60,180,120,30);
        lblphone.setFont(new Font("monteserrat",Font.PLAIN, 18));
        add(lblphone);
        //txt field for phone
        tfphone = new JTextField();
        tfphone.setBounds(200,180,150,30);
        add(tfphone);
        //Jlabel for mail
        JLabel lblemail = new JLabel("E-mail");
        lblemail.setBounds(60,230,120,30);
        lblemail.setFont(new Font("monteserrat",Font.PLAIN, 18));
        add(lblemail);
        //text field for email
        tfemail = new JTextField();
        tfemail.setBounds(200,230,150,30);
        add(tfemail);
        //SUBMIT BUTTON
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,330,150,30);
        submit.addActionListener(this);
        add(submit);
        //keeping an image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/faculty1.png"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,30,450,370);
        add(image);
        
        
        getContentPane().setBackground(Color.white);
        setBounds(330,200,870,540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        
        String gender = null;
        //validation
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty ");
            return;
        }
        if(rbmale.isSelected()){
            gender = "Male";
        }else if (rbfemale.isSelected()){
            gender = "Female";
        }
        try{
                Conn c = new Conn();
                String query = "insert into faculty values('" + name + "', '" + age + "' , '" + gender + "','" + phone + "','" + email + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Faculty added");
                setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
                
    }
   public static void main(String [] args){
        new AddFaculty();   
    } 
}
