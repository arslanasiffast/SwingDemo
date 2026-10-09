import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaOrderGUI extends JFrame {

    private JTextField customerNameField;

    private JComboBox<String> sizeComboBox;
    private JComboBox<Integer> quantityComboBox;

    private JCheckBox cheeseCheckBox;
    private JCheckBox mushroomsCheckBox;
    private JCheckBox olivesCheckBox;
    private JCheckBox chickenCheckBox;

    private JRadioButton thinRadioButton;
    private JRadioButton thickRadioButton;

    private JTextArea instructionsTextArea;

    private JButton orderButton;
    private JButton clearButton;
    private JButton exitButton;

    public PizzaOrderGUI() {

        setTitle("Pizza Ordering System");
        setSize(600, 550);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DO_NOTHING_ON_CLOSE
        );

        createGUI();
        registerEvents();
    }

    private void createGUI() {

        setLayout(new BorderLayout(10, 10));

        // -----------------------------
        // Customer Information
        // -----------------------------

        JPanel customerPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
        );

        customerPanel.add(
                new JLabel("Customer Name:")
        );

        customerNameField = new JTextField(20);

        customerPanel.add(customerNameField);

        // -----------------------------
        // Pizza Information
        // -----------------------------

        JPanel pizzaPanel = new JPanel(
                new GridLayout(3, 2, 5, 5)
        );

        pizzaPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Pizza Information"
                )
        );

        pizzaPanel.add(new JLabel("Pizza Size:"));

        sizeComboBox = new JComboBox<>(
                new String[]{
                        "Small",
                        "Medium",
                        "Large"
                }
        );

        pizzaPanel.add(sizeComboBox);

        pizzaPanel.add(new JLabel("Quantity:"));

        quantityComboBox = new JComboBox<>(
                new Integer[]{
                        1, 2, 3, 4, 5
                }
        );

        pizzaPanel.add(quantityComboBox);

        pizzaPanel.add(new JLabel("Crust:"));

        JPanel crustPanel = new JPanel();

        thinRadioButton =
                new JRadioButton("Thin", true);

        thickRadioButton =
                new JRadioButton("Thick");

        ButtonGroup crustGroup = new ButtonGroup();

        crustGroup.add(thinRadioButton);
        crustGroup.add(thickRadioButton);

        crustPanel.add(thinRadioButton);
        crustPanel.add(thickRadioButton);

        pizzaPanel.add(crustPanel);

        // -----------------------------
        // Toppings
        // -----------------------------

        JPanel toppingsPanel = new JPanel();

        toppingsPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Toppings"
                )
        );

        cheeseCheckBox =
                new JCheckBox("Cheese");

        mushroomsCheckBox =
                new JCheckBox("Mushrooms");

        olivesCheckBox =
                new JCheckBox("Olives");

        chickenCheckBox =
                new JCheckBox("Chicken");

        toppingsPanel.add(cheeseCheckBox);
        toppingsPanel.add(mushroomsCheckBox);
        toppingsPanel.add(olivesCheckBox);
        toppingsPanel.add(chickenCheckBox);

        // -----------------------------
        // Special Instructions
        // -----------------------------

        JPanel instructionPanel = new JPanel(
                new BorderLayout()
        );

        instructionPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Special Instructions"
                )
        );

        instructionsTextArea =
                new JTextArea(5, 40);

        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setWrapStyleWord(true);

        instructionPanel.add(
                new JScrollPane(instructionsTextArea),
                BorderLayout.CENTER
        );

        // -----------------------------
        // Buttons
        // -----------------------------

        JPanel buttonPanel = new JPanel();

        orderButton =
                new JButton("Place Order");

        clearButton =
                new JButton("Clear");

        exitButton =
                new JButton("Exit");

        buttonPanel.add(orderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // -----------------------------
        // Add panels to JFrame
        // -----------------------------

        JPanel centerPanel = new JPanel(
                new BorderLayout(10, 10)
        );

        centerPanel.add(
                pizzaPanel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                toppingsPanel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                instructionPanel,
                BorderLayout.SOUTH
        );

        add(
                customerPanel,
                BorderLayout.NORTH
        );

        add(
                centerPanel,
                BorderLayout.CENTER
        );

        add(
                buttonPanel,
                BorderLayout.SOUTH
        );
    }

    private void registerEvents() {

        // ---------------------------------
        // Place Order
        // ---------------------------------

        orderButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        placeOrder();
                    }
                }
        );

        // ---------------------------------
        // Clear
        // ---------------------------------

        clearButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        clearForm();
                    }
                }
        );

        // ---------------------------------
        // Exit Button
        // ---------------------------------

        exitButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        confirmExit();
                    }
                }
        );

        // ---------------------------------
        // Mouse Event
        // ---------------------------------

        orderButton.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        orderButton.setText(
                                "Click to Order"
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        orderButton.setText(
                                "Place Order"
                        );
                    }
                }
        );

        // ---------------------------------
        // Window Closing
        // ---------------------------------

        addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(
                            WindowEvent e) {

                        confirmExit();
                    }
                }
        );
    }

    // =====================================
    // Create OrderDTO from GUI
    // =====================================

    private OrderDTO getOrderFromGUI() {

        OrderDTO order = new OrderDTO();

        order.setCustomerName(
                customerNameField.getText()
        );

        order.setPizzaSize(
                (String) sizeComboBox.getSelectedItem()
        );

        order.setQuantity(
                (Integer) quantityComboBox.getSelectedItem()
        );

        order.setCheese(
                cheeseCheckBox.isSelected()
        );

        order.setMushrooms(
                mushroomsCheckBox.isSelected()
        );

        order.setOlives(
                olivesCheckBox.isSelected()
        );

        order.setChicken(
                chickenCheckBox.isSelected()
        );

        if (thinRadioButton.isSelected()) {
            order.setCrust("Thin");
        }
        else {
            order.setCrust("Thick");
        }

        order.setSpecialInstructions(
                instructionsTextArea.getText()
        );

        return order;
    }

    // =====================================
    // Place Order
    // =====================================

    private void placeOrder() {

        String customerName =
                customerNameField.getText().trim();

        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter customer name.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Do you want to place this order?",
                        "Confirm Order",
                        JOptionPane.YES_NO_OPTION
                );

        if (result == JOptionPane.YES_OPTION) {

            OrderDTO order =
                    getOrderFromGUI();

            JOptionPane.showMessageDialog(
                    this,
                    order,
                    "Order Details",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =====================================
    // Clear Form
    // =====================================

    private void clearForm() {

        customerNameField.setText("");

        sizeComboBox.setSelectedIndex(0);

        quantityComboBox.setSelectedIndex(0);

        cheeseCheckBox.setSelected(false);
        mushroomsCheckBox.setSelected(false);
        olivesCheckBox.setSelected(false);
        chickenCheckBox.setSelected(false);

        thinRadioButton.setSelected(true);

        instructionsTextArea.setText("");
    }

    // =====================================
    // Exit Confirmation
    // =====================================

    private void confirmExit() {

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to exit?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION
                );

        if (result == JOptionPane.YES_OPTION) {

            System.exit(0);
        }
    }

    // =====================================
    // Main
    // =====================================

    public static void main(String[] args) {

        PizzaOrderGUI pg = new PizzaOrderGUI();
        pg.setVisible(true);

    }
}