package com.bank.DTO.Models;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.ChangeType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Schema(description = "DTO для представления информации о записи в справочнике BIC")
public class BicDirectoryDTO {

    @Schema(description = "Идентификатор записи", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger id;

    @Schema(description = "БИК", example = "123456789")
    private String BIC;

    @Schema(description = "Тип изменения", example = "ADD")
    private String changeType;

    @Schema(description = "Информация об участнике",accessMode = Schema.AccessMode.READ_ONLY)
    private ParticipantInfoDTO participantInfo;

    @Schema(description = "Список счетов",accessMode = Schema.AccessMode.READ_ONLY)
    private Set<AccountsDTO> accounts = new HashSet<>();

    @Schema(description = "Список SWBIC",accessMode = Schema.AccessMode.READ_ONLY)
    private Set<SWBICSDTO> swbics = new HashSet<>();


    // Getters and Setters

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public ParticipantInfoDTO getParticipantInfo() {
        return participantInfo;
    }

    public void setParticipantInfo(ParticipantInfoDTO participantInfo) {
        this.participantInfo = participantInfo;
    }

    public Set<AccountsDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountsDTO> accounts) {
        this.accounts = accounts;
    }

    public Set<SWBICSDTO> getSwbics() {
        return swbics;
    }

    public void setSwbics(Set<SWBICSDTO> swbics) {
        this.swbics = swbics;
    }

    @Override
    public String toString() {
        return "BicDirectoryDTO{" +
                "id=" + id +
                ", BIC='" + BIC + '\'' +
                ", changeType='" + changeType + '\'' +
                ", participantInfo=" + participantInfo +
                ", accounts=" + accounts +
                ", swbics=" + swbics +
                '}';
    }
}
