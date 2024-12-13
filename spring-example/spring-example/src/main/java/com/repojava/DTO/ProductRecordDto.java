package com.repojava.DTO;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public record ProductRecordDto (@NotBlank String name, @NotNull BigDecimal price){
    
}
