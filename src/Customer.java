import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String address;
    private String name;
    private String password;
    private String phone;
    private List<Order> orders;

    // Constructor
    public Customer(String address, String name, String phone, String password) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    // تحديث بيانات العميل (عدا كلمة المرور)
    public void updateInfo(String address, String name, String phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
    }

    // إضافة طلب جديد إلى قائمة الطلبات
    public void addOrder(Order order) {
        orders.add(order);
    }

    // إرجاع تفاصيل العميل على شكل سلسلة مفصولة بفواصل
    public String getDetails() {
        return address + "," + name + "," + phone + "," + password;
    }

    // Getters
    public String getCustomerId() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
