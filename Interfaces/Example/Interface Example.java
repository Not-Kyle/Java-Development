public interface Example {
    int age = 17;
    float settingPrice = 4.95f;

    String name = "mawborn"; // It's hidden but infront of this String is public static final so its actually written like (public static final String name = "mawborn")

    void printTests();
    void printPrice(float price);  // You can not declare a value through an interface

    String getName();

    default void writeExample() {
        Main.print("I can call methods from an interface");
    }

    // How can I give this method a body in an interface?
    // I can add a body to this method by using the default keyword, it allows me to add new methods
    // A class can override this method or use it
}

/*
Infront of every field, is (public static final)
What are fields? Fields are variables belonging to the class. Like age, settingPrice and name
*/
