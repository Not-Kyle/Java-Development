public class Clock {
    private int value;
    private int limit;

    public Clock(int limit) {
        this.limit = limit;
        this.value = 0;
    }

    public void increment() {
        this.value++;

        if (this.value >= this.limit) {
            this.value = 0;
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        if (this.value < 10) {
            return "0" + this.value;
        }

        return "" + this.value;
    }
}
