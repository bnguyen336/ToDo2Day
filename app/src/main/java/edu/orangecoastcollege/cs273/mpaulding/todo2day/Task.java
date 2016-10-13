package edu.orangecoastcollege.cs273.mpaulding.todo2day;

/**
 * The <code>Task</code> class maintains information about a task that needs to be
 * accomplished, including its id number, description and whether it is done.
 *
 * @author Michael Paulding
 */
public class Task {

    //Member variables
    private int mId;
    private String mDescription;
    private int mIsDone;

    /**
     * Creates a default <code>Task</code> with an id of -1, empty description and not done status.
     */
    /*public Task()
    {
        mId = -1;
        mDescription = "";
        mIsDone = 0;
    }*/

    /**
     * Create a new <code>Task</code> from user input. Id will be assigned automatically by
     * the database.
     * @param desc The task's description
     * @param done Status of the task
     */
    public Task(String desc, int done) {
        this(-1, desc, done);
    }

    /**
     * Creates a new <code>Task</code> from its id, description and status.
     * @param id The task id
     * @param desc The task description
     * @param done The task status
     */
    public Task(int id, String desc, int done) {
        mId = id;
        mDescription = desc;
        mIsDone = done;
    }

    /**
     * Gets the unique id of the <code>Task</code>.
     * @return The unique id
     */
    public int getId() {
        return mId;
    }

    /**
     * Gets the description of the <code>Task</code>.
     * @return The task description
     */
    public String getDescription () {
        return mDescription;
    }

    /**
     * Sets the description of the <code>Task</code>.
     * @param desc The new task description
     */
    public void setDescription (String desc) {
        mDescription = desc;
    }

    /**
     * Gets the status of the <code>Task</code>.
     * @return The task status
     */
    public int getIsDone() {
        return mIsDone;
    }

    /**
     * Sets the status of the <code>Task</code>.
     * @param done The new task status
     */
    public void setIsDone(int done) {
        mIsDone = done;
    }

    /**
     * A method for displaying a <code>Task</code> as a String in the form:
     *
     * Task{id=1, description='Study for CS 273 midterm', isDone = 0}
     *
     * @return The formatted String
     */
    @Override
    public String toString() {
        return "Task{" +
                "id=" + mId +
                ", description='" + mDescription + '\'' +
                ", isDone=" + mIsDone +
                '}';
    }
}
