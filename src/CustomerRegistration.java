import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CustomerRegistration extends javax.swing.JFrame {

    public CustomerRegistration() {
        initComponents();

        // عند الضغط على زر "OK"
        ok.addActionListener(e -> {
            // قراءة البيانات من الحقول
            String name = n1.getText();
            String phone = ph.getText();
            String address = ad1.getText();
            String password = p2.getText();

            // إنشاء كائن زبون
            Customer customer = new Customer(address, name, phone, password);

            // إضافة الزبون إلى المدير وتخزينه في الملف
            CustomerManager customerManager = new CustomerManager();
            customerManager.addCustomer(customer);

            WritertoFile writer = new WritertoFile();
            try {
                writer.writeCustomer(customer, "customer.txt");
            } catch (IOException ex) {
                Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }

            // إظهار رسالة نجاح
            JOptionPane.showMessageDialog(this, "it was sucssfully add !");

            // الانتقال إلى قائمة الوجبات
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        n1 = new javax.swing.JTextField();
        ph = new javax.swing.JTextField();
        ad1 = new javax.swing.JTextField();
        p2 = new javax.swing.JTextField();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("الاسم:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("رقم الهاتف:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("العنوان:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("كلمة المرور:");

        ok.setBackground(new java.awt.Color(255, 102, 0));
        ok.setFont(new java.awt.Font("Tahoma", 0, 24));
        ok.setText("تأكيد");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1).addComponent(jLabel2)
                                        .addComponent(jLabel3).addComponent(jLabel4))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(n1).addComponent(ph)
                                        .addComponent(ad1).addComponent(p2))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1).addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2).addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3).addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4).addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CustomerRegistration().setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JTextField ad1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField n1;
    private javax.swing.JButton ok;
    private javax.swing.JTextField p2;
    private javax.swing.JTextField ph;
}
