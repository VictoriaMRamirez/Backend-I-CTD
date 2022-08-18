package Class12.ExerciseDAO.model;

public class Medicine {
    private Long id;
    private String name;
    private String factory;

    public Medicine(Long id, String name, String factory) {
        this.id = id;
        this.name = name;
        this.factory = factory;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFactory() { return factory; }

    public void setFactory(String factory) { this.factory = factory; }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                '}';
    }
}
