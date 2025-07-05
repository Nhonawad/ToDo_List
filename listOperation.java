
import java.util.List;

public class listOperation {


    private listDb userdata;

    public listOperation(){
        this.userdata = new listDb();
    }

    public boolean addtolist(Operations inputop){
        return userdata.adddata(inputop);
    }

    public List<Operations> showlist(){
        return userdata.showdata();
    }

    public boolean DeleteListItem(int id){
        return userdata.deletedata(id);
    }
    public boolean updateItem(int itemid,String updatefield,String updatevalue){
        userdata.updatedata(itemid,updatefield,updatevalue);
        return true;
    }
    public boolean sortitems(String fieldname){
        userdata.sortitems(fieldname);
        return true;
    }


}
