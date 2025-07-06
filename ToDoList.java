import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.time.*;

public class ToDoList {
    listOperation lop = new listOperation();

    public ToDoList(){
        printMyMenu();
    }

    public String getUserInput(String usermessage){
        System.out.println(usermessage);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }

    public void printMyMenu(){
        int useroption = 0;
        System.out.println("Welcome to Nayana's To Do List");
        while(true) {
            System.out.println("Please select an option from the below" + "\n" +
                    "1.Add    " + "2.Update  " + "3.Delete  " + "4.List   " + "5.Sort   " + "6.Exit");

            try {
                useroption = Integer.valueOf((getUserInput("Please enter option number")).trim()); // converting string value to int for switch
            }
            catch(NumberFormatException e){
                useroption = 0;
            }

            switch (useroption) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    listTask();
                    break;
                case 5:
                    sorttask();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("You have selected an invalid input.Please select a valid one to continue");
            }
        }

    }


    public boolean addTask(){
        String taskname = getUserInput("Enter task name");
        String deadline = (getUserInput("Enter deadline in dd-mm-yyyy format")).trim();
        if (validatedateformat(deadline) == false){
            System.out.println("Please enter date in dd-mm-yyyy format");
            return true;
        }
        else {
            Operations Operation = new Operations(Operations.getUniqueId(), taskname, deadline, "Pending");
            System.out.println("Your task has been added successfully!!");
            return lop.addtolist(Operation);
        }

    }
    public boolean validatedateformat(String deadline){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            LocalDate.parse(deadline, format);
            //if the format of the deadline string matches the formatter, it returns a LocalDate object.
            return true;
        }
        catch(Exception e){
            return false;
        }
    }



    public void deleteTask(){
        int deletetaskid =  Integer.valueOf((getUserInput("Enter the task ID which you want to delete").trim()));
        lop.DeleteListItem(deletetaskid);

    }
    public void listTask(){
        List<Operations> completedata = lop.showlist();
        if(!(completedata.isEmpty())) {

            System.out.println("               Nayana's TODO List:                   ");
            System.out.println("-----------------------------------------------------");
            System.out.println("Task No      Name               Deadline       Status");
            System.out.println("-----------------------------------------------------");

            for (Operations op : completedata) {
                System.out.println(op.getId() + "        " + op.getName() + "      " + op.getDeadline() + "      " + op.getStatus());
            }
        }
        else{
            System.out.println("There are no items to display in the list");
        }

    }
    public void updateTask(){
        int modifytaskid =  Integer.valueOf((getUserInput("Enter the task ID which you want to update")).trim());
        String modfield = (getUserInput("Enter the field which you want to update")).trim();
        String modvalue = (getUserInput("Enter new value")).trim();
        lop.updateItem(modifytaskid,modfield,modvalue);

    }

    public void sorttask(){
        String sortfield = getUserInput("Enter the field with which you want to sort the tasks");
        lop.sortitems(sortfield);
    }
}
