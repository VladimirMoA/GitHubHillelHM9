public class Link {
    public Object dData;
    public Link next;
    public Link prev;

    public void displayLink() {
        System.out.print(dData + " ");
    }

    public Link (Link prev, Object element, Link next) {
        this.dData = element;
        this.next = next;
        this.prev = prev;
    }
}
