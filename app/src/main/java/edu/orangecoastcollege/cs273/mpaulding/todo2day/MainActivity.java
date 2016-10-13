package edu.orangecoastcollege.cs273.mpaulding.todo2day;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBHelper database;
    private List<Task> taskList;
    private TaskListAdapter taskListAdapter;

    private EditText taskEditText;
    private ListView taskListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // FOR NOW (TEMPORARY), delete the old database, then create a new one
        //this.deleteDatabase("Tasks");

        // Let's make a DBHelper reference:
        database = new DBHelper(this);

        //Fill list with tasks from database
        taskList = database.getAllTasks();

        //Associate the adapter with context, layout and the List
        taskListAdapter = new TaskListAdapter(this, R.layout.task_item, taskList);

        //Connect ListView with layout
        taskListView = (ListView) findViewById(R.id.taskListView);
        taskEditText = (EditText) findViewById(R.id.taskEditText);

        //Associate the adapter with the ListView
        taskListView.setAdapter(taskListAdapter);
    }

    public void addTask(View view) {
        String description = taskEditText.getText().toString();
        if (description.isEmpty()) {
            Toast.makeText(this, "Task description cannot be empty!", Toast.LENGTH_SHORT).show();
        } else {
            //Create a new task and add to the List
            Task newTask = new Task(description, 0);
            taskListAdapter.add(newTask);
            database.addTask(newTask);
            taskEditText.setText("");
        }
    }

    public void changeTaskStatus(View view) {
        if (view instanceof CheckBox) {
            CheckBox selectedCheckBox = (CheckBox) view;
            Task selectedTask = (Task) selectedCheckBox.getTag();
            selectedTask.setIsDone(selectedCheckBox.isChecked() ? 1 : 0);
            //Update database
            database.updateTask(selectedTask);
        }
    }

    public void clearAllTasks(View view) {
        //Clear the List
        taskList.clear();
        //Delete all records in database
        database.deleteAllTask();
        //Update ListAdapter
        taskListAdapter.notifyDataSetChanged();
    }
}
