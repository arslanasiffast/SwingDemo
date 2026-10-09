public class OrderDTO {

    private String customerName;
    private String pizzaSize;

    private boolean cheese;
    private boolean mushrooms;
    private boolean olives;
    private boolean chicken;

    private String crust;
    private int quantity;

    private String specialInstructions;

    // Customer Name
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Pizza Size
    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    // Cheese
    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    // Mushrooms
    public boolean isMushrooms() {
        return mushrooms;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    // Olives
    public boolean isOlives() {
        return olives;
    }

    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    // Chicken
    public boolean isChicken() {
        return chicken;
    }

    public void setChicken(boolean chicken) {
        this.chicken = chicken;
    }

    // Crust
    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    // Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Special Instructions
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @Override
    public String toString() {

        return "Customer: " + customerName +
                "\nPizza Size: " + pizzaSize +
                "\nCheese: " + cheese +
                "\nMushrooms: " + mushrooms +
                "\nOlives: " + olives +
                "\nChicken: " + chicken +
                "\nCrust: " + crust +
                "\nQuantity: " + quantity +
                "\nSpecial Instructions: " + specialInstructions;
    }
}