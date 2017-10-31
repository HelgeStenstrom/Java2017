/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3C;

public class Bag {
    private int height, width, length;

    // Jag har ingen äkta getter-metod i denna klass, för jag tuycker inte att det tillför något.
    // Istället har jag toString() och volume() som returnerar allt jag är intresserad av.
    // I någon mening är de getter-metoder, eftersom de inte manipulerar något data; inga sidoeffekter.

    Bag(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    int volume() {
        return height * width * length;
    }

    @Override
    public String toString() {
        return String.format("%dx%dx%d", height, width, length);
    }
}
