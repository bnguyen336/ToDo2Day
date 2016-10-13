package edu.orangecoastcollege.cs273.mpaulding.todo2day;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to provide custom adapter for the <code>Task</code> list.
 */
public class TaskListAdapter extends ArrayAdapter<Task> {

    private Context mContext;
    private List<Task> mTaskList = new ArrayList<>();
    private int mResourceId;

    private CheckBox mIsDoneCheckBox;

    /**
     * Creates a new <code>TaskListAdapter</code> given a mContext, resource id and list of tasks.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param tasks The list of tasks to display
     */
    public TaskListAdapter(Context c, int rId, List<Task> tasks) {
        super(c, rId, tasks);
        mContext = c;
        mResourceId = rId;
        mTaskList = tasks;
    }

    /**
     * Gets the view associated with the layout (sets CheckBox content).
     * @param pos The position of the Task selected.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content (CheckBox) set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Task selectedTask = mTaskList.get(pos);
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        //Fill checkbox with text and status
        mIsDoneCheckBox = (CheckBox) view.findViewById(R.id.isDoneCheckBox);
        mIsDoneCheckBox.setText(selectedTask.getDescription());
        mIsDoneCheckBox.setChecked(selectedTask.getIsDone() == 1 ? true : false);

        //Lets associate each CheckBox with a specific task through View's TAG
        mIsDoneCheckBox.setTag(selectedTask);

        return view;
    }
}
