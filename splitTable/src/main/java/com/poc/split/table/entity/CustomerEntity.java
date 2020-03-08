package com.poc.split.table.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "customer", schema = "order")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String custNo;
    private String username;
    private String password;
    private short age;
    private Date birthday;
    private String idNo;
    private String email;
    private String mobile;
    private String city;
    private String bankCode;
    private String bankCard;
    private Date dateCreated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity customer = (CustomerEntity) o;
        return id == customer.id &&
                age == customer.age &&
                Objects.equals(custNo, customer.custNo) &&
                Objects.equals(username, customer.username) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(birthday, customer.birthday) &&
                Objects.equals(idNo, customer.idNo) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(mobile, customer.mobile) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(bankCode, customer.bankCode) &&
                Objects.equals(bankCard, customer.bankCard) &&
                Objects.equals(dateCreated, customer.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custNo, username, password, age, birthday, idNo, email, mobile, city, bankCode, bankCard, dateCreated);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", custNo='" + custNo + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", idNo='" + idNo + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", city='" + city + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
