public class Test implements Example {
    @Override
    public void printTests() {
        Main.print("Testing interfaces");
    }

    @Override
    public String getName() {
        return "mawborn";
    }

    @Override
    public void printPrice(float price) {
        Main.print("$" + String.valueOf(price));
    }
}
