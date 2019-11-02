public class Vertex {

    private String value;

    public Vertex(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Vertex vertex1){
        if(vertex1.value.equals(this.value)){
            return true;
        }
        return false;
    }
}
