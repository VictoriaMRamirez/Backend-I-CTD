package Class8.Exercise1;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        try {
            app.calculateAverage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        app.addIntegers(1);
        app.addIntegers(2);
        app.addIntegers(3);
        app.addIntegers(4);
        app.addIntegers(5);
        app.addIntegers(6);

        try {
            app.calculateAverage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        app.addIntegers(7);
        app.addIntegers(8);
        app.addIntegers(9);
        app.addIntegers(10);
        app.addIntegers(11);

        try {
            app.calculateAverage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
