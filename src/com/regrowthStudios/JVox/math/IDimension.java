//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package com.regrowthStudios.JVox.math;

/**
 * Provides read-only access to a {@link Dimension}.
 */
public interface IDimension extends Cloneable
{
    /**
     * Returns the magnitude in the x-dimension.
     */
    double width ();

    /**
     * Returns the magnitude in the y-dimension.
     */
    double height ();

    /**
     * Returns a mutable copy of this dimension.
     */
    Dimension clone ();
}
