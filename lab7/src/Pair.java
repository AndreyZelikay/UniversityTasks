public class Pair {

    private Vertex vertex;
    private int distance;

    public Pair(Vertex vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }
}
