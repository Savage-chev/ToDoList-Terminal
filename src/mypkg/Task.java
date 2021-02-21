package mypkg;

/**
 * @author (Plamen Savchev)
 * @version (1.3 25/11/20)
 * 
 * class Task stores the task values
 */

public class Task {

	private String taskName;      // name of the task
	
	private String date;          // date of the task
	
	private String priority;      // priority of task
	
	/**
     * Constructor for objects of class Task
     */
	public Task(String taskName, String date, String priority) {
		this.taskName = taskName;
		this.date = date;
		this.priority = priority;
	}
	
	/**
	* Returns the <code>taskName</code> field value of the <code>Task</code> object
	* 
	* @return   the name of task, as a <code>String</code>
	*/
	public String getTaskName() {
		return taskName;
	}

	/**
	* Set the <code>taskName</code> field value of the <code>Task</code> object
	*/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	* Returns the <code>date</code> field value of the <code>Task</code> object
	* 
	* @return   the date of task, as a <code>String</code>
	*/
	public String getDate() {
		return date;
	}

	/**
	* Set the <code>date</code> field value of the <code>Task</code> object
	*/
	public void setDate(String date) {
		this.date = date;
	}

	/**
	* Returns the <code>priority</code> field value of the <code>Task</code> object
	* 
	* @return   the priority of task, as a <code>String</code>
	*/
	public String getPriority() {
		return priority;
	}

	/**
	* Set the <code>priority</code> field value of the <code>Task</code> object
	*/
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	/**
	* Returns all the fields value of the <code>Task</code> object
	* 
	* @return   the task values, as a <code>String</code>
	* @overriding the internal call toString() to return values instead of their hash
	*/
	public String toString()
	{
	    return "Task name: " + taskName + ", Date: " + date +", Priority: " + priority;
	}
}