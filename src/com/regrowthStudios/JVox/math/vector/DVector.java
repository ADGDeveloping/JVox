package com.regrowthStudios.JVox.math.vector;

public class DVector {
    public double x, y, z;

    public DVector(DVector other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public DVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DVector(double n) {
        this.x = this.y = this.z = n;
    }

    /* Adds */
    public void add(DVector other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }

    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void add(double n) {
        this.x += n;
        this.y += n;
        this.z += n;
    }

    /* Subs */
    public void sub(DVector other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }

    public void sub(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void sub(double n) {
        this.x -= n;
        this.y -= n;
        this.z -= n;
    }

    /* Mults */
    public void mult(DVector other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
    }

    public void mult(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
    }

    public void mult(double n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
    }

    /* Divides */
    public void divide(DVector other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
    }

    public void divide(double x, double y, double z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
    }

    public void divide(double n) {
        this.x /= n;
        this.y /= n;
        this.z /= n;
    }
}