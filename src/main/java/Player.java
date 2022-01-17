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

    //public Player(Color color, String name)
    public Player(Color color) {
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
    }

    public void decrementSettlements() {
        settlements--;
    }

    public void decrementRoads() {
        roads--;
    }

    public int getRoads() {
        return roads;
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


    public boolean buildRoad() {
        if (wallet.hasCard(ResourceType.BRICK, 1) &&
                wallet.hasCard(ResourceType.LUMBER, 1)) {
            useCard(ResourceType.BRICK);
            useCard(ResourceType.LUMBER);
            //consecutiveRoads++; TODO: add logic here?
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

    public boolean hasDevelopmentCard(DevelopmentCard card) {
        return developmentCards.contains(card);
    }

    public void useDevelopmentCard(DevelopmentCard card) {
        developmentCards.remove(card);
    }

    public ResourceType getRandomCard() {
        return wallet.getRandomCard();
    }

    public int getTotalCards() {
        return wallet.getTotalCards();
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
