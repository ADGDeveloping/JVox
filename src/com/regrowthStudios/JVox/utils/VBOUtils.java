package com.regrowthStudios.JVox.utils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class VBOUtils {
    public static int createVBOID() {
        return GL15.glGenBuffers();
    }

    public static int createVAOID() {
        return GL30.glGenVertexArrays();
    }

    public static void bufferData(int id, FloatBuffer buffer) {
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
    }

    public static void bufferElementData(int id, ByteBuffer buffer) {
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
    }

    public static void bindArray(int id) {
        GL30.glBindVertexArray(id);
    }

    public static void bindBuffer(int id) {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id);
    }

    public static void bindElementBuffer(int id) {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, id);
    }

    public static void deleteBuffer(int id) {
        GL15.glDeleteBuffers(id);
    }

    public static void deleteArray(int id) {
        GL30.glDeleteVertexArrays(id);
    }
}