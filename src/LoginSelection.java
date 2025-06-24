import javax.swing.*;

public class LoginSelection extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel1;
    private JButton btnManager;
    private JButton btnCustomer;

    public LoginSelection() {
        initComponents();
    }

    private void initComponents() {
        // إنشاء العناصر
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        btnManager = new JButton();
        btnCustomer = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // إعداد الخلفية
        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        // إعداد عنوان الشاشة
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setText("تسجيل الدخول");

        // زر المدير
        btnManager.setBackground(new java.awt.Color(255, 102, 0));
        btnManager.setFont(new java.awt.Font("Tahoma", 0, 24));
        btnManager.setText("مدير");
        btnManager.addActionListener(evt -> btnManagerActionPerformed(evt));

        // زر الزبون
        btnCustomer.setBackground(new java.awt.Color(255, 102, 0));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 0, 24));
        btnCustomer.setText("زبون");
        btnCustomer.addActionListener(evt -> btnCustomerActionPerformed(evt));

        // تخطيط اللوحة jPanel1
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(btnManager, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnManager)
                                        .addComponent(btnCustomer))
                                .addGap(99, 99, 99))
        );

        // تخطيط النافذة العامة
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // زر الزبون
    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {
        CustomerRegistration customerWindow = new CustomerRegistration();
        customerWindow.setVisible(true);
        this.dispose();
    }

    // زر المدير
    private void btnManagerActionPerformed(java.awt.event.ActionEvent evt) {
        ManagerLogin managerWindow = new ManagerLogin();
        managerWindow.setVisible(true);
        this.dispose();
    }

    // Main لتشغيل النموذج
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new LoginSelection().setVisible(true));
    }
}
