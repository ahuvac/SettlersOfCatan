import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board {
    ;
    Hex[][] hexes = new Hex[5][9];
    Vertex[][] vertices;
    Edge[][] edges = new Edge[21][10];


    public Board(){
        List<Hex> hexArrayList = createHexes();
        Collections.shuffle(hexArrayList);
        assignNumbers(hexArrayList);
        placesHexes(hexArrayList);
        placeEdges();
        placeVertices();
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
        edges[0][5] = new Edge(borderingHexes);
        edges[0][7] = new Edge(borderingHexes);
        borderingHexes.clear();
        borderingHexes.add(hexes[0][4]);
        edges[0][9] = new Edge(borderingHexes);
        edges[0][11] = new Edge(borderingHexes);
        borderingHexes.clear();
        borderingHexes.add(hexes[0][6]);
        edges[0][13] = new Edge(borderingHexes);
        edges[0][15] = new Edge(borderingHexes);
        //second row
        borderingHexes.clear();
        borderingHexes.add(hexes[0][2]);
        edges[1][4] = new Edge(borderingHexes);
        borderingHexes.add(hexes[0][4]);
        edges[1][8] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);
        edges[1][12] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[1][16] = new Edge(borderingHexes);
        //third row
        borderingHexes.clear();
        borderingHexes.add(hexes[1][1]);
        edges[2][3] = new Edge(borderingHexes);
        borderingHexes.add(hexes[0][2]);
        edges[2][5] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][3]);
        edges[2][7] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][4]);
        edges[2][9] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        edges[2][11] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);
        edges[2][13] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][7]);
        edges[2][15] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[2][17] = new Edge(borderingHexes);
        //fourth row
        borderingHexes.clear();
        borderingHexes.add(hexes[1][1]);
        edges[3][2] = new Edge(borderingHexes);
        borderingHexes.add(hexes[1][3]);
        edges[3][6] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        edges[3][10] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][7]);
        edges[3][14] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[3][18] = new Edge(borderingHexes);
        //fifth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        edges[4][1] = new Edge(borderingHexes);
        borderingHexes.add(hexes[1][1]);
        edges[4][3] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][2]);
        edges[4][5] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][3]);
        edges[4][7] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        edges[4][9] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        edges[4][11] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        edges[4][13] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][7]);
        edges[4][15] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        edges[4][17] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[4][19] = new Edge(borderingHexes);
        //sixth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        edges[5][0] = new Edge(borderingHexes);
        borderingHexes.add(hexes[2][2]);
        edges[5][4] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        edges[5][8] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        edges[5][12] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        edges[5][16] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[5][20] = new Edge(borderingHexes);
        //seventh row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        edges[6][1] = new Edge(borderingHexes);
        borderingHexes.add(hexes[3][1]);
        edges[6][3] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][2]);
        edges[6][5] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][3]);
        edges[6][7] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        edges[6][9] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        edges[6][11] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        edges[6][13] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][7]);
        edges[6][15] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        edges[6][17] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[6][19] = new Edge(borderingHexes);
        //eighth row
        borderingHexes.clear();
        borderingHexes.add(hexes[3][1]);
        edges[7][2] = new Edge(borderingHexes);
        borderingHexes.add(hexes[3][3]);
        edges[7][6] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        edges[7][10] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][7]);
        edges[7][14] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[7][18] = new Edge(borderingHexes);
        //ninth row
        borderingHexes.clear();
        borderingHexes.add(hexes[3][1]);
        edges[8][3] = new Edge(borderingHexes);
        borderingHexes.add(hexes[4][2]);
        edges[8][5] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][3]);
        edges[8][7] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][4]);
        edges[8][9] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        edges[8][11] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        edges[8][13] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][7]);
        edges[8][15] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[8][17] = new Edge(borderingHexes);
        //tenth row
        borderingHexes.clear();
        borderingHexes.add(hexes[4][2]);
        edges[9][4] = new Edge(borderingHexes);
        borderingHexes.add(hexes[4][4]);
        edges[9][8] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        edges[9][12] = new Edge(borderingHexes);
        borderingHexes.remove(0);
        edges[9][16] = new Edge(borderingHexes);
        //11th row
        borderingHexes.clear();
        borderingHexes.add(hexes[4][2]);
        edges[10][5] = new Edge(borderingHexes);
        edges[10][7] = new Edge(borderingHexes);
        borderingHexes.clear();
        borderingHexes.add(hexes[4][4]);
        edges[10][9] = new Edge(borderingHexes);
        edges[10][11] = new Edge(borderingHexes);
        borderingHexes.clear();
        borderingHexes.add(hexes[4][6]);
        edges[10][13] = new Edge(borderingHexes);
        edges[10][15] = new Edge(borderingHexes);
    }

    private void placeVertices()
    {
        //first row
        List<Hex> borderingHexes = new ArrayList<Hex>();
        borderingHexes.add(hexes[0][2]);
        vertices[0][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][4]);
        vertices[0][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);
        vertices[0][7] = new Vertex(borderingHexes);
        //second row
        borderingHexes.clear();
        borderingHexes.add(hexes[0][2]);
        vertices[1][2] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[0][4]);
        vertices[1][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);
        vertices[1][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        vertices[1][8] = new Vertex(borderingHexes);
        //third row
        borderingHexes.clear();
        borderingHexes.add(hexes[1][1]);
        borderingHexes.add(hexes[0][2]);
        vertices[2][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][3]);
        borderingHexes.add(hexes[0][4]);
        vertices[2][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        borderingHexes.add(hexes[0][6]);
        vertices[2][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        vertices[2][8] = new Vertex(borderingHexes);
        //fourth row
        borderingHexes.clear();
        borderingHexes.add(hexes[1][1]);
        vertices[3][1] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[0][2]);
        borderingHexes.add(hexes[1][3]);
        vertices[3][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][4]);
        borderingHexes.add(hexes[1][5]);
        vertices[3][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);
        borderingHexes.add(hexes[1][7]);
        vertices[3][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        vertices[3][9] = new Vertex(borderingHexes);
        //fifth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        borderingHexes.add(hexes[1][1]);
        vertices[4][1] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][2]);
        borderingHexes.add(hexes[1][3]);
        vertices[4][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        borderingHexes.add(hexes[1][5]);
        vertices[4][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        borderingHexes.add(hexes[1][7]);
        vertices[4][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        vertices[4][9] = new Vertex(borderingHexes);
        //sixth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        vertices[5][0] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[1][1]);
        borderingHexes.add(hexes[2][2]);
        vertices[5][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][3]);
        borderingHexes.add(hexes[2][4]);
        vertices[5][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        borderingHexes.add(hexes[2][6]);
        vertices[5][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][7]);
        borderingHexes.add(hexes[2][8]);
        vertices[5][8] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        vertices[5][10] = new Vertex(borderingHexes);
        //seventh row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        vertices[6][0] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[3][1]);
        borderingHexes.add(hexes[2][2]);
        vertices[6][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][3]);
        borderingHexes.add(hexes[2][4]);
        vertices[6][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        borderingHexes.add(hexes[2][6]);
        vertices[6][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][7]);
        borderingHexes.add(hexes[2][8]);
        vertices[6][8] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        vertices[6][10] = new Vertex(borderingHexes);
        //eighth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        borderingHexes.add(hexes[3][1]);
        vertices[7][1] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][2]);
        borderingHexes.add(hexes[3][3]);
        vertices[7][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        borderingHexes.add(hexes[3][5]);
        vertices[7][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        borderingHexes.add(hexes[3][7]);
        vertices[7][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        vertices[7][9] = new Vertex(borderingHexes);
        //ninth row
        borderingHexes.clear();
        borderingHexes.add(hexes[3][1]);
        vertices[8][1] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[4][2]);
        borderingHexes.add(hexes[3][3]);
        vertices[8][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][4]);
        borderingHexes.add(hexes[3][5]);
        vertices[8][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        borderingHexes.add(hexes[3][7]);
        vertices[8][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        vertices[8][9] = new Vertex(borderingHexes);
        //tenth row
        borderingHexes.clear();
        borderingHexes.add(hexes[3][1]);
        borderingHexes.add(hexes[4][2]);
        vertices[9][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][3]);
        borderingHexes.add(hexes[4][4]);
        vertices[9][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        borderingHexes.add(hexes[4][6]);
        vertices[9][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        vertices[9][8] = new Vertex(borderingHexes);
        //eleventh row
        borderingHexes.clear();
        borderingHexes.add(hexes[4][2]);
        vertices[10][2] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[4][4]);
        vertices[10][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        vertices[10][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        vertices[10][8] = new Vertex(borderingHexes);
        //twelfth row
        borderingHexes.clear();
        borderingHexes.add(hexes[4][2]);
        vertices[11][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][4]);
        vertices[11][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        vertices[11][7] = new Vertex(borderingHexes);
        
    }

    public List<HexLocation> getHexesWithNumber(int number)
    {
        ArrayList<HexLocation> hexesWithNumber = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (hexes[i][j].number == number)
                {
                    hexesWithNumber.add(new HexLocation(i, j));
                }
            }
        }
        return hexesWithNumber;
    }

    public List<Vertex> getVertices(HexLocation location)
    {
        List<Vertex> vertexList = new ArrayList<>();
        int index = location.row * 2;

        vertexList.add(vertices[index] [location.col + 1]);
        vertexList.add(vertices[index + 1] [location.col]);
        vertexList.add(vertices[index + 2] [location.col]);
        vertexList.add(vertices[index + 3] [location.col + 1]);
        vertexList.add(vertices[index + 1] [location.col + 2]);
        vertexList.add(vertices[index + 2] [location.col + 2]);

        return vertexList;
    }

    public List<Vertex> getVertices(Edge edge)
    {
        List<Vertex> vertices = new ArrayList<>();
        return vertices;
    }

    public ResourceType getResource(HexLocation location)
    {
        return hexes[location.row][location.col].type;
    }

}
