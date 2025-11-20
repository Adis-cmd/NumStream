package com.numberservice.numstream.repo;

import com.numberservice.numstream.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NumberRepository extends JpaRepository<Number, Long> {
    List<Number> findAllByOrderByValueAsc();
}
