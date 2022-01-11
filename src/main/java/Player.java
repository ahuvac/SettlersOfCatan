import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int settlements;
    private int cities;
    private int roads;
    private int score;
    private List<DevelopmentCard> developmentCards;
    private Wallet wallet;
    int numRoads;
    Color color;

    public Player(Color color)
    {
        this.color = color;
        wallet = new Wallet();
        developmentCards = new ArrayList<>();
        cities = 4;
        settlements = 5;
        roads = 15;
        score = 0;
        numRoads = 0;
    }

    public boolean hasSpareRoads()
    {
        return roads != 0;
    }

    public boolean hasSpareSettlements()
    {
        return settlements != 0;
    }

    public boolean hasBuiltSettlements()
    {
        return settlements != 5;
    }

    public boolean hasSpareCities()
    {
        return cities != 0;
    }

    public boolean hasCard(ResourceType type, int number)
    {
        return wallet.hasCard(type, number);
    }

    public void useCard(ResourceType type)
    {
        wallet.useCard(type);
    }

    public void addCard(ResourceType type, int number) {wallet.addCard(type, number);}

    public void buyDevelopmentCard(DevelopmentCard card)
    {
        useCard(ResourceType.WOOL);
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.ORE);
        developmentCards.add(card);
    }

    //TODO: Specify location
    public void buildRoad(){
        useCard(ResourceType.BRICK);
        useCard(ResourceType.LUMBER);
            numRoads++;
            roads--;
    }

    //TODO: Specify location
    public void buildSettlement(){
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.WOOL);
        useCard(ResourceType.LUMBER);
        useCard(ResourceType.BRICK);
            score++;
            settlements--;
    }

    //TODO: Specify location
    public void buildCity(){
        useCard(ResourceType.ORE);
        useCard(ResourceType.ORE);
        useCard(ResourceType.ORE);
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.GRAIN);

            score+=2;
            cities--;
            settlements++;

    }


}
