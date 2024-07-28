package com.bank.DTO.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
@Schema(description = "DTO для SWBICS")
public class SWBICSDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "1")
    private BigInteger id;

    @Schema(description = "БИК (СВИФТ) (по справочнику СВИФТ, стандарт ИСО 9362).", example = "INEARUMMXXX")
    @Pattern(regexp = "^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$", message = "SWBIC должен соответствовать формату 4!a2!a2!c[3!c]")
    private String SWBIC;

    @Schema(description = "Признак использования БИК (СВИФТ), «по умолчанию».",example = "1")
    @Size(max = 1)
    private Boolean DefaultSWBIC;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        id = id;
    }

    public @Pattern(regexp = "^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$", message = "SWBIC должен соответствовать формату 4!a2!a2!c[3!c]") String getSWBIC() {
        return SWBIC;
    }

    public void setSWBIC(@Pattern(regexp = "^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$", message = "SWBIC должен соответствовать формату 4!a2!a2!c[3!c]") String SWBIC) {
        this.SWBIC = SWBIC;
    }

    public @Size(max = 1) Boolean getDefaultSWBIC() {
        return DefaultSWBIC;
    }

    public void setDefaultSWBIC(@Size(max = 1) Boolean defaultSWBIC) {
        DefaultSWBIC = defaultSWBIC;
    }
}
