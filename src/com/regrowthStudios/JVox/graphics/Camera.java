package com.regrowthStudios.JVox.graphics;

import com.regrowthStudios.JVox.math.Matrix4;
import com.regrowthStudios.JVox.math.Vector;

public class Camera {
    private float x = 0.0f, y = 0.0f;
    private float scaleX = 1.0f, scaleY = 1.0f;
    private Matrix4 matrix;
    private Matrix4 orthoMatrix;
    private int screenWidth;
    private int screenHeight;
    private boolean needsMatrixUpdate = true;
    
    public void init(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        needsMatrixUpdate = true;
        
        orthoMatrix = new Matrix4();
        matrix = new Matrix4();

        orthoMatrix.setToOrtho(0.0, screenWidth, 0.0, screenHeight, 0.0, 1000.0);
        
    }
    
    public void update() {
        if (needsMatrixUpdate) {
            Matrix4 tmp = new Matrix4();
            tmp.setToTranslation(-x + screenWidth / 2.0, -y + screenHeight / 2.0, 0.0);
            
            orthoMatrix.mult(tmp, matrix);
            needsMatrixUpdate = false;
        }
    }
    
    public Vector convertScreenToWorld(float x, float y) {
        x -= screenWidth / 2.0f;
        y -= screenHeight / 2.0f;
        x /= scaleX;
        y /= scaleY;
        x += this.x;
        y += this.y;
        System.out.printf("%f %f\n", x, y);
        return new Vector(x, y);
    }
    
    public Matrix4 getCameraMatrix() {
        return matrix;
    }
    
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        needsMatrixUpdate = true;
    }
    
    public void setScale(float sx, float sy) {
        this.scaleX = x;
        this.scaleY = y;
        needsMatrixUpdate = true;
    }
}
