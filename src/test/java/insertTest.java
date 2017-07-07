import springTest.domain.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by guofengrui on 2017/7/7.
 */
public class insertTest {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Student student = new Student();
        student.setId(null);
        student.setName("肖志昂");
        student.setAge(20);
        Set<ConstraintViolation<Student>> constraintViolations = validator
                .validate(student);
        for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}
