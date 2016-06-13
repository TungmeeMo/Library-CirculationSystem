package szu.library.cs.pojo;

public class UserSetting {
    private Integer id;

    private Integer staffId;

    private String staffKey;

    private String staffValue;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffKey() {
        return staffKey;
    }

    public void setStaffKey(String staffKey) {
        this.staffKey = staffKey == null ? null : staffKey.trim();
    }

    public String getStaffValue() {
        return staffValue;
    }

    public void setStaffValue(String staffValue) {
        this.staffValue = staffValue == null ? null : staffValue.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}