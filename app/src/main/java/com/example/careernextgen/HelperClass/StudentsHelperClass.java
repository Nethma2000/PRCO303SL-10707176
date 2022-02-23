package com.example.careernextgen.HelperClass;

public class StudentsHelperClass {
    String name,email,nic,mobile,age,scl,password,confirm;

    public StudentsHelperClass() {

    }

    public StudentsHelperClass(String name, String email, String nic, String mobile, String password, String age, String scl) {
        this.name = name;
        this.email = email;
        this.nic = nic;
        this.mobile = mobile;
        this.age = age;
        this.scl = scl;
        this.password = password;
        this.confirm = confirm;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getScl() {
        return scl;
    }

    public void setScl(String scl) {
        this.scl = scl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

}
