import java.util.Collection;
import java.util.LinkedList;

public class NotLinkedList implements CustomCollection{
    private Link first;
    private Link last;
    private int size = 0;

    public NotLinkedList() {
        first = null;
    }

    public boolean addFirst(Object obj) {
        Link l = last;
        Link newLink = new Link(l,obj,null);
        newLink.next = first;
        first = newLink;
        size++;
        return true;
    }

    public boolean add(Object obj) {
        Link l = last;
        Link newLink = new Link(l,obj,null);
        last = newLink;
        if (l == null)
            first = newLink;
        else
            l.next = newLink;
            size++;
        return true;
    }

    public boolean addAll(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
        return true;
    }

    public boolean addAll(Collection objColl) {
        Object[] objects = objColl.toArray(new Object[objColl.size()]);
        addAll(objects);
        return true;
    }

    public boolean addAll(NotLinkedList notLinkedList) {
        Object[] objects = new Object[notLinkedList.size];
        for (int i = 0; i < notLinkedList.size; i++) {
            objects[i] = get(i).dData;
        }
        addAll(objects);
        return true;
    }

    public boolean delete (int index) {
            if (index > 0 && index < size-1) {
                get(index - 1).next = get(index + 1);
                get(index + 1).prev = get(index - 1);
                size--;
                return true;
            } else if (index == 0) {
                first = get(index+1);
                size--;
                return true;
            } else if (index == size-1) {
                get(index - 1).next = null;
                size--;
            }
            return false;
        }

    public boolean delete(Object obj) {
        if (contains(obj)) {
            for (int i = 0; i < size; i++) {
                if (get(i).dData == obj) {
                    delete(i);
                    return true;
                }
            }
        }
        return false;
    }

    public Link get(int index) {
        if (index < size()/2) {
            Link current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Link current = last;
            for (int i = size-1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (get(i).dData == obj) return true;
        }
        return false;
    }

    public boolean clear() {
        first = null;
        size = 0;
        return true;
    }

    public int size() {
        return size;
    }

    public void displayList() {
        System.out.print("List (first ->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add("sad");
        linkedList.get(0);
        linkedList.remove(1);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList);
        Object[] objects = new Object[]{"sad", 1, 5, "das"};
        NotLinkedList notLinkedList = new NotLinkedList();
        notLinkedList.add(24);
        notLinkedList.add(25);
        notLinkedList.addFirst(23);
        notLinkedList.add(26);
        notLinkedList.addAll(notLinkedList);
        notLinkedList.addAll(objects);
        notLinkedList.addAll(linkedList);
        notLinkedList.delete(12);
        notLinkedList.delete((Object) 23);
        System.out.println(notLinkedList.contains("sad"));
        notLinkedList.displayList();
        System.out.println();
        System.out.println(notLinkedList.size());
        notLinkedList.clear();
        notLinkedList.displayList();
        System.out.println();
        System.out.println(notLinkedList.size());
    }

}
