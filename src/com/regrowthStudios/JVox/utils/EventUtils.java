package com.regrowthStudios.JVox.utils;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.regrowthStudios.JVox.math.vector.IVector2;

public class EventUtils {
    public static class KeyboardEvents {
        public static boolean keyDown(int key) {
            return Keyboard.isKeyDown(key);
        }

        public static boolean keyUp(int key) {
            return !Keyboard.isKeyDown(key);
        }

        public static boolean isKeyRepeatEvent(int key) {
            return Keyboard.isRepeatEvent();
        }

        public static int getKeyDown() {
            return Keyboard.getEventKey();
        }
    }

    public static class MouseEvents {
        public static boolean buttonDown(int button) {
            return Mouse.isButtonDown(button);
        }

        public static boolean buttonUp(int button) {
            return !Mouse.isButtonDown(button);
        }

        public static int getButton() {
            return Mouse.getEventButton();
        }

        public static IVector2 getPosition() {
            return new IVector2(Mouse.getX(), Mouse.getY());
        }
        
        public static IVector2 getPositionInvY() {
            return new IVector2(Mouse.getX(), Display.getHeight() - Mouse.getY());
        }

        public static IVector2 getMove() {
            return new IVector2(Mouse.getDX(), -Mouse.getDY());
        }

        public static boolean isMouseGrabbed() {
            return Mouse.isGrabbed();
        }

        public static void setMouseGrabbed() {
            Mouse.setGrabbed(!Mouse.isGrabbed());
        }

        public static void setMouseClip() {
            Mouse.setClipMouseCoordinatesToWindow(!Mouse.isClipMouseCoordinatesToWindow());
        }

        public static void setMousePosition(IVector2 pos) {
            Mouse.setCursorPosition(pos.x, pos.y);
        }

        public static void setCursor(Cursor cursor) {
            try {
                Mouse.setNativeCursor(cursor);
            } catch (LWJGLException e) {
                e.printStackTrace();
            }
        }
        
        public static void updateCursor()
        {
            Mouse.updateCursor();
        }
    }

    public static class EventState {
        public static int NONE = 0x00;
        public static int DOWN_LEFT = 0x01;
        public static int UP_LEFT = 0x02;
        public static int DOWN_MID = 0x04;
        public static int UP_MID = 0x08;
        public static int DOWN_RIGHT = 0x10;
        public static int UP_RIGHT = 0x20;
        public static int HOVER = 0x40;

        public static boolean checkFor(int flags, int flag) {
            return (flags & flag) == flag;
        }
    }
}
