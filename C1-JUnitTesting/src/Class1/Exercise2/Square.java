package Class1.Exercise2;

public class Square implements GeometricFigure {
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public Boolean greaterThanZero() {
        return size > 0;
    }

    @Override
    public String calculateArea() {
        String message = "";

        if(size <= 0) {
            message = "The size can't be 0.";
        } else {
            message = "The area of the square is " + Math.pow(size, 2) + " units.";
        }
        return message;
    }
}
