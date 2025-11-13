import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame {

    //
    private HashMap<String, String> users = new HashMap<>();
    private JTextField userBox;
    private JPasswordField pswdBox;
    private JPanel panel;
    
    public login() {
        setTitle("Login Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //backdoor
        users.put("itsme", "letmein");
        
        logpanel();
        setVisible(true);
    }
    
    private void logpanel() {
        panel = new JPanel(null);
        
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(160, 30, 100, 30);
        panel.add(title);
        
        JLabel userLbl = new JLabel("Username:");
        userLbl.setBounds(70, 90, 100, 25);
        panel.add(userLbl);
        
        userBox = new JTextField();
        userBox.setBounds(160, 90, 170, 25);
        panel.add(userBox);
        
        JLabel pswdLbl = new JLabel("Password:");
        pswdLbl.setBounds(70, 130, 100, 25);
        panel.add(pswdLbl);
        
        pswdBox = new JPasswordField();
        pswdBox.setBounds(160, 130, 170, 25);
        panel.add(pswdBox);
        
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 190, 100, 30);
        panel.add(loginBtn);
        
        JButton regBtn = new JButton("Register");
        regBtn.setBounds(210, 190, 100, 30);
        panel.add(regBtn);
        
        loginBtn.addActionListener(e -> handleLogin());
        regBtn.addActionListener(e -> regpanel());
        
        setContentPane(panel);
        revalidate();
        repaint();
    }
    
    private void regpanel() {
        panel = new JPanel(null);
        
        JLabel title = new JLabel("Register");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(150, 30, 120, 30);
        panel.add(title);
        
        JLabel userLbl = new JLabel("Username:");
        userLbl.setBounds(70, 90, 100, 25);
        panel.add(userLbl);
        
        userBox = new JTextField();
        userBox.setBounds(160, 90, 170, 25);
        panel.add(userBox);
        
        JLabel pswdLbl = new JLabel("Password:");
        pswdLbl.setBounds(70, 130, 100, 25);
        panel.add(pswdLbl);
        
        pswdBox = new JPasswordField();
        pswdBox.setBounds(160, 130, 170, 25);
        panel.add(pswdBox);
        
        JButton regBtn = new JButton("Register");
        regBtn.setBounds(70, 190, 110, 30);
        panel.add(regBtn);
        
        JButton backBtn = new JButton("Back to Login");
        backBtn.setBounds(200, 190, 130, 30);
        panel.add(backBtn);
        
        regBtn.addActionListener(e -> handleRegister());
        backBtn.addActionListener(e -> logpanel());
        
        setContentPane(panel);
        revalidate();
        repaint();
    }
    
    private void handleLogin() {
        
        String user = userBox.getText();
        String pswd = new String(pswdBox.getPassword());
        

        if (user.isEmpty() || pswd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "fill in all!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        if (users.containsKey(user) && users.get(user).equals(pswd)) {
            JOptionPane.showMessageDialog(this, "login successful! Welcome" + user, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleRegister() {

        String user = userBox.getText();
        String pswd = new String(pswdBox.getPassword());


        if (user.isEmpty() || pswd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "fill in all!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        if (users.containsKey(user)) {
            JOptionPane.showMessageDialog(this, "username already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        users.put(user, pswd);
        JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        logpanel();
    }
    
    //main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login());
    }
}