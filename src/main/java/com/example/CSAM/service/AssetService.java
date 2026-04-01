package com.example.CSAM.service;

import com.example.CSAM.dto.AssetRequest;
import com.example.CSAM.model.Asset;
import com.example.CSAM.repository.AssetRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssetService {
    private final AssetRepository repository;

    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public Asset createAsset(AssetRequest request) {
        Asset asset = new Asset();
        asset.setDeviceName(request.deviceName());
        asset.setIpAddress(request.ipAddress());
        asset.setOsType(request.osType());
        asset.setLastScanDate(LocalDate.now());

        // Domain Logic: Auto-flag legacy systems
        if (request.osType().equalsIgnoreCase("Windows 7") ||
                request.osType().equalsIgnoreCase("Legacy")) {
            asset.setSecurityStatus("Vulnerable");
        } else {
            asset.setSecurityStatus("Safe");
        }

        return repository.save(asset);
    }

    public List<Asset> getVulnerableAssets() {
        return repository.findBySecurityStatus("Vulnerable");
    }
}