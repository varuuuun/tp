package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import static seedu.address.logic.Messages.MESSAGE_STUDENT_ATTENDANCE_MARKED;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.person.Person;
import seedu.address.model.person.StudentId;
import seedu.address.model.person.StudentIdEqualsPredicate;

/**
 * Marks a student identified using their student id as present.
 */
public class MarkCommand extends Command {
    public static final String COMMAND_WORD = "mark";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the student identified as present by the "
            + "student id as present.\nParameters: [STUDENT_ID]\n"
            + "Example: " + COMMAND_WORD + " A01A";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "Mark command not implemented yet";

    public static final String MESSAGE_ARGUMENTS = "Student ID: %1$s";

    private final String id;

    /**
     * Initialises MarkCommand with given student id.
     * @param id ID of student to mark attendance.
     */
    public MarkCommand(String id) {
        requireAllNonNull(id);

        this.id = id;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.updateFilteredPersonList(new StudentIdEqualsPredicate(new StudentId(id)));
        List<Person> students = model.getFilteredPersonList();

        if (students.isEmpty()){
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
            throw new CommandException("Requested student was not found in the student list.");
        }

        Person studentToMark = students.get(0);
        studentToMark.setPresent();

        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_STUDENT_ATTENDANCE_MARKED, id));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MarkCommand)) {
            return false;
        }

        MarkCommand e = (MarkCommand) other;
        return id.equals(e.id);
    }
}
