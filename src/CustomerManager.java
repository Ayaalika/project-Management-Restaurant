
import java.util.HashMap;

public class CustomerManager {

    // خريطة لتخزين العملاء، المفتاح هو اسم المستخدم
    private HashMap<String, Customer> customers;

    // المُنشئ
    public CustomerManager() {
        customers = new HashMap<>();
    }

    // إضافة عميل جديد إلى القائمة
    public void addCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    // البحث عن عميل باستخدام اسم المستخدم
    public synchronized Customer findCustomerByUsername(String username) {
        return customers.get(username);
    }

    // إرجاع جميع العملاء
    public HashMap<String, Customer> getCustomers() {
        return customers;
    }
}
