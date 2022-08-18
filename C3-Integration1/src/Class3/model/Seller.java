package Class3.model;

public abstract class Seller {
    protected String name;
    protected int salesMade;

    public Seller(String name) {
        this.name = name;
    }

    public void sell(int sales) {
        this.salesMade += sales;
    }

    public abstract String showCategory();
}
