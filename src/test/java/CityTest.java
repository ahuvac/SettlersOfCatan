import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void getColor() {

        //given
        City city = new City(Color.BLUE);

        //when
        Color color = city.getColor();

        //then
        assertEquals(Color.BLUE, color);
    }
}