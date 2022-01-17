import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    //TODO Mocito to create mock dev card to see if it preforms correctly for each dev card
    @Test
    void buyDevelopmentCard() {

        Game game = new Game();

        Player player = game.getCurrentPlayer();

        player.addCard(ResourceType.WOOL,1);
        player.addCard(ResourceType.GRAIN,1);
        player.addCard(ResourceType.ORE,1);

        DevelopmentCard card = game.buyDevelopmentCard();

        assertNotNull(card);
    }

    //TODO write test
    @Test
    void gameBeginning() {
    }

    //TODO
    @Test
    void chooseSettlementLocation() {
    }

    //TODO
    @Test
    void chooseRoadLocation() {
    }

    @Test
    void addToPlayerOrder(){
    }

    @Test
    void switchPlayer() {
    }

    @Test
    void buyRoad() {
    }

    @Test
    void checkRoadLocation() {
    }

    @Test
    void hasCityOrSettlementSameColor() {
    }

    @Test
    void buySettlement() {
    }

    @Test
    void checkSettlementLocation() {
    }

    @Test
    void buyCity() {
    }

    @Test
    void rollDiceAndDistributeCards() {
    }

    @Test
    void over() {
    }

    @Test
    void winningPlayer() {
    }

    @Test
    void playRobber() {
    }

    @Test
    void moveRobber() {
    }

    @Test
    void playYearOfPlenty() {
    }

    @Test
    void playMonopoly() {
    }

    @Test
    void playRoadBuilding() {
    }

    @Test
    void playKnight() {
    }
}