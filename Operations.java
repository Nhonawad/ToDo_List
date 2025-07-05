public class Operations {
    private  int id ;
    private String name,status,deadline;
    private static int uniqueid = 0;

    enum status {Pending,inprogress,completed ;}

    public static int getUniqueId() {
        uniqueid++;
        return uniqueid;
    }

    public String getStatus() {
        return status;
    }

    public  int getId() {
        return this.id;
    }


    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operations(int id,String inputname , String inputdate, String inputstatus) {
        this.id = id;
        this.name = inputname;
        this.deadline = inputdate;
        this.status = inputstatus;
    }




}
