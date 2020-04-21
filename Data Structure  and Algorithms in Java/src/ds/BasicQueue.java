package ds;

public class BasicQueue <x> {
    private x[] data;
    private int front ;
    private int end ;

    public BasicQueue(){
        this(1000);
    }

    public BasicQueue( int size){
        this.front = -1;
        this.end = -1;
        data = (x[])new Object[size];
    }


    public int size(){
        if (front == -1 && end == -1){
            return 0;
        }
        else{
            return end - front + 1;
        }
    }


        public void enQueue(x item){
         if ((end +1 )% data.length == front){
             throw new IllegalStateException("the Queue is full");
         }
         else if (size() ==0){
             front++;
             end++;
             data[end] = item;
         }
         else {
             end++;
             data[end]= item;
         }

        }

        public x deQueue(){
        x item = null;

        if (size() == 0){
            throw new IllegalStateException("can't dequeue because the queue is empty!");

        }
        else if (front == end ){
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }
        else {
            item = data[front];
            data[front]= null;
            front++;
        }
        return item ;
        }


        public boolean contains(x item){
        boolean found = false ;

        if (size() == 0){
            return found ;
        }
        for (int i = front ; i < end; i++){
            if (data[i].equals(item)){
                found = true;
                break;
            }
        }
        return found ;
        }

        public x access(int position){
        if (size() == 0 || position > size()){
            throw new IllegalArgumentException("No items in the queue or the position is greater ");
        }

        int trueIndex = 0;
        for ( int i = front ; i < end ;i++ ){
            if(trueIndex == position){
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException("could not get queue item as position "+ position);

        }
}
