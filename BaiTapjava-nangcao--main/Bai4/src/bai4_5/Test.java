package bai4_5;

public class Test {
	public static void main(String[] args) {
		Shape shape = new Shape("blue", false);
        System.out.println(shape);

        Circle circle = new Circle("red", true, 5.5);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());

        Rectangle rectangle = new Rectangle(4.0, 5.0, "yellow", false);
        System.out.println(rectangle);
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        Square square = new Square(3.0, "purple", true);
        System.out.println(square);
        square.setSide(4.0);
        System.out.println("Updated Square: " + square);
	}

}
