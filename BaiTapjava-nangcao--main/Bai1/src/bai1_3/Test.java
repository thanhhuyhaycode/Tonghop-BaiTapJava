package bai1_3;

public class Test {
	public static void main(String[] args) {
		Rectangle r1= new Rectangle(1.2f ,3.4f);
		r1.setLength(1.2f);
		r1.setWidth(3.4f);
		System.out.println(r1);
		r1.setLength(1.0f);
		r1.setWidth(1.0f);
		System.out.println(r1);
		r1.setLength(5.6f);
		r1.setWidth(7.8f);
		System.out.println(r1);
		System.out.println("length is :"+r1.getlength());
		System.out.println("width is :"+r1.getwidth());
		System.out.println("area="+r1.getArea());
		System.out.println("perimeter="+r1.getPerimeter());
	}
}
