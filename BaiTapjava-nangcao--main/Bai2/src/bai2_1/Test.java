package bai2_1;

public class Test {
	public static void main(String[] args) {
		Author author = new Author("John Doe", "john.doe@example.com", 'm');
        System.out.println(author);
        author.setEmail("new.email@example.com");
        System.out.println("Updated email: " + author);
}
}
