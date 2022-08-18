package Class3.model;

public class Affiliate extends Seller {

    public Affiliate(String name) {
        super(name);
    }

    @Override
    public String showCategory() {
        int finalScore = salesMade * 15;
        String category = "";

        if(finalScore < 20) {
            category = "Newbie";
        } else if(finalScore >= 20 && finalScore <= 30) {
            category = "Trainee";
        } else if(finalScore >= 31 && finalScore <= 40) {
            category = "Good";
        } else {
            category = "Master";
        }

        String message = name + " has a score of " + finalScore
                + " points and categorize as " + category;
        return message;
    }
}
