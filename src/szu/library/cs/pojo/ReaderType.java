package szu.library.cs.pojo;

import java.util.Date;

public class ReaderType {
    private Integer typeId;

    private String typeName;

    private String bookMaxmum;

    private Date bookLimitedDay;

    private String validPeriod;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getBookMaxmum() {
        return bookMaxmum;
    }

    public void setBookMaxmum(String bookMaxmum) {
        this.bookMaxmum = bookMaxmum == null ? null : bookMaxmum.trim();
    }

    public Date getBookLimitedDay() {
        return bookLimitedDay;
    }

    public void setBookLimitedDay(Date bookLimitedDay) {
        this.bookLimitedDay = bookLimitedDay;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod == null ? null : validPeriod.trim();
    }
}