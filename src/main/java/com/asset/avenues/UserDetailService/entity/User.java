package com.asset.avenues.UserDetailService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mobileNumber;
    private String email;
    private String productName;
    private String aacode;
    private String profession;
    private String loanType;
    private String homeLoanType;
    private String loanAgainstSecurities;

    public User() {
    }

    public User(Long id, String name, String mobileNumber, String email, String productName, String aacode, String profession, String loanType
            , String homeLoanType, String loanAgainstSecurities) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.productName = productName;
        this.aacode = aacode;
        this.profession = profession;
        this.loanType = loanType;
        this.homeLoanType = homeLoanType;
        this.loanAgainstSecurities = loanAgainstSecurities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAacode() {
        return aacode;
    }

    public void setAacode(String aacode) {
        this.aacode = aacode;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public String getHomeLoanType() {
        return homeLoanType;
    }
    public void setHomeLoanType(String homeLoanType) {
        this.homeLoanType = homeLoanType;
    }
    public String getLoanAgainstSecurities() {
        return loanAgainstSecurities;
    }
    public void setLoanAgainstSecurities(String loanAgainstSecurities) {
        this.loanAgainstSecurities = loanAgainstSecurities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", productName='" + productName + '\'' +
                ", aacode='" + aacode + '\'' +
                ", profession='" + profession + '\'' +
                ", loanType='" + loanType + '\'' +
                ", homeLoanType='" + homeLoanType + '\'' +
                ", loanAgainstSecurities='" + loanAgainstSecurities + '\'' +
                '}';
    }
}
