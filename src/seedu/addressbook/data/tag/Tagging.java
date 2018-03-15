package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * This class will represent an adding or deleting of a tag for a specific person
 * that happened during that session.
 */
public class Tagging {
    private static final String ADD_PREFIX = "+ ";
    private static final String DELETE_PREFIX = "- ";

    private static String personName;
    private static String tagName;

    private static boolean isAdded;

    /**
     * Creates a tagging record
     * @param person Person who added/deleted a tag
     * @param tag Tag which was added/deleted
     * @param isAdded is true if the tag was added, else the tag was deleted
     */
    public Tagging(Person person, Tag tag, boolean isAdded) {
        this.personName = person.getName().toString();
        this.tagName = tag.tagName;
        this.isAdded = isAdded;
    }

    @Override
    public String toString() {
        return (isAdded ? ADD_PREFIX : DELETE_PREFIX) + personName + " [" + tagName + "]";
    }


}
