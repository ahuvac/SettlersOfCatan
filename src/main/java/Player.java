import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int settlements;
    private int cities;
    private int roads;
    private int score;
    private List<DevelopmentCard> developmentCards;
    private Wallet wallet;
    private int consecutiveRoads;
    private int numKnights;
    Color color;
    private boolean largestArmy;
    private boolean longestRoad;
<<<<<<< HEAD
    List<Edge> ownedRoads;

    public Player(Color color, String name)
    {
=======
    private List<Edge> edges;

    //public Player(Color color, String name)
    public Player(Color color) {
>>>>>>> 4678a1bcd084aaccfa543f0be9c492be043929aa
        this.color = color;
        wallet = new Wallet();
        developmentCards = new ArrayList<>();
        cities = 4;
        settlements = 5;
        roads = 15;
        score = 0;
        consecutiveRoads = 0;
        largestArmy = false;
        longestRoad = false;
        this.name = name;
<<<<<<< HEAD
        ownedRoads = new ArrayList<>();
=======
        edges = new ArrayList<>();
    }

    public void decrementSettlements() {
        settlements--;
    }

    public void decrementRoads() {
        roads--;
>>>>>>> 4678a1bcd084aaccfa543f0be9c492be043929aa
    }

    public int getRoads() {
        return roads;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean hasMoreRoads() {
        return roads > 0;
    }

    public void largestArmy(boolean on) {
        largestArmy = on;
    }

    public void incrementScore() {
        ++score;
    }

    public boolean hasMoreSettlements() {
        return settlements != 0 && settlements > 0;
    }

    public boolean hasBuiltSettlements() {
        return settlements != 5;
    }

    public boolean hasMoreCities() {
        return cities != 0 && cities > 0;
    }

    public boolean hasCard(ResourceType type, int number) {
        return wallet.hasCard(type, number);
    }

    public void useCard(ResourceType type) {
        wallet.useCard(type);
    }

    public int getScore() {
        return this.score;
    }

    public void addCard(ResourceType type, int number) {
        wallet.addCard(type, number);
    }

    public void buyDevelopmentCard(DevelopmentCard card) {
        useCard(ResourceType.WOOL);
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.ORE);
        developmentCards.add(card);
    }

    public void addKnight() {
        numKnights++;
    }

    public int getKnight() {
        return numKnights;
    }

<<<<<<< HEAD
    //TODO: Specify location
    public void buildRoad(Edge edge){
        useCard(ResourceType.BRICK);
        useCard(ResourceType.LUMBER);
        consecutiveRoads++;
        roads--;
        ownedRoads.add(edge);
    }

    //TODO: Specify location
    public void buildSettlement(){
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.WOOL);
        useCard(ResourceType.LUMBER);
        useCard(ResourceType.BRICK);
=======

    public boolean buildRoad(Edge edge) {
        if (wallet.hasCard(ResourceType.BRICK, 1) && wallet.hasCard(ResourceType.LUMBER, 1)) {
            useCard(ResourceType.BRICK);
            useCard(ResourceType.LUMBER);
            edges.add(edge);
            --roads;
            return true;
        }
        return false;
    }


    public boolean buildSettlement() {
        if(wallet.hasCard(ResourceType.GRAIN,1) &&
        wallet.hasCard(ResourceType.WOOL,1) &&
        wallet.hasCard(ResourceType.LUMBER,1) &&
        wallet.hasCard(ResourceType.BRICK,1)) {
            useCard(ResourceType.GRAIN);
            useCard(ResourceType.WOOL);
            useCard(ResourceType.LUMBER);
            useCard(ResourceType.BRICK);
>>>>>>> 4678a1bcd084aaccfa543f0be9c492be043929aa
            score++;
            settlements--;
            return true;
        }
        return false;
    }

    public boolean buildCity() {
        if(wallet.hasCard(ResourceType.ORE,3) &&
                wallet.hasCard(ResourceType.GRAIN,2)) {
            useCard(ResourceType.ORE);
            useCard(ResourceType.ORE);
            useCard(ResourceType.ORE);
            useCard(ResourceType.GRAIN);
            useCard(ResourceType.GRAIN);

            score += 2;
            cities--;
            settlements++;

            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public List<Edge> getRoads(){
        return this.ownedRoads;
=======
    public boolean hasDevelopmentCard(DevelopmentCard card) {
        return developmentCards.contains(card);
    }

    public boolean hasDevelopmentCard()
    {
        if(developmentCards.size() > 0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public List<DevelopmentCard> getDevelopmentCards()
    {
        return developmentCards;
    }

    public void useDevelopmentCard(DevelopmentCard card) {
        developmentCards.remove(card);
    }

    public ResourceType getRandomCard() {
        return wallet.getRandomCard();
    }

    public int getTotalCards() {
        return wallet.getTotalCards();
>>>>>>> 4678a1bcd084aaccfa543f0be9c492be043929aa
    }

    public int getCardAmount(ResourceType type)
    {
        return wallet.getCardAmount(type);
    }

    public int getDevCardAmount()
    {
        return developmentCards.size();
    }

    @Override
    public String toString()
    {
        return this.color.toString();
    }


}
