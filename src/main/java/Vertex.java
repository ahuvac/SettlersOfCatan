import java.util.List;

public class Vertex {
    private List<Hex> hexes;
    private List<Edge> edges;
    private Settlement settlement = null;
    private City city = null;

    public Vertex(List<Hex> hexes)
    {
        this.hexes = hexes;
    }


    public List<Hex> getHexes()
    {
        return hexes;
    }

    public void buildSettlement(Settlement settlement)
    {
        if (!hasSettlement() && !hasCity())
        {
            this.settlement = settlement;
        }
    }

    public void buildCity(City city)
    {
        if (hasSettlement() && settlement.getColor() == city.getColor())
        {
            this.settlement = null;
            this.city = city;
        }
    }

    public boolean hasCity()
    {
        return city != null;
    }

    public boolean hasSettlement()
    {
        return settlement != null;
    }


    public Color getCityColor()
    {
        if (hasCity()) {
            return city.getColor();
        }
        else
        {
            return null;
        }
    }

    public Color getSettlementColor()
    {
        if (hasSettlement()) {
            return settlement.getColor();
        }
        else
        {
            return null;
        }
    }

    public void setEdges(List<Edge> edgeList){
        this.edges = edgeList;
        for(Edge edge : edgeList){
            edge.setVertices(this);
        }

    }

    public List<Edge> getEdges(){
        return this.edges;
    }

}
