package com.bank.DTO.Models;

import com.bank.DB.AccRstrListEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Schema(description = "DTO для сущности Accounts")
public class AccountsDTO {

    @Schema(description = "Идентификатор аккаунта", example = "1")
    private BigInteger id;

    @Schema(description = "Номер счета", required = true, example = "12345678901234567890")
    @NotNull(message = "Account не может быть пустым")
    @Size(min = 20, max = 20, message = "Account должен содержать ровно 20 символов")
    private String account;

    @Schema(description = "Тип регулируемого аккаунта", required = true, example = "0123")
    @NotNull(message = "RegulationAccountType не может быть пустым")
    @Size(min = 4, max = 4, message = "RegulationAccountType должен содержать ровно 4 символа")
    private String regulationAccountType;

    @Schema(description = "Контрольный ключ", example = "12")
    @Size(min = 2, max = 2, message = "CK должен содержать ровно 2 символа")
    private String ck;

    @Schema(description = "BIC центрального банка", required = true, example = "123456789")
    @NotNull(message = "AccountCBRBIC не может быть пустым")
    @Size(min = 9, max = 9, message = "AccountCBRBIC должен содержать ровно 9 символов")
    private String accountCBRBIC;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Дата открытия счета", required = true, example = "2023-01-01")
    @NotNull(message = "DateIn не может быть пустым")
    private Date dateIn;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Дата закрытия счета", example = "2023-12-31")
    private Date dateOut;

    @Schema(description = "Статус счета", example = "0123")
    @Size(min = 4, max = 4, message = "AccountStatus должен содержать ровно 4 символа")
    private String accountStatus;

    @Schema(description = "Список ограничений аккаунта", accessMode = Schema.AccessMode.READ_ONLY)
    private Set<AccRstrListDTO> accRstrListDTOList;


    // Getters and setters

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegulationAccountType() {
        return regulationAccountType;
    }

    public void setRegulationAccountType(String regulationAccountType) {
        this.regulationAccountType = regulationAccountType;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getAccountCBRBIC() {
        return accountCBRBIC;
    }

    public void setAccountCBRBIC(String accountCBRBIC) {
        this.accountCBRBIC = accountCBRBIC;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Set<AccRstrListDTO> getAccRstrListDTOList() {
        return accRstrListDTOList;
    }

    public void setAccRstrListDTOList(Set<AccRstrListDTO> accRstrListDTOList) {
        this.accRstrListDTOList = accRstrListDTOList;
    }
}