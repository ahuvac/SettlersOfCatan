/*
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void buildRoad() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.BRICK);
        player.wallet.addCard(ResourceType.LUMBER);

        //then
        assertTrue(player.buildRoad());
    }

    @Test
    void buildRoadFalse() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.BRICK);

        //then
        assertFalse(player.buildRoad());
    }

    @Test
    void buildSettlement() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.GRAIN);
        player.wallet.addCard(ResourceType.BRICK);
        player.wallet.addCard(ResourceType.LUMBER);

        //then
        assertTrue(player.buildSettlement());
    }

    @Test
    void buildSettlement2() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.BRICK);
        player.wallet.addCard(ResourceType.GRAIN);
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.LUMBER);

        //then
        assertTrue(player.buildSettlement());
    }

    @Test
    void buildSettlementFail() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.GRAIN);

        //then
        assertFalse(player.buildSettlement());
    }

    @Test
    void buildCity() {
        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.GRAIN);
        player.wallet.addCard(ResourceType.GRAIN);
        player.wallet.addCard(ResourceType.ORE);
        player.wallet.addCard(ResourceType.ORE);
        player.wallet.addCard(ResourceType.ORE);

        //then
        assertTrue(player.buildCity());
    }

    @Test
    void buildCityFail() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.GRAIN);

        //then
        assertFalse(player.buildCity());
    }

    @Test
    void buyDevelopmentCard() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.GRAIN);
        player.wallet.addCard(ResourceType.ORE);

        //then
        assertTrue(player.buyDevelopmentCard());
    }

    @Test
    void buyDevelopmentCardFail() {

        //given
        Player player = new Player();

        //when
        player.wallet.addCard(ResourceType.WOOL);
        player.wallet.addCard(ResourceType.GRAIN);

        //then
        assertFalse(player.buyDevelopmentCard());
    }
}
*/
