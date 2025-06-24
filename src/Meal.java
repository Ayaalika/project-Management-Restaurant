import java.util.ArrayList;

public class Meal {
    private String mealId;
    private String name;
    private ArrayList<String> ingredients;
    private double price;

    // Constructor
    public Meal(String mealId, String name, ArrayList<String> ingredients, double price) {
        this.mealId = mealId;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    // تحديث معلومات الوجبة
    public void updateInfo(String mealId, String name, ArrayList<String> ingredients, double price) {
        this.mealId = mealId;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    // إضافة مكون جديد لقائمة المكونات
    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    // Getters
    public String getMealId() {
        return mealId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // طباعة تفاصيل الوجبة
    public String getDetails() {
        return mealId + "," + name + "," + ingredients.toString() + "," + price;
    }

    // لعرض اسم الوجبة فقط في القوائم
    @Override
    public String toString() {
        return name;
    }
}
