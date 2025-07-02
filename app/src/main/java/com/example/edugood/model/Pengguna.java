package com.example.edugood.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Pengguna extends RealmObject {

    @PrimaryKey
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String konfirmasipassword;
    private String studentClass;

    public Pengguna() {
    }

    public Pengguna(String name, String email, String phoneNumber, String password, String konfirmasipassword, String StudentClass ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.konfirmasipassword = konfirmasipassword;
        this.studentClass = StudentClass;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getKonfirmasipassword() { return konfirmasipassword; }
    public void setKonfirmasipassword(String password) { this.konfirmasipassword = konfirmasipassword; }

    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }

    @Override
    public String toString() {
        return "Pengguna{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", konfirmasipassword='" + konfirmasipassword + '\'' +
                ", Kelas=" + studentClass +
                '}';
    }
}


