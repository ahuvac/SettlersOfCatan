/*
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void addCard() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK);

        //then
        assertNotNull(wallet);
    }

    @Test
    void useCards() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK);
        wallet.addCard(ResourceType.BRICK);
        wallet.addCard(ResourceType.BRICK);

        Map<ResourceType, Integer> cards = new HashMap<>();
        cards.put(ResourceType.BRICK, 2);

        //then
        assertTrue(wallet.useCards(cards));
    }

    @Test
    void useCardsFail() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK);
        wallet.addCard(ResourceType.BRICK);
        wallet.addCard(ResourceType.BRICK);

        Map<ResourceType, Integer> cards = new HashMap<>();
        cards.put(ResourceType.BRICK, 5);

        //then
        assertFalse(wallet.useCards(cards));
    }


}*/
