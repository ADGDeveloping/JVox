package com.regrowthStudios.JVox.math.vector;

public class IVector2 {
    public int x, y;

    public IVector2(IVector2 other) {
        this.x = other.x;
        this.y = other.y;
    }

    public IVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IVector2(int n) {
        this.x = this.y = n;
    }

    /* Adds */
    public void add(IVector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void add(int n) {
        this.x += n;
        this.y += n;
    }

    /* Subs */
    public void sub(IVector2 other) {
        this.x -= other.x;
        this.y -= other.y;
    }

    public void sub(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void sub(int n) {
        this.x -= n;
        this.y -= n;
    }

    /* Mults */
    public void mult(IVector2 other) {
        this.x *= other.x;
        this.y *= other.y;
    }

    public void mult(int x, int y) {
        this.x *= x;
        this.y *= y;
    }

    public void mult(int n) {
        this.x *= n;
        this.y *= n;
    }

    /* divides */
    public void divide(IVector2 other) {
        this.x /= other.x;
        this.y /= other.y;
    }

    public void divide(int x, int y) {
        this.x /= x;
        this.y /= y;
    }

    public void divide(int n) {
        this.x /= n;
        this.y /= n;
    }
}