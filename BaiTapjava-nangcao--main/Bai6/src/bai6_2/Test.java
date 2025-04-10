package bai6_2;

public class Test {
	public static void main(String[] args) {
		GeometricObject c = new Circle(5);
        System.out.println(c);
        System.out.println("Area: " + c.getArea());
        System.out.println("Perimeter: " + c.getPerimeter());

        GeometricObject r = new Rectangle(4, 6);
        System.out.println(r);
        System.out.println("Area: " + r.getArea());
        System.out.println("Perimeter: " + r.getPerimeter());
	}

}
