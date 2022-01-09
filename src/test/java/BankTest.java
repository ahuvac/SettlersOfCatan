import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void getResourceCard() {

        //given
        Bank bank = new Bank();

        //when
        ResourceCard card = bank.getResourceCard(ResourceType.ORE);

        //then
        assertEquals(card.type, ResourceType.ORE);
    }

    @Test
     void addResourceCard() {

    }

    @Test
    void getDevelopmentCard() {
        //given
        Bank bank = new Bank();

        //when
       DevelopmentCard devCard = bank.getDevelopmentCard();

        //then
        assertNotNull(devCard);
    }

    @Test
    void getDevelopmentCardNull() {
        //given
        Bank bank = new Bank();

        //when
        DevelopmentCard devCard = null;
        for (int i = 0; i < 100; i++) {
            devCard = bank.getDevelopmentCard();
        }

        //then
        assertNull(devCard);
    }
}