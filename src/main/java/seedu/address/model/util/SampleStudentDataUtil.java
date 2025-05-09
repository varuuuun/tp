package seedu.address.model.util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.student.Address;
import seedu.address.model.student.Attendance;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Phone;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;


/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleStudentDataUtil {
    public static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new StudentId("A01A"), new Name("John Yeoh"), new Phone("87438807"),
                    new Email("alexyeoh@example.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
                    new Attendance(new HashSet<>(List.of(LocalDate.now())))),
            new Student(new Name("Bernice Yu"), new StudentId("A23A"), new Name("Tan Yu"), new Phone("99272758"),
                    new Email("berniceyu@example.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new Attendance(new HashSet<>(List.of(LocalDate.now())))),
            new Student(new Name("Charlotte Oliveiro"), new StudentId("A54X"), new Name("Oliveiro"),
                    new Phone("93210283"), new Email("charlotte@example.com"),
                    new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new Attendance(new HashSet<>())),
            new Student(new Name("David Li"), new StudentId("A69A"), new Name("Jamie Li"), new Phone("91031282"),
                    new Email("lidavid@example.com"),
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Attendance(new HashSet<>())),
            new Student(new Name("Irfan Ibrahim"), new StudentId("A78B"), new Name("Michael Ibrahim"),
                    new Phone("92492021"), new Email("irfan@example.com"),
                    new Address("Blk 47 Tampines Street 20, #17-35"), new Attendance(new HashSet<>())),
            new Student(new Name("Roy Balakrishnan"), new StudentId("A93Y"), new Name("Balakrishnan Subrahmani"),
                    new Phone("92624417"), new Email("royb@example.com"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"), new Attendance(new HashSet<>()))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student samplePerson : getSamplePersons()) {
            sampleAb.addStudent(samplePerson);
        }
        return sampleAb;
    }


}
