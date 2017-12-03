import static org.junit.Assert.*;
//TODO check indices
public class DoublyLinkedListTest {
    @org.junit.Test
    public void addFirst() throws Exception {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("first");
        String test = list.toStringValue();
        assertTrue(test == "first");

    }

    /**
     * tests adding a last item to a non empty list
     * @throws Exception
     */
    @org.junit.Test
    public void addLast() throws Exception {
       DoublyLinkedList list = new DoublyLinkedList();
       list.add(3, "3");
       list.addLast("4");
       String test = list.toString();
       assertTrue(test == " ");
    }

    /**
     * tests addding a last item to an empty list
     * which should add it as first element
     * @throws Exception
     */
    @org.junit.Test
    public void addLastToEmptyList() throws Exception {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast("last");
        String testString = list.toString();
        assertTrue((testString == "last") && (list.get(1) == "last"));
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.Test
    public void addOneElementToEmptyList() throws Exception {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(145, "145");
    }

    @org.junit.Test
    public void get() throws Exception {
    }

    @org.junit.Test
    public void removeFirst() throws Exception {
    }

    @org.junit.Test
    public void removeLast() throws Exception {
    }

    @org.junit.Test
    public void getSize() throws Exception {
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
    }

}