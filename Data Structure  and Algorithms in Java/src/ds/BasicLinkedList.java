package ds;

public class BasicLinkedList <x>{
   private Node first;
   private Node last;
   private int nodeCount;
    public BasicLinkedList(){
        first = null;
        last = null;
        nodeCount = 0;

    }

    public void add(x item){
        if (first == null){
            first = new Node (item);
            last = first;
        }
        else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public void insert ( x item , int position){
        if (size() < position){
            throw new IllegalStateException(" the lisked list is samller than the position you want to insert to");

        }
        Node currentNode = first ;

        for (int i = 1; i < position && currentNode != null ;i++){
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;

    }

    public x removeAt(int position){
        if (first == null){
            throw new IllegalStateException("thr linked list is empty and there are no items to remove");

        }

        Node currentNode = first;
        Node prevNode = first;


        for (int i = 1; i < position && currentNode != null; i++){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        x nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;



    }

    public x remove(){
        if (first == null){
            throw new IllegalStateException("thr linked list is empty and there are no items to remove");

        }
        x nodeItem =  first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;


    }
    public x get(int position){
        if (first == null){
            throw new IllegalStateException("The linked list is empty and there are no items to get");

        }

        Node currentNode = first;
        for ( int i = 1; i < size()&& currentNode != null; i++ ) {
            if (i == position) {
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }

        return null;
    }
public int find(x item){
        if (first == null){
            throw new IllegalStateException("the LinkedList is empty ");

        }

        Node currentNode = first;
        for (int i = 1; i <size() && currentNode != null; i++ ){
            if (currentNode.getNodeItem().equals(item)){
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
}


public String toString(){
        StringBuffer contents = new StringBuffer();
        Node curNode = first;

        while (curNode != null){
            contents.append(curNode.getNodeItem());
            curNode = curNode.getNextNode();

            if (curNode != null){
                contents.append(",");
            }
        }
        return contents.toString();
}


    public int size(){
        return nodeCount;
    }

    private class Node {
        private Node nextNode ;
        private x nodeItem;

        public Node (x item){
            this.nextNode = null;
            this.nodeItem = item;

        }

        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }

        public Node getNextNode(){
            return nextNode;
        }

        public x getNodeItem(){
            return  nodeItem;
        }

    }
}
