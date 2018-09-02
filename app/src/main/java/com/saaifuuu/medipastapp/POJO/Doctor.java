package com.saaifuuu.medipastapp.POJO;

public class Doctor {
    private int doctorId;
    private String doctorName;
    private String doctorDetails;
    private String doctorAppoinment;
    private String doctorPhone;
    private String doctorEmail;

    public Doctor(int doctorId, String doctorName, String doctorDetails, String doctorAppoinment, String doctorPhone, String doctorEmail) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.doctorAppoinment = doctorAppoinment;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
    }

    public Doctor(String doctorName, String doctorDetails, String doctorAppoinment, String doctorPhone, String doctorEmail) {
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.doctorAppoinment = doctorAppoinment;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(String doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public String getDoctorAppoinment() {
        return doctorAppoinment;
    }

    public void setDoctorAppoinment(String doctorAppoinment) {
        this.doctorAppoinment = doctorAppoinment;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }
}
