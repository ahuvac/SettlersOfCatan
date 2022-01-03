import java.util.*;

public class Bank {
    private Map<ResourceType, Integer> resourceCards;
    private List<DevelopmentCard> developmentCards;

    public Bank()
    {
        resourceCards = new HashMap<>();
        int numberOfCards = 19;
        ResourceType[] typesOfCards = {ResourceType.BRICK, ResourceType.GRAIN, ResourceType.LUMBER, ResourceType.ORE, ResourceType.ORE};
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

    public ResourceCard getResourceCard(ResourceType type)
    {
        int old = resourceCards.get(type);
        resourceCards.put(type, --old);
        return new ResourceCard(type);
    }

    public void addResourceCard(ResourceType type)
    {
        int old = resourceCards.get(type);
        resourceCards.put(type, ++old);
    }

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
