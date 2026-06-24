package com.tss.model;

public class EnrollmentService {

    private StudentValidator studentValidator;
    private CourseValidator courseValidator;
    private FeeCalculator feeCalculator;
    private DiscountService discountService;
    private ConfirmationGenerator confirmationGenerator;
    private EnrollmentRepository repository;
    private NotificationService notificationService;

    public EnrollmentService(StudentValidator studentValidator,
                             CourseValidator courseValidator,
                             FeeCalculator feeCalculator,
                             DiscountService discountService,
                             ConfirmationGenerator confirmationGenerator,
                             EnrollmentRepository repository,
                             NotificationService notificationService) {

        this.studentValidator = studentValidator;
        this.courseValidator = courseValidator;
        this.feeCalculator = feeCalculator;
        this.discountService = discountService;
        this.confirmationGenerator = confirmationGenerator;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void enroll(StudentEnrollment enrollment) {

        studentValidator.validateStudent(enrollment);

        if (!courseValidator.courseExists(enrollment.getCourseName())) {
            System.out.println("Course does not exist");
            return;
        }

        if (!courseValidator.seatsAvailable(enrollment.getCourseName())) {
            System.out.println("No seats available");
            return;
        }

        double fee = feeCalculator.calculateFee(enrollment.getCourseType());

        fee = discountService.applyDiscount(fee,enrollment.isScholarship());

        String confirmationNumber = confirmationGenerator.generateConfirmationNumber();

        repository.save(enrollment);

        notificationService.sendConfirmation(enrollment.getEmail(),confirmationNumber);

        System.out.println("Final Fee : " + fee);
    }
}