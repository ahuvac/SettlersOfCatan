import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board {
    ;
    Hex[][] hexes = new Hex[5][9];
    Vertex[][] vertices;
    Edge[][] edges = new Edge[11][10];


    public Board(){
        List<Hex> hexArrayList = createHexes();
        Collections.shuffle(hexArrayList);
        assignNumbers(hexArrayList);
        placesHexes(hexArrayList);
        placeEdges();
    }

    private List<Hex> createHexes()
    {
        List<Hex> hexArrayList = new ArrayList<>();
        for (int i = 0 ; i < 3; i++){
        hexArrayList.add( new Hex(ResourceType.ORE));
        }

        for (int i = 0 ; i < 3; i++){
            hexArrayList.add( new Hex(ResourceType.BRICK));
        }

        for (int i = 0 ; i < 4; i++){
            hexArrayList.add( new Hex(ResourceType.GRAIN));
        }

        for (int i = 0 ; i < 4; i++){
            hexArrayList.add( new Hex(ResourceType.LUMBER));
        }

        for (int i = 0 ; i < 4; i++){
            hexArrayList.add( new Hex(ResourceType.WOOL));
        }

        hexArrayList.add( new Hex(ResourceType.DESERT));
        return hexArrayList;
    }

    private void assignNumbers(List<Hex> hexArrayList)
    {
        int[] numbers = new int[18];
        numbers[0] = 5;
        numbers[1] = 2;
        numbers[2] = 6;
        numbers[3] = 3;
        numbers[4] = 8;
        numbers[6] = 10;
        numbers[7] = 9;
        numbers[8] = 12;
        numbers[9] = 11;
        numbers[10] = 4;
        numbers[11] = 8;
        numbers[12] = 10;
        numbers[13] = 9;
        numbers[14] = 4;
        numbers[15] = 5;
        numbers[16] = 6;
        numbers[17] = 3;
        numbers[18] = 11;

        int index = 0;
        for (Hex hex : hexArrayList) {
            if (hex.type == ResourceType.DESERT)
            {
                continue;
            }
            hex.setNumber(numbers[index]);
            index++;
        }

    }

    private void placesHexes(List<Hex> hexArrayList)
    {
        //first row
        hexes[0][2] = hexArrayList.remove(0);
        hexes[0][4] = hexArrayList.remove(0);
        hexes[0][6] = hexArrayList.remove(0);
        //second row
        hexes[1][1] = hexArrayList.remove(0);
        hexes[1][3] = hexArrayList.remove(0);
        hexes[1][5] = hexArrayList.remove(0);
        hexes[1][7] = hexArrayList.remove(0);
        //third row
        hexes[2][0] = hexArrayList.remove(0);
        hexes[2][2] = hexArrayList.remove(0);
        hexes[2][4] = hexArrayList.remove(0);
        hexes[2][6] = hexArrayList.remove(0);
        hexes[2][8] = hexArrayList.remove(0);
        //fourth row
        hexes[3][1] = hexArrayList.remove(0);
        hexes[3][3] = hexArrayList.remove(0);
        hexes[3][5] = hexArrayList.remove(0);
        hexes[3][7] = hexArrayList.remove(0);
        //fifth row
        hexes[4][2] = hexArrayList.remove(0);
        hexes[4][4] = hexArrayList.remove(0);
        hexes[4][6] = hexArrayList.remove(0);
    }

    private void placeEdges()
    {
        //first row
        List<Hex> borderingHexes = new ArrayList<Hex>();
        borderingHexes.add(hexes[0][2]);
        edges[0][2] = new Edge(borderingHexes);
        edges[0][3] = new Edge(borderingHexes);
        borderingHexes.clear();
        borderingHexes.add(hexes[0][4]);
        edges[0][4] = new Edge(borderingHexes);
        edges[0][5] = new Edge(borderingHexes);
        borderingHexes.clear();
        borderingHexes.add(hexes[0][6]);
        edges[0][6] = new Edge(borderingHexes);
        edges[0][7] = new Edge(borderingHexes);
        //second row
        

    }

}
