package com.poc.split.table.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Data
@Document(indexName = "orders", type = "docs", shards = 1, replicas = 0)
public class Order implements Serializable {
    @Id
    private long id;
    @Field(type = FieldType.Keyword)
    private String orderNo;
    @Field(type = FieldType.Keyword)
    private String custNo;
    @Field(type = FieldType.Double)
    private BigDecimal amount;
    @Field(type = FieldType.Keyword)
    private String orderStatus;
    @Field(type = FieldType.Integer)
    private int buyCount;
    @Field(type = FieldType.Keyword, index = false)
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateCreated;
    private String col0;
    private String col1;
    private String col2;
    private String col3;
    private String col4;
    private String col5;
    private String col6;
    private String col7;
    private String col8;
    private String col9;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCol0() {
        return col0;
    }

    public void setCol0(String col0) {
        this.col0 = col0;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3;
    }

    public String getCol4() {
        return col4;
    }

    public void setCol4(String col4) {
        this.col4 = col4;
    }

    public String getCol5() {
        return col5;
    }

    public void setCol5(String col5) {
        this.col5 = col5;
    }

    public String getCol6() {
        return col6;
    }

    public void setCol6(String col6) {
        this.col6 = col6;
    }

    public String getCol7() {
        return col7;
    }

    public void setCol7(String col7) {
        this.col7 = col7;
    }

    public String getCol8() {
        return col8;
    }

    public void setCol8(String col8) {
        this.col8 = col8;
    }

    public String getCol9() {
        return col9;
    }

    public void setCol9(String col9) {
        this.col9 = col9;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                buyCount == order.buyCount &&
                Objects.equals(orderNo, order.orderNo) &&
                Objects.equals(custNo, order.custNo) &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(remark, order.remark) &&
                Objects.equals(dateCreated, order.dateCreated) &&
                Objects.equals(col0, order.col0) &&
                Objects.equals(col1, order.col1) &&
                Objects.equals(col2, order.col2) &&
                Objects.equals(col3, order.col3) &&
                Objects.equals(col4, order.col4) &&
                Objects.equals(col5, order.col5) &&
                Objects.equals(col6, order.col6) &&
                Objects.equals(col7, order.col7) &&
                Objects.equals(col8, order.col8) &&
                Objects.equals(col9, order.col9);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNo, custNo, amount, orderStatus, buyCount, remark, dateCreated, col0, col1, col2, col3, col4, col5, col6, col7, col8, col9);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", custNo='" + custNo + '\'' +
                ", amount=" + amount +
                ", orderStatus='" + orderStatus + '\'' +
                ", buyCount=" + buyCount +
                ", remark='" + remark + '\'' +
                ", dateCreated=" + dateCreated +
                ", col0='" + col0 + '\'' +
                ", col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                ", col3='" + col3 + '\'' +
                ", col4='" + col4 + '\'' +
                ", col5='" + col5 + '\'' +
                ", col6='" + col6 + '\'' +
                ", col7='" + col7 + '\'' +
                ", col8='" + col8 + '\'' +
                ", col9='" + col9 + '\'' +
                '}';
    }
}
