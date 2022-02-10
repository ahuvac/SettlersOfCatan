import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void decrementSettlements() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.decrementSettlements();

        //then
        assertTrue(player.hasMoreSettlements());
    }

    @Test
    void decrementSettlementsFail() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        for (int i = 0; i < 5; i++) {
            player.decrementSettlements();
        }

        //then
        assertFalse(player.hasMoreSettlements());
    }


    @Test
    void decrementRoads() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.decrementRoads();

        //then
        assertTrue(player.hasMoreRoads());
    }

    @Test
    void decrementRoadsFail() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        for (int i = 0; i < 16; i++) {
            player.decrementRoads();
        }

        //then
        assertFalse(player.hasMoreRoads());
    }

    @Test
    void hasMoreRoads() {

        //given
        Player player = new Player(Color.BLUE);
        List<Hex> hexes = new ArrayList<>();
        hexes.add(new Hex(ResourceType.DESERT));

        //when
        player.addCard(ResourceType.BRICK, 15);
        player.addCard(ResourceType.LUMBER, 15);

        for (int i = 0; i < 8; i++) {
            player.buildRoad(new Edge(hexes));
        }

        //then
        assertTrue(player.hasMoreRoads());
    }


    @Test
    void hasMoreRoadsFalse() {

        //given
        Player player = new Player(Color.BLUE);
        List<Hex> hexes = new ArrayList<>();
        hexes.add(new Hex(ResourceType.DESERT));

        //when
        player.addCard(ResourceType.BRICK, 15);
        player.addCard(ResourceType.LUMBER, 15);

        for (int i = 0; i < 16; i++) {
            player.buildRoad(new Edge(hexes));
        }

        //then
        assertFalse(player.hasMoreRoads());
    }

    @Test
    void incrementScore() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.incrementScore();

        //then
        assertEquals(1, player.getScore());
    }


    @Test
    void hasMoreSettlements() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        for (int i = 0; i < 2; i++) {
            player.decrementSettlements();
        }

        //then
        assertTrue(player.hasMoreSettlements());

    }

    @Test
    void hasMoreSettlementsFalse() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        for (int i = 0; i < 5; i++) {
            player.decrementSettlements();
        }

        //then
        assertFalse(player.hasMoreSettlements());

    }



    @Test
    void hasBuiltSettlements() {
        //given
        Player player = new Player(Color.BLUE);

        //when
        for (int i = 0; i < 2; i++) {
            player.decrementSettlements();
        }

        //then
        assertTrue(player.hasBuiltSettlements());
    }

    @Test
    void hasBuiltSettlementsFalse() {
        //given
        Player player = new Player(Color.BLUE);

        //then
        assertFalse(player.hasBuiltSettlements());
    }

    @Test
    void hasMoreCities() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.ORE,3);
        player.addCard(ResourceType.GRAIN, 2);

        player.buildCity();

        //then
        assertTrue(player.hasMoreCities());
    }

    @Test
    void hasMoreCitiesFalse() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.ORE,12);
        player.addCard(ResourceType.GRAIN, 8);

        for (int i = 0; i < 4 ; i++) {
            player.buildCity();
        }

        //then
        assertFalse(player.hasMoreCities());
    }


    @Test
    void hasCard() {
        //given
        Player player = new Player(Color.BLUE);

        //when
       player.addCard(ResourceType.BRICK, 2);

        //then
        assertTrue(player.hasCard(ResourceType.BRICK, 1));
    }

    @Test
    void hasCardFalse() {
        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.BRICK, 2);
        player.addCard(ResourceType.ORE, 2);
        player.useCard(ResourceType.BRICK);
        player.useCard(ResourceType.BRICK);

        //then
        assertFalse(player.hasCard(ResourceType.BRICK, 1));
    }


    @Test
    void getScore() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.incrementScore();

        //then
        assertEquals(1, player.getScore());
    }

    @Test
    void addCard() {
        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.BRICK, 2);
        player.addCard(ResourceType.ORE, 2);


        //then
        assertTrue(player.hasCard(ResourceType.BRICK, 2));
        assertTrue(player.hasCard(ResourceType.ORE, 2));
    }

    @Test
    void buyDevelopmentCard() {

        //given
        Player player = new Player(Color.BLUE);
        Bank bank = new Bank();

        //when
        player.addCard(ResourceType.WOOL, 1);
        player.addCard(ResourceType.GRAIN, 1);
        player.addCard(ResourceType.ORE, 1);

        DevelopmentCard card = bank.getDevelopmentCard();

        player.buyDevelopmentCard(card);

        //then
        assertTrue(player.hasDevelopmentCard(card));
    }

    @Test
    void addKnight() {
        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addKnight();
        player.addKnight();

        //then
        assertEquals(2, player.getKnight());
    }


    @Test
    void hasDevelopmentCard() {

        //given
        Player player = new Player(Color.BLUE);
        Bank bank = new Bank();

        //when
        player.addCard(ResourceType.WOOL, 1);
        player.addCard(ResourceType.GRAIN, 1);
        player.addCard(ResourceType.ORE, 1);

        DevelopmentCard card = bank.getDevelopmentCard();

        player.buyDevelopmentCard(card);

        //then
        assertTrue(player.hasDevelopmentCard(card));
    }

    @Test
    void hasDevelopmentCardFalse() {

        //given
        Player player = new Player(Color.BLUE);
        Bank bank = new Bank();

        //when
        player.addCard(ResourceType.WOOL, 1);
        player.addCard(ResourceType.GRAIN, 1);
        player.addCard(ResourceType.ORE, 1);

        DevelopmentCard card = bank.getDevelopmentCard();

        player.buyDevelopmentCard(card);
        player.useDevelopmentCard(card);

        //then
        assertFalse(player.hasDevelopmentCard(card));
    }

    @Test
    void useDevelopmentCard() {

        //given
        Player player = new Player(Color.BLUE);
        Bank bank = new Bank();

        //when
        player.addCard(ResourceType.WOOL, 1);
        player.addCard(ResourceType.GRAIN, 1);
        player.addCard(ResourceType.ORE, 1);

        DevelopmentCard card = bank.getDevelopmentCard();

        player.buyDevelopmentCard(card);
        player.useDevelopmentCard(card);
        player.buyDevelopmentCard(card);
        player.useDevelopmentCard(card);

        //then
        assertFalse(player.hasDevelopmentCard(card));
    }


    @Test
    void buildRoad() {

        //given
        Player player = new Player(Color.BLUE);
        List<Hex> hexes = new ArrayList<>();
        hexes.add(new Hex(ResourceType.DESERT));

        //when
        player.addCard(ResourceType.BRICK, 2);
        player.addCard(ResourceType.LUMBER, 2);

        //then
        assertTrue( player.buildRoad(new Edge(hexes)));
        assertEquals(2, player.getTotalCards());
    }

    @Test
    void buildRoadFalse(){
        //given
        Player player = new Player(Color.BLUE);
        List<Hex> hexes = new ArrayList<>();
        hexes.add(new Hex(ResourceType.DESERT));

        //when
        player.addCard(ResourceType.BRICK, 0);
        player.addCard(ResourceType.LUMBER, 2);

        //then
        assertFalse(player.buildRoad(new Edge(hexes)));
    }

    @Test
    void buildSettlement() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.WOOL,2);
        player.addCard(ResourceType.GRAIN,1);
        player.addCard(ResourceType.BRICK,2);
        player.addCard(ResourceType.LUMBER,1);

        //then
        assertTrue(player.buildSettlement());
    }

    @Test
    void buildSettlement2() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.WOOL, 3);
        player.addCard(ResourceType.BRICK,2);
        player.addCard(ResourceType.GRAIN ,1);
        player.addCard(ResourceType.LUMBER, 1);

        //then
        assertTrue(player.buildSettlement());
    }

    @Test
    void buildSettlementFail() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.WOOL, 1);
        player.addCard(ResourceType.GRAIN, 1);

        //then
        assertFalse(player.buildSettlement());
    }

    @Test
    void buildCity() {
        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.GRAIN, 2);
        player.addCard(ResourceType.ORE, 3);

        //then
        assertTrue(player.buildCity());
    }

    @Test
    void buildCityFail() {

        //given
        Player player = new Player(Color.BLUE);

        //when
        player.addCard(ResourceType.WOOL, 1);
        player.addCard(ResourceType.GRAIN, 1);

        //then
        assertFalse(player.buildCity());
    }


}