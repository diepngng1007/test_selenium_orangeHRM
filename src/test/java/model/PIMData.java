package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PIMData {
    //data employee
    private String imagePath;
    private String firstName;
    private String middleName;
    private String lastName;
    private String employeeId;

    //data personal detail page
    private String firstNamep;
    private String middleNamep;
    private String lastNamep;
    private String employeeIdp;
    private String otherId;
    private String dLNumber;
    private String lEDate;
    private String nationality;
    private String maritalStatus;
    private String dateOfBirth;
    private String gender;
}
