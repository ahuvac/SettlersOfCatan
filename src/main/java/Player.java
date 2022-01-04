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
        List<ResourceType> cardList = new ArrayList<>();
        cardList.add(ResourceType.LUMBER);
        cardList.add(ResourceType.BRICK);
        if(wallet.useCards(cardList)){
            numRoads++;
            roads--;
        }
        else{
          // try again
        }

    }

    public void buildSettlement(){
        wallet.useCard(ResourceType.LUMBER, 1);
        wallet.useCard(ResourceType.WOOL, 1);
        wallet.useCard(ResourceType.GRAIN, 1);
        wallet.useCard(ResourceType.BRICK, 1);
        score++;
        settlements--;
    }

    public void buildCity(){
        wallet.useCard(ResourceType.ORE, 3);
        wallet.useCard(ResourceType.GRAIN, 2);

        score+=2;
        cities--;
        settlements++;
    }

    public void buyDevelopmentCard(){
        wallet.useCard(ResourceType.GRAIN, 1);
        wallet.useCard(ResourceType.ORE, 1);
        wallet.useCard(ResourceType.WOOL, 1);
        developmentCards.add(new DevelopmentCard());
    }
}
