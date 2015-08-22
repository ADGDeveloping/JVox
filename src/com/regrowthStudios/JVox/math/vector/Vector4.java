package com.regrowthStudios.JVox.math.vector;

public class Vector4 {
    public float x, y, z, w;

    public Vector4(Vector4 other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.w = other.w;
    }

    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(float n) {
        this.x = this.y = this.z = this.w = n;
    }

    /* Adds */
    public void add(Vector4 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        this.w += other.w;
    }

    public void add(float x, float y, float z, float w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w += w;
    }

    public void add(float n) {
        this.x += n;
        this.y += n;
        this.z += n;
        this.w += n;
    }

    /* Subs */
    public void sub(Vector4 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        this.w -= other.w;
    }

    public void sub(float x, float y, float z, float w) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.w -= w;
    }

    public void sub(float n) {
        this.x -= n;
        this.y -= n;
        this.z -= n;
        this.w -= n;
    }

    /* Mults */
    public void mult(Vector4 other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
        this.w *= other.w;
    }

    public void mult(float x, float y, float z, float w) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        this.w *= w;
    }

    public void mult(float n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
        this.w *= n;
    }

    /* Divides */
    public void divide(Vector4 other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
        this.w /= other.w;
    }

    public void divide(float x, float y, float z, float w) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        this.w /= w;
    }

    public void divide(float n) {
        this.x /= n;
        this.y /= n;
        this.z /= n;
        this.w /= n;
    }
}