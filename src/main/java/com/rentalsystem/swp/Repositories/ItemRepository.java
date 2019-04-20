package com.rentalsystem.swp.Repositories;

import com.rentalsystem.swp.models.ItemProfile;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemProfile, Integer> {
    List<ItemProfile> findAllByOwnerIs(String owner);
    List<ItemProfile> findAllByCategory(String category);
    List<ItemProfile> findAllByTimeSlots(String timeSlots);
    List<ItemProfile> findAllByTimeSlotsAndCategory(String timeSlots, String catedory);
}
