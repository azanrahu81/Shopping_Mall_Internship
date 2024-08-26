import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

public class ShoppingMallApp extends JFrame {

    JLabel nameLabel, productLabel, quantityLabel, priceLabel;
    JTextField nameField, quantityField;
    JComboBox<String> productComboBox;
    JButton submitButton;
    JLabel productImageLabel;
    JLabel totalPriceLabel;

    // Sample product data
    String[] products = {"Product 1", "Product 2", "Product 3", "Product 4", "Product 5", "Product 6", "Product 7", "Product 8"};
    int[] prices = {100, 200, 300, 400, 500, 600, 700, 800}; // Corresponding prices for the products

    public ShoppingMallApp() 
    {
        setTitle("Shopping Mall Management System");
        setSize(1600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JPanel p1=new JPanel();
        p1.setBounds(0,0,1600,70);
        p1.setBackground(Color.BLACK);
        p1.setLayout(null);
        add(p1);

        // Title label with custom font and color
        JLabel titleLabel = new JLabel("Shopping Mall System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(400, 0, 800, 70); // Adjust bounds as needed
        p1.add(titleLabel);

        JSeparator s=new JSeparator();
        s.setBounds(0,55,1600,40);
        setFont(new Font("Serif", Font.BOLD,60));
        add(s);

        // Product images panel
        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(0, 50, 1200, 350);
        imagePanel.setLayout(new GridLayout(2, 4, 10, 10)); // 2 rows, 4 columns

        // Example product images
        String[] imagePaths = {"product1.png", "product2.png", "product3.png", "product4.png", 
                               "product5.png", "product6.png", "product7.png", "product8.png"};
        for (String path : imagePaths) 
        {
            JLabel imageLabel = new JLabel(new ImageIcon(path));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(imageLabel);
        }
        add(imagePanel);

        // Name label and field
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 410, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.BOLD,15));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(190, 410, 200, 30);
        add(nameField);

        // Product selection
        productLabel = new JLabel("Select Product:");
        productLabel.setFont(new Font("Serif", Font.BOLD,15));
        productLabel.setBounds(50, 460, 130, 30);
        add(productLabel);

        productComboBox = new JComboBox<>(products);
        productComboBox.setBounds(190, 460, 200, 30);

        productComboBox.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
             {
                // Update product image when selection changes
                int index = productComboBox.getSelectedIndex();
                productImageLabel.setIcon(new ImageIcon(imagePaths[index]));
            }
        });
        add(productComboBox);

        // Quantity label and field
        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font("Serif", Font.BOLD,15));
        quantityLabel.setBounds(50, 510, 100, 30);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(190, 510, 200, 30);
        add(quantityField);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.BOLD,25));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(220, 550, 120, 40);
        
        submitButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Calculate and display total price
                try 
                {
                    int quantity = Integer.parseInt(quantityField.getText());
                    int selectedIndex = productComboBox.getSelectedIndex();
                    int price = prices[selectedIndex];
                    int totalPrice = price * quantity;

                    // Display total price
                    totalPriceLabel.setText("Total Price: $" + totalPrice);
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");
                }
            }
        });
        add(submitButton);

        // Price label
        priceLabel = new JLabel("Total Price:");
        priceLabel.setFont(new Font("Serif", Font.BOLD,15));
        priceLabel.setBounds(50, 590, 100, 30);
        add(priceLabel);

        totalPriceLabel = new JLabel("");
        totalPriceLabel.setBounds(190, 590, 200, 30);
        add(totalPriceLabel);

        // Product image display
        productImageLabel = new JLabel(new ImageIcon(imagePaths[0]));
        productImageLabel.setBounds(400, 370, 800, 300);
        add(productImageLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingMallApp().setVisible(true);
            }
        });
    }
}
