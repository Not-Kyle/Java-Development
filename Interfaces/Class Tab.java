public class Tab implements Drinks, Menu {
    private final String Drink = "Pepsi Bottle";
    private final float Price = 7.96f;

    @Override
    public void DrPepper() {
        Main.print("Drinking some Dr.P");
    }

    @Override
    public String Drinks() {
        return this.Drink;
    }

    @Override
    public void ChickenWing() {
        Main.print("Eating some Chicken Wing Ding");
    }

    @Override
    public float ChickenPrice() {
        return this.Price;
    }
}
