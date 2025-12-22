public class Main {
    public static void main(String[] arg) {
        print(Example.name); // I can call the field because of the static keyword

        Example examples = new Test();
        examples.printPrice(Example.settingPrice);
        examples.getName();

        examples.writeExample();
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
