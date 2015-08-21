package com.regrowthStudios.JVox.math.vector;

public class Vector2 {
    public float x, y;

    public Vector2(Vector2 other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(float n) {
        this.x = this.y = n;
    }

    /* Adds */
    public void add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void add(float n) {
        this.x += n;
        this.y += n;
    }

    /* Subs */
    public void sub(Vector2 other) {
        this.x -= other.x;
        this.y -= other.y;
    }

    public void sub(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void sub(float n) {
        this.x -= n;
        this.y -= n;
    }

    /* Mults */
    public void mult(Vector2 other) {
        this.x *= other.x;
        this.y *= other.y;
    }

    public void mult(float x, float y) {
        this.x *= x;
        this.y *= y;
    }

    public void mult(float n) {
        this.x *= n;
        this.y *= n;
    }

    /* Devides */
    public void devide(Vector2 other) {
        this.x /= other.x;
        this.y /= other.y;
    }

    public void devide(float x, float y) {
        this.x /= x;
        this.y /= y;
    }

    public void devide(float n) {
        this.x /= n;
        this.y /= n;
    }
}