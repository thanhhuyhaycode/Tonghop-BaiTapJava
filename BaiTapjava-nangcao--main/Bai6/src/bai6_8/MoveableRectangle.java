package bai6_8;
class MovableRectangle implements Moveable {
    private MoveablePoint topLeft;
    private MoveablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MoveablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MoveablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public String toString() {
        return "MovableRectangle{ topLeft=" + topLeft + ", bottomRight=" + bottomRight + " }";
    }
}
