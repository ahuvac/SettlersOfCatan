import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<ResourceCard, Integer> resourceCards;
    private Map<DevelopmentCard, Integer> developmentCards;

    public Bank()
    {
        resourceCards = new HashMap<>();
        int numberOfCards = 19;
        ResourceType[] typesOfCards = {ResourceType.BRICK, ResourceType.GRAIN, ResourceType.LUMBER, ResourceType.ORE, ResourceType.ORE};
        for (ResourceType type : typesOfCards)
        {
            resourceCards.put(new ResourceCard(type), 19);
        }
        developmentCards = new HashMap<>();
    }

}
