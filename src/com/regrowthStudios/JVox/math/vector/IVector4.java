package com.regrowthStudios.JVox.math.vector;

public class IVector4 {
    public int x, y, z, w;

    public IVector4(IVector4 other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.w = other.w;
    }

    public IVector4(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public IVector4(int n) {
        this.x = this.y = this.z = this.w = n;
    }

    /* Adds */
    public void add(IVector4 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        this.w += other.w;
    }

    public void add(int x, int y, int z, int w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w += w;
    }

    public void add(int n) {
        this.x += n;
        this.y += n;
        this.z += n;
        this.w += n;
    }

    /* Subs */
    public void sub(IVector4 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        this.w -= other.w;
    }

    public void sub(int x, int y, int z, int w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w -= w;
    }

    public void sub(int n) {
        this.x -= n;
        this.y -= n;
        this.z -= n;
        this.w -= n;
    }

    /* Mults */
    public void mult(IVector4 other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
        this.w *= other.w;
    }

    public void mult(int x, int y, int z, int w) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        this.w *= w;
    }

    public void mult(int n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
        this.w *= n;
    }

    /* Divides */
    public void divide(IVector4 other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
        this.w /= other.w;
    }

    public void divide(int x, int y, int z, int w) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        this.w /= w;
    }

    public void divide(int n) {
        this.x /= n;
        this.y /= n;
        this.z /= n;
        this.w /= n;
    }
}