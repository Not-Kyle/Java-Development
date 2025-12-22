public class Main {
    public static void main(String[] arg) {
        Drinks drinks = new Tab();
        Menu menu = new Tab();

        drinks.DrPepper();
        print(drinks.Drinks());

        menu.ChickenWing();
        print("$" + String.valueOf(menu.ChickenPrice()));
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
