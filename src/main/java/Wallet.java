import java.util.*;

public class Wallet {

    private Map<ResourceType, Integer> cards = new HashMap<>();

    public Wallet() {
        cards.put(ResourceType.BRICK, 0);
        cards.put(ResourceType.GRAIN, 0);
        cards.put(ResourceType.ORE, 0);
        cards.put(ResourceType.LUMBER, 0);
        cards.put(ResourceType.WOOL, 0);
    }

    public boolean hasCard(ResourceType type, int number)
    {
        int numberOfCards = cards.get(type);
        cards.put(type, numberOfCards);
        if (number > numberOfCards)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void useCard(ResourceType type)
    {
        int numberOfCards = cards.get(type);
        cards.put(type, --numberOfCards);
    }

    // adds a card to the wallet
    public void addCard(ResourceType card, int number) {
        int amount = cards.get(card);
        cards.put(card, amount+=number);
    }

}
