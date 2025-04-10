package bai1_7;

public class Test {
	public static void main(String[] args) {
		Date d1 = new Date(14, 12, 2014);
        System.out.println(d1);  // toString()

        // Test Setters and Getters
        d1.setMonth(12);
        d1.setDay(14);
        d1.setYear(2014);
        System.out.println(d1);  // toString()
        System.out.println("Month: " + d1.getMonth());
        System.out.println("Day: " + d1.getDay());
        System.out.println("Year: " + d1.getYear());

        // Test setDate()
        d1.setDate(3, 4, 2016);
        System.out.println(d1);  // toString()
	}

}
