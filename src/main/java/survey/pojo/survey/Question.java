package survey.pojo.survey;

public class Question {
    private int id;         //ID
    private String title;   //标题
    private String remark;  //描述
    private int required;   //是否必填 0：不是 1：是
    private int type;       //类型 0：单选 1：多选 2：单行文本 3：多行文本
    private int surveyId;   //问卷Id

}
