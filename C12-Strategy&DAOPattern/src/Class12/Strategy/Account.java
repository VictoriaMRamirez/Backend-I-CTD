package Class12.Strategy;

public class Account {
    private int number;
    private double balance;
    private ExtractionStrategy extractionStrategy;

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public ExtractionStrategy getExtractionStrategy() { return extractionStrategy; }

    public void setExtractionStrategy(ExtractionStrategy extractionStrategy) {
        this.extractionStrategy = extractionStrategy;
    }

    public boolean extract(double amount) {
        return extractionStrategy.extract(this, amount);
    }
}
