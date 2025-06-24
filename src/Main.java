import javax.swing.*;

public class Main extends JFrame {

    private JPanel jPanel2;
    private JButton jButton1;
    private JLabel jLabel2;

    public Main() {
        initComponents();
    }

    private void initComponents() {
        // إنشاء المكونات
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jLabel2 = new JLabel();

        // إعدادات النافذة الرئيسية
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // إعدادات اللوحة
        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        // إعدادات الزر
        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jButton1.setText("اضغط");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        // إعداد الصورة
        jLabel2.setIcon(new ImageIcon("src\\Food\\1750767480456.jpg"));

        // إعداد تخطيط اللوحة jPanel2
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 540, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(204, 204, 204)
                    .addComponent(jButton1)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // إعداد تخطيط النافذة
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );

        pack(); // لضبط حجم النافذة تلقائيًا
    }

    // حدث الضغط على الزر
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginSelection aboutWindow = new LoginSelection();
        aboutWindow.setVisible(true);
        this.dispose(); // إغلاق النافذة الحالية
    }

    public static void main(String[] args) {
        // تعيين الشكل الجمالي Nimbus إذا كان متوفراً
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // طباعة أي خطأ في الإعداد
        }

        // عرض الواجهة
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}
