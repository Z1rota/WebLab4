package org.ziro.backend.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ziro.backend.dto.PointRequestDTO;
import org.ziro.backend.models.Point;
import org.ziro.backend.repository.PointRepository;
import org.ziro.backend.util.HitChecker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped
public class PointService {

    private final PointRepository pointRepository;
    private final HitChecker hitChecker;


    public PointService() {
        this.pointRepository = null;
        this.hitChecker = null;
    }
    @Inject
    public PointService(PointRepository pointRepository, HitChecker hitChecker) {
        this.pointRepository = pointRepository;
        this.hitChecker = hitChecker;
    }


    public Point addPoint(PointRequestDTO dtoPoint, String creator) {
        Long startTime = System.nanoTime();
        boolean isHit =hitChecker.isHit(dtoPoint.getX(),dtoPoint.getY(),dtoPoint.getR());
        Double executionTime = (System.nanoTime() - startTime)/1_000_000.0;
        String creationTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        Point point = new Point(
                dtoPoint.getX(),
                dtoPoint.getY(),
                dtoPoint.getR(),
                isHit,
                creationTime,
                executionTime,
                creator
        );
        Point savedPoint=pointRepository.save(point);

        return savedPoint;
    }

    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    public int deleteAllPoints() {
        return pointRepository.deleteAll();
    }
}
