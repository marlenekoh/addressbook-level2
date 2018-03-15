package seedu.addressbook.commands;

import seedu.addressbook.data.tag.Tagging;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXIT_ACKNOWEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tagging tagging: addressBook.listOfTaggingRecords) {
            stringBuilder.append(tagging.toString() + "\n");
        }
        return new CommandResult(stringBuilder.toString() + MESSAGE_EXIT_ACKNOWEDGEMENT);
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
