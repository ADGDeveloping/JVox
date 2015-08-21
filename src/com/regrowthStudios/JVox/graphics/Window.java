package com.regrowthStudios.JVox.graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.regrowthStudios.JVox.math.vector.IVector2;

public class Window {
    private String windowTitle = "JVox Application";
    private IVector2 windowDims = new IVector2(800, 600);
    
    public void init(String title, IVector2 dims)
    {
        this.windowTitle = title;
        this.windowDims = dims;
    }
    
    public void create() {
        try {
            Display.setDisplayMode(new DisplayMode(this.windowDims.x, this.windowDims.y));
            Display.setTitle(this.windowTitle);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }
}
