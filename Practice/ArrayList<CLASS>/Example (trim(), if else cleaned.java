import java.util.Objects;

public class Example extends Main {
    private short number;
    private String name;

    public Example(String user, short id) {
        this.name = (user == null || user.trim().isEmpty()) ? "Unknown" : user;
        // .trim() just erases spaces at the start and end, so if a string was " YES " using .trim() would do "YES"
        // this.name = Objects.requireNonNullElse(user, "Unknown"); ONLY RETURNS UNKNOWN IF USER IS NULL (examples.add(new Example(null, (short) 5));)

        if (id < 0) {
            throw new IllegalArgumentException("Numbers must be positive");
        }

        this.number = (id == 0) ? 1 : id; // This means, if (id == 0) { return 1 } else { return id }

        /*
            if (id == 1) {
                return 1
            } else {
                return id
            }
        */
    }

    public String getName() {
        return this.name;
    }

    public short getId() {
        return this.number;
    }
}
