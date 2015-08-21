package com.regrowthStudios.JVox.graphics;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.math.vector.IVector4;
import com.regrowthStudios.JVox.utils.VBOUtils;

public class SpriteBatch {
    private int VBOID, TBOID, IBOID, VAOID;
    public IVector4 bbox = null;
    public int sx, sy, ex, ey;
    public Texture texture;
    public boolean usesVBO = false;

    public void init(IVector4 bbox) {
        this.bbox = bbox;

        byte[] idata = { 0, 1, 2, 2, 3, 0 };
        float[] vdata = { bbox.x, bbox.y, 0, bbox.x + bbox.z, bbox.y, 0, bbox.x + bbox.z, bbox.y + bbox.w, 0, bbox.x,
                bbox.y + bbox.w, 0 };
        float[] tdata = { sx, sy, texture.getWidth(), sy, texture.getWidth(), texture.getHeight(), sx, texture.getHeight() };

        VAOID = VBOUtils.createVAOID();
        VBOUtils.bindArray(VAOID);

        {
            FloatBuffer fb = BufferUtils.createFloatBuffer(12);
            fb.put(vdata);
            fb.flip();

            VBOID = VBOUtils.createVBOID();

            VBOUtils.bindBuffer(VBOID);
            VBOUtils.bufferData(VBOID, fb);
            GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, 0);
            VBOUtils.bindBuffer(0);
        }

        {
            FloatBuffer fb = BufferUtils.createFloatBuffer(8);
            fb.put(tdata);
            fb.flip();

            TBOID = VBOUtils.createVBOID();

            VBOUtils.bindBuffer(TBOID);
            VBOUtils.bufferData(TBOID, fb);
            GL11.glTexCoordPointer(2, GL11.GL_FLOAT, 0, 0);
            VBOUtils.bindBuffer(0);
        }

        {
            ByteBuffer bb = BufferUtils.createByteBuffer(6);
            bb.put(idata);
            bb.flip();

            IBOID = VBOUtils.createVBOID();

            VBOUtils.bindElementBuffer(IBOID);
            VBOUtils.bufferElementData(IBOID, bb);
            VBOUtils.bindElementBuffer(0);
        }

        VBOUtils.bindArray(0);
    }

    public void render() {
        texture.bind();

        if (usesVBO) {
            VBOUtils.bindArray(VAOID);
            // GL20.glEnableVertexAttribArray(0);
            // GL20.glEnableVertexAttribArray(1);

            VBOUtils.bindElementBuffer(IBOID);

            GL11.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, 0);

            VBOUtils.bindElementBuffer(0);

            // GL20.glDisableVertexAttribArray(0);
            // GL20.glDisableVertexAttribArray(1);
            VBOUtils.bindArray(0);
        } else {
            GL11.glBegin(GL11.GL_TRIANGLE_FAN);
            GL11.glTexCoord2f(sx, sy);
            GL11.glVertex2f(bbox.x, bbox.y);
            GL11.glTexCoord2f(texture.getWidth(), sy);
            GL11.glVertex2f(bbox.x + bbox.z, bbox.y);
            GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
            GL11.glVertex2f(bbox.x + bbox.z, bbox.y + bbox.w);
            GL11.glTexCoord2f(sx, texture.getHeight());
            GL11.glVertex2f(bbox.x, bbox.y + bbox.w);
            GL11.glEnd();
        }
    }
}
