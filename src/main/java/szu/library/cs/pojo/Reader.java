package szu.library.cs.pojo;

import java.util.Date;

public class Reader {
    private Integer readerId;

    private Integer readerType;
    
    private String readerTypeName;

    private String readerName;

    private Integer readerGender;
    
    private String readerGenderName;

    private String readerAddress;

    private String readerTelephone;

    private Date readerRegisterDate;

    private Integer readerBorrowbook;

    private Integer status;
    
    private String statusName;
    
    private Integer maxBookNum;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }


    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
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

	public Integer getReaderType() {
		return readerType;
	}

	public void setReaderType(Integer readerType) {
		this.readerType = readerType;
	}

	public Integer getReaderGender() {
		return readerGender;
	}

	public void setReaderGender(Integer readerGender) {
		this.readerGender = readerGender;
	}

	public String getReaderTypeName() {
		return readerTypeName;
	}

	public void setReaderTypeName(String readerTypeName) {
		this.readerTypeName = readerTypeName;
	}

	public String getReaderGenderName() {
		return readerGenderName;
	}

	public void setReaderGenderName(String readerGenderName) {
		this.readerGenderName = readerGenderName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getMaxBookNum() {
		return maxBookNum;
	}

	public void setMaxBookNum(Integer maxBookNum) {
		this.maxBookNum = maxBookNum;
	}
    
	
    
}