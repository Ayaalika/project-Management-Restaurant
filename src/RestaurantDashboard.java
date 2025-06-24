
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * الواجهة الرئيسية لعرض الملفات المرتبطة بالمطعم
 * meal.txt - order.txt - customer.txt - report.txt
 */
public class RestaurantDashboard extends javax.swing.JFrame {

    // ===================== Constructor =====================
    public RestaurantDashboard() {
        initComponents();

        // فتح الملفات عند الضغط على الأزرار
        listButton.addActionListener(e -> openFile("meal.txt"));
        orderlist.addActionListener(e -> openFile("order.txt"));
        infoCustomer.addActionListener(e -> openFile("customer.txt"));
        jButton2.addActionListener(e -> openFile("report.txt"));
    }

    // ===================== تهيئة المكونات =====================
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        infoCustomer = new JButton("بيانات زباىن");
        listButton = new JButton("قاىمة وجبات");
        orderlist = new JButton("قاىمة طلبات");
        jButton1 = new JButton("اضافة");
        jButton2 = new JButton("التقارير");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // تنسيق الخلفية
        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        // تنسيق الأزرار
        JButton[] buttons = {infoCustomer, listButton, orderlist, jButton1, jButton2};
        for (JButton btn : buttons) {
            btn.setBackground(new java.awt.Color(255, 102, 0));
            btn.setFont(new java.awt.Font("Tahoma", 0, 18));
            btn.setForeground(new java.awt.Color(255, 255, 255));
        }

        // زر "اضافة" يفتح نافذة جديدة
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        // زر "قاىمة وجبات" (غير مفعل حالياً لكن تركناه للتمديد مستقبلاً)
        listButton.addActionListener(evt -> listButtonActionPerformed(evt));

        // تخطيط الأزرار
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, 134, 134, 134)
                        .addGap(18)
                        .addComponent(orderlist, 134, 134, 134)
                        .addGap(18)
                        .addComponent(listButton, 134, 134, 134)
                        .addGap(18)
                        .addComponent(infoCustomer, 135, 135, 135)
                        .addGap(18)
                        .addComponent(jButton2, 134, 134, 134)
                        .addContainerGap()
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addGap(20)
                        .addGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(orderlist)
                                        .addComponent(listButton)
                                        .addComponent(infoCustomer)
                                        .addComponent(jButton2)
                        )
                        .addContainerGap(330, Short.MAX_VALUE)
        );

        // تطبيق التخطيط الرئيسي
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // ===================== أحداث الأزرار =====================

    // فتح واجهة إضافة وجبة جديدة
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        AddMealForm w = new AddMealForm();
        w.setVisible(true);
    }

    // إجراء فارغ حالياً لزر "قائمة الوجبات"
    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // غير مستخدم حالياً
    }

    // فتح ملف معين باستخدام البرنامج الافتراضي في النظام
    private void openFile(String fileName) {
        try {
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening file : " + fileName);
        }
    }

    // ===================== Main =====================
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RestaurantDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new RestaurantDashboard().setVisible(true));
    }

    // ===================== المتغيرات =====================
    private JButton infoCustomer;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JButton listButton;
    private JButton orderlist;
}
