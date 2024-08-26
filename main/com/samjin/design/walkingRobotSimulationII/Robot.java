package com.samjin.design.walkingRobotSimulationII;

class Robot {

    private int width, height;
    private int x, y; // Robot's current position
    private int direction; // Current direction index in the order ["East", "North", "West", "South"]
    private String[] directions = {"East", "North", "West", "South"};
    private int perimeter; // Total perimeter length of the grid

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.direction = 0; // Start facing "East"
        this.perimeter = 2 * (width + height - 2); // Calculate the perimeter of the grid
    }

    public void step(int num) {
        num %= perimeter;

        while (num > 0) {
            if (direction == 0) { // Moving East
                int steps = Math.min(num, width - 1 - x);
                x += steps;
                num -= steps;
                if (x == width - 1 && num > 0) direction = 1;
            } else if (direction == 1) { // Moving North
                int steps = Math.min(num, height - 1 - y);
                y += steps;
                num -= steps;
                if (y == height - 1 && num > 0) direction = 2;
            } else if (direction == 2) { // Moving West
                int steps = Math.min(num, x);
                x -= steps;
                num -= steps;
                if (x == 0 && num > 0) direction = 3;
            } else if (direction == 3) { // Moving South
                int steps = Math.min(num, y);
                y -= steps;
                num -= steps;
                if (y == 0 && num > 0) direction = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};

    }

    public String getDir() {
        return directions[direction];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */