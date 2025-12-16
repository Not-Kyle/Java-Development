import java.util.ArrayList;

public class Stack extends Main {
    private ArrayList<String> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void add(String addStack) {
        this.stack.add(addStack);
    }

    public String take() {
        if (this.stack.isEmpty()) {
            throw new IllegalArgumentException("Empty CallStack");
        }

        return this.stack.remove(this.stack.size() - 1);

        /*
            arraylist.add(value) = Push
            arraylist.remove(value) = Pop
            arraylist.get(size - 1) = Peek
        */

        // ArrayList.remove will remove the object and returns the object that was removed
    }

    public ArrayList<String> values() {
        return this.stack;
    }
}
