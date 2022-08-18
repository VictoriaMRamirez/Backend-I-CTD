package Class2.Exercise2.model;

public class ChildrenMenu extends Menu {
    private Double toys;

    public ChildrenMenu(Double basePrice, Double toys) {
        super(basePrice);
        this.toys = toys;
    }

    public Double getToys() { return toys; }

    @Override
    public Double extraCharges() {
        return toys * 3;
    }
}
