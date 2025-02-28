public class ClockInt {
    private Clock hours;
    private Clock minutes;
    private Clock seconds;

    public ClockInt() {
        this.hours = new Clock(24);
        this.minutes = new Clock(60);
        this.seconds = new Clock(60);
    }

    public void advance() {
        seconds.increment();

        if (seconds.getValue() == 0) {
            minutes.increment();

            if (minutes.getValue() == 0) {
                hours.increment();
            }
        }
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
