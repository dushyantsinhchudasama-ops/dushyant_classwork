package com.tss.model;

public class EnrollmentRepository {

    public void save(StudentEnrollment enrollment) {

        System.out.println(
                "Enrollment saved for "
                        + enrollment.getStudentName());
    }
}