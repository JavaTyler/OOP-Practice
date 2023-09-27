package LinkedList;

public class SingleLinkedList<T> extends SingleLinkedListAbstract<T> implements SingleLinkedListInterface<T> {

   @Override
   public boolean isEmpty() {
       return size == 0;
   }

   @Override
   public int size() {
       return size;
   }

   @Override
   public boolean contains(T o) {
       LinkedListNode<T> currentNode = head;
       while(currentNode != null)
       {
           if(currentNode.getValue().equals(o))
               return true;

           currentNode = currentNode.getNext();
       }
       return false;
   }

   @Override
   public T[] toArray() {
       T[] result = makearray(size);

       int i = 0;
       LinkedListNode<T> currentNode = head;
       while(currentNode != null)
       {
           result[i++] = currentNode.getValue();
           currentNode = currentNode.getNext();
       }

       return result;
   }

   @Override
   public void add(T e) {

       LinkedListNode<T> newNode = new LinkedListNode<T>(e);
       if(size == 0) {
           head = newNode;
       }
       else
           tail.setNext(newNode);
       tail = newNode;
       size++;
   }

   @Override
   public void add(int index, T element) throws IndexOutOfBoundsException {
       if(index < 0)
           throw new IndexOutOfBoundsException();
       else if(index >= size)
       {
           add(element);
           return;
       }

       LinkedListNode<T> currNode = head;
       LinkedListNode<T> newNode = new LinkedListNode<T>(element);
       LinkedListNode<T> prevNode = null;
       for(int i = 0; i < index; i++)
       {
           prevNode = currNode;
           currNode = currNode.getNext();
       }

       if(prevNode != null)
           prevNode.setNext(newNode);

       if(index == 0)
           head = newNode;

       newNode.setNext(currNode);
       size++;
   }

   @Override
   public boolean remove(T o) {
       LinkedListNode<T> currNode = head;
       LinkedListNode<T> prevNode = null;
       while(currNode != null)
       {
           if(currNode.getValue().equals(o))
           {
               if(currNode == tail)
                   tail = prevNode;

               if(currNode == head)
                   head = currNode.getNext();
               else
                   prevNode.setNext(currNode.getNext());

               size--;
               return true;
           }
           prevNode = currNode;
           currNode = currNode.getNext();
       }

       return false;
   }

   @Override
   public T remove(int index) throws IndexOutOfBoundsException {
       if(index < 0 || index >= size)
           throw new IndexOutOfBoundsException();

       // index = 3
       // A - B - C - D
       LinkedListNode<T> currNode = head;
       LinkedListNode<T> prevNode = null;
       for(int i = 0; i < index; i++)
       {
           prevNode = currNode;
           currNode = currNode.getNext();
       }

       if(currNode == tail)
           tail = prevNode;

       if(currNode == head)
           head = currNode.getNext();
       else
           prevNode.setNext(currNode.getNext());

       size--;

       return currNode.getValue();
   }

   @Override
   public void clear() {
       size = 0;
       head = null;
       tail = null;
   }

   @Override
   public T get(int index) throws IndexOutOfBoundsException {
       if(index < 0 || index >= size)
           throw new IndexOutOfBoundsException();

       LinkedListNode<T> currNode = head;
       for(int i = 0; i < index; i++)
       {
           currNode = currNode.getNext();
       }

       return currNode.getValue();
   }

   @Override
   public T set(int index, T e) throws IndexOutOfBoundsException {
       if(index < 0 || index >= size)
           throw new IndexOutOfBoundsException();

       LinkedListNode<T> currNode = head;
       LinkedListNode<T> prevNode = null;
       for(int i = 0; i < index; i++)
       {
           prevNode = currNode;
           currNode = currNode.getNext();
       }

       T original = currNode.getValue();
       LinkedListNode<T> newNode = new LinkedListNode<T>(e);

       if(index == 0)
           head = newNode;
       else
           prevNode.setNext(newNode);

       if(currNode == tail)
           tail = newNode;

       newNode.setNext(currNode.getNext());

       return original;
   }

   @Override
   public int indexOf(T e) {
       LinkedListNode<T> currNode = head;

       int index = 0;
       while(currNode != null)
       {
           if(currNode.getValue().equals(e))
           {
               return index;
           }
           index++;
           currNode = currNode.getNext();
       }

       return -1;
   }

   @Override
   public int lastIndexOf(T o) {
       LinkedListNode<T> currNode = head;

       int index = 0;
       int lastIndexOf = -1;
       while(currNode != null)
       {
           if(currNode.getValue().equals(o))
           {
               lastIndexOf = index;
           }
           index++;
           currNode = currNode.getNext();
       }

       return lastIndexOf;
   }

}


