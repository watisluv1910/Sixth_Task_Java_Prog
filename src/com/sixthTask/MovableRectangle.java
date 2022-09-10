package com.sixthTask;

import com.fifthTask.Movable;
import com.fifthTask.MovablePoint;
import com.fourthTask.Rectangle;

public class MovableRectangle extends Rectangle implements Movable {

    private MovablePoint topLeft;
    private MovablePoint bottonRight;

    MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) throws MyException {
        if (!AreEqual(xSpeed, ySpeed)) throw new MyException("Both directions speed should be equal.");

        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottonRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    private boolean AreEqual(int a, int b) {
        return a == b;
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottonRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottonRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottonRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottonRight.moveRight();
    }

    @Override
    public boolean isFilled() {
        return topLeft != null & bottonRight != null;
    }

    @Override
    public String toString() {
        return "MoveableRectangle{" +
                "topLeft=" + topLeft +
                ", bottonRight=" + bottonRight +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
