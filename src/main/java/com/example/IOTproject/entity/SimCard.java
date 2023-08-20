package com.example.IOTproject.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
public class SimCard {
    private int simID;
    private String operatorCode;
    private String simCountry;
    private String simStatus;
    @OneToOne(mappedBy = "simCard",cascade = CascadeType.ALL)
    private IOTdevice ioTdevice;

    public SimCard(int simID, String operatorCode, String simCountry, String simStatus) {
        this.simID = simID;
        this.operatorCode = operatorCode;
        this.simCountry = simCountry;
        this.simStatus = simStatus;
    }
    @Id
    @Column(name = "SIM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSimID() {
        return simID;
    }

    public void setSimID(int simID) {
        this.simID = simID;
    }
    @Basic
    @Column(name = "OPERATOR_CODE")
    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }
    @Basic
    @Column(name = "SIM_COUNTRY")
    public String getSimCountry() {
        return simCountry;
    }

    public void setSimCountry(String simCountry) {
        this.simCountry = simCountry;
    }
    @Basic
    @Column(name = "SIM_STATUS")
    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        this.simStatus = simStatus;
    }
}
