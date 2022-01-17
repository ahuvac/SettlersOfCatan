import java.util.*;

public class Game {
    private List<Player> players;
    private Die[] dice;
    private Board board;
    private Bank bank;
    private int largestArmy;
    private Player currentPlayer;
    Map<Player, Integer> roadLengths = new HashMap<>();


    public Game(List<String> names){
        players = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            players.add(new Player(Color.values()[new Random().nextInt(Color.values().length)], names.get(i)));
        }
        dice = new Die[2];
        board = new Board();
        bank = new Bank();
        largestArmy = 0;
        currentPlayer = players.get(0);
        roadLengths.put(players.get(0), 0);
        roadLengths.put(players.get(1), 0);
    }

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
            if(card.equals(DevelopmentCard.KNIGHT)) player.addSoldier();
            if(player.getSoldiers() >= 3 && player.getSoldiers() > largestArmy){
                    largestArmy = player.getSoldiers();
                    for(Player p : players) p.largestArmy(false);
                    player.largestArmy(true);

                }
            if(card.equals(DevelopmentCard.VICTORY_POINTS)) player.incrementScore();

            return card;
        }
        else
        {
            return null;
        }
    }



    public void switchPlayer(){
        int index = players.indexOf(currentPlayer);
        currentPlayer =  players.get(index + 1);
        rollDiceAndDistributeCards();
    }

    //TODO: check that there is a location to put a road down
    public boolean buyRoad(Player player, Location location)

    {
        if (player.hasCard(ResourceType.BRICK, 1) &&
                player.hasCard(ResourceType.LUMBER, 1) &&
        player.hasSpareRoads())
        {
            if (checkRoadLocation(player, location)) {
                bank.addResourceCard(ResourceType.LUMBER);
                bank.addResourceCard(ResourceType.BRICK);
                player.buildRoad(board.edges[location.row][location.col]);
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
        if (!edge.hasRoad()) {
            List<Vertex> vertices = edge.getVertices();
            for (Vertex vertex : vertices) {
                if (hasCityOrSettlementSameColor(player.color, vertex)) {
                    edge.buildRoad(new Road(player.color));
                    return true;
                } else {
                    List<Edge> edges = vertex.getEdges();
                    for (Edge connectingEdge : edges) {
                        if (connectingEdge.hasRoad() && connectingEdge.getRoadColor() == player.color) {
                            edge.buildRoad(new Road(player.color));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
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

        if(diceNumber == 7){
            playRobber();
        }
        else {
            List<Location> hexes = board.getHexesWithNumber(diceNumber);
            for (Location location : hexes) {
                ResourceType resource = board.getResource(location);
                List<Vertex> vertices = board.getVertices(location);
                for (Vertex vertex : vertices) {
                    if (vertex.hasCity()) {
                        Color cityColor = vertex.getCityColor();
                        for (Player player : players) {
                            if (player.color == cityColor) {
                                player.addCard(resource, 2);
                                break;
                            }

                        }
                    } else if (vertex.hasSettlement()) {
                        Color settlementColor = vertex.getSettlementColor();
                        for (Player player : players) {
                            if (player.color == settlementColor) {
                                player.addCard(resource, 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return rolledNumbers;
    }

    public boolean over() {
        return winningPlayer() != null;
    }

    // if game is over, returns the winning player, otherwise returns null
    public Player winningPlayer() {
        Player winner = players.get(0);
        for (Player p : players) {
            if (p.getScore() > winner.getScore()) {
                winner = p;
            }
        }
        if (winner.getScore() >= 10) {
            return winner;
        }
        else
            return null;
    }

    public void playRobber(){
        // TODO add functionality for moving the robber when a seven is rolled
        // TODO includes:
        //              - halving anyones' cards over 7
        //              - moving the robber and blocking that hex
        //              - roller picks a card from someone

    }
}
