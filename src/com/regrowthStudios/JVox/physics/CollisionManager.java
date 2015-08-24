package com.regrowthStudios.JVox.physics;

import java.util.ArrayList;

import com.regrowthStudios.JVox.entity.Entity;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.utils.math.VectorHelper;

public class CollisionManager {
    private double TILE_WIDTH = 1.F;

    public void collide(ArrayList<Entity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            Entity tmp = entities.get(i);

            // Collide with entities
            for (int j = i + 1; j < entities.size(); j++) {
                this.collideWithEntity(entities.get(i), entities.get(j));
            }
            
            // Collide with world
            {
                ArrayList<Vector> collideTilePositions = new ArrayList<Vector>();

                this.checkTilePosition(collideTilePositions, tmp.aabb.x, tmp.aabb.y);
                this.checkTilePosition(collideTilePositions, tmp.aabb.x + tmp.aabb.z, tmp.aabb.y);
                this.checkTilePosition(collideTilePositions, tmp.aabb.x, tmp.aabb.y + tmp.aabb.w);
                this.checkTilePosition(collideTilePositions, tmp.aabb.x + tmp.aabb.z, tmp.aabb.y + tmp.aabb.w);

                for (int k = 0; k < collideTilePositions.size(); k++) {
                    this.collideWithTile(tmp, collideTilePositions.get(k));
                }
            }
        }
    }

    private void checkTilePosition(ArrayList<Vector> collideTilePositions, double x, double y) {
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

    private void collideWithTile(Entity entity, Vector tilePos) {
        double TILE_RADIUS = TILE_WIDTH / 2.0f;
        double MIN_DISTANCEX = (entity.aabb.z / 2.F) + TILE_RADIUS;
        double MIN_DISTANCEY = (entity.aabb.w / 2.F) + TILE_RADIUS;

        Vector newPosition = new Vector(entity.aabb.x, entity.aabb.y);
        Vector centerAgentPos = newPosition.add(new Vector((entity.aabb.z / 2.F), (entity.aabb.w / 2.F)));
        Vector distVec = VectorHelper.sub(centerAgentPos, tilePos);

        double xDepth = MIN_DISTANCEX - Math.abs(distVec.x);
        double yDepth = MIN_DISTANCEY - Math.abs(distVec.y);

        if (xDepth > 0 && yDepth > 0) {
            if (Math.max(xDepth, 0.0f) < Math.max(yDepth, 0.0f)) {
                if (distVec.x < 0) {
                    newPosition.x -= xDepth;
                } else {
                    newPosition.x += xDepth;
                }
            } else {
                if (distVec.y < 0) {
                    newPosition.y -= yDepth;
                } else {
                    newPosition.y += yDepth;
                }
            }
        }

        entity.aabb.x = newPosition.x;
        entity.aabb.y = newPosition.y;
    }

    private void collideWithEntity(Entity e1, Entity e2) {
        double MIN_DISTANCEX = (e1.aabb.z / 2.F) + (e2.aabb.z / 2.F);
        double MIN_DISTANCEY = (e1.aabb.w / 2.F) + (e2.aabb.w / 2.F);
        
        {
            Vector newPosition = new Vector(e1.aabb.x, e1.aabb.y);
            Vector centerAgentPos = newPosition.add(new Vector((e1.aabb.z / 2.F), (e1.aabb.w / 2.F)));
            Vector distVec = VectorHelper.sub(centerAgentPos, new Vector(e2.aabb.x + (e2.aabb.z * 0.5f), e2.aabb.y + (e2.aabb.w * 0.5f)));

            double xDepth = (MIN_DISTANCEX - Math.abs(distVec.x)) / 2.F;
            double yDepth = (MIN_DISTANCEY - Math.abs(distVec.y)) / 2.F;

            if (xDepth > 0 && yDepth > 0) {
                if (Math.max(xDepth, 0.0f) < Math.max(yDepth, 0.0f)) {
                    if (distVec.x < 0) {
                        newPosition.x -= xDepth;
                    } else {
                        newPosition.x += xDepth;
                    }
                } else {
                    if (distVec.y < 0) {
                        newPosition.y -= yDepth;
                    } else {
                        newPosition.y += yDepth;
                    }
                }
            }

            e1.aabb.x = newPosition.x;
            e1.aabb.y = newPosition.y;
        }
        
        {
            Vector newPosition = new Vector(e2.aabb.x, e2.aabb.y);
            Vector centerAgentPos = newPosition.add(new Vector((e2.aabb.z / 2.F), (e2.aabb.w / 2.F)));
            Vector distVec = VectorHelper.sub(centerAgentPos, new Vector(e1.aabb.x + (e1.aabb.z * 0.5f), e1.aabb.y + (e1.aabb.w * 0.5f)));

            double xDepth = (MIN_DISTANCEX - Math.abs(distVec.x)) / 2.F;
            double yDepth = (MIN_DISTANCEY - Math.abs(distVec.y)) / 2.F;

            if (xDepth > 0 && yDepth > 0) {
                if (Math.max(xDepth, 0.0f) < Math.max(yDepth, 0.0f)) {
                    if (distVec.x < 0) {
                        newPosition.x -= xDepth;
                    } else {
                        newPosition.x += xDepth;
                    }
                } else {
                    if (distVec.y < 0) {
                        newPosition.y -= yDepth;
                    } else {
                        newPosition.y += yDepth;
                    }
                }
            }

            e2.aabb.x = newPosition.x;
            e2.aabb.y = newPosition.y;
        }
    }
}