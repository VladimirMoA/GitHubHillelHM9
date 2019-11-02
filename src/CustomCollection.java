import java.util.Collection;

public interface CustomCollection {
    public boolean addFirst(Object obj);
    public boolean add(Object obj);
    public boolean addAll(Object[] objects);
    public boolean addAll(Collection objColl);
    public boolean addAll(NotLinkedList notLinkedList);
    boolean delete (int index);
    public boolean delete(Object obj);
    public Link get(int index);
    public boolean contains(Object obj);
    public boolean clear();
    public int size();
    public void displayList();
}
