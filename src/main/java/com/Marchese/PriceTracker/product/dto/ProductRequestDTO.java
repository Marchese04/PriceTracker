package com.Marchese.PriceTracker.product.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, String url, String store, BigDecimal targetPrice) {


}
