package com.sixthTask;

public class Main {

    static int start_x1, start_y1, start_x2, start_y2, xSpeed, ySpeed;

    public static void main(String[] args) {

        MovableRectangle movableRectangle = null;

        while (true) {

            Integer navigationVar = MyInput.inputInteger("""
                    Navigation menu:
                    Enter 1 to init a movable rectangle.
                    Enter 2 to move a rectangle.
                    Enter 3 to see the movable rectangle information.
                    Enter any other digit to stop the program.""", Integer::valueOf);

            switch (navigationVar) {
                case 1: {
                    input();

                    try {
                        movableRectangle = new MovableRectangle(start_x1, start_y1, start_x2, start_y2, xSpeed, ySpeed);
                    } catch (MyException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        if (!movableRectangle.isFilled()) throw new NullPointerException();
                    } catch (NullPointerException ex) {
                        System.err.println("Rectangle was not initialized.");
                        System.exit(1);
                    }

                    Integer subnavigationVar = MyInput.inputInteger("""
                            Navigation menu:
                            Enter 1 to move up.
                            Enter 2 to move down.
                            Enter 3 to move left.
                            Enter 4 to move right.
                            Enter any other digit to return.""", Integer::valueOf);
                    switch (subnavigationVar) {
                        case 1:
                            movableRectangle.moveUp();
                            break;
                        case 2:
                            movableRectangle.moveDown();
                            break;
                        case 3:
                            movableRectangle.moveLeft();
                            break;
                        case 4:
                            movableRectangle.moveRight();
                            break;
                        default:
                            System.out.println("Returning to the main menu...");
                            break;
                    }
                    break;
                }
                case 3:
                    try {
                        if (!movableRectangle.isFilled()) throw new NullPointerException();
                    } catch (NullPointerException ex) {
                        System.err.println("Rectangle was not initialized.");
                        System.exit(1);
                    }
                    System.out.println(movableRectangle);
                    break;
                default:
                    System.out.println("Executing the program...");
                    System.exit(1);
                    break;
            }
        }
    }

    private static void input() {
        start_x1 = MyInput.inputInteger("Enter the x start coordinate of top left point", Integer::valueOf);
        start_y1 = MyInput.inputInteger("Enter the y start coordinate of top left point", Integer::valueOf);
        start_x2 = MyInput.inputInteger("Enter the x start coordinate of bottom right point", Integer::valueOf);
        start_y2 = MyInput.inputInteger("Enter the y start coordinate of bottom right point", Integer::valueOf);
        xSpeed = MyInput.inputInteger("Enter the value of the projection of the point speed on the x coordinate line", Integer::valueOf);
        ySpeed = MyInput.inputInteger("Enter the value of the projection of the point speed on the y coordinate line", Integer::valueOf);
    }
}
