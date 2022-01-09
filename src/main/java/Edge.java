import java.util.List;

public class Edge {
    private List<Hex> hexes;
    private Vertex[] vertices;
    private Road road = null;

    public Edge(List<Hex> hexes, Vertex[] vertices)
    {
        this.hexes = hexes;
        this.vertices = vertices;
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

}
