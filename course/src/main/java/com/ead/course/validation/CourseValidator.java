package com.ead.course.validation;

import com.ead.course.dtos.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.UUID;

@Component
public class CourseValidator implements Validator {

    @Autowired
    @Qualifier("defaultValidator")
    private Validator validator;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDTO courseDTO = (CourseDTO) target;
        validator.validate(courseDTO, errors);
        if(!errors.hasErrors()) {
            validateUserInstructor(courseDTO.getUserInstructor(), errors);
        }
    }

    private void validateUserInstructor(UUID userIdInstructor, Errors errors) {
//        ResponseEntity<UserDTO> responseUserInstructor;
//
//        try {
//            responseUserInstructor = authUserClient.getOneUserById(userIdInstructor);
//            var userDTOuserType = responseUserInstructor.getBody().getUserType();
//            if(!userDTOuserType.equals(UserType.INSTRUCTOR) || !userDTOuserType.equals(UserType.ADMIM)) {
//                errors.rejectValue("userInstructor", "UserInstructorError", "User must be INSTRUCTOR or ADMIN.");
//            }
//        } catch (HttpStatusCodeException e) {
//            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND))
//                errors.rejectValue("userInstructor", "UserInstructorError", "Instructor not found.");
//        }
    }
}
