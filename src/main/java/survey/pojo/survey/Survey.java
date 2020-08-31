package survey.pojo.survey;

import java.util.Date;

public class Survey {
    private int id;         //ID
    private String title;   //标题
    private String remark;  //描述
    private int bound;      //限制 0：不限制 1：IP限制
    private Date startTime; //开始时间
    private Date endTime;   //结束时间
    private int rules;      //权限 0：无 1：密码访问
    private String password;//密码
    private String url;     //调查问卷路径
    private int adminId;    //所属id
    private int status;     //状态集 0：未创建 1：创建 2：进行 3：结束

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getRules() {
        return rules;
    }

    public void setRules(int rules) {
        this.rules = rules;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
