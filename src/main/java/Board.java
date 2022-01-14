import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board {
    ;
    Hex[][] hexes = new Hex[5][9];
    Vertex[][] vertices = new Vertex[12][11];
    Edge[][] edges = new Edge[11][21];


    public Board(){
        List<Hex> hexArrayList = createHexes();
        Collections.shuffle(hexArrayList);
        assignNumbers(hexArrayList);
        placesHexes(hexArrayList);
        placeEdges();
        placeVertices();
    }

    public List<Hex> getHexesAsList()
    {
        List<Hex> hexList = new ArrayList<Hex>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (hexes[i][j] != null)
                {
                    hexList.add(hexes[i][j]);
                }
            }
        }
        return hexList;
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
        int[] numbers = new int[19];
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

    //TODO replace method with the formula
    private void placeVertices()
    {
        //first row
        List<Hex> borderingHexes = new ArrayList<Hex>();
        List<Edge> edgeList = new ArrayList<>();

        borderingHexes.add(hexes[0][2]);
        vertices[0][3] = new Vertex(borderingHexes);
        edgeList.add(edges[0][5]);
        edgeList.add(edges[0][7]);
        vertices[0][3].setEdges(edgeList);
        edgeList.clear();

        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][4]);
        vertices[0][5] = new Vertex(borderingHexes);
        edgeList.add(edges[0][9]);
        edgeList.add(edges[0][11]);
        vertices[0][5].setEdges(edgeList);
        borderingHexes.remove(0);
        edgeList.clear();

        borderingHexes.add(hexes[0][6]);
        vertices[0][7] = new Vertex(borderingHexes);
        edgeList.add(edges[0][13]);
        edgeList.add(edges[0][15]);
        vertices[0][7].setEdges(edgeList);
        edgeList.clear();

        //second row
        borderingHexes.clear();
        borderingHexes.add(hexes[0][2]);
        vertices[1][2] = new Vertex(borderingHexes);
        edgeList.add(edges[1][4]);
        edgeList.add(edges[0][5]);
        vertices[1][2].setEdges(edgeList);
        edgeList.clear();

        borderingHexes.add(hexes[0][4]);
        vertices[1][4] = new Vertex(borderingHexes);
        edgeList.add(edges[0][7]);
        edgeList.add(edges[1][8]);
        vertices[1][4].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);

        vertices[1][6] = new Vertex(borderingHexes);
        edgeList.add(edges[0][11]);
        edgeList.add(edges[1][12]);
        vertices[1][6].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);

        vertices[1][8] = new Vertex(borderingHexes);
        edgeList.add(edges[0][15]);
        edgeList.add(edges[1][16]);
        vertices[1][8].setEdges(edgeList);
        edgeList.clear();

        //third row
        borderingHexes.clear();
        borderingHexes.add(hexes[1][1]);
        borderingHexes.add(hexes[0][2]);
        vertices[2][2] = new Vertex(borderingHexes);
        edgeList.add(edges[1][4]);
        edgeList.add(edges[2][3]);
        edgeList.add(edges[2][5]);
        vertices[2][2].setEdges(edgeList);
        edgeList.clear();

        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][3]);
        borderingHexes.add(hexes[0][4]);
        vertices[2][4] = new Vertex(borderingHexes);
        edgeList.add(edges[2][7]);
        edgeList.add(edges[1][8]);
        edgeList.add(edges[2][9]);
        vertices[2][4].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        borderingHexes.add(hexes[0][6]);

        vertices[2][6] = new Vertex(borderingHexes);
        edgeList.add(edges[2][11]);
        edgeList.add(edges[1][12]);
        edgeList.add(edges[2][13]);
        vertices[2][6].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);
        borderingHexes.remove(0);

        vertices[2][8] = new Vertex(borderingHexes);
        edgeList.add(edges[2][15]);
        edgeList.add(edges[1][16]);
        edgeList.add(edges[2][17]);
        vertices[2][8].setEdges(edgeList);
        edgeList.clear();

        //fourth row
        borderingHexes.clear();
        borderingHexes.add(hexes[1][1]);
        vertices[3][1] = new Vertex(borderingHexes);
        edgeList.add(edges[2][3]);
        edgeList.add(edges[3][2]);
        vertices[3][1].setEdges(edgeList);
        edgeList.clear();

        borderingHexes.add(hexes[0][2]);
        borderingHexes.add(hexes[1][3]);
        vertices[3][3] = new Vertex(borderingHexes);
        edgeList.add(edges[2][5]);
        edgeList.add(edges[3][6]);
        edgeList.add(edges[2][7]);
        vertices[3][3].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][4]);
        borderingHexes.add(hexes[1][5]);

        vertices[3][5] = new Vertex(borderingHexes);
        edgeList.add(edges[2][9]);
        edgeList.add(edges[3][10]);
        edgeList.add(edges[2][11]);
        vertices[3][5].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[0][6]);
        borderingHexes.add(hexes[1][7]);

        vertices[3][7] = new Vertex(borderingHexes);
        edgeList.add(edges[2][13]);
        edgeList.add(edges[3][14]);
        edgeList.add(edges[2][15]);
        vertices[3][7].setEdges(edgeList);
        edgeList.clear();
        borderingHexes.remove(0);
        borderingHexes.remove(0);

        vertices[3][9] = new Vertex(borderingHexes);
        edgeList.add(edges[2][17]);
        edgeList.add(edges[3][18]);
        vertices[3][9].setEdges(edgeList);
        edgeList.clear();

        //fifth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        borderingHexes.add(hexes[1][1]);
        vertices[4][1] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][2]);
        borderingHexes.add(hexes[1][3]);
        edgeList.add(edges[4][1]);
        edgeList.add(edges[4][3]);
        edgeList.add(edges[3][2]);
        vertices[4][1].setEdges(edgeList);
        edgeList.clear();

        vertices[4][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        borderingHexes.add(hexes[1][5]);
        edgeList.add(edges[4][5]);
        edgeList.add(edges[3][6]);
        edgeList.add(edges[4][7]);
        vertices[4][3].setEdges(edgeList);
        edgeList.clear();

        vertices[4][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        borderingHexes.add(hexes[1][7]);
        edgeList.add(edges[4][9]);
        edgeList.add(edges[3][10]);
        edgeList.add(edges[4][11]);
        vertices[4][5].setEdges(edgeList);
        edgeList.clear();

        vertices[4][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        edgeList.add(edges[4][13]);
        edgeList.add(edges[4][15]);
        edgeList.add(edges[3][14]);
        vertices[4][7].setEdges(edgeList);
        edgeList.clear();

        vertices[4][9] = new Vertex(borderingHexes);
        edgeList.add(edges[4][17]);
        edgeList.add(edges[4][19]);
        edgeList.add(edges[3][18]);
        vertices[4][9].setEdges(edgeList);
        edgeList.clear();

        //sixth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        vertices[5][0] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[1][1]);
        borderingHexes.add(hexes[2][2]);
        edgeList.add(edges[5][0]);
        edgeList.add(edges[4][1]);
        vertices[5][0].setEdges(edgeList);
        edgeList.clear();

        vertices[5][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][3]);
        borderingHexes.add(hexes[2][4]);
        edgeList.add(edges[4][5]);
        edgeList.add(edges[4][3]);
        edgeList.add(edges[5][4]);
        vertices[5][2].setEdges(edgeList);
        edgeList.clear();

        vertices[5][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][5]);
        borderingHexes.add(hexes[2][6]);
        edgeList.add(edges[5][8]);
        edgeList.add(edges[4][7]);
        edgeList.add(edges[4][9]);
        vertices[5][4].setEdges(edgeList);
        edgeList.clear();

        vertices[5][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[1][7]);
        borderingHexes.add(hexes[2][8]);
        edgeList.add(edges[4][11]);
        edgeList.add(edges[5][12]);
        edgeList.add(edges[4][13]);
        vertices[5][6].setEdges(edgeList);
        edgeList.clear();


        vertices[5][8] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        edgeList.add(edges[4][15]);
        edgeList.add(edges[4][17]);
        edgeList.add(edges[5][16]);
        vertices[5][8].setEdges(edgeList);
        edgeList.clear();

        vertices[5][10] = new Vertex(borderingHexes);
        edgeList.add(edges[4][19]);
        edgeList.add(edges[5][20]);
        vertices[5][10].setEdges(edgeList);
        edgeList.clear();

        //seventh row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        vertices[6][0] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[3][1]);
        borderingHexes.add(hexes[2][2]);
        edgeList.add(edges[6][1]);
        edgeList.add(edges[5][0]);
        vertices[6][0].setEdges(edgeList);
        edgeList.clear();

        vertices[6][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][3]);
        borderingHexes.add(hexes[2][4]);
        edgeList.add(edges[6][3]);
        edgeList.add(edges[5][4]);
        edgeList.add(edges[6][5]);
        vertices[6][2].setEdges(edgeList);
        edgeList.clear();

        vertices[6][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        borderingHexes.add(hexes[2][6]);
        edgeList.add(edges[6][7]);
        edgeList.add(edges[5][8]);
        edgeList.add(edges[6][9]);
        vertices[6][4].setEdges(edgeList);
        edgeList.clear();

        vertices[6][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][7]);
        borderingHexes.add(hexes[2][8]);
        edgeList.add(edges[6][11]);
        edgeList.add(edges[5][12]);
        edgeList.add(edges[6][13]);
        vertices[6][6].setEdges(edgeList);
        edgeList.clear();

        vertices[6][8] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        edgeList.add(edges[6][15]);
        edgeList.add(edges[5][16]);
        edgeList.add(edges[6][17]);
        vertices[6][8].setEdges(edgeList);
        edgeList.clear();

        vertices[6][10] = new Vertex(borderingHexes);
        edgeList.add(edges[6][19]);
        edgeList.add(edges[5][20]);
        vertices[6][10].setEdges(edgeList);
        edgeList.clear();

        //eighth row
        borderingHexes.clear();
        borderingHexes.add(hexes[2][0]);
        borderingHexes.add(hexes[3][1]);
        vertices[7][1] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][2]);
        borderingHexes.add(hexes[3][3]);
        edgeList.add(edges[6][1]);
        edgeList.add(edges[7][2]);
        edgeList.add(edges[6][3]);
        vertices[7][1].setEdges(edgeList);
        edgeList.clear();

        vertices[7][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][4]);
        borderingHexes.add(hexes[3][5]);
        edgeList.add(edges[6][5]);
        edgeList.add(edges[7][6]);
        edgeList.add(edges[6][7]);
        vertices[7][3].setEdges(edgeList);
        edgeList.clear();

        vertices[7][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][6]);
        borderingHexes.add(hexes[3][7]);
        edgeList.add(edges[6][9]);
        edgeList.add(edges[7][10]);
        edgeList.add(edges[6][11]);
        vertices[7][5].setEdges(edgeList);
        edgeList.clear();

        vertices[7][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[2][8]);
        edgeList.add(edges[6][13]);
        edgeList.add(edges[7][14]);
        edgeList.add(edges[6][15]);
        vertices[7][7].setEdges(edgeList);
        edgeList.clear();


        vertices[7][9] = new Vertex(borderingHexes);
        edgeList.add(edges[6][17]);
        edgeList.add(edges[7][18]);
        edgeList.add(edges[6][19]);
        vertices[7][9].setEdges(edgeList);
        edgeList.clear();

        //ninth row
        borderingHexes.clear();
        borderingHexes.add(hexes[3][1]);
        vertices[8][1] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[4][2]);
        borderingHexes.add(hexes[3][3]);
        edgeList.add(edges[7][2]);
        edgeList.add(edges[8][3]);
        vertices[8][1].setEdges(edgeList);
        edgeList.clear();

        vertices[8][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][4]);
        borderingHexes.add(hexes[3][5]);
        edgeList.add(edges[7][6]);
        edgeList.add(edges[8][5]);
        edgeList.add(edges[8][7]);
        vertices[8][3].setEdges(edgeList);
        edgeList.clear();

        vertices[8][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        borderingHexes.add(hexes[3][7]);
        edgeList.add(edges[7][10]);
        edgeList.add(edges[8][9]);
        edgeList.add(edges[8][11]);
        vertices[8][5].setEdges(edgeList);
        edgeList.clear();

        vertices[8][7] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        edgeList.add(edges[7][14]);
        edgeList.add(edges[8][13]);
        edgeList.add(edges[8][15]);
        vertices[8][7].setEdges(edgeList);
        edgeList.clear();

        vertices[8][9] = new Vertex(borderingHexes);
        edgeList.add(edges[8][17]);
        edgeList.add(edges[7][18]);
        vertices[8][9].setEdges(edgeList);
        edgeList.clear();

        //tenth row
        borderingHexes.clear();
        borderingHexes.add(hexes[3][1]);
        borderingHexes.add(hexes[4][2]);
        vertices[9][2] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][3]);
        borderingHexes.add(hexes[4][4]);
        edgeList.add(edges[9][4]);
        edgeList.add(edges[8][3]);
        edgeList.add(edges[8][5]);
        vertices[9][2].setEdges(edgeList);
        edgeList.clear();

        vertices[9][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[3][5]);
        borderingHexes.add(hexes[4][6]);
        edgeList.add(edges[9][8]);
        edgeList.add(edges[8][7]);
        edgeList.add(edges[8][9]);
        vertices[9][2].setEdges(edgeList);
        edgeList.clear();

        vertices[9][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.remove(0);
        edgeList.add(edges[9][12]);
        edgeList.add(edges[8][11]);
        edgeList.add(edges[8][13]);
        vertices[9][6].setEdges(edgeList);
        edgeList.clear();

        vertices[9][8] = new Vertex(borderingHexes);
        edgeList.add(edges[9][16]);
        edgeList.add(edges[8][15]);
        edgeList.add(edges[8][17]);
        vertices[9][8].setEdges(edgeList);
        edgeList.clear();

        //eleventh row
        borderingHexes.clear();
        borderingHexes.add(hexes[4][2]);
        vertices[10][2] = new Vertex(borderingHexes);
        borderingHexes.add(hexes[4][4]);
        edgeList.add(edges[10][5]);
        edgeList.add(edges[9][4]);
        vertices[10][2].setEdges(edgeList);
        edgeList.clear();

        vertices[10][4] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        edgeList.add(edges[9][8]);
        edgeList.add(edges[10][7]);
        edgeList.add(edges[10][9]);
        vertices[10][4].setEdges(edgeList);
        edgeList.clear();

        vertices[10][6] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        edgeList.add(edges[10][11]);
        edgeList.add(edges[9][12]);
        edgeList.add(edges[10][13]);
        vertices[10][6].setEdges(edgeList);
        edgeList.clear();

        vertices[10][8] = new Vertex(borderingHexes);
        edgeList.add(edges[10][15]);
        edgeList.add(edges[9][16]);
        vertices[10][8].setEdges(edgeList);
        edgeList.clear();

        //twelfth row
        borderingHexes.clear();
        borderingHexes.add(hexes[4][2]);
        vertices[11][3] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][4]);
        edgeList.add(edges[10][5]);
        edgeList.add(edges[10][7]);
        vertices[11][3].setEdges(edgeList);
        edgeList.clear();

        vertices[11][5] = new Vertex(borderingHexes);
        borderingHexes.remove(0);
        borderingHexes.add(hexes[4][6]);
        edgeList.add(edges[10][9]);
        edgeList.add(edges[10][11]);
        vertices[11][5].setEdges(edgeList);
        edgeList.clear();

        vertices[11][7] = new Vertex(borderingHexes);
        edgeList.add(edges[10][13]);
        edgeList.add(edges[10][15]);
        vertices[11][7].setEdges(edgeList);
        edgeList.clear();
        
    }

    public List<Location> getHexesWithNumber(int number)
    {
        ArrayList<Location> hexesWithNumber = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (hexes[i][j].number == number)
                {
                    hexesWithNumber.add(new Location(i, j));
                }
            }
        }
        return hexesWithNumber;
    }

    public List<Vertex> getVertices(Location location)
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

    public ResourceType getResource(Location location)
    {
        return hexes[location.row][location.col].type;
    }

    public Location findRobber()
    {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (hexes[i][j].hasRobber)
                {
                    return new Location(i, j);
                }
            }

        }
        return null;
    }
}
