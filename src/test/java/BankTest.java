import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void hasResourceCard() {

        //given
        Bank bank = new Bank();

        //then
        assertTrue(bank.hasResourceCard(ResourceType.BRICK, 2));
        assertTrue(bank.hasResourceCard(ResourceType.ORE, 3));
        assertTrue(bank.hasResourceCard(ResourceType.WOOL, 4));
    }


    @Test
    void hasResourceCardFalse() {

        //given
        Bank bank = new Bank();

        //then
        assertFalse(bank.hasResourceCard(ResourceType.BRICK, 30));
        assertFalse(bank.hasResourceCard(ResourceType.ORE, 27));
        assertFalse(bank.hasResourceCard(ResourceType.WOOL, 44));
    }


    @Test
    void hasDevelopmentCard() {

        //given
        Bank bank = new Bank();

        //then
        assertTrue(bank.hasDevelopmentCard());
    }

    @Test
    void hasDevelopmentCard2() {

        //given
        Bank bank = new Bank();

        //when
        DevelopmentCard card = bank.getDevelopmentCard();

        //then
        assertTrue(bank.hasDevelopmentCard());
    }

    @Test
    void hasDevelopmentCardFalse() {

        //given
        Bank bank = new Bank();

        //when
        for (int i = 0; i < 30; i++) {
            DevelopmentCard card = bank.getDevelopmentCard();
        }
        //then
        assertFalse(bank.hasDevelopmentCard());
    }

    @Test
    void getResourceCard() {

        //given
        Bank bank = new Bank();

        //then
        assertTrue(bank.getResourceCard(ResourceType.BRICK));
    }

    @Test
    void getResourceCard2() {

        //given
        Bank bank = new Bank();

        //when
        bank.getResourceCard(ResourceType.BRICK);
        //then
        assertTrue(bank.getResourceCard(ResourceType.BRICK));
    }

    @Test
    void getResourceCardFalse() {

        //given
        Bank bank = new Bank();

        //then
        assertFalse(bank.getResourceCard(ResourceType.DESERT));
    }

    @Test
    void getResourceCardFalse2() {

        //given
        Bank bank = new Bank();

        //when
        for (int i = 0; i < 20; i++) {
            bank.getResourceCard(ResourceType.BRICK);
        }

        //then
        assertFalse(bank.getResourceCard(ResourceType.BRICK));
    }

    @Test
    void addResourceCard() {
        //given
        Bank bank = new Bank();

        //when
        //removing all the Brick from the pile
        for (int i = 0; i < 20; i++) {
            bank.getResourceCard(ResourceType.BRICK);
        }

        bank.addResourceCard(ResourceType.BRICK);

        //then
        assertTrue(bank.hasResourceCard(ResourceType.BRICK, 1));
    }

    @Test
    void getDevelopmentCard() {
        //given
        Bank bank = new Bank();

        //when
        DevelopmentCard card = bank.getDevelopmentCard();

        //then
        assertNotNull(card);
    }

    @Test
    void getDevelopmentCard2() {
        //given
        Bank bank = new Bank();

        //when
        DevelopmentCard card = null;
        for (int i = 0; i < 5; i++) {
           card = bank.getDevelopmentCard();
        }

        //then
        assertNotNull(card);
    }


    @Test
    void getDevelopmentCardFalse() {
        //given
        Bank bank = new Bank();

        //when
        DevelopmentCard card = null;
        for (int i = 0; i < 30; i++) {
            card = bank.getDevelopmentCard();
        }

        //then
        assertNull(card);
    }
}