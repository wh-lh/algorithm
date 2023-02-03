public class Graph {
    private Integer start;
    private Integer weight;
    private Integer end;
    private Integer num;

    public Graph(Integer start, Integer weight, Integer end,Integer num) {
        this.start = start;
        this.weight = weight;
        this.end = end;
        this.num = num;

    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "start=" + start +
                ", weight=" + weight +
                ", end=" + end +
                ", num=" + num +
                '}';
    }
}
