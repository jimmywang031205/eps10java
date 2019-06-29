//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Students {
    private String firstName;
    private String lastName;
    private String Student_Number;
    private int Grade;
    private String Gender;
    private boolean Programming_12_Student;

    public Students() {
    }

    public void Students(String _firstName, String _lastName, String _Student_Number, int _Grade, String _Gender, boolean _Programming_12_Student) {
        this.setFirstName(_firstName);
        this.setLastName(_lastName);
        this.setStudent_Number(_Student_Number);
        this.setGrade(_Grade);
        this.setGender(_Gender);
        this.setProgramming_12_Student(_Programming_12_Student);
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setStudent_Number(String _Student_Number) {
        this.Student_Number = _Student_Number;
    }

    public String getStudent_Number() {
        return this.Student_Number;
    }

    public void setGrade(int _Grade) {
        this.Grade = _Grade;
    }

    public int getGrade() {
        return this.Grade;
    }

    public void setGender(String _Gender) {
        this.Gender = _Gender;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setProgramming_12_Student(boolean _Programming_12_Student) {
        this.Programming_12_Student = _Programming_12_Student;
    }

    public boolean getProgramming_12_Student() {
        return this.Programming_12_Student;
    }
}
