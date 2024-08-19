package com.javastart.springhomework.controllers.dto;

import com.javastart.springhomework.entity.Bill;

import java.math.BigDecimal;

public class BillResponseDTO {
    private Long billId;

    private BigDecimal amount;

    private boolean isDefault;

    public BillResponseDTO(Bill bill) {
        billId = bill.getBillId();
        amount = bill.getAmount();
        isDefault = bill.isDefault();
    }

    public BillResponseDTO(Long billId, BigDecimal amount, boolean isDefault) {
        this.billId = billId;
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

}
