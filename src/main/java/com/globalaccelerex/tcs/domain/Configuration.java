package com.globalaccelerex.tcs.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "configId",nullable = false)
    private Long configId;

    @Column(name = "serialNo",nullable = false,unique = true)
    private String serialNo;

    private String merchantNo;

    private String merchantName;

    private String merchantAddress;

    private String merchantPhone;

    private String merchantType;

    private String terminalId;

    private String terminalOwner;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modified;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalOwner() {
        return terminalOwner;
    }

    public void setTerminalOwner(String terminalOwner) {
        this.terminalOwner = terminalOwner;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configId=" + configId +
                ", serialNo='" + serialNo + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantAddress='" + merchantAddress + '\'' +
                ", merchantPhone='" + merchantPhone + '\'' +
                ", merchantType='" + merchantType + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", terminalOwner='" + terminalOwner + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", created=" + created +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modified=" + modified +
                '}';
    }

    //    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "CREATED_DATE",  insertable = true, updatable = false)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "MODIFIED_DATE", insertable = false, updatable = true)
//    private Date modifiedDate;


}
