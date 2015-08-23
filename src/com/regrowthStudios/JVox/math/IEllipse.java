//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package com.regrowthStudios.JVox.math;

/**
 * Provides read-only access to an {@link Ellipse}.
 */
public interface IEllipse extends IRectangularShape, Cloneable
{
    /** Returns a mutable copy of this ellipse. */
    Ellipse clone ();
}
