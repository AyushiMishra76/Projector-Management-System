package projector.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JTextField Faculty_Id;
    JPasswordField Password;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.gray);
        
        setLayout(null);
        //Creating label
        JLabel user = new JLabel("Faculty_Id");
        user.setBounds(40,20,100,30);
        add(user);
        //Creating text field for faculty
        Faculty_Id = new JTextField();
        Faculty_Id.setBounds(150,20,150,30);
        add(Faculty_Id);
        //Creating password label
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        //Creating password textfield for password label
        Password = new JPasswordField();
        Password.setBounds(150,70,150,30);
        add(Password);
        //Creating login button
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        
        //changing colors for login button
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        //
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        //creating image icon
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/id.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
       
        setBounds(500,200,600,300);  //to create java frame of certain size and locating it with some postion
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
            String user = Faculty_Id.getText();
            String pass = Password.getText();
            try{
                Conn c = new Conn();
                String query = "select * from login where Faculty_Id = '" + user + "' and Password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null,"invalid username or password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== cancel){
            setVisible(false);
        } 
    }
    public static void main(String [] args){
        new Login();   
    }
}
