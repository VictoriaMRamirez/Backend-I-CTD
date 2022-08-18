package Class3;

import Class3.model.Affiliate;
import Class3.model.Employee;
import Class3.model.Seller;

public class Main {
    public static void main(String[] args) {
        // Modify main to test the logic of Template pattern.
        Employee employee = new Employee("Pedro", 3);
        Employee employee1 = new Employee("Maria", 1);
        employee.sell(2);
        employee1.sell(1);

        Seller affiliate = new Affiliate("John");
        Seller affiliate1 = new Affiliate("Lucia");
        Seller affiliate2 = new Affiliate("Santiago");
        affiliate.sell(4);
        affiliate1.sell(1);

        employee1.addAffiliate(affiliate);

        System.out.println(employee.showCategory());
        System.out.println(employee1.showCategory());
        System.out.println(affiliate.showCategory());
        System.out.println(affiliate1.showCategory());
        System.out.println(affiliate2.showCategory());
    }
}
