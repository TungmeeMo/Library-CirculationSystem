package szu.library.cs.pojo;

import java.util.Date;

public class ReaderType {
    private Integer typeId;

    private String typeName;

    private Integer bookMaxmum;

    private Integer bookLimitedDay;

    private Integer validPeriod;

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


    public void setBookMaxmum(Integer bookMaxmum) {
        this.bookMaxmum = bookMaxmum;
    }

	public Integer getBookLimitedDay() {
		return bookLimitedDay;
	}

	public void setBookLimitedDay(Integer bookLimitedDay) {
		this.bookLimitedDay = bookLimitedDay;
	}

	public Integer getValidPeriod() {
		return validPeriod;
	}

	public void setValidPeriod(Integer validPeriod) {
		this.validPeriod = validPeriod;
	}

	public Integer getBookMaxmum() {
		return bookMaxmum;
	}

    
}