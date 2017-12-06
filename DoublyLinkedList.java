public class DoublyLinkedList {

    private Element firstElement;
    private int size;


    public DoublyLinkedList() {
        size = 0;
    }
    private class Element {
        Element prev;
        Element post;
        String value;
        int index;

        public Element(Element prev, Element post, String value, int index) {
            this.prev = prev;
            this.post = post;
            this.value = null;
            this.index = index;
        }
    }

    /**
     * creates new element at beginning of list
     * links it to the second
     */
    public void addFirst(String value){
        Element newElement = new Element(null, null, value, 1);
        Element prevElement = null;
        Element postElement = null;
        if(isEmpty()) {
            this.firstElement = newElement;
            newElement.prev = this.firstElement;
            newElement.post = this.firstElement;
            this.size++;
        }else if (size == 1 || size < this.firstElement.index) {
                prevElement = this.firstElement.post;
                postElement = this.firstElement;
                this.firstElement = newElement;
        }
        // only if addFirst
        //TODO do I realy need this??
        if (size == 1) {
            int momIndex = 1;
            Element momElement = this.firstElement.post;
            //increase index until gap
            while (momElement.index == momIndex) {
                momIndex++;
                momElement.index = momIndex;
                momElement = momElement.post;
            }
        }
    }

    /**
     * inserts object of element at end of list
     */
    public void addLast(String value) {
        Element newElement = new Element(null, null, value, this.firstElement.prev.index + 1);
        Element prevElement = null;
        Element postElement = null;
        if(size != 0){
            if (size > this.firstElement.post.index) {
                prevElement = this.firstElement.post;
                postElement = this.firstElement;
            }
        }else{
            addFirst(value);
            System.out.println("For list was empty, element has been inserted as first element.");
        }

    }

    /**
     * Inserts element at place of given index into list.
     *
     */
    public void add(int index, String value) {
        Element newElement = new Element(null, null, value, this.firstElement.prev.index + 1);
        Element prevElement = null;
        Element postElement = null;
        Element lastElement = firstElement.prev;
        if (index < 1) {
            System.out.println("Index was set to 1. Indices start with 1");
            index = 1;
        }
        if (isEmpty() || index == 1) {
           addFirst(value);
        }else if(index > lastElement.index){
            addLast(value);
        }else{
            Element currentElement = this.firstElement;
            while(currentElement.index <= lastElement.index){
                if(currentElement.index == index) {
                    System.out.println("Index already in use.");
                    return;
                }else if(currentElement.index > index){
                    newElement.index = index;
                    currentElement.prev.prev = newElement.prev;
                    currentElement = newElement.post;
                }
            }
        }
        size++;
    }

    /**
     * reads value at given index.
     */
    public String get(int index) {
        if (size == 0) {
            return "Error: Cannot read from an empty list";
        }
        if (index > firstElement.prev.index) {
            return "Error: No element with index " + index + " found";
        }
        if (index < 1) {
            return "Error: No valid index. Indices musst be positive integers strating with 1";
        }
        Element momElement = this.firstElement;
        while (momElement.index < index) {
            momElement.post = momElement;
        }
        if (momElement.index == index) {
            return momElement.value;
        } else {
            return "Error: No element with index " + index + " found";
        }
    }

    /**
     * deletes first element of list.
     */
    public String removeFirst() {
        if (size == 0) {
            return "Error: Cannot delete from an empty list.";
        }
        if(size > 1){
            firstElement.prev.post = firstElement.post;
            firstElement.post.prev = firstElement.prev;
            firstElement.post = firstElement;
            this.size--;
        }else{
            firstElement = null;
        }
        return "First element has been deleted.";
    }

    /**
     * Deletes last element of list.
     */
    public String removeLast() {
        if (size == 0) {
            return "Error: Cannot delete from an empty list.";
        } else if (size == 1) {
            return "Error: List has no last element, only a first";
        } else {
            firstElement.prev.prev.post = firstElement;
            firstElement.prev = firstElement.prev.prev;
            this.size--;
        }
        return "Last element has been deleted";
    }

    /**
     * returns number of list elements.
     */
    public int getSize() {
        return size;
    }

    /**
     * return whether the list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }


    public String toStringValue(){
        String output = null;
        Element momElement = this.firstElement;
        while(momElement.index < firstElement.prev.index){
            output += (momElement.value);
        }
        return output;
    }

    public String toStringIndex(){
        String output = null;
        Element momElement = this.firstElement;
        while(momElement.index < firstElement.prev.index){
            output += (momElement.index + "/n");
        }
        return output;
    }

}


