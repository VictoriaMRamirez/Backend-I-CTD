package Class3.model;

public class Employee extends Seller {
    private int yearsOfService;
    private int affiliates;
    private int salesMade;

    public Employee(String name, int yearsOfService) {
        super(name);
        this.yearsOfService = yearsOfService;
    }

    public void addAffiliate(Seller affiliate) {
        if(affiliate !=null) {
            affiliates ++;
        }
    }

    @Override
    public String showCategory() {
        int finalScore = (affiliates * 10) + (salesMade * 5) + (yearsOfService * 5);
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
