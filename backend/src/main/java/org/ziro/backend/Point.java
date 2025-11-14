package org.ziro.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Point {
    @Id
    private long id;
    private double x;
    private double y;
    private double r;
    public boolean isHit;
    public String startTime;
    public double executionTime;

    public Point() {}

    public Point(double x, double y, double r, boolean isHit, String startTime, double executionTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
        this.startTime = startTime;
        this.executionTime = executionTime;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }

}
