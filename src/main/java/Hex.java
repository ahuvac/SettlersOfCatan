import java.util.ArrayList;
import java.util.List;

public class Hex {
    ResourceType type;
    List<Hex> neighbors;
    boolean hasRobber = false;
    int number;


    public Hex(ResourceType type) {
        this.type = type;
        this.neighbors = new ArrayList();
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

}
