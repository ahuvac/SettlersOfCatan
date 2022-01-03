import java.util.ArrayList;
import java.util.List;

public class Player {
    private int settlements;
    private int cities;
    private int roads;
    private int score;
    private List<ResourceCard> wallet;
    private List<DevelopmentCard> developmentCards;

    public Player()
    {
        wallet = new ArrayList<>();
        developmentCards = new ArrayList<>();
        cities = 4;
        settlements = 5;
        roads = 15;
        score = 0;
    }

}
