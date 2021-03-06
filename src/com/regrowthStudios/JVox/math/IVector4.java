//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package com.regrowthStudios.JVox.math;

import java.nio.DoubleBuffer;

/**
 * Provides read-only access to a {@link Vector4}.
 */
public interface IVector4
{
    /** Returns the x-component of this vector. */
    double x ();

    /** Returns the y-component of this vector. */
    double y ();

    /** Returns the z-component of this vector. */
    double z ();

    /** Returns the w-component of this vector. */
    double w ();

    /**
     * Populates the supplied buffer with the contents of this vector.
     *
     * @return a reference to the buffer, for chaining.
     */
    DoubleBuffer get (DoubleBuffer buf);

    /**
     * Compares this vector to another with the provided epsilon.
     */
    boolean epsilonEquals (IVector4 other, double epsilon);

    /**
     * Negates this vector.
     *
     * @return a new vector containing the result.
     */
    Vector4 negate ();

    /**
     * Negates this vector, storing the result in the supplied object.
     *
     * @return a reference to the result, for chaining.
     */
    Vector4 negate (Vector4 result);

    /**
     * Absolute-values this vector.
     *
     * @return a new vector containing the result.
     */
    Vector4 abs ();

    /**
     * Absolute-values this vector, storing the result in the supplied object.
     *
     * @return a reference to the result, for chaining.
     */
    Vector4 abs (Vector4 result);

    /**
     * Multiplies this vector by a scalar.
     *
     * @return a new vector containing the result.
     */
    Vector4 mult (double v);

    /**
     * Multiplies this vector by a scalar and places the result in the supplied object.
     *
     * @return a reference to the result, for chaining.
     */
    Vector4 mult (double v, Vector4 result);

    /**
     * Multiplies this vector by a matrix (V * M).
     *
     * @return a new vector containing the result.
     */
    Vector4 mult (IMatrix4 matrix);

    /**
     * Multiplies this vector by a matrix (V * M) and stores the result in the object provided.
     *
     * @return a reference to the result vector, for chaining.
     */
    Vector4 mult (IMatrix4 matrix, Vector4 result);
}
