package com.iAnalyze.microservice.reportsservice.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer step;

    @Column(length = 10)
    private String type;

    private BigDecimal amount;

    @Column(length = 32)
    private String nameOrig;

    private BigDecimal oldBalanceOrg;

    private BigDecimal newBalanceOrig;

    @Column(length = 32)
    private String nameDest;

    private BigDecimal oldBalanceDest;

    private BigDecimal newBalanceDest;

    private Integer isFraud;

    private Integer isFlaggedFraud;

    public Transaction() {
    }

    public Transaction(Integer step, String type, BigDecimal amount, String nameOrig,
                             BigDecimal oldBalanceOrig, BigDecimal newBalanceOrig, String nameDest, BigDecimal oldBalanceDest,
                             BigDecimal newBalanceDest, Integer isFraud, Integer isFlaggedFraud) {
//        super();
        this.step = step;
        this.type = type;
        this.amount = amount;
        this.nameOrig = nameOrig;
        this.oldBalanceOrg = oldBalanceOrig;
        this.newBalanceOrig = newBalanceOrig;
        this.nameDest = nameDest;
        this.oldBalanceDest = oldBalanceDest;
        this.newBalanceDest = newBalanceDest;
        this.isFraud = isFraud;
        this.isFlaggedFraud = isFlaggedFraud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public void setNameOrig(String nameOrig) {
        this.nameOrig = nameOrig;
    }

    public BigDecimal getOldBalanceOrg() {
        return oldBalanceOrg;
    }

    public void setOldBalanceOrg(BigDecimal oldBalanceOrg) {
        this.oldBalanceOrg = oldBalanceOrg;
    }

    public BigDecimal getNewBalanceOrig() {
        return newBalanceOrig;
    }

    public void setNewBalanceOrig(BigDecimal newBalanceOrig) {
        this.newBalanceOrig = newBalanceOrig;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = nameDest;
    }

    public BigDecimal getOldBalanceDest() {
        return oldBalanceDest;
    }

    public void setOldBalanceDest(BigDecimal oldBalanceDest) {
        this.oldBalanceDest = oldBalanceDest;
    }

    public BigDecimal getNewBalanceDest() {
        return newBalanceDest;
    }

    public void setNewBalanceDest(BigDecimal newBalanceDest) {
        this.newBalanceDest = newBalanceDest;
    }

    public Integer getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(Integer isFraud) {
        this.isFraud = isFraud;
    }

    public Integer getIsFlaggedFraud() {
        return isFlaggedFraud;
    }

    public void setIsFlaggedFraud(Integer isFlaggedFraud) {
        this.isFlaggedFraud = isFlaggedFraud;
    }
}
