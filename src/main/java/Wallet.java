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
        int amount = cards.get(card);
        cards.put(card, amount++);
    }

    public boolean useCards(List<ResourceType> cards){
        // check if has each card
//        if(cards.containsKey(card) && cards.get(card) == amount) {
//            int num = cards.get(card);
//            cards.put(card, num--);
//            return true;
//        }
//        else
            return false;
    }

//    public boolean contains(ResourceType type, int amount){
//        if(cards.containsKey(type) && cards.get(type) == amount) return true;
//        else return false;
//    }
}
