import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettlementTest {

    @Test
    void getColor() {

        //given
        Settlement settlement = new Settlement(Color.BLUE);

        //when
        Color color = settlement.getColor();

        //then
        assertEquals(Color.BLUE, color);
    }
}
