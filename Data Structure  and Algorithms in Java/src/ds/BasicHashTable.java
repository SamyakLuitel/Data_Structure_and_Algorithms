package ds;

public class BasicHashTable <x ,y>{
    private HashEntry[] data;
    private int capacity;
    private int size =0;


    public BasicHashTable (int tableSize){
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];

    }


        public y get(x key){
        int hash = calculateHash(key);


        if (data[hash]== null){
            return null;
        }
        else {
            return (y)data[hash].getValue();
        }
        }


        public void put(x key, y value){
        int hash = calculateHash(key);

        data[hash]  = new HashEntry <x , y>(key, value);
        size ++;
        }


        public y delete(x key){
        y value = get(key);

        if (value != null){
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
            hash = (hash + 1) % this.capacity;


            while (data[hash]!= null){
                HashEntry he = data[hash];
                data[hash] = null;
                size --;
                hash = (hash +1)% this.capacity;
            }
            }
        return value;
        }

        public boolean hasKey (x key){

        int hash = calculateHash(key);

        if (data[hash]== null){
            return  false;
        }

        else{
            if(data[hash].getKey().equals(key)){
                return true;
            }
        }
        return false;
        }


        public boolean hasValue(y value){
        for (int i = 0 ; i < this.capacity; i++){
            HashEntry entry = data[i];

            if (entry != null && entry.getValue().equals(value)){
                return  true;
            }
        }
        return false;
        }

    private int calculateHash(x key){
        int hash = (key.hashCode() % this.capacity);

        while (data[hash] != null && !data[hash].getKey().equals(key)){
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    public int size(){
        return this.size;

    }

    private class HashEntry<x , y>{
        private x key;
        private y value ;

        public HashEntry(x key, y value){
            this.key = key;
            this.value = value ;
        }

        public x getKey(){
            return key;
        }

        public void setKey(x key){
            this.key = key;
        }


        public y getValue(){
            return value;
        }

        public void setValue(y value){
            this.value = value;
        }
    }
}
