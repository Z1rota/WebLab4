package org.ziro.backend.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ziro.backend.repository.PointRepository;

@ApplicationScoped
public class PointService {

    private final PointRepository pointRepository;

    @Inject
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }
}
