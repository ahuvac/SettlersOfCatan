import java.util.ArrayList;
import java.util.List;

public class Hex {
    ResourceType type;
    List<Hex> neighbors;
    int position;


    public Hex(ResourceType type) {
        this.type = type;
        this.neighbors = new ArrayList();
//        this.position = position;
    }


    public void connect(){

    }

}
