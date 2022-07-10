package com.example.bikerent;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class BikeRepository {
    private final EntityManager entityManager;

    public BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Bike bike) {
        entityManager.persist(bike);

    }

    private boolean exists(Bike bike) {
        return entityManager.find(Bike.class, bike.getId()) != null;
    }

    public Optional<Bike> findById (Long id) {
        return Optional.ofNullable(entityManager.find(Bike.class, id));
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
