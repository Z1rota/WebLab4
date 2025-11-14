package org.ziro.backend.repository;

import org.ziro.backend.models.Point;

public interface PointRepository {
    public void save(Point point);
    public Point findByUser(String user);
}
