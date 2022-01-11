import java.util.List;

public class Edge {
    private List<Hex> hexes;
    private List<Vertex> vertices;
    private Road road = null;

    public Edge(List<Hex> hexes)
    {
        this.hexes = hexes;
    }

    public boolean hasRoad()
    {
        return road != null;
    }

    public void buildRoad(Road road)
    {
        if (!hasRoad())
        {
            this.road = road;
        }
    }


    public Color getRoadColor()
    {
        return road.getColor();
    }


    public void setVertices(Vertex vertex){
        this.vertices.add(vertex);
    }

    public List<Vertex> getVertices(){
        return this.vertices;
    }



}
