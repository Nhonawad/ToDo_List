import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.*;

public class listDb {

    static List<Operations> userdatadb = new ArrayList<>();


    public boolean adddata(Operations op){
        return userdatadb.add(op);
    }

    public List<Operations> showdata(){
        return userdatadb;
    }

    public boolean deletedata(int id){
        Iterator<Operations> iterator = userdatadb.iterator();
        while(iterator.hasNext()){
            Operations targetdata =iterator.next();
            if (targetdata.getId() == id){
                iterator.remove();
            }
        }
        return true;
    }

    public void updatedata(int itemid,String updatefield,String updatevalue){
        //validations
        for(Operations ud: userdatadb){
            if (ud.getId() == itemid){
                switch (updatefield.toUpperCase()){
                    case "NAME":
                        ud.setName(updatevalue);
                        break;
                    case "DEADLINE":
                        ud.setDeadline(updatevalue);
                        break;
                    case "STATUS":
                        ud.setStatus(updatevalue);
                        break;
                }

            }

        }
    }

    public boolean sortitems(String fieldname){
        switch (fieldname.toUpperCase()) {
            case "NAME":
                    userdatadb.sort(new Comparator<Operations>() {
                        @Override
                        public int compare(Operations o1, Operations o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    break;
            case "DEADLINE":
                    userdatadb.sort(new Comparator<Operations>() {
                        @Override
                        public int compare(Operations o1, Operations o2) {
                            return o1.getDeadline().compareTo(o2.getDeadline());
                        }
                    });
                break;
            case "STATUS":
                userdatadb.sort(new Comparator<Operations>() {
                    @Override
                    public int compare(Operations o1, Operations o2) {
                        return o1.getStatus().compareTo(o2.getStatus());
                    }
                });
                break;

        }

        return true;
    }
}
