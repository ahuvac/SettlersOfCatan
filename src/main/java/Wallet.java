import java.util.*;

public class Wallet {

    private Map<ResourceType, Integer> cards = new HashMap<>();;

    public Wallet(){
        cards.put(ResourceType.BRICK, 0);
        cards.put(ResourceType.DESERT, 0);
        cards.put(ResourceType.GRAIN, 0);
        cards.put(ResourceType.ORE, 0);
        cards.put(ResourceType.LUMBER, 0);
        cards.put(ResourceType.ROBBER, 0);
        cards.put(ResourceType.WOOL, 0);
    }

    public void addCard(ResourceType card){
        int old = cards.get(card);
        cards.put(card, old++);
    }

    public void useCard(ResourceType card){
        int old = cards.get(card);
        cards.put(card, old--);
    }
}
