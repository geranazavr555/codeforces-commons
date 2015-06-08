package com.codeforces.commons.geometry;

import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.DoublePair;
import com.codeforces.commons.text.StringUtil;

import static java.lang.StrictMath.atan2;
import static java.lang.StrictMath.hypot;

/**
 * @author Maxim Shipko (sladethe@gmail.com)
 *         Date: 22.07.13
 */
public class Vector2D extends DoublePair {
    public static final double DEFAULT_EPSILON = 1.0E-6D;

    public Vector2D(double x, double y) {
        super(x, y);
    }

    public Vector2D(double x1, double y1, double x2, double y2) {
        super(x2 - x1, y2 - y1);
    }

    public Vector2D(Vector2D vector) {
        super(vector.getX(), vector.getY());
    }

    public double getX() {
        return getFirst();
    }

    public void setX(double x) {
        setFirst(x);
    }

    public double getY() {
        return getSecond();
    }

    public void setY(double y) {
        setSecond(y);
    }

    public Vector2D add(Vector2D vector) {
        setX(getX() + vector.getX());
        setY(getY() + vector.getY());
        return this;
    }

    public Vector2D subtract(Vector2D vector) {
        setX(getX() - vector.getX());
        setY(getY() - vector.getY());
        return this;
    }

    public Vector2D multiply(double factor) {
        setX(factor * getX());
        setY(factor * getY());
        return this;
    }

    public Vector2D normalize() {
        double length = hypot(getX(), getY());
        setX(getX() / length);
        setY(getY() / length);
        return this;
    }

    public double getAngle() {
        return atan2(getY(), getX());
    }

    public double getLength() {
        return hypot(getX(), getY());
    }

    public double getSquaredLength() {
        return getX() * getX() + getY() * getY();
    }

    public Vector2D copy() {
        return new Vector2D(this);
    }

    public boolean nearlyEquals(Vector2D vector, double epsilon) {
        return vector != null
                && NumberUtil.nearlyEquals(getX(), vector.getX(), epsilon)
                && NumberUtil.nearlyEquals(getY(), vector.getY(), epsilon);
    }

    public boolean nearlyEquals(Vector2D vector) {
        return nearlyEquals(vector, DEFAULT_EPSILON);
    }

    public boolean nearlyEquals(double x, double y, double epsilon) {
        return NumberUtil.nearlyEquals(getX(), x, epsilon)
                && NumberUtil.nearlyEquals(getY(), y, epsilon);
    }

    public boolean nearlyEquals(double x, double y) {
        return nearlyEquals(x, y, DEFAULT_EPSILON);
    }

    @Override
    public String toString() {
        return StringUtil.toString(this, false, "x", "y");
    }
}