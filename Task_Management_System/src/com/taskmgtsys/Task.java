package com.taskmgtsys;

//POJO Class
class Task
{
    private String name;
    private String description;
    private String dueDate;

    
    //Constructor to initialize task properties
    public Task(String name, String description, String dueDate)
    {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    
    //Getter methods for accessing task properties
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public String getDueDate()
    {
        return dueDate;
    }
}