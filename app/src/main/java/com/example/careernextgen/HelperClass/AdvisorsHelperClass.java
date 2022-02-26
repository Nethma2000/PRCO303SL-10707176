package com.example.careernextgen.HelperClass;

public class AdvisorsHelperClass {

    String name,email,nic,mobile,qualification,linkedinprofile,password,description;
    public AdvisorsHelperClass() {

    }

    public AdvisorsHelperClass(String name, String email, String nic, String mobile, String password, String qualification, String linkedinprofile,String description) {
        this.name = name;
        this.email = email;
        this.nic = nic;
        this.mobile = mobile;
        this.qualification = qualification;
        this.linkedinprofile = linkedinprofile;
        this.password = password;
        this.description = description;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String age) {
        this.qualification = qualification;
    }

    public String getLinkedinprofile() {
        return linkedinprofile;
    }

    public void setLinkedinprofile(String scl) {
        this.linkedinprofile = linkedinprofile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String confirm) {
        this.description = description;
    }
}
