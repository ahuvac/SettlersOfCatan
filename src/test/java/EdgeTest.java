import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void hasRoad() {

        //given
        ArrayList<Hex> hexes = new ArrayList<>();

        Hex hex1 = new Hex(ResourceType.BRICK);
        Hex hex2 = new Hex(ResourceType.WOOL);
        Hex hex3 = new Hex(ResourceType.ORE);

        hexes.add(hex1);
        hexes.add(hex2);
        hexes.add(hex3);

        Edge edge = new Edge(hexes);

        //when
        Road road = new Road(Color.BLUE);
        edge.buildRoad(road);

        //then
        assertTrue(edge.hasRoad());
    }

    @Test
    void hasRoadFalse() {

        //given
        ArrayList<Hex> hexes = new ArrayList<>();

        Hex hex1 = new Hex(ResourceType.BRICK);
        Hex hex2 = new Hex(ResourceType.WOOL);
        Hex hex3 = new Hex(ResourceType.ORE);

        hexes.add(hex1);
        hexes.add(hex2);
        hexes.add(hex3);

        Edge edge = new Edge(hexes);

        //then
        assertFalse(edge.hasRoad());
    }

    @Test
    void buildRoad() {
        //given
        ArrayList<Hex> hexes = new ArrayList<>();

        Hex hex1 = new Hex(ResourceType.BRICK);
        Hex hex2 = new Hex(ResourceType.WOOL);
        Hex hex3 = new Hex(ResourceType.ORE);

        hexes.add(hex1);
        hexes.add(hex2);
        hexes.add(hex3);

        Edge edge = new Edge(hexes);

        //when
        Road road = new Road(Color.BLUE);
        edge.buildRoad(road);

        //then
        assertTrue(edge.hasRoad());
    }


    @Test
    void getRoadColor() {
        //given
        ArrayList<Hex> hexes = new ArrayList<>();

        Hex hex1 = new Hex(ResourceType.BRICK);
        Hex hex2 = new Hex(ResourceType.WOOL);
        Hex hex3 = new Hex(ResourceType.ORE);

        hexes.add(hex1);
        hexes.add(hex2);
        hexes.add(hex3);

        Edge edge = new Edge(hexes);

        //when
        Road road = new Road(Color.BLUE);
        edge.buildRoad(road);

        //then
        assertEquals(Color.BLUE, edge.getRoadColor());
    }

    @Test
    void getVertices() {
        //given
        ArrayList<Hex> hexes = new ArrayList<>();

        Hex hex1 = new Hex(ResourceType.BRICK);
        Hex hex2 = new Hex(ResourceType.WOOL);

        hexes.add(hex1);
        hexes.add(hex2);

        Edge edge = new Edge(hexes);

        //when
        Vertex vertex = new Vertex(hexes);
        edge.setVertices(vertex);


        //then
        assertNotNull(edge.getVertices());
    }
}