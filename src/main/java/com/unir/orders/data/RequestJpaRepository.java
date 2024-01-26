package com.unir.orders.data;

import com.unir.orders.model.db.AddRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestJpaRepository extends JpaRepository<AddRequest, Long> {
}
