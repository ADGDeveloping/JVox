package com.regrowthStudios.JVox.math.vector;

public class DVector2 {
    public double x, y;

    public DVector2(DVector2 other) {
        this.x = other.x;
        this.y = other.y;
    }

    public DVector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public DVector2(double n) {
        this.x = this.y = n;
    }

    /* Adds */
    public void add(DVector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(double n) {
        this.x += n;
        this.y += n;
    }

    /* Subs */
    public void sub(DVector2 other) {
        this.x -= other.x;
        this.y -= other.y;
    }

    public void sub(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void sub(double n) {
        this.x -= n;
        this.y -= n;
    }

    /* Mults */
    public void mult(DVector2 other) {
        this.x *= other.x;
        this.y *= other.y;
    }

    public void mult(double x, double y) {
        this.x *= x;
        this.y *= y;
    }

    public void mult(double n) {
        this.x *= n;
        this.y *= n;
    }

    /* Divides */
    public void divide(DVector2 other) {
        this.x /= other.x;
        this.y /= other.y;
    }

    public void divide(double x, double y) {
        this.x /= x;
        this.y /= y;
    }

    public void divide(double n) {
        this.x /= n;
        this.y /= n;
    }
}