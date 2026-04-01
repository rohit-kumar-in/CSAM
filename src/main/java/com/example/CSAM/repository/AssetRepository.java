package com.example.CSAM.repository;

// CHANGE THIS LINE: It must match your project's actual package
import com.example.CSAM.model.Asset;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    // Custom query to find vulnerable devices
    List<Asset> findBySecurityStatus(String status);
}