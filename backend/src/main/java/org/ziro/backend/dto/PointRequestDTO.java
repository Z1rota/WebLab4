package org.ziro.backend.dto;

public class PointRequestDTO {
    private double x;
    private double y;
    private double r;
    public PointRequestDTO() {}

    public PointRequestDTO(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
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
