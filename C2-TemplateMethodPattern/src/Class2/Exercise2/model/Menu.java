package Class2.Exercise2.model;

public abstract class Menu {
    private Double basePrice;

    public Menu(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getBasePrice() { return basePrice; }

    public abstract Double extraCharges();
}
