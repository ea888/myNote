package note.clone;

import java.util.ArrayList;
import java.util.List;

public class TBCloned implements Cloneable {
    private String name;
    private List<String> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Object clone() throws CloneNotSupportedException {
        TBCloned tbc = (TBCloned) super.clone();
        return tbc;
    }

    public static void main(String[] args){
        TBCloned tbc = new TBCloned();
        tbc.setName("tbc");
        List<String> list = new ArrayList<>();
        list.add("e1");
        list.add("e2");
        tbc.setList(list);

        TBCloned tbc2;
        try {
            tbc2 = (TBCloned)tbc.clone();
            tbc2.setName("tbc2");
            List<String> list2 = new ArrayList<>();
            list2.add("e1");
            list2.add("e2");
            list2.add("e3");
            tbc2.setList(list2);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
