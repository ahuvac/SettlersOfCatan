import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void getColor() {

        //given
        Road road = new Road(Color.BLUE);

        //when
        Color color = road.getColor();
        //then
        assertEquals(Color.BLUE, color);
    }
}