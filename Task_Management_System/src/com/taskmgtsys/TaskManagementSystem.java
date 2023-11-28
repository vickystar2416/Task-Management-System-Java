package com.taskmgtsys;

import java.util.ArrayList;
import java.util.Scanner;

//Main Class
public class TaskManagementSystem
{
  private ArrayList<Task> tasks;
  private Scanner scanner;
  
  
  //Constructor to initialize the system
  public TaskManagementSystem()
  {
      tasks = new ArrayList<>();
      scanner = new Scanner(System.in);
  }
  
  
  //Displays the main menu of the system
  public void displayMenu()
  {
  	  System.out.println();
  	  System.out.println();
  	  System.out.println();
      System.out.println("\t\t\t=====Task Management System=====");
      System.out.println("\t\t--------------------------------------------------");
      System.out.println();
      System.out.println("================================================================================");
      System.out.println("\t1. Add Task");
      System.out.println("\t2. Remove Task");
      System.out.println("\t3. List Tasks");
      System.out.println("\t4. Clear Screen");
      System.out.println("\t5. Exit");
      System.out.println("================================================================================");
      System.out.println();
      System.out.print("\tEnter your choice  :  ");
  }

  
  //Allows users to add a new task to the system
  public void addTask()
  {
  	System.out.println();
      System.out.print("\tEnter task name  :  ");
      String name = scanner.nextLine();
      System.out.print("\tEnter task description  :  ");
      String description = scanner.nextLine();
      System.out.print("\tEnter due date  :  ");
      String dueDate = scanner.nextLine();

      Task newTask = new Task(name, description, dueDate);
      tasks.add(newTask);
      System.out.println();
      System.out.println("\t\t----------Task added successfully!!!---------");
  }

  
  //Allows users to remove a task from the system
  public void removeTask()
  {
      if (tasks.isEmpty())
      {
      	System.out.println();
          System.out.println("\t\t---------No tasks available to remove.---------");
          return;
      }

      listTasks();
      System.out.println();
      System.out.print("\tEnter the task number to remove  :  ");
      int taskNumber = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      if (taskNumber > 0 && taskNumber <= tasks.size())
      {
          tasks.remove(taskNumber - 1);
          System.out.println();
          System.out.println("\t\t---------Task removed successfully!!!---------");
      }
      else
      {
      	System.out.println();
          System.out.println("\t\t---------Invalid task number.----------");
      }
  }

  
  //Displays a list of all tasks in the system
  public void listTasks()
  {
      if (tasks.isEmpty())
      {
      	System.out.println();
          System.out.println("\t\t---------No tasks available."
          		+ "---------");
      }
      else
      {
      	System.out.println();
          System.out.println("\t-------------------------------------------------------------------------------------------------");
          System.out.println("\t\t\t\t\t=====***ALL TASKS***=====");
          System.out.println("\t-------------------------------------------------------------------------------------------------");
          System.out.println();
          for (int i = 0; i < tasks.size(); i++)
          {
              Task task = tasks.get(i);
              System.out.println();
              System.out.println("\t\tTask No.\t:\t"+(i+1));
              System.out.println("\t===========================================");
              System.out.println();
              System.out.println("\tName\t\t:\t" + task.getName());
              System.out.println("\tDescription\t:\t" + task.getDescription());
              System.out.println("\tDue Date\t:\t" + task.getDueDate());
              System.out.println("-------------------------------------------------------------------------------------------");
          }
          System.out.println();
      }
  }
  
  
  //A method for make the user feel of clearning screen
  public void clearScreen()
  {
  	for(int i=0; i<37;i++)
  	{
  		System.out.println();
  	}
  	System.out.println("\t\t\t\tS c r e e n     C l e a r e d");
  }

  
  //Main method to run the Task Management System
  public static void main(String[] args)
  {
      TaskManagementSystem taskManagementSystem = new TaskManagementSystem();
      int choice;

      do
      {
          taskManagementSystem.displayMenu();
          choice = taskManagementSystem.scanner.nextInt();
          taskManagementSystem.scanner.nextLine(); // Consume the newline character

          switch (choice)
          {
              case 1:
                  taskManagementSystem.addTask();
                  break;
              case 2:
                  taskManagementSystem.removeTask();
                  break;
              case 3:
                  taskManagementSystem.listTasks();
                  break;
              case 4:
              	taskManagementSystem.clearScreen();
              	break;
              case 5:
                  System.out.println("\tExiting the program. Goodbye!");
                  break;
              default:
                  System.out.println("\tInvalid choice. Please try again.");
          }

      } while (choice != 5);
  }
}
