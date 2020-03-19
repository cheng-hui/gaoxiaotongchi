package tencent.com.gao_xiao_tong_chi.java.Entity;

public class User {
    private String user_head;//头像
    private String user_name;//昵称
    private String user_zhanghao;//账号
    private String user_password;//密码
    private String user_question;//密保问题
    private String user_answer;//密保答案
    //标签暂时写三个
    private String  user_labelone;
    private String  user_labeltwo;
    private String  user_labelthree;


    public User(String user_head, String user_name, String user_zhanghao, String user_password, String user_question,String user_answer) {
        this.user_head=user_head;
        this.user_name = user_name;
        this.user_zhanghao = user_zhanghao;
        this.user_password = user_password;
        this.user_question = user_question;
        this.user_answer = user_answer;
    }

    public String getUser_head() {
        return user_head;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_zhanghao() {
        return user_zhanghao;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_zhanghao(String user_zhanghao) {
        this.user_zhanghao = user_zhanghao;
    }

    public String getUser_answer() {
        return user_answer;
    }

    public String getUser_question() {
        return user_question;
    }

    public String getUser_labelone() {
        return user_labelone;
    }

    public void setUser_question(String user_question) {
        this.user_question = user_question;
    }

    public String getUser_labelthree() {
        return user_labelthree;
    }

    public String getUser_labeltwo() {
        return user_labeltwo;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public void setUser_labelone(String user_labelone) {
        this.user_labelone = user_labelone;
    }

    public void setUser_labelthree(String user_labelthree) {
        this.user_labelthree = user_labelthree;
    }

    public void setUser_labeltwo(String user_labeltwo) {
        this.user_labeltwo = user_labeltwo;
    }
    //String user_head, String user_name, String user_zhanghao, String user_password, String user_question,String user_answer
    @Override
    public String toString() {
        return "User{" +
                "user_head='" + user_head + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_zhanghao='" + user_zhanghao + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_question='" + user_question + '\'' +
                ", user_answer='" + user_answer + '\'' +
                '}';
    }
}

