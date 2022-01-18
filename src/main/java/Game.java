import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players;
    private Die[] dice;
    private Board board;
    private Bank bank;
    private boolean rolled = false;
    private int largestArmy;
    private Player currentPlayer;

    //    public Game(List<String> names){
    public Game() {
        players = new ArrayList<>();
        players.add(new Player(Color.values()[new Random().nextInt(Color.values().length)]));
        Color nextColor = Color.values()[new Random().nextInt(Color.values().length)];
        while (nextColor == players.get(0).color) {
            nextColor = Color.values()[new Random().nextInt(Color.values().length)];
        }
        players.add(new Player(nextColor));
//        for(int i = 0; i < players.size(); i++){
//            players.add(new Player(Color.values()[new Random().nextInt(Color.values().length)], names.get(i)));
//        }
        dice = new Die[2];
        dice[0] = new Die();
        dice[1] = new Die();
        board = new Board();
        bank = new Bank();
        largestArmy = 0;
        currentPlayer = players.get(0);

        for(Player player: players){
            giveCards(ResourceType.LUMBER, 4, player);
            giveCards(ResourceType.BRICK, 4, player);
            giveCards(ResourceType.WOOL, 2, player);
            giveCards(ResourceType.GRAIN, 2, player);
        }
    }

    public boolean isRolled() {
        return rolled;
    }

    public void setRolled(boolean rolled) {
        this.rolled = rolled;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean connected(Location edgeLocation, Location vertexLocation)
    {
        Edge edge = board.edges[edgeLocation.row][edgeLocation.col];
        Vertex vertex = board.vertices[vertexLocation.row][vertexLocation.col];
        List<Vertex> vertices = edge.getVertices();
        if (vertices.contains(vertex))
        {
            return true;
        }
        return false;
    }

    public DevelopmentCard buyDevelopmentCard() {
        if (currentPlayer.hasCard(ResourceType.WOOL, 1) &&
                currentPlayer.hasCard(ResourceType.GRAIN, 1) &&
                currentPlayer.hasCard(ResourceType.ORE, 1) &&
                bank.hasDevelopmentCard()) {

            bank.addResourceCard(ResourceType.WOOL);
            bank.addResourceCard(ResourceType.GRAIN);
            bank.addResourceCard(ResourceType.ORE);
            DevelopmentCard card = bank.getDevelopmentCard();
            currentPlayer.buyDevelopmentCard(card);
            if (card.equals(DevelopmentCard.KNIGHT)) {
                currentPlayer.addKnight();
            }
            if (currentPlayer.getKnight() >= 3 && currentPlayer.getKnight() > largestArmy) {
                largestArmy = currentPlayer.getKnight();
                for (Player p : players) p.largestArmy(false);
                currentPlayer.largestArmy(true);

            }
            if (card.equals(DevelopmentCard.VICTORY_POINTS)) {
                currentPlayer.incrementScore();
            }

            return card;
        } else {
            return null;
        }
    }

//    public void gameBeginning() {
//        List<Player> playerOrder = new ArrayList<>();
//        int[] rolledNumbers = new int[players.size()];
////        for (int i = 0; i < players.size(); i++) {
////            int rolledNumber = 0;
////            for (Die die : dice) {
////                rolledNumber += die.roll();
////            }
////            rolledNumbers[i] = rolledNumber;
////        }
//        // TODO add roll dice to choose player order
//        for (int i = 0; i < playerOrder.size(); i++) {
//            playerOrder.add(players.get(addToPlayerOrder(rolledNumbers)));
//        }
//        for (Player player : playerOrder) {
//            boolean allowed = false;
//            while (!allowed) {
//                Location vertexLocation = chooseSettlementLocation();
//                Location roadLocation = chooseRoadLocation();
//                Vertex vertex = board.vertices[vertexLocation.row][vertexLocation.col];
//                if (checkSettlementLocation(player.color, vertexLocation, true)) {
//                    allowed = true;
//                    player.decrementSettlements();
//                    Edge edge = board.edges[roadLocation.row][roadLocation.col];
//                    edge.buildRoad(new Road(player.color));
//                    player.decrementRoads();
//                }
//            }
//        }
//        for (int i = players.size() - 1; i >= 0; i--) {
//            Player player = playerOrder.get(i);
//            boolean allowed = false;
//            while (!allowed) {
//                Location vertexLocation = chooseSettlementLocation();
//                Location roadLocation = chooseRoadLocation();
//                Vertex vertex = board.vertices[vertexLocation.row][vertexLocation.col];
//                if (checkSettlementLocation(player.color, vertexLocation, true)) {
//                    List<Hex> hexes = vertex.getHexes();
//                    for (Hex hex : hexes) {
//                        if (hex.type != ResourceType.DESERT) {
//                            player.addCard(hex.type, 1);
//                        }
//                    }
//                    allowed = true;
//                    player.decrementSettlements();
//                    Edge edge = board.edges[roadLocation.row][roadLocation.col];
//                    edge.buildRoad(new Road(player.color));
//                    player.decrementRoads();
//                }
//            }
//        }
//    }

    public List<Hex> getHexes() {
        return board.getHexesAsList();
    }


    private int addToPlayerOrder(int[] rolledNumbers) {
        int highest = 0;
        int index = 0;
        for (int i = 0; i < rolledNumbers.length; i++) {
            if (rolledNumbers[i] > highest) {
                highest = rolledNumbers[i];
                index = i;
            }
        }
        rolledNumbers[index] = 0;
        return index;
    }

    public void switchPlayer() {
        currentPlayer = getOtherPlayer();
        rolled = false;
    }

    public Player getOtherPlayer() {
        int index = players.indexOf(currentPlayer);
        if (++index == players.size()) {
            index = 0;
        }
        return players.get(index);
    }

    public boolean buyRoad(Location location) {
        if (currentPlayer.hasCard(ResourceType.BRICK, 1) &&
                currentPlayer.hasCard(ResourceType.LUMBER, 1) &&
                currentPlayer.hasMoreRoads()) {
            if (checkRoadLocation(location)) {
                bank.addResourceCard(ResourceType.LUMBER);
                bank.addResourceCard(ResourceType.BRICK);
                currentPlayer.buildRoad();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean checkRoadLocation(Location location) {
        Edge edge = board.edges[location.row][location.col];
        if (!edge.hasRoad()) {
            List<Vertex> vertices = edge.getVertices();
            for (Vertex vertex : vertices) {
                if (hasCityOrSettlementSameColor(currentPlayer.color, vertex)) {
                    edge.buildRoad(new Road(currentPlayer.color));
                    return true;
                } else {
                    List<Edge> edges = vertex.getEdges();
                    for (Edge connectingEdge : edges) {
                        if (connectingEdge.hasRoad() && connectingEdge.getRoadColor() == currentPlayer.color) {
                            edge.buildRoad(new Road(currentPlayer.color));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean hasCityOrSettlementSameColor(Color color, Vertex vertex) {
        if (vertex.hasCity() && vertex.getCityColor() == color) {
            return true;
        } else if (vertex.hasSettlement() && vertex.getSettlementColor() == color) {
            return true;
        } else {
            return false;
        }
    }


    public boolean buySettlement(Location location, boolean preGame) {
        if (preGame || (currentPlayer.hasCard(ResourceType.LUMBER, 1) &&
                currentPlayer.hasCard(ResourceType.BRICK, 1) &&
                currentPlayer.hasCard(ResourceType.WOOL, 1) &&
                currentPlayer.hasCard(ResourceType.GRAIN, 1) &&
                currentPlayer.hasMoreSettlements())) {
            if (checkSettlementLocation(currentPlayer.color, location, preGame)) {
                bank.addResourceCard(ResourceType.WOOL);
                bank.addResourceCard(ResourceType.GRAIN);
                bank.addResourceCard(ResourceType.LUMBER);
                bank.addResourceCard(ResourceType.BRICK);
                currentPlayer.buildSettlement();
                return true;
            }
        }
        return false;
    }

    public boolean checkSettlementLocation(Color color, Location location, boolean firstSettlement) {
        Vertex vertex = board.vertices[location.row][location.col];
        if (vertex.hasCity() || vertex.hasSettlement()) {
            return false;
        }
        List<Edge> edges = vertex.getEdges();
        boolean connectingRoad = false;
        for (Edge edge : edges) {
            if (edge.hasRoad() && edge.getRoadColor() == color) {
                connectingRoad = true;
            }
            List<Vertex> borderingVertices = edge.getVertices();
            for (Vertex borderingVertex : borderingVertices) {
                if (borderingVertex.hasSettlement() || borderingVertex.hasCity()) {
                    return false;
                }
            }

        }
        if (connectingRoad || firstSettlement) {
            vertex.buildSettlement(new Settlement(color));
            return true;
        }
        return false;
    }

    public boolean buyCity(Location location) {
        Vertex vertex = board.vertices[location.row][location.col];
        if (currentPlayer.hasCard(ResourceType.ORE, 3) &&
                currentPlayer.hasCard(ResourceType.GRAIN, 2) &&
                currentPlayer.hasMoreCities()) {
            if (vertex.hasSettlement() && vertex.getSettlementColor() == currentPlayer.color) {
                currentPlayer.buildCity();
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

    public void distributeCards(int roll) {
        List<Location> hexes = board.getHexesWithNumber(roll);
        for (Location location : hexes) {
            if (board.hexes[location.row][location.col].hasRobber) {
                continue;
            }
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

    public int[] rollDice() {
        int[] rolledNumbers = new int[2];
        int diceNumber = 0;
        for (int i = 0; i < dice.length; i++) {
            int rolled = dice[i].roll();
            diceNumber += rolled;
            rolledNumbers[i] = rolled;
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
        } else
            return null;
    }

    public void playRobber(Location location) {
        for (Player player : players) {
            if (player.getTotalCards() > 7) {
                int totalCards = player.getTotalCards();
                int half = totalCards / 2;
                for (int i = 0; i < half; i++) {
                    bank.addResourceCard(player.getRandomCard());
                }
            }
        }
        moveRobber(location, getOtherPlayer());
    }

    public void moveRobber(Location location, Player player) {
        Location hexLocation = board.findRobber();
        Hex hex = board.hexes[hexLocation.row][hexLocation.col];
        hex.hasRobber = false;
        List<Vertex> vertices = board.getVertices(location);
        boolean canTake = false;
        for (Vertex vertex : vertices) {
            if (hasCityOrSettlementSameColor(player.color, vertex)) {
                canTake = true;
                break;
            }
        }
        if (canTake) {
            ResourceType cardTaken = player.getRandomCard();
            if (cardTaken != null)
                currentPlayer.addCard(cardTaken, 1);
        }
        board.hexes[location.row][location.col].hasRobber = true;
    }

    public void playYearOfPlenty(ResourceType type1, ResourceType type2) {

        if (currentPlayer.hasDevelopmentCard(DevelopmentCard.YEAR_OF_PLENTY)) {
            currentPlayer.useDevelopmentCard(DevelopmentCard.YEAR_OF_PLENTY);
            if (bank.hasResourceCard(type1, 1)) {
                bank.getResourceCard(type1);
                currentPlayer.addCard(type1, 1);
            }
            if (bank.hasResourceCard(type2, 1)) {
                bank.getResourceCard(type2);
                currentPlayer.addCard(type2, 1);
            }
        }
    }

    public void playMonopoly(ResourceType type) {
        if (currentPlayer.hasDevelopmentCard(DevelopmentCard.MONOPOLY)) {
            for (Player player : players) {
                if (player != currentPlayer) {
                    while (player.hasCard(type, 1)) {
                        player.useCard(type);
                        currentPlayer.addCard(type, 1);
                    }
                }
            }
        }
    }

    public void playRoadBuilding(Location location1, Location location2) {
        if (currentPlayer.hasDevelopmentCard(DevelopmentCard.ROAD_BUILDING)) {
            if (checkRoadLocation(location1)) {
                Edge edge = board.edges[location1.row][location1.col];
                edge.buildRoad(new Road(currentPlayer.color));
                currentPlayer.decrementRoads();
            }
            if (checkRoadLocation(location2)) {
                Edge edge = board.edges[location2.row][location2.col];
                edge.buildRoad(new Road(currentPlayer.color));
                currentPlayer.decrementRoads();
            }
        }
    }

    public void playKnight(Location location, Player player) {
        if (currentPlayer.hasDevelopmentCard(DevelopmentCard.KNIGHT)) {
            moveRobber(location, player);
        }
    }

    public void giveCards(ResourceType type, int amount, Player player){
        for (int i = 0; i < amount ; i++) {
            bank.getResourceCard(type);
        }
        player.addCard(type,amount);
    }
}
