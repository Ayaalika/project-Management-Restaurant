import javax.swing.JOptionPane;

public class ManagerLogin extends javax.swing.JFrame {

    private String managerPassword = "admin123";

    public ManagerLogin() {
        initComponents();

        // عند الضغط على زر الدخول
        loginButton.addActionListener(e -> {
            String enteredPassword = new String(passwordField.getPassword());

            if (enteredPassword.equals(managerPassword)) {
                openManagerInterface();
            } else {
                JOptionPane.showMessageDialog(this, "The password is wrong!", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        loginButton.setBackground(new java.awt.Color(0, 153, 153));
        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("دخول");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setText("كلمة المرور:");

        // صورة من الجهاز - تأكدي إن المسار صحيح أو ممكن تشيليها
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\JUMBO CO\\Desktop\\تنزيل.png"));

        // تصميم واجهة الإدخال
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)
                                .addComponent(jLabel4)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42)
                                                .addComponent(loginButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel4)))
                                .addContainerGap(75, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
    }

    // فتح واجهة المدير بعد تسجيل الدخول
    void openManagerInterface() {
        new RestaurantDashboard().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManagerLogin().setVisible(true);
        });
    }

    // المتغيرات
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
}
