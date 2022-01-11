import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private int settlements;
    private int cities;
    private int roads;
    private int score;
    private List<DevelopmentCard> developmentCards;
    protected Wallet wallet;
    private int consecutiveRoads;
    private int numSoldiers;
    Color color;
    private boolean largestArmy;
    private boolean longestRoad;
    List<Edge> ownedRoads;

    public Player(Color color, String name)
    {
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
        ownedRoads = new ArrayList<>();
    }

    public boolean hasSpareRoads()
    {
        return roads != 0;
    }

    public void largestArmy(boolean on){
        largestArmy = on;
    }

    public void incrementScore(){
        ++score;
    }

    public boolean hasSpareSettlements()
    {
        return settlements != 0;
    }

    public boolean hasBuiltSettlements()
    {
        return settlements != 5;
    }

    public boolean hasSpareCities()
    {
        return cities != 0;
    }

    public boolean hasCard(ResourceType type, int number)
    {
        return wallet.hasCard(type, number);
    }

    public void useCard(ResourceType type)
    {
        wallet.useCard(type);
    }
    public int getScore(){
        return this.score;
    }

    public void addCard(ResourceType type, int number) {wallet.addCard(type, number);}

    public void buyDevelopmentCard(DevelopmentCard card)
    {
        useCard(ResourceType.WOOL);
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.ORE);
        developmentCards.add(card);
    }

    public void addSoldier(){
        numSoldiers++;
    }
    public int getSoldiers(){
        return numSoldiers;
    }


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
            score++;
            settlements--;
    }

    public void buildCity() {
        useCard(ResourceType.ORE);
        useCard(ResourceType.ORE);
        useCard(ResourceType.ORE);
        useCard(ResourceType.GRAIN);
        useCard(ResourceType.GRAIN);

        score += 2;
        cities--;
        settlements++;
    }

    public List<Edge> getRoads(){
        return this.ownedRoads;
    }


}
