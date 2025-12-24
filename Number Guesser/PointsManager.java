import java.util.Random;

public class PointsManager {
    Random random = new Random();

    private int points = 0;
    private int highScore = 0;
    private int targetNumber = 1;

    public int getPoints() {
        return this.points;
    }

    public void setDefaultPoints() {
        this.points = 0;
    }

    public void setDefaultTargetNumber() {
        this.targetNumber = 1;
    }

    public void addHighScore() {
        this.highScore++;
    }

    public void addPoints(int add) {
        this.points += add;
    }

    public int getRandomValue(int value) {
        return this.random.nextInt(value + 1);
    }

    public int getTargetNumber() {
        return this.targetNumber;
    }

    public int getHighScore() {
        return this.highScore;
    }

    public void generateNextTarget() {
        this.targetNumber += 1;
    }
}
