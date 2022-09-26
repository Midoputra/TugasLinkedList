public class LinkedList {
  private Node first;
  private int length = 0;

  static class Node {
    private int value;
    private Node next;

    public Node(int value) { this.value = value; }
    public void setNext(Node next) { this.next = next; }
    public Node getNext() { return this.next; }
    public int getValue() { return this.value; }
  }

  public LinkedList() { this.first = null; }
  public void add(int value) {
    Node temp = new Node(value);
    if (this.first == null) {
      this.first = temp;
    } else {
      temp.setNext(first);
      first = temp;
    }
    length++;
  }
  public void insert(int index, int value) {
    if (index > length || index < 0) {
      System.out.println("posisi  " + index + "  tidak ditemukan");
      return;
    }
    Node temp = new Node(value);
    if (0 == index) {
      temp.setNext(first);
      first = temp;
    } else {
      Node CariNode = carinode(index - 1);
      temp.setNext(CariNode.getNext());
      CariNode.setNext(temp);
    }
    length++;
  }
   public Node cariNode(int index){
     Node currentNode = this.first;
     for (int i = 0; i < index; i++){
       currentNode = currentNode.getNext();
       if ( currentNode == null){
         System.out.println(index + "posisi tidak ditemukan");
       }
     }
     return currentNode;
   }

  public void remove(int index) {
    if (index > length || index < 0) {
      throw new IndexOutOfBoundsException(" posisi tidak ditemukan");
    }
    if (index == 0) {
      first = this.first.getNext();
    } else {
      Node node = carinode(index - 1);
      Node temp = node;

      for (int i = 0; i < 2; ++i) {
        if (temp != null) {
          temp = temp.getNext();
          node.setNext(temp);
        }
      }
    }
  }
  public void swap(int index1, int index2) {
    if (index1 < length && index2 < length && index1 >= 0 && index2 >= 0) {
      int tempindex1 = Math.max(index1, index2);
      int tempindex2 = Math.min(index1, index2);
      index1 = tempindex1;
      index2 = tempindex2;

      Node temp1 = carinode(index1);
      Node temp2 = carinode(index2);
      remove(index2);
      insert(index2 + 1, temp1.getValue());
      insert(index1 + 1, temp2.getValue());
      remove(index1);
    }
  }
  public Node carinode(int index) {
    Node currentNode = this.first;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }

    return currentNode;
  }

  public void showAll(String a) {
    var temp = first;
    if (a != null) {
      System.out.println(a + ": ");
    }
    while (temp != null) {
      System.out.print(temp.getValue() + " ");
      temp = temp.getNext();
    }
    System.out.print("\n");
  }

  public void removeDuplikat() {
    int current = 0;
    Node currentNode = carinode(current);

    while (currentNode != null) {
      int nextInt = current + 1;
      Node next = currentNode.getNext();
      while (next != null) {
        if (next.getValue() == currentNode.getValue()) {
          nextInt -= 1;
          remove(nextInt);
        }

        nextInt += 1;
        next = next.getNext();
      }

      current += 1;
      currentNode = currentNode.getNext();
   }
}

  public void deleteValue(int value) {
    Node temp = first;
    int index = length;
    for (int i = 0; i < index; i++) {
      if (temp != null) {
        if (temp.getValue() == value) {
          remove(i);
        }
        temp = temp.getNext();
      }
    }
  }
  
  

  public void FirstLastSwap() {
    Node current = first, temp = null, index = null;

    if (first == null) {
      return;
    } else {
      while (current.next != null) {
        index = current;
        current = current.next;
      }

      if (first == current) {
        return;
      }
      else if (first.next == current) {
        temp = first;
        first = current;
        first.next = temp;
        temp.next = null;
      } else {
        temp = first;
        first = current;
        first.next = temp.next;
        index.next = temp;
        temp.next = null;
      }
    }
  }


  public static void main(String[] args) {
    try {
      LinkedList a = new LinkedList();
      a.add(2);
      a.add(2);
      a.add(6); 
      a.add(10);
      a.add(5);
      a.removeDuplikat();
      a.deleteValue(10);
      a.FirstLastSwap();

      a.showAll("end");
      System.out.println(a.toString());

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}