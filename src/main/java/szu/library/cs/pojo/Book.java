package szu.library.cs.pojo;

import java.util.Date;

public class Book {
	
	private Integer id;
	
    private String bookId;

    private String typeId;
    
    private String typeName;

    private String bookName;

    private String authorName;

    private String publishingHouse;

    private Date publishingDate;

    private Date readerRegisterDate;

    private Integer isBorrowed;
    
    private String isBorrowedName;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

    public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse == null ? null : publishingHouse.trim();
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Date getReaderRegisterDate() {
        return readerRegisterDate;
    }

    public void setReaderRegisterDate(Date readerRegisterDate) {
        this.readerRegisterDate = readerRegisterDate;
    }

    public Integer getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Integer isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

	public String getIsBorrowedName() {
		return isBorrowedName;
	}

	public void setIsBorrowedName(String isBorrowedName) {
		this.isBorrowedName = isBorrowedName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
    
}