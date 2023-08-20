package com.example.IOTproject.Repository;

import com.example.IOTproject.entity.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimRepository extends JpaRepository<SimCard,Integer> {
}
