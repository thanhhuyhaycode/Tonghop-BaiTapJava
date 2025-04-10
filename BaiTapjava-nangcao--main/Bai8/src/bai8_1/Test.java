package bai8_1;

public class Test {
	public static void main(String[] args) {
		 MyIntStack stack = new MyIntStack(3);

	        // Kiểm tra isEmpty() ban đầu
	        System.out.println("Stack is empty? " + stack.isEmpty());

	        // Thêm phần tử vào stack
	        System.out.println("Pushing 10: " + stack.push(10));
	        System.out.println("Pushing 20: " + stack.push(20));
	        System.out.println("Pushing 30: " + stack.push(30));

	        // Stack đã đầy, thử push thêm để kiểm tra mở rộng kích thước
	        System.out.println("Pushing 40 (should trigger resize): " + stack.push(40));

	        // Kiểm tra peek()
	        System.out.println("Top element (peek): " + stack.peek());

	        // Lấy phần tử ra khỏi stack
	        System.out.println("Popped: " + stack.pop());
	        System.out.println("Popped: " + stack.pop());

	        // Kiểm tra stack còn trống không
	        System.out.println("Stack is empty? " + stack.isEmpty());

	        // Tiếp tục pop cho đến khi rỗng
	        System.out.println("Popped: " + stack.pop());
	        System.out.println("Popped: " + stack.pop());

	        // Thử pop từ ngăn xếp rỗng để kiểm tra ngoại lệ
	        try {
	            System.out.println("Attempting to pop from empty stack...");
	            System.out.println("Popped: " + stack.pop());
	        } catch (IllegalStateException e) {
	            System.out.println("Exception caught: " + e.getMessage());
	        }
	    
	}

}
