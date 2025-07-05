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
        System.out.println("Welcome to Nayana's To Do List");
        while(true) {
            System.out.println("Please select an option from the below" + "\n" +
                    "1.Add " + "\n" +
                    "2.Update " + "\n" +
                    "3.Delete" + "\n" +
                    "4.List" + "\n" +
                    "5.Sort" + "\n" +
                    "6.Exit");

            int useroption = Integer.valueOf(getUserInput("Please enter option number")); // converting string value to int for switch

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
        String deadline = getUserInput("Enter deadline in dd-mm-yy format");
        if (validatedateformat(deadline) == false){
            System.out.println("Please enter date in dd-mm-yy format");
            return true;
        }
        else {
            Operations Operation = new Operations(Operations.getUniqueId(), taskname, deadline, "Pending");
            return lop.addtolist(Operation);
        }

    }
    public boolean validatedateformat(String deadline){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            LocalDate.parse(deadline, formatter);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }



    public void deleteTask(){
        int deletetaskid =  Integer.valueOf(getUserInput("Enter the task ID which you want to delete"));
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
        int modifytaskid =  Integer.valueOf(getUserInput("Enter the task ID which you want to update"));
        String modfield = getUserInput("Enter the field which you want to update");
        String modvalue = getUserInput("Enter new value");

        lop.updateItem(modifytaskid,modfield,modvalue);

    }

    public void sorttask(){
        String sortfield = getUserInput("Enter the field with which you want to sort the tasks");
        lop.sortitems(sortfield);
        System.out.println("Testing  feature one branch");
    }
}
