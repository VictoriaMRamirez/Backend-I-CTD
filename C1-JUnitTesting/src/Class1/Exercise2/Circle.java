package Class1.Exercise2;

public class Circle implements GeometricFigure {
    private double radio;

    public Circle(double radio) {
        this.radio = radio;
    }

    @Override
    public Boolean greaterThanZero() {
        return radio > 0;
    }

    @Override
    public String calculateArea() {
        String message = "";

        if(radio <= 0) {
            message = "The radio can't be 0.";
        } else {
            message = "The area of the circle is " + Math.PI * Math.pow(radio, 2) + " units.";
        }
        return message;
    }
}
