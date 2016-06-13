package szu.library.cs.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private Integer accountId;

    private Integer borrowId;

    private Integer itemId;

    private String itemName;

    private Date accountDate;

    private BigDecimal amount;

    private Integer staffId;

    private String workSate;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getWorkSate() {
        return workSate;
    }

    public void setWorkSate(String workSate) {
        this.workSate = workSate == null ? null : workSate.trim();
    }
}