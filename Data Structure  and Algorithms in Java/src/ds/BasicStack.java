package ds;


public class BasicStack<x>{
    private x[] data;
    private int stackPointer;

    public BasicStack(){
        data = (x[]) new Object[1000];
        stackPointer = 0;


    }
     public void push( x newItem){
        data[stackPointer++] = newItem;
     }

     public x pop(){
       if (stackPointer == 0){
           throw new IllegalStateException(" No more items on the stack");
       }
        return data[--stackPointer];
     }

     public boolean contains( x item){
        boolean found = false;

        for ( int i = 0 ; i < stackPointer; i++){
            if ( data[i].equals(item)){
                found = true;
                break;
            }



        }
         return found ;
     }

     public x access(x item){
        while(stackPointer > 0){
            x tmpItem = pop();
            if(item.equals(tmpItem)){
                return tmpItem;
            }
        }
        // if we didn;t find the items sin the stack throw an exception
         throw new IllegalArgumentException("could not find item on the stack " + item);
     }

     public int size(){
        return stackPointer;
     }
}
