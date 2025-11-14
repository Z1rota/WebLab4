package org.ziro.backend.repository;

import jakarta.data.repository.CrudRepository;
import org.ziro.backend.models.Point;

public interface PointRepository extends CrudRepository<Point, Long> {

    public Point findByUser(String user);
}
