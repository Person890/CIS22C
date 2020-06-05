/*
 * CIS 22C - Data Structures
 * Spring 2020
 * 
 * @author Natalie Stepankevycova
 * 
 * This program implements the LinkedQueue ADT
*/

public class LinkedQueue<T> implements QueueInterface<T> {

     
	// create node
      class Node {

            T data;

            Node next; //link to next node

            // constructor

            public Node(T data) {

                  this.data = data;

            }

      } 

     // two references of Node

      private Node head, tail;

      // creating empty queue

      public LinkedQueue() {

            head = tail = null;

      }

      @Override

      public void enqueue(T newEntry) {

            // creating new node

            Node a = new Node(newEntry);

            // if the node is empty

            if (isEmpty()) {

                  head = tail = a;

            } else {
            	
                  tail.next = a;

                  tail = a;

            }

      }

      
      @Override

      public T getFront() {

           // if queue is empty

            if (isEmpty()) {

                  throw new EmptyQueueException("Queue is empty.");
            }

            // will return data if not empty

            return head.data;

      }

      @Override

      // check if queue is empty
      public boolean isEmpty() {

            return head == null;

      }
      
      @Override

      public T dequeue() {

            if (isEmpty()) { // exception if queue is empty

                  throw new EmptyQueueException("Queue is empty.");

            }

           // otherwise taking data

            T data = head.data;

            head = head.next;

            if (head == null) {

                  tail = null;

            }

            // returning data

            return data;

      }


      @Override

      public void clear() {

           //deleting queue

            head = tail = null;

      }

} // end LinkedQueue


/*===================SAMPLE OUTPUT========================
 * Create a queue: 


isEmpty() returns true

Add to queue to get
Joe Jess Jim Jill Jane Jerry


isEmpty() returns false



Testing getFront and dequeue:

Joe is at the front of the queue.
Joe is removed from the front of the queue.

Jess is at the front of the queue.
Jess is removed from the front of the queue.

Jim is at the front of the queue.
Jim is removed from the front of the queue.

Jill is at the front of the queue.
Jill is removed from the front of the queue.

Jane is at the front of the queue.
Jane is removed from the front of the queue.

Jerry is at the front of the queue.
Jerry is removed from the front of the queue.


The queue should be empty: isEmpty() returns true


Add to queue to get
Joe Jess Jim


Testing clear:


isEmpty() returns true


Add to queue to get
Joe Jess Jim

Joe is at the front of the queue.
Joe is removed from the front of the queue.

Jess is at the front of the queue.
Jess is removed from the front of the queue.

Jim is at the front of the queue.
Jim is removed from the front of the queue.



The queue should be empty: isEmpty() returns true

The next calls will throw an exception.

Exception in thread "main" EmptyQueueException: Queue is empty!
	at LinkedQueue.getFront(LinkedQueue.java:101)
	at Driver.testQueueOperations(Driver.java:76)
	at Driver.main(Driver.java:12)
*/



