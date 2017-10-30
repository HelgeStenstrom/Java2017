/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3C;

public class Bag {
    private int height, width, length;

    public Bag(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double volume() {
        return height * width * length;
    }

    @Override
    public String toString() {
        return String.format("%dx%dx%d", height, width, length);
    }
}
