import java.util.*;

public class Bank {
    private Map<ResourceType, Integer> resourceCards;
    private List<DevelopmentCard> developmentCards;

    public Bank()
    {
        resourceCards = new HashMap<>();
        int numberOfCards = 19;
        ResourceType[] typesOfCards = {ResourceType.BRICK, ResourceType.GRAIN, ResourceType.LUMBER, ResourceType.ORE, ResourceType.WOOL};
        for (ResourceType type : typesOfCards)
        {
            resourceCards.put(type, numberOfCards);
        }
        developmentCards = new ArrayList<DevelopmentCard>();
        for (int i = 0; i < 14; i++)
        {
            developmentCards.add(DevelopmentCard.KNIGHT);
        }
        for (int i =0; i < 5; i++)
        {
            developmentCards.add(DevelopmentCard.VICTORY_POINTS);
        }
        for (int i = 0; i < 2; i++) {
            developmentCards.add(DevelopmentCard.MONOPOLY);
            developmentCards.add(DevelopmentCard.YEAR_OF_PLENTY);
            developmentCards.add(DevelopmentCard.ROAD_BUILDING);
        }
        Collections.shuffle(developmentCards);
    }

    public boolean hasResourceCard(ResourceType type, int number)
    {
        int numberOfCards = resourceCards.get(type);
        resourceCards.put(type, numberOfCards);
        if (number > numberOfCards)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean hasDevelopmentCard()
    {
        return developmentCards.size() > 0;
    }

    /**
     * This method takes a resource type and returns true if there is that card in the bank and false if there are
     * none in the bank
     * it also decrements that amount in the bank if true is returned
     */
    public boolean getResourceCard(ResourceType type)
    {
        if (type == ResourceType.DESERT)
        {
            return false;
        }
        int old = resourceCards.get(type);
        if (old == 0)
        {
            return false;
        }
        resourceCards.put(type, --old);
        return true;
    }


    /**
     * This method takes a resource type and adds it to those stored in the bank
     * @param type resource type
     */
    public void addResourceCard(ResourceType type)
    {
        if (type != ResourceType.DESERT)
        {
            int old = resourceCards.get(type);
            resourceCards.put(type, ++old);
        }
    }

    /**
     * This method returns a random development card from the bank
     * if there are no more development cards in the bank, it returns null
     * @return development card or null
     */
    public DevelopmentCard getDevelopmentCard()
    {
        if (developmentCards.size() > 0) {
            return developmentCards.get(0);
        }
        else
        {
            return null;
        }
    }
}
