public class Robot {
    public int x;
    public int y;
    public Direction direct;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direct = Direction.UP;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirect() {
        return direct;
    }

    public void turnLeftL() {
        this.direct = switch (this.direct) {
            case UP -> Direction.LEFT;
            case RIGHT -> Direction.UP;
            case DOWN -> Direction.RIGHT;
            case LEFT -> Direction.DOWN;
        };
    }

    public void turnRightL() {
        this.direct = switch (this.direct) {
            case UP -> Direction.RIGHT;
            case RIGHT -> Direction.DOWN;
            case DOWN -> Direction.LEFT;
            case LEFT -> Direction.UP;
        };
    }

    public void stepForwardL() {
        int a = switch (this.direct) {
            case UP -> this.y++;
            case RIGHT -> this.x++;
            case DOWN -> this.y--;
            case LEFT -> this.x--;
        };
    }

    public static void moveRobot(int toX, int toY, Robot robot) {
        if (toX > 0) {
            robot.direct = Direction.RIGHT;
        } else {
            robot.direct = Direction.LEFT;
        }
        for (int i = 1; i <= Math.abs(toX); i++) {
            robot.stepForwardL();
        }
        if (toY > 0) {
            robot.direct = Direction.UP;
        } else {
            robot.direct = Direction.DOWN;
        }
        for (int i = 1; i <= Math.abs(toY); i++) {
            robot.stepForwardL();
        }
    }

    public void showPos() {
        System.out.println("X = " + this.x + "; Y = " + this.y);
    }
}
