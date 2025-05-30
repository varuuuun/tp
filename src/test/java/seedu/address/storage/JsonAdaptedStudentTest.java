package seedu.address.storage;

import static seedu.address.logic.Messages.ADDRESS_MESSAGE_CONSTRAINTS;
import static seedu.address.logic.Messages.ATTENDANCE_DATE_CONSTRAINTS;
import static seedu.address.logic.Messages.EMAIL_MESSAGE_CONSTRAINTS;
import static seedu.address.logic.Messages.NAME_MESSAGE_CONSTRAINTS;
import static seedu.address.logic.Messages.PHONE_MESSAGE_CONSTRAINTS;
import static seedu.address.logic.Messages.STUDENT_ID_MESSAGE_CONSTRAINTS;
import static seedu.address.storage.JsonAdaptedStudent.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.BENSON;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.student.Address;
import seedu.address.model.student.Attendance;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Phone;
import seedu.address.model.student.StudentId;

public class JsonAdaptedStudentTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_STUDENT_ID = "B099";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final List<LocalDate> INVALID_ATTENDANCE = new ArrayList<>(Collections.singleton(LocalDate.MAX));

    private static final String VALID_NAME = BENSON.getStudentName().toString();
    private static final String VALID_STUDENT_ID = BENSON.getStudentId().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<LocalDate> VALID_ATTENDANCE = BENSON.getAttendance().getAttendance().stream()
            .collect(Collectors.toList());

    /*
    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }
    */

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(INVALID_NAME, VALID_NAME, VALID_STUDENT_ID,
                        VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_ATTENDANCE);
        String expectedMessage = NAME_MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(null, VALID_NAME, VALID_STUDENT_ID,
                VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_ATTENDANCE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidSId_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_NAME, INVALID_STUDENT_ID, VALID_PHONE,
                        VALID_EMAIL, VALID_ADDRESS, VALID_ATTENDANCE);
        String expectedMessage = STUDENT_ID_MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullSId_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME,
                VALID_NAME, null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_ATTENDANCE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, StudentId.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_NAME, VALID_STUDENT_ID, INVALID_PHONE,
                        VALID_EMAIL, VALID_ADDRESS, VALID_ATTENDANCE);
        String expectedMessage = PHONE_MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME,
                VALID_NAME, VALID_STUDENT_ID, null, VALID_EMAIL, VALID_ADDRESS,
                VALID_ATTENDANCE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_NAME, VALID_STUDENT_ID, VALID_PHONE,
                        INVALID_EMAIL, VALID_ADDRESS, VALID_ATTENDANCE);
        String expectedMessage = EMAIL_MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME,
                VALID_NAME, VALID_STUDENT_ID, VALID_PHONE, null, VALID_ADDRESS,
                VALID_ATTENDANCE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedStudent person =
                new JsonAdaptedStudent(VALID_NAME, VALID_NAME, VALID_STUDENT_ID, VALID_PHONE,
                        VALID_EMAIL, INVALID_ADDRESS,
                        VALID_ATTENDANCE);
        String expectedMessage = ADDRESS_MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME,
                VALID_NAME, VALID_STUDENT_ID, VALID_PHONE, VALID_EMAIL, null,
                VALID_ATTENDANCE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAttendance_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME,
                VALID_NAME, VALID_STUDENT_ID, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                INVALID_ATTENDANCE);
        String expectedMessage = ATTENDANCE_DATE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAttendance_throwsIllegalValueException() {
        JsonAdaptedStudent person = new JsonAdaptedStudent(VALID_NAME,
                VALID_NAME, VALID_STUDENT_ID, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Attendance.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

}
