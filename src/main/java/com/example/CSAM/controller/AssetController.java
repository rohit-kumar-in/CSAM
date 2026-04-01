package com.example.CSAM.controller;

import com.example.CSAM.dto.AssetRequest;
import com.example.CSAM.model.Asset;
import com.example.CSAM.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @PostMapping
    public Asset addAsset(@Valid @RequestBody AssetRequest request) {
        return service.createAsset(request);
    }

    @GetMapping("/vulnerable")
    public List<Asset> getVulnerable() {
        return service.getVulnerableAssets();
    }
}