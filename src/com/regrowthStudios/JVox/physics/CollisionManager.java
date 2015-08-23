package com.regrowthStudios.JVox.physics;

import java.util.ArrayList;

import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.utils.math.VectorHelper;

public class CollisionManager {
    private double TILE_WIDTH = 1.F;
    private double AGENT_RADIUS = 0.5F;
    private double AGENT_WIDTH = 1.F;

    public boolean collideWithLevel(Vector position) {
        ArrayList<Vector> collideTilePositions = new ArrayList<Vector>();

        // Check the four corners
        // First corner
        checkTilePosition(collideTilePositions, position.x, position.y);
        // Second Corner
        checkTilePosition(collideTilePositions, position.x + AGENT_WIDTH, position.y);

        // Third Corner
        checkTilePosition(collideTilePositions, position.x, position.y + AGENT_WIDTH);

        // Third Corner
        checkTilePosition(collideTilePositions, position.x + AGENT_WIDTH, position.y + AGENT_WIDTH);

        // Check if there was no collision
        if (collideTilePositions.size() == 0) {
            return false;
        }

        // Do the collision
        for (int i = 0; i < collideTilePositions.size(); i++) {
            collideWithTile(position, collideTilePositions.get(i));
        }

        return true;
    }

    public void checkTilePosition(ArrayList<Vector> collideTilePositions, double x, double y) {
        Vector gridPos = new Vector(Math.floor(x / TILE_WIDTH), Math.floor(y / TILE_WIDTH));

        // If we are outside the world, just return
        /*
         * f (gridPos.x < 0 || gridPos.x >= levelData[0].size() || gridPos.y < 0
         * || gridPos.y >= levelData.size()) { return; }
         * 
         * // If this is not an air tile, we should collide with it if
         * (levelData[gridPos.y][gridPos.x] != '.') {
         * collideTilePositions.push_back(gridPos * (double)TILE_WIDTH +
         * glm::vec2((double)TILE_WIDTH / 2.0f)); }
         */
    }
    
    void collideWithTile(Vector position, Vector tilePos) {
        double TILE_RADIUS = TILE_WIDTH / 2.0f;
        double MIN_DISTANCE = AGENT_RADIUS + TILE_RADIUS;

        Vector centerAgentPos = position.add(new Vector(AGENT_RADIUS, AGENT_RADIUS));
        Vector distVec = VectorHelper.sub(centerAgentPos, tilePos);
        
        double xDepth = MIN_DISTANCE - Math.abs(distVec.x);
        double yDepth = MIN_DISTANCE - Math.abs(distVec.y);

        if (xDepth > 0 && yDepth > 0) {
            if (Math.max(xDepth, 0.0f) < Math.max(yDepth, 0.0f)) {
                if (distVec.x < 0) {
                    position.x -= xDepth;
                } else {
                    position.x += xDepth;
                }
            } else {
                if (distVec.y < 0) {
                    position.y -= yDepth;
                } else {
                    position.y += yDepth;
                }
            }
        }
    }
}