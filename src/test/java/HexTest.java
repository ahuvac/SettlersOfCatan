import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexTest {

    @Test
    void setNumber() {

        //given
        Hex hex = new Hex(ResourceType.BRICK);

        //when
        hex.setNumber(6);

        //then
        assertEquals(6, hex.number);
    }

    //TODO Fill this in or delete
//    @Test
//    void connect() {
//    }
}