package Class2.Exercise2.model;

public class ClassicMenu extends Menu {

    public ClassicMenu(Double basePrice) {
        super(basePrice);
    }

    @Override
    public Double extraCharges() {
        return 0.0;
    }
}
