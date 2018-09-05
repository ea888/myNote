package note.iteratorSample;

import java.util.Collection;
import java.util.Iterator;

public class ScannerImpl implements Scanner {
    @Override
    public void printCollection(Collection collection) {
        //
    }

    private void print(Iterator<String> it){
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
