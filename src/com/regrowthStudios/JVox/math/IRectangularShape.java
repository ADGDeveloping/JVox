//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package com.regrowthStudios.JVox.math;

/**
 * An interface implemented by {@link IShape} classes whose geometry is defined by a rectangular
 * frame. The framing rectangle <em>defines</em> the geometry, but may in some cases differ from
 * the <em>bounding</em> rectangle of the shape.
 */
public interface IRectangularShape extends IShape
{
    /** Returns the x-coordinate of the upper-left corner of the framing rectangle. */
    double x ();

    /** Returns the y-coordinate of the upper-left corner of the framing rectangle. */
    double y ();

    /** Returns the width of the framing rectangle. */
    double width ();

    /** Returns the height of the framing rectangle. */
    double height ();

    /** Returns the minimum x,y-coordinate of the framing rectangle. */
    Point min ();

    /** Returns the minimum x-coordinate of the framing rectangle. */
    double minX ();

    /** Returns the minimum y-coordinate of the framing rectangle. */
    double minY ();

    /** Returns the maximum x,y-coordinate of the framing rectangle. */
    Point max ();

    /** Returns the maximum x-coordinate of the framing rectangle. */
    double maxX ();

    /** Returns the maximum y-coordinate of the framing rectangle. */
    double maxY ();

    /** Returns the center of the framing rectangle. */
    Point center ();

    /** Returns the x-coordinate of the center of the framing rectangle. */
    double centerX ();

    /** Returns the y-coordinate of the center of the framing rectangle. */
    double centerY ();

    /** Returns a copy of this shape's framing rectangle. */
    Rectangle frame ();

    /** Initializes the supplied rectangle with this shape's framing rectangle.
     * @return the supplied rectangle. */
    Rectangle frame (Rectangle target);
}
