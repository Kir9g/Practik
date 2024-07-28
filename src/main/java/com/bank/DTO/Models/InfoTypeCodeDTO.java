package com.bank.DTO.Models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.util.Set;

@Schema(description = "DTO для InfoTypeCodeEntity")
public class InfoTypeCodeDTO {

    @Schema(description = "ID", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger id;

    @Schema(description = "Название типа информации", example = "FIRR")
    @Size(max = 4,min = 4)
    @NotNull
    private String name;

    @Schema(description = "Описание типа информации", example = "This is a type description")
    @Size(min = 0,max = 500)
    @NotNull
    private String description;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}