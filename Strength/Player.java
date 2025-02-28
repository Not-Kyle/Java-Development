public class Player {
    private String playerName;
    private int age;
    private int health;
    private int strength;

    public Player(String playerName, int age, int health, int strength) {
        this.playerName = playerName;
        this.age = age;
        this.health = health;
        this.strength = strength;
    }

    public double bodyStrength() {
        return this.strength * (1.0 - (this.age - 30) * 0.001);
    }

    public double bodyHealth() {
        return this.health * (1.0 - (this.age - 30) * 0.001);
    }

    @Override
    public String toString() {
        return "Player: " + playerName + "\nAge: " + age + "\nHealth: " + this.bodyHealth() + "\nStrength: " + this.bodyStrength();
    }
}
