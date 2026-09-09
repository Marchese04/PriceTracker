package com.Marchese.PriceTracker.product.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ProductResponseDTO(Long id,String name, String url, String store, BigDecimal targetPrice, OffsetDateTime createdAt) {
}
