package bai6_6;

public class Test {
	public static void main(String[] args) {
		Cat myCat = new Cat("Whiskers");
        Dog myDog = new Dog("Buddy");
        BigDog myBigDog = new BigDog("Max");

        myCat.greets(); // Output: Meow
        myDog.greets(); // Output: Woof
        myDog.greets(myDog); // Output: Woooof
        myBigDog.greets(); // Output: Wooow
        myBigDog.greets(myDog); // Output: Wooooooow
        myBigDog.greets(myBigDog); // Output: Woo0000000w
	}
}
