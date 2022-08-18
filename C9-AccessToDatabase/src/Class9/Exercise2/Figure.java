package Class9.Exercise2;

public class Figure {
    private Integer id;
    private String type;
    private String color;

    public Figure() {}

    public Figure(Integer id, String type, String color) {
        this.id = id;
        this.type = type;
        this.color = color;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return "Figure{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
