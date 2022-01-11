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

            bank.addResourceCard(ResourceType.WOOL);
            bank.addResourceCard(ResourceType.GRAIN);
            bank.addResourceCard(ResourceType.ORE);
            DevelopmentCard card = bank.getDevelopmentCard();
            player.buyDevelopmentCard(card);
            return card;
        }
        else
        {
            return null;
        }
    }

    //TODO: check that there is a location to put a road down
    public boolean buyRoad(Player player)
    {
        if (player.hasCard(ResourceType.BRICK, 1) &&
                player.hasCard(ResourceType.LUMBER, 1) &&
        player.hasSpareRoads())
        {
            bank.addResourceCard(ResourceType.LUMBER);
            bank.addResourceCard(ResourceType.BRICK);
            player.buildRoad();
            return true;
        }
        else {
            return false;
        }
    }

    //TODO: Check that there is a location to put a settlement
    public boolean buySettlement(Player player)
    {
        if (player.hasCard(ResourceType.LUMBER, 1) &&
                player.hasCard(ResourceType.BRICK, 1) &&
                player.hasCard(ResourceType.WOOL, 1) &&
                player.hasCard(ResourceType.GRAIN, 1) &&
        player.hasSpareSettlements())
        {
            bank.addResourceCard(ResourceType.WOOL);
            bank.addResourceCard(ResourceType.GRAIN);
            bank.addResourceCard(ResourceType.LUMBER);
            bank.addResourceCard(ResourceType.BRICK);
            player.buildSettlement();
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean buyCity(Player player)
    {
        if (player.hasCard(ResourceType.ORE, 3) &&
                player.hasCard(ResourceType.GRAIN, 2) &&
            player.hasBuiltSettlements() &&
            player.hasSpareCities())
        {
            player.buildCity();
            bank.addResourceCard(ResourceType.ORE);
            bank.addResourceCard(ResourceType.ORE);
            bank.addResourceCard(ResourceType.ORE);
            bank.addResourceCard(ResourceType.GRAIN);
            bank.addResourceCard(ResourceType.GRAIN);
            return true;
        }
        else
        {
            return false;
        }
    }

    public int[] rollDiceAndDistributeCards()
    {
        int[] rolledNumbers = new int[2];
        int diceNumber = 0;
        for (int i = 0; i < dice.length; i++)
        {
            int rolled = dice[i].roll();
            diceNumber += rolled;
            rolledNumbers[i] = rolled;
        }
        List<HexLocation> hexes = board.getHexesWithNumber(diceNumber);
        for (HexLocation location : hexes) {
            ResourceType resource = board.getResource(location);
            List<Vertex> vertices = board.getVertices(location);
            for (Vertex vertex: vertices) {
                if (vertex.hasCity())
                {
                    Color cityColor = vertex.getCityColor();
                    for (Player player : players)
                    {
                        if (player.color == cityColor)
                        {
                            player.addCard(resource, 2);
                            break;
                        }
                    }
                }
                else if (vertex.hasSettlement())
                {
                    Color settlementColor = vertex.getSettlementColor();
                    for (Player player : players)
                    {
                        if (player.color == settlementColor)
                        {
                            player.addCard(resource, 1);
                            break;
                        }
                    }
                }
            }
        }
        return rolledNumbers;
    }
}
