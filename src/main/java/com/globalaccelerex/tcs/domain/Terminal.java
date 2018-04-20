package com.globalaccelerex.tcs.domain;

import com.globalaccelerex.tcs.validation.checkUniqueSerialNo;
import com.globalaccelerex.tcs.validation.checkUniqueTerminalId;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "terminals")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "configId",nullable = false)
    private Long configId;

    //@checkUniqueSerialNo
    @NotBlank(message = "Serial No cannot be null")
    @Column(name = "serialNo",nullable = false,unique = true)
    private String serialNo;

    private String merchantNo;

    private String merchantName;

    //@Max(value = 50,message = "Merchant Address cannot be more than 50 character")
    private String merchantAddress;

    private String merchantPhone;

    private String merchantType;

    //@checkUniqueTerminalId
    @NotBlank(message = "Terminal Id cannot be null")
   // @Max(value = 8,message = "Terminal id cannot be more than 8 character")
    @Column(name = "terminalId",nullable = false,unique = true)
    private String terminalId;

    private String terminalOwner;


    private Long userId;

//    @CreatedBy
//    @Column(nullable = false, updatable = false)
//    private String createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column
    private LocalDateTime created;

//    @LastModifiedBy
//    @Column(nullable = false)
//    private String modifiedBy;

    @LastModifiedDate
    @CreationTimestamp
    @Column
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

//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }
//
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "configId=" + configId +
                ", serialNo='" + serialNo + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantAddress='" + merchantAddress + '\'' +
                ", merchantPhone='" + merchantPhone + '\'' +
                ", merchantType='" + merchantType + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", terminalOwner='" + terminalOwner + '\'' +
                ", userId='" + userId + '\'' +
                ", created=" + created +
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
