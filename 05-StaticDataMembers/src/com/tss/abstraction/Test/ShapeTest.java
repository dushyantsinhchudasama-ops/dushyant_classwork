package com.tss.abstraction.Test;

import com.tss.abstraction.model.Circle;
import com.tss.abstraction.model.Rectangle;
import com.tss.abstraction.model.Shape;

public class ShapeTest {
    public static void main(String[] args) {

        Shape circle = new Circle(10);
        circle.calculateArea();

        Shape rectangle = new Rectangle(20,30);
        rectangle.calculateArea();
    }
}
