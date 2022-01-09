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
    protected Wallet wallet;
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

    public boolean buildRoad(){
        Map<ResourceType, Integer> cardList = new HashMap<>();
        cardList.put(ResourceType.LUMBER, 1);
        cardList.put(ResourceType.BRICK, 1);
        if(wallet.useCards(cardList)){
            numRoads++;
            roads--;
            return true;
        }
        else{
           return false;
        }

    }

    public boolean buildSettlement(){
        Map<ResourceType, Integer> cardList = new HashMap<>();
        cardList.put(ResourceType.WOOL, 1);
        cardList.put(ResourceType.GRAIN, 1);
        cardList.put(ResourceType.BRICK, 1);
        cardList.put(ResourceType.LUMBER, 1);

        if(wallet.useCards(cardList)) {
            score++;
            settlements--;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean buildCity(){
        Map<ResourceType, Integer> cardList = new HashMap<>();
        cardList.put(ResourceType.GRAIN, 2);
        cardList.put(ResourceType.ORE, 3);

        if(wallet.useCards(cardList)) {
            score+=2;
            cities--;
            settlements++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean buyDevelopmentCard(){
        Map<ResourceType, Integer> cardList = new HashMap<>();
        cardList.put(ResourceType.GRAIN, 1);
        cardList.put(ResourceType.ORE, 1);
        cardList.put(ResourceType.WOOL, 1);
        if(wallet.useCards(cardList)) {
            //developmentCards.add(new DevelopmentCard());
            return true;
        }
        else {
            return false;
        }
    }
}
