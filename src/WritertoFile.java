import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * كلاس مسؤول عن كتابة الكائنات إلى ملفات نصية (Meals, Customers, Reports)
 */
public class WritertoFile {

    /**
     * كتابة نص عادي (مثل تقرير) إلى الملف المحدد.
     */
    public void writeReporter(String text, String filename) throws IOException {
        File file = new File(filename);
        try (
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(text);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error writing reporter to file: " + filename, e);
        }
    }

    /**
     * كتابة بيانات زبون إلى الملف.
     */
    public void writeCustomer(Customer customer, String filename) throws IOException {
        File file = new File(filename);
        try (
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(customer.getDetails());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error writing customer to file: " + filename, e);
        }
    }

    /**
     * كتابة بيانات وجبة إلى الملف.
     */
    public void writeMeal(Meal meal, String filename) throws IOException {
        File file = new File(filename);
        try (
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(meal.getDetails());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error writing meal to file: " + filename, e);
        }
    }
}

