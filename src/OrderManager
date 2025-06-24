
import java.util.LinkedList;

public class OrderManager {

    private final LinkedList<Order> ordersList;
    private final NotificationService notificationService;
    private volatile boolean isRunning;

    public OrderManager(NotificationService notificationService) {
        this.ordersList = new LinkedList<>();
        this.notificationService = notificationService;
        this.isRunning = true;
        startOrderProcessing();
    }

    // إضافة طلب جديد إلى قائمة المعالجة
    public void addOrder(Order order) {
        synchronized (ordersList) {
            ordersList.add(order);
            ordersList.notifyAll(); // تنبيه الثريد بوجود طلب جديد
        }
        notificationService.sendNotification(order.getOrderId(), "Order added");
    }

    // بدء معالجة الطلبات في Thread منفصل
    private void startOrderProcessing() {
        Thread processingThread = new Thread(() -> {
            while (isRunning) {
                Order nextOrder;
                synchronized (ordersList) {
                    while (ordersList.isEmpty() && isRunning) {
                        try {
                            ordersList.wait(); // الانتظار لحين وجود طلب جديد
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    nextOrder = ordersList.poll(); // أخذ الطلب التالي
                }
                if (nextOrder != null) {
                    processOrder(nextOrder);
                }
            }
        });
        processingThread.start();
    }

    // تنفيذ الطلب وتحديث حالته مع إشعار المستخدم
    private void processOrder(Order order) {
        order.updateStatus("Pending");
        sleep(40000); // انتظار 40 ثانية
        notificationService.sendNotification(order.getOrderId(), "Order is Pending");

        sleep(40000); // انتظار 40 ثانية إضافية
        order.updateStatus("Order has been executed");
        notificationService.sendNotification(order.getOrderId(), "Order has been executed");
    }

    // إيقاف المعالجة بأمان
    public void stop() {
        isRunning = false;
        synchronized (ordersList) {
            ordersList.notifyAll(); // تنبيه الثريد للخروج
        }
    }

    // دالة مساعدة للنوم مع إدارة الاستثناء
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
