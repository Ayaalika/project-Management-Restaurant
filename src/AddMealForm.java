import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddMealForm extends javax.swing.JFrame {

    public AddMealForm() {
        initComponents();

        // عند الضغط على زر الإضافة
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String id = idField.getText();
                double price = Double.parseDouble(priceField.getText());

                String ingredientsText = ingredientsField.getText(); // "chicken,rice,onion"
                String[] ingredientsArray = ingredientsText.split(",");
                ArrayList<String> ingredients = new ArrayList<>(Arrays.asList(ingredientsArray));

                Meal meal = new Meal(id, name, ingredients, price);

                WritertoFile writer = new WritertoFile();
                writer.writeMeal(meal, "meal.txt");

                JOptionPane.showMessageDialog(this, "Meal added successfully!");

            } catch (IOException ex) {
                Logger.getLogger(AddMealForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error saving the meal.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price format.");
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        nameField = new JTextField();
        idField = new JTextField();
        ingredientsField = new JTextField();
        priceField = new JTextField();

        nameLabel = new JLabel("Name");
        idLabel = new JLabel("ID");
        ingredientsLabel = new JLabel("Ingredients (comma separated)");
        priceLabel = new JLabel("Price");

        addButton = new JButton("Add Meal");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 204));

        // Layout setup
        GroupLayout layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameLabel)
                                .addComponent(idLabel)
                                .addComponent(ingredientsLabel)
                                .addComponent(priceLabel)
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameField)
                                .addComponent(idField)
                                .addComponent(ingredientsField)
                                .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(idLabel)
                                .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(ingredientsLabel)
                                .addComponent(ingredientsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(priceLabel)
                                .addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(30)
                        .addComponent(addButton)
                        .addGap(30)
        );

        getContentPane().add(jPanel1);
        pack();
    }

    // Main Method
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new AddMealForm().setVisible(true);
        });
    }

    // Variables declaration
    private JButton addButton;
    private JTextField idField;
    private JTextField ingredientsField;
    private JTextField nameField;
    private JTextField priceField;
    private JLabel idLabel;
    private JLabel ingredientsLabel;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JPanel jPanel1;
}
