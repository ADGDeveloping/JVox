package com.regrowthStudios.JVox.math.vector;

public class IVector {
    public int x, y, z;

    public IVector(IVector other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public IVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public IVector(int n) {
        this.x = this.y = this.z = n;
    }

    /* Adds */
    public void add(IVector other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }

    public void add(int x, int y, int z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void add(int n) {
        this.x += n;
        this.y += n;
        this.z += n;
    }

    /* Subs */
    public void sub(IVector other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }

    public void sub(int x, int y, int z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void sub(int n) {
        this.x -= n;
        this.y -= n;
        this.z -= n;
    }

    /* Mults */
    public void mult(IVector other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
    }

    public void mult(int x, int y, int z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
    }

    public void mult(int n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
    }

    /* divides */
    public void divide(IVector other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
    }

    public void divide(int x, int y, int z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
    }

    public void divide(int n) {
        this.x /= n;
        this.y /= n;
        this.z /= n;
    }
}