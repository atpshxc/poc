package com.poc.split.table.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "payment", schema = "order")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String payNo;
    private String status;
    private String custNo;
    private String orderNo;
    private BigDecimal amount;
    private Date dateCreated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
        PaymentEntity payment = (PaymentEntity) o;
        return id == payment.id &&
                Objects.equals(payNo, payment.payNo) &&
                Objects.equals(status, payment.status) &&
                Objects.equals(custNo, payment.custNo) &&
                Objects.equals(orderNo, payment.orderNo) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(dateCreated, payment.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payNo, status, custNo, orderNo, amount, dateCreated);
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", payNo='" + payNo + '\'' +
                ", status='" + status + '\'' +
                ", custNo='" + custNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
