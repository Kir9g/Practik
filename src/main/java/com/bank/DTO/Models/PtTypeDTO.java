package com.bank.DTO.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
@Schema(description = "PtTypeDto")
public class PtTypeDTO {
    @Schema(description = "ID", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger id;

    @Schema(description = "Название типа изменения", example = "00")
    @Size(max = 2,min = 2)
    private String name;

    @Schema(description = "Описание типа изменения", example = "This is a change type description")
    @Size(min = 0,max = 500)
    private String description;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public @Size(max = 2, min = 2) String getName() {
        return name;
    }

    public void setName(@Size(max = 2, min = 2) String name) {
        this.name = name;
    }

    public @Size(min = 0, max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 0, max = 500) String description) {
        this.description = description;
    }
}
