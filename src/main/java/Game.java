import java.util.List;

public class Game {
    private List<Player> players;
    private Die[] dice;
    private Board board;
    private Bank bank;
    private Player currentTurn;


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


    public boolean buyRoad(Player player, Location location)
    {
        if (player.hasCard(ResourceType.BRICK, 1) &&
                player.hasCard(ResourceType.LUMBER, 1) &&
        player.hasSpareRoads())
        {
            if (checkRoadLocation(player, location)) {
                bank.addResourceCard(ResourceType.LUMBER);
                bank.addResourceCard(ResourceType.BRICK);
                player.buildRoad();
                return true;
            }
            else
            {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean checkRoadLocation(Player player, Location location)
    {
        Edge edge = board.edges[location.row][location.col];
        if (edge.hasRoad())
        {
            return false;
        }
        else
        {
            List<Vertex> vertices = edge.getVertices();
            for (Vertex vertex : vertices)
            {
                if (hasCityOrSettlementSameColor(player.color, vertex))
                {
                    edge.buildRoad(new Road(player.color));
                    return true;
                }
                else
                {
                    List<Edge> edges = vertex.getEdges();
                    for (Edge connectingEdge : edges)
                    {
                        if (connectingEdge.hasRoad() && connectingEdge.getRoadColor() == player.color)
                        {
                            edge.buildRoad(new Road(player.color));
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean hasCityOrSettlementSameColor(Color color, Vertex vertex)
    {
        if (vertex.hasCity() && vertex.getCityColor() == color)
        {
            return true;
        }
        else if (vertex.hasSettlement() && vertex.getSettlementColor() == color)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean buySettlement(Player player, Location location)
    {
        if (player.hasCard(ResourceType.LUMBER, 1) &&
                player.hasCard(ResourceType.BRICK, 1) &&
                player.hasCard(ResourceType.WOOL, 1) &&
                player.hasCard(ResourceType.GRAIN, 1) &&
        player.hasSpareSettlements())
        {
            if (checkSettlementLocation(player.color, location)) {
                bank.addResourceCard(ResourceType.WOOL);
                bank.addResourceCard(ResourceType.GRAIN);
                bank.addResourceCard(ResourceType.LUMBER);
                bank.addResourceCard(ResourceType.BRICK);
                player.buildSettlement();
                return true;
            }
        }
        return false;

    }

    public boolean checkSettlementLocation(Color color, Location location)
    {
        Vertex vertex = board.vertices[location.row][location.col];
        if (vertex.hasCity() || vertex.hasSettlement())
        {
            return false;
        }
        List<Edge> edges = vertex.getEdges();
        boolean connectingRoad = false;
        for (Edge edge : edges)
        {
            if (edge.hasRoad() && edge.getRoadColor() == color)
            {
                connectingRoad = false;
            }
            List<Vertex> borderingVertices = edge.getVertices();
            for (Vertex borderingVertex : borderingVertices)
            {
                if (borderingVertex.hasSettlement() || borderingVertex.hasCity())
                {
                    return false;
                }
            }

        }
        if (connectingRoad)
        {
            vertex.buildSettlement(new Settlement(color));
            return true;
        }
        return false;
    }

    public boolean buyCity(Player player, Location location)
    {
        Vertex vertex = board.vertices[location.row][location.col];
        if (player.hasCard(ResourceType.ORE, 3) &&
                player.hasCard(ResourceType.GRAIN, 2) &&
            player.hasSpareCities())
        {
            if (vertex.hasSettlement() && vertex.getSettlementColor() == player.color)
            {
                player.buildCity();
                bank.addResourceCard(ResourceType.ORE);
                bank.addResourceCard(ResourceType.ORE);
                bank.addResourceCard(ResourceType.ORE);
                bank.addResourceCard(ResourceType.GRAIN);
                bank.addResourceCard(ResourceType.GRAIN);
                return true;
            }

        }
        return false;
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
        List<Location> hexes = board.getHexesWithNumber(diceNumber);
        for (Location location : hexes) {
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
