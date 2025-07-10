import java.util.List;

public interface iListOperation {

    public boolean addtolist(Operations inputop);

    public List<Operations> showlist();

    public boolean DeleteListItem(int id);

    public boolean updateItem(int itemid,String updatefield,String updatevalue);

    public boolean sortitems(String fieldname);
}
