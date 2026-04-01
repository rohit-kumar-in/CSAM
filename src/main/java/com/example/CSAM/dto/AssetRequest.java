package com.example.CSAM.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AssetRequest(
        @NotBlank(message = "Device name is required")
        String deviceName,

        @Pattern(regexp = "^(\\d{1,3}\\.){3}\\d{1,3}$", message = "Invalid IPv4 format")
        String ipAddress,

        @NotBlank(message = "OS Type is required")
        String osType
) {}