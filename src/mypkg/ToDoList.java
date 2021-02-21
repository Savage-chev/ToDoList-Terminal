package mypkg;

import java.util.Scanner;

/**
 * @author (Plamen Savchev)
 * @version (1.3 25/11/20)
 * 
 * class ToDo List is the main class of the application.
 */

public class ToDoList {
	
	// create a Doubly linked list object
	DoublyLinkedList<Task> taskList;
	// create a scanner
	Scanner scan;
	
	public ToDoList() {
		taskList = new DoublyLinkedList<Task> ();
		scan = new Scanner(System.in);
		
		displayAscending();
		displayMenu();
	}
	
	/** <code>dispayMenu</code> method displays and awaits choice from the available action.
	 *  That is done by passing <code>int</code> to a <code>switch</code> statement. */
	public void displayMenu() {
		System.out.println("Choose from the following options: ");
		System.out.println("1. Add Task");
		System.out.println("2. Add Test Data");
		System.out.println("3. Find task by index");
		System.out.println("4. Find task by name");
		System.out.println("5. Display tasks in ascending order");
		System.out.println("6. Display tasks in descending order");
		System.out.println("7. Remove task");
		System.out.println("8. List size");
		System.out.println("9. Exit");
		
		do {
			int option = 0;
			try {
				String optionStr = scan.nextLine();
				option = Integer.parseInt(optionStr);
			}
			catch (Exception e) {
				System.out.println("Please enter value from 1 to 9");
				continue;
			}
			
			
			/** <code>dispayMenu</code> method displays and awaits choice from the available action.
			 *  That is done by passing <code>int</code> to a <code>switch</code> statement provides 9 
			 *  different options to the the user to choose from. If the entered value is not in that 
			 *  range, the system will expect another input */
			switch(option) {
			case 1:
				addTask();
				displayMenu();
				break;
			case 2:
				addTestData();
				displayMenu();
				break;
			case 3:
				findByIndex();
				displayMenu();
				break;
			case 4:
				findByName();
				displayMenu();
				break;
			case 5:
				displayAscending();
				displayMenu();
				break;
			case 6:
				displayDescending();
				displayMenu();
				break;
		    case 7:
			    removeTask();
			    displayMenu();
			    break;
		    case 8:
			    getListSize();
			    displayMenu();
			    break;
		    case 9:
		    	scan.close();
		        System.exit(1);
		        break;
		    default:
		    	System.out.println("Available options: 1 to 9");
		    }
		}while(true);
	}
	
	/** New <code>Task</code> object is added to the <code>DoublyLinkedList</code>
	 * as a <code>Node</code> */
	public void addTask() {
		/** The value typed will be assigned to local variable <code>String</code> <code>nameTask</code> 
		 * In while loop until correct format added */
		System.out.println("Please type the following values:");
		String taskName = "";
		while (!taskName.matches("^.{1,20}$")) {			System.out.println("Task name (1-20 characters): ");
			taskName = scan.nextLine();
		}
		/** The value typed will be assigned to local variable <code>String</code> <code>date</code> 
		 * In while loop until correct format added */	
		String date = "";
		while (!date.matches("^[0-3][0-9]-[0-1][0-9]-[0-9]{2}$")) {
			System.out.println("Date of the task (**-**-**):");
			date = scan.nextLine();
		}
		
		/** The value typed will be assigned to local variable <code>String</code> <code>priority</code> 
		 *In while loop until correct format added */
		String priority = "";
		while (!priority.matches("^HIGH|LOW$")) {
			priority = "";
			System.out.println("Priority of the task (high/low):");;
			priority = scan.nextLine().toUpperCase();
		}
		
		/** All the <code>String</code>s will be passed to a newly
		* created <code>Task</code> object in a corresponding order */
		Task task = new Task(taskName, date, priority);
		
		/** The <code>Task</code> object is added to the <code>DoublyLinkedList</code>
		 * as a <code>Node</code> */
		taskList.addLast(task);
		task = null;
		
		displayAscending();
		displayMenu();
	}
	
	/** More <code>Task</code> objects are created and added to the 
	 * <code>DoublyLinkedList</code> as a <code>Node</code> */
	public void addTestData() {
		Task task = new Task("One","21-11-20","HIGH");
		taskList.addLast(task);
		task = null;
		task = new Task("Two","22-11-20","LOW");
		taskList.addLast(task);
		task = null;
		task = new Task("Three","23-11-20","HIGH");
		taskList.addLast(task);
		task = null;
		task = new Task("Four","24-11-20","LOW");
		taskList.addLast(task);
		task = null;
		task = new Task("Five","25-11-20","HIGH");
		taskList.addLast(task);
		task = null;
		
		displayAscending();
		displayMenu();
	}
	
	/** input assigned to local variable <code>int</code> and passed to the <code>removeByIndex()</code>
	 * method, which will remove the <code>Node</code> with that <code>index</code>
	 * @try @catch exception*/
	public void removeTask() {
		System.out.println("Please enter the number of the task you wish to remove: ");
		int indexRemove = scan.nextInt();
		try {
			taskList.removeByIndex(indexRemove);
		}
		catch (NullPointerException ex) {
			System.err.println("\n\n*** Null Pointer Exception ***");
            System.err.println("File not Found");
		}
		
		displayAscending();
		displayMenu();
	}
	
	/** input assigned to local variable <code>int</code> and passed to the <code>getByIndex()</code>
	 * method, which will return the <code>Node</code> with that <code>index</code> 
	 * @throw exception if index out of boundaries */
	public void findByIndex() {
		System.out.println("Please enter the index of the task you wish to display: ");
		int indexGet = scan.nextInt();
		if (indexGet < 1 || indexGet > taskList.size()) {
			throw new IllegalArgumentException("Index must be an integer between 1 & " + taskList.size() + "!");
        }
			System.out.println(taskList.getByIndex(indexGet));
			
			displayMenu();
	}
	
	/** input assigned to local variable <code>String</code> and passed to the <code>getAllMatches()</code>
	 * and <code>getByName()</code> methods, which will return all the <code>Nodes</code> that
	 * contain it */
    public void findByName() {
    	System.out.println("Please enter sequence of characters to find task: ");
		String sequenceOfChar = scan.nextLine();
		taskList.getAllMatches(sequenceOfChar.toLowerCase());
	}
    
    /** Print all the <code>Nodes</code> of the <code>taskList</code> 
	 * in a head-to-tail order */
    public void displayAscending() {
    	getListSize();
		System.out.println("Task list(front-to-back): ");
		taskList.iterateForward();
	}
    
    /** Print all the <code>Nodes</code> of the <code>taskList</code> 
	 * in a tail-to-head order */
    public void displayDescending() {
    	getListSize();
		System.out.println("Task list(back-to-front): ");
		taskList.iterateBackward();
	}
    
    /** Print the size of the <code>taskList</code> */
    public void getListSize() {
		System.out.println("Number of task: " + taskList.size());
    }
	
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		toDoList.displayMenu();
	}
}
