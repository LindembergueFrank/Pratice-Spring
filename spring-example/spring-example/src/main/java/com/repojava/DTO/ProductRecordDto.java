package com.repojava.DTO;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public record ProductRecordDto (@NotBlank String name, @NotBlank String description , @NotNull BigDecimal price){
    
}
