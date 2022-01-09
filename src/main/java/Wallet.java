import java.util.*;

public class Wallet {

    private Map<ResourceType, Integer> cards = new HashMap<>();

    public Wallet() {
        cards.put(ResourceType.BRICK, 0);
        cards.put(ResourceType.GRAIN, 0);
        cards.put(ResourceType.ORE, 0);
        cards.put(ResourceType.LUMBER, 0);
        cards.put(ResourceType.ROBBER, 0);
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
    public void addCard(ResourceType card) {
        int amount = cards.get(card);
        cards.put(card, amount++);
    }

    // takes a list of cards the player wants to use and checks if the user has those cards in his wallet
    // returns true if he has the cards and removes them from wallet and returns them to the bank
    public boolean useCards(Map<ResourceType, Integer> payment) {
        for (Map.Entry<ResourceType, Integer> entry : payment.entrySet()) {
            ResourceType cardType = entry.getKey();
            if (!cards.containsKey(cardType) || payment.get(cardType) > cards.get(cardType)) {
                return false;
            }
            else{
                int num = cards.get(cardType);
                cards.put(cardType, num--);
                //bank.return(cardType);
            }
        }
        return true;
    }
}
