package com.regrowthStudios.JVox.math.vector;

public class DVector4 {
    public double x, y, z, w;

    public DVector4(DVector4 other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.w = other.w;
    }

    public DVector4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public DVector4(double n) {
        this.x = this.y = this.z = this.w = n;
    }

    /* Adds */
    public void add(DVector4 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        this.w += other.w;
    }

    public void add(double x, double y, double z, double w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w += w;
    }

    public void add(double n) {
        this.x += n;
        this.y += n;
        this.z += n;
        this.w += w;
    }

    /* Subs */
    public void sub(DVector4 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        this.w -= other.w;
    }

    public void sub(double x, double y, double z, double w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w -= w;
    }

    public void sub(double n) {
        this.x -= n;
        this.y -= n;
        this.z -= n;
        this.w -= n;
    }

    /* Mults */
    public void mult(DVector4 other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
        this.w *= other.w;
    }

    public void mult(double x, double y, double z, double w) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        this.w *= w;
    }

    public void mult(double n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
        this.w *= n;
    }

    /* Divides */
    public void divide(DVector4 other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
        this.w /= other.w;
    }

    public void divide(double x, double y, double z, double w) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        this.w /= w;
    }

    public void divide(double n) {
        this.x /= n;
        this.y /= n;
        this.z /= n;
        this.w /= n;
    }
}