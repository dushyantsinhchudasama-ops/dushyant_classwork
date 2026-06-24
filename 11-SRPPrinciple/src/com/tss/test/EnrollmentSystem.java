package com.tss.test;

import com.tss.model.*;

public class EnrollmentSystem {

    public static void main(String[] args) {

        StudentEnrollment enrollment = new StudentEnrollment("Dushyant","dushyant@gmail.com",21,"Full Stack using Java","PRO",true);

        EnrollmentService service = new EnrollmentService(new StudentValidator(), new CourseValidator(new CourseRepository()),
                new FeeCalculator(),
                        new DiscountService(),
                        new ConfirmationGenerator(),
                        new EnrollmentRepository(),
                        new NotificationService()
        );

        service.enroll(enrollment);
    }
}