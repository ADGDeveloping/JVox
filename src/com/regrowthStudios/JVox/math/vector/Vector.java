package com.regrowthStudios.JVox.math.vector;

public class Vector {
    public float x, y, z;

    public Vector(Vector other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(float n) {
        this.x = this.y = this.z = n;
    }

    /* Adds */
    public void add(Vector other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }

    public void add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void add(float n) {
        this.x += n;
        this.y += n;
        this.z += n;
    }

    /* Subs */
    public void sub(Vector other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }

    public void sub(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void sub(float n) {
        this.x -= n;
        this.y -= n;
        this.z -= n;
    }

    /* Mults */
    public void mult(Vector other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
    }

    public void mult(float x, float y, float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
    }

    public void mult(float n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
    }

    /* divides */
    public void divide(Vector other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
    }

    public void divide(float x, float y, float z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
    }

    public void divide(float n) {
        this.x /= n;
        this.y /= n;
        this.z /= n;
    }
}