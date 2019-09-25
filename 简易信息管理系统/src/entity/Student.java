package entity;

public class Student {
    private Long eid;
    private String number;
    private String name;
    private String academy;
    private String discipline;
    private String grade;
    private String age;

    public Student(){
        super();
    }

    public Student(String num,String name, String academy, String discipline, String grade, String age) {
        this.number=num;
        this.name = name;
        this.academy = academy;
        this.discipline = discipline;
        this.grade = grade;
        this.age = age;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String num){
        this.number = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
