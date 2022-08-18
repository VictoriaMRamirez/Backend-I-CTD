package Class2.Exercise2.model;

public class VeggieMenu extends Menu {
    private Double spices;
    private Double sauces;

    public VeggieMenu(Double basePrice, Double spices, Double sauces) {
        super(basePrice);
        this.spices = spices;
        this.sauces = sauces;
    }

    public Double getSpices() { return spices; }

    public Double getSauces() { return sauces; }

    @Override
    public Double extraCharges() {
        return (spices * 0.1) + (sauces * 2);
    }
}
