package com.rentalsystem.swp.Repositories;

import com.rentalsystem.swp.models.ItemProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemProfile, Integer> {
}
