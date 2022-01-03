import java.util.ArrayList;
import java.util.List;

public class Player {
    private int settlements;
    private int cities;
    private int roads;
    private int score;
    private List<DevelopmentCard> developmentCards;
    private Wallet wallet;
    int numRoads;

    public Player()
    {
        wallet = new Wallet();
        developmentCards = new ArrayList<>();
        cities = 4;
        settlements = 5;
        roads = 15;
        score = 0;
        numRoads = 0;
    }

    public void buildRoad(){
        roads--;
        wallet.useCard(ResourceType.LUMBER);
        wallet.useCard(ResourceType.BRICK);
        numRoads++;
    }

    public void buildSettlement(){
        settlements--;
        wallet.useCard(ResourceType.LUMBER);
        wallet.useCard(ResourceType.WOOL);
        wallet.useCard(ResourceType.GRAIN);
        wallet.useCard(ResourceType.BRICK);
        score++;
    }

    public void buildCity(){
        cities--;
        settlements++;
        wallet.useCard(ResourceType.ORE);
        wallet.useCard(ResourceType.ORE);
        wallet.useCard(ResourceType.ORE);
        wallet.useCard(ResourceType.GRAIN);
        wallet.useCard(ResourceType.GRAIN);
        score+=2;
    }

    public void buyDevelopmentCard(){
        wallet.useCard(ResourceType.GRAIN);
        wallet.useCard(ResourceType.ORE);
        wallet.useCard(ResourceType.WOOL);
    }
}
