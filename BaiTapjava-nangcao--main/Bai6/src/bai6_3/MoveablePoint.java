package bai6_3;

public class MoveablePoint implements Moveable {
	private int x, y;
    private int xSpeed, ySpeed;

    public MoveablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getXSpeed() { return xSpeed; }
    public int getYSpeed() { return ySpeed; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setXSpeed(int xSpeed) { this.xSpeed = xSpeed; }
    public void setYSpeed(int ySpeed) { this.ySpeed = ySpeed; }

    @Override
    public void moveUp() { y -= ySpeed; }

    @Override
    public void moveDown() { y += ySpeed; }

    @Override
    public void moveLeft() { x -= xSpeed; }

    @Override
    public void moveRight() { x += xSpeed; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") speed=(" + xSpeed + ", " + ySpeed + ")";
    }

}
