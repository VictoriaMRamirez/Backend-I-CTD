package Class3.model;

public class Trainee extends Seller {

    public Trainee(String name) {
        super(name);
    }

    @Override
    public String showCategory() {
        int finalScore = salesMade * 5;
        String category = "";

        if(finalScore < 50) {
            category = "Trainee newbie";
        } else {
            category = "Experienced trainee";
        }

        String message = name + " has a score of " + finalScore
                + " points and categorize as " + category;
        return message;
    }
}
