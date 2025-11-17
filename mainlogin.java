import javax.swing.*;
import java.awt.*;

public class MainLogin extends JFrame {
    
    private JPanel contentPanel;
    private String currentRole = "STUDENT";
    
    public MainLogin() {

        setTitle("Login Page");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        MainPanel();
        setVisible(true);
    }
    
    private void MainPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        
        //leftpanel
        JPanel sidePanel = rolePanel();
        mainPanel.add(sidePanel, BorderLayout.WEST);
        
        //rightpanel
        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBackground(Color.WHITE);
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        setContentPane(mainPanel);
        showPanel("STUDENT");
    }
    
    private JPanel rolePanel() {

        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(200, 500));
        panel.setBackground(new Color(44, 62, 80));
        
        //labeltext
        JLabel titleLbl = new JLabel("EPMS");
        titleLbl.setFont(new Font("Arial", Font.BOLD, 28));
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setBounds(60, 40, 100, 35);
        panel.add(titleLbl);
        
        JLabel subtitleLbl = new JLabel("Login Portal");
        subtitleLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLbl.setForeground(new Color(189, 195, 199));
        subtitleLbl.setBounds(55, 75, 100, 20);
        panel.add(subtitleLbl);
        
        //
        JButton studentBtn = roleBtn("Student", 140);
        JButton lecturerBtn = roleBtn("Lecturer", 200);
        JButton adminBtn = roleBtn("Admin", 260);
        
        panel.add(studentBtn);
        panel.add(lecturerBtn);
        panel.add(adminBtn);
        
        //listener
        studentBtn.addActionListener(e -> {
            currentRole = "STUDENT";
            showPanel("STUDENT");
            highlightButton(studentBtn, lecturerBtn, adminBtn);
        });
        
        lecturerBtn.addActionListener(e -> {
            currentRole = "LECTURER";
            showPanel("LECTURER");
            highlightButton(lecturerBtn, studentBtn, adminBtn);
        });
        
        adminBtn.addActionListener(e -> {
            currentRole = "ADMIN";
            showPanel("ADMIN");
            highlightButton(adminBtn, studentBtn, lecturerBtn);
        });

        highlightButton(studentBtn, lecturerBtn, adminBtn);
        
        return panel;
    }
    
    private JButton roleBtn(String text, int yPos) {

        JButton btn = new JButton(text);
        btn.setBounds(20, yPos, 160, 40);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBackground(new Color(52, 73, 94));
        btn.setForeground(Color.WHITE);
        return btn;

    }
    
    private void highlightButton(JButton active, JButton... others) {

        active.setBackground(new Color(41, 128, 185));
        for (JButton btn : others) {
            btn.setBackground(new Color(52, 73, 94));
        }
    }
    
    public void showPanel(String role) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, role);
    }
    
    //main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainLogin());
    }
}

