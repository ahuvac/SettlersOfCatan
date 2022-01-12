import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void isEmpty() {

        //given
        Wallet wallet = new Wallet();

        //then
        assertTrue(wallet.isEmpty());
    }

    @Test
    void isEmptyFalse() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK, 2);

        //then
        assertFalse(wallet.isEmpty());
    }

    @Test
    void hasCard() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK,2);

        //then
        assertTrue(wallet.hasCard(ResourceType.BRICK,1));
    }

    @Test
    void hasCardFalse() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK,2);

        //then
        assertFalse(wallet.hasCard(ResourceType.ORE,1));
    }

    @Test
    void hasCardFalse2() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK,2);
        wallet.useCard(ResourceType.BRICK);
        wallet.useCard(ResourceType.BRICK);

        //then
        assertFalse(wallet.hasCard(ResourceType.BRICK,1));
    }

    @Test
    void useCard() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK,2);
        wallet.useCard(ResourceType.BRICK);

        //then
        assertFalse(wallet.hasCard(ResourceType.BRICK, 2));
    }

    @Test
    void addCard() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK, 2);

        //then
        assertNotNull(wallet);
        assertTrue(wallet.hasCard(ResourceType.BRICK, 2));
    }

    //TODO MOCITO need to fill in this method
    @Test
    void getRandomCard() {

        //given
        Wallet wallet = new Wallet();

        //when
        //then
    }

    @Test
    void getTotalCards() {

        //given
        Wallet wallet = new Wallet();

        //when
        wallet.addCard(ResourceType.BRICK, 2);
        wallet.addCard(ResourceType.ORE, 2);
        wallet.addCard(ResourceType.WOOL, 2);

        int sum = wallet.getTotalCards();

        //then
        assertEquals(6, sum);
    }
}