package szu.library.cs.pojo;

import java.util.Date;

public class Reader {
    private Integer readerId;

    private String readerType;

    private String readerName;

    private String readerGender;

    private String readerAddress;

    private String readerTelephone;

    private Date readerRegisterDate;

    private Integer readerBorrowbook;

    private Integer status;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType == null ? null : readerType.trim();
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
    }

    public String getReaderGender() {
        return readerGender;
    }

    public void setReaderGender(String readerGender) {
        this.readerGender = readerGender == null ? null : readerGender.trim();
    }

    public String getReaderAddress() {
        return readerAddress;
    }

    public void setReaderAddress(String readerAddress) {
        this.readerAddress = readerAddress == null ? null : readerAddress.trim();
    }

    public String getReaderTelephone() {
        return readerTelephone;
    }

    public void setReaderTelephone(String readerTelephone) {
        this.readerTelephone = readerTelephone == null ? null : readerTelephone.trim();
    }

    public Date getReaderRegisterDate() {
        return readerRegisterDate;
    }

    public void setReaderRegisterDate(Date readerRegisterDate) {
        this.readerRegisterDate = readerRegisterDate;
    }

    public Integer getReaderBorrowbook() {
        return readerBorrowbook;
    }

    public void setReaderBorrowbook(Integer readerBorrowbook) {
        this.readerBorrowbook = readerBorrowbook;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}