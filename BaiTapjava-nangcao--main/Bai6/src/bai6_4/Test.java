package bai6_4;

public class Test {
	public static void main(String[] args) {
		MoveablePoint point = new MoveablePoint(2, 3, 1, 1);
        System.out.println(point);
        point.moveUp();
        point.moveRight();
        System.out.println(point);

        MoveableCircle circle = new MoveableCircle(5, 5, 2, 2, 10);
        System.out.println(circle);
        circle.moveDown();
        circle.moveLeft();
        System.out.println(circle);
	}

}
