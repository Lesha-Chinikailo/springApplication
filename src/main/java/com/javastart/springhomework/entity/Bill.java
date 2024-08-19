package com.javastart.springhomework.entity;

import com.javastart.springhomework.controllers.dto.BillRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    private BigDecimal amount;

    private boolean isDefault;

    public Bill(BigDecimal amount, boolean isDefault) {
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Bill(BillRequestDTO billRequestDTO){
        amount = billRequestDTO.getAmount();
        isDefault = billRequestDTO.isDefault();
    }

    public Bill() {
    }

    public Long getBillId() {
        return billId;
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

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", amount=" + amount +
                ", isDefault=" + isDefault +
                '}';
    }
}
