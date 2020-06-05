package StackAndQueuePackage;


public class LinkedQueue<T> implements QueueInterface<T> {

      // simple Node class to represent a node

      class Node {

            // data stored in current node

            T data;

            // reference to next node

            Node next;

            // constructor taking value for data

            public Node(T data) {

                  this.data = data;

            }

      } // end Node

      // defining two references of Node class as head & tail

      private Node head, tail;

      // constructor initializing empty queue

      public LinkedQueue() {

            head = tail = null;

      }

      @Override

      public void enqueue(T newEntry) {

            // creating a new node with value=newEntry

            Node n = new Node(newEntry);

            // seting as both head and tail if queue is empty

            if (isEmpty()) {

                  head = tail = n;

            } else {

                  // otherwise appending to tail and updating tail

                  tail.next = n;

                  tail = n;

            }

      }

      @Override

      public T dequeue() {

            // throwing exception if queue is empty

            if (isEmpty()) {

                  throw new EmptyQueueException("Queue is empty!");

            }

            // fetching data at head, advancing head, updating tail if necessary

            T data = head.data;

            head = head.next;

            if (head == null) {

                  tail = null;

            }

            // returning removed data

            return data;

      }

      @Override

      public T getFront() {

            // throwing exception if queue is empty

            if (isEmpty()) {

                  throw new EmptyQueueException("Queue is empty!");

            }

            // returning data of head node

            return head.data;

      }

      @Override

      public boolean isEmpty() {

            // queue is empty if head is null

            return head == null;

      }

      @Override

      public void clear() {

            // setting head and tail to null

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



