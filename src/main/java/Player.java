import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {
    Random random = new Random();
    private String name;
    private int positionV = random.nextInt(10);
    private int positionH = random.nextInt(10);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionV() {
        return positionV;
    }

    public void setPositionV(int positionV) {
        this.positionV = positionV;
    }

    public int getPositionH() {
        return positionH;
    }

    public void setPositionH(int positionH) {
        this.positionH = positionH;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", positionV=" + positionV +
                ", positionH=" + positionH +
                '}';
    }
}
