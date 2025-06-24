
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private List<Meal> meals;
    private String status;
    private boolean isPaid;

    // المُنشئ
    public Order(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
        this.meals = new ArrayList<>();
        this.isPaid = false;
    }

    // إضافة وجبة إلى الطلب
    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    // تحديث حالة الطلب (مثلاً: جاري التحضير، تم التوصيل، ...إلخ)
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // تعيين حالة الدفع كمدفوع
    public void markAsPaid() {
        this.isPaid = true;
    }

    // حساب المجموع الكلي للطلب
    public double calculateTotalPrice() {
        double total = 0;
        for (Meal meal : meals) {
            total += meal.getPrice();
        }
        return total;
    }

    // إرجاع تفاصيل الطلب كسلسلة نصية
    public String getDetails() {
        return orderId + "," + meals.toString() + "," + status + "," + (isPaid ? "Paid" : "Not Paid");
    }

    // Getter methods
    public String getOrderId() {
        return orderId;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
