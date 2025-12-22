public class Main {
    public static void main(String[] arg) {
        Float[] floats = {4.5f, 3.5f, 2.5f, 1.5f, 0.5f};
        Integer[] ints = {4, 3, 2, 1, 0};

        displayArray(floats);
        displayArray(ints);

        Main.print("");
        Main.print(indexFirst(floats));
        Main.print(indexFirst(ints));
    }

    public static <Index> void print(Index message) {
        System.out.println(message);
    }

    public static <T> void displayArray(T[] array) {
        for (T index : array) {
            Main.print(index);
        }
    }

    public static <T> T indexFirst(T[] array) {
        return array[0];
    }
}
