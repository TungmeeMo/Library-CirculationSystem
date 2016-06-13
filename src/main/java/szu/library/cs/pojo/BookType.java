package szu.library.cs.pojo;

public class BookType {
    private Integer typeId;

    private String typeName;

    private String sourceBaseType;

    private String recordType;

    private String documentType;

    private String code;

    private String classIdMin;

    private String classIdMax;

    private String place;

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

    public String getSourceBaseType() {
        return sourceBaseType;
    }

    public void setSourceBaseType(String sourceBaseType) {
        this.sourceBaseType = sourceBaseType == null ? null : sourceBaseType.trim();
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType == null ? null : recordType.trim();
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType == null ? null : documentType.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getClassIdMin() {
        return classIdMin;
    }

    public void setClassIdMin(String classIdMin) {
        this.classIdMin = classIdMin == null ? null : classIdMin.trim();
    }

    public String getClassIdMax() {
        return classIdMax;
    }

    public void setClassIdMax(String classIdMax) {
        this.classIdMax = classIdMax == null ? null : classIdMax.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }
}