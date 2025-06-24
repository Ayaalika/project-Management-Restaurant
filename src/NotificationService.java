import javax.swing.JOptionPane;

public class NotificationService {

    // إرسال إشعار لصاحب الطلب بناءً على رقم الطلب والرسالة
    public void sendNotification(String orderId, String message) {
        String fullMessage = "Notification for Order ID " + orderId + ":\n" + message;
        JOptionPane.showMessageDialog(null, fullMessage, "Order Notification", JOptionPane.INFORMATION_MESSAGE);
    }
}
