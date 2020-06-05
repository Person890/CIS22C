
	/*
    @Natalie Stepankevycova
    04/20/20
    -01 linked list exercise
    Practice Class Node
 */

public class Node <T>{
	
    private T data;
    private Node next;

    //constructor
    private Node(T dataPortion){
        this(dataPortion, null);
    }

    //constructor
    private Node(T dataPortion, Node nextNode)
    {
        data = dataPortion;
        next = nextNode;
    }
    //getters
    private  T getData(){
        return data;
    }
    
    private Node getNextNode(){
        return next;
    }

    //setters
    private void setData(T newData){
        data = newData;
    }

    private void setNextNode(Node nextNode){
        next = nextNode;
    }
}


