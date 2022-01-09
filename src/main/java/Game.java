import java.util.List;

public class Game {
    private List<Player> players;
    private Die[] dice;
    private Board board;
    private Bank bank;

    public DevelopmentCard buyDevelopmentCard(Player player)
    {
        if (player.hasCard(ResourceType.WOOL, 1) &&
                player.hasCard(ResourceType.GRAIN, 1) &&
                player.hasCard(ResourceType.ORE, 1) &&
                bank.hasDevelopmentCard())
        {
            player.useCard(ResourceType.WOOL);
            player.useCard(ResourceType.GRAIN);
            player.useCard(ResourceType.ORE);
            bank.addResourceCard(ResourceType.WOOL);
            bank.addResourceCard(ResourceType.GRAIN);
            bank.addResourceCard(ResourceType.ORE);
            return bank.getDevelopmentCard();
        }
        else
        {
            return null;
        }
    }
}
