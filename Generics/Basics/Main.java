public class Main {
    public static void main(String[] arg) {
        Float[] floats = {4.5f, 3.5f, 2.5f, 1.5f, 0.5f};
        Integer[] ints = {4, 3, 2, 1, 0};

        displayArray(floats);
        displayArray(ints);
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static <T> void displayArray(T[] array) {
        for (T index : array) {
            Main.print(String.valueOf(index));
        }
    }
}

// T can be named anything, its like for _, Index in next Table do print(Index) end (How Index can be named anything)
