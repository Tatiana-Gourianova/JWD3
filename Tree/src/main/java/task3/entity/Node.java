package task3.entity;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.LinkedList;
import java.util.List;

public class Node<T1, T2> {//abstract?
    private T1 tag;
    private T2 text;
    //  private Node<T1, T2> child;
    // private Node<T1, T2> parent;
    private LinkedList<Node> linkedList = new LinkedList<>();

    public LinkedList<Node> getLinkedList() {
        LinkedList<Node> linkedList2 = new LinkedList<>();
        for (Node node : linkedList) {
            linkedList2.add(node);
        }
        linkedList2.add(new Node(getTag(), getText()));
        return linkedList2;
    }

    public Node() {
        this.tag = null;
        this.text = null;
        linkedList.add(null);
    }

    public Node(T1 tag, T2 text) {
        this.tag = tag;
        this.text = text;

    }

    public T1 getTag() {
        return tag;
    }

    public void setTag(T1 tag) {
        this.tag = tag;
    }

    public T2 getText() {
        return text;
    }

    public void setText(T2 text) {
        this.text = text;
    }

    public void print() {
        LinkedList<Node> linkedList2 = (LinkedList<Node>) this.getLinkedList().clone();
        for (Node node : linkedList2) {
            System.out.println(node.getTag() + " " + node.getText());
        }
        System.out.println(getTag() + " " + getText());
    }


   public T2 get(T1 k) {
        T2 result = null;
        for (Node node : linkedList) {
            if (node.tag == k)
                result = (T2) node.text;
        }
        return result;
    }


   /* public T1 get(T2 v) {
        T1 result = null;
        for (Node node : linkedList) {
            if (node.text == v)
                result = (T1) node.tag;
        }
        return result;
    }*/

    public void add(T1 k, T2 v) {
        Node node = new Node(getTag(), getText());
        linkedList.add(node);
        setTag(k);
        setText(v);
    }

    @Override
    public String toString() {
        LinkedList<Node> linkedList2 = (LinkedList<Node>) this.getLinkedList().clone();
        String result = "";
        for (Node node : linkedList2) {
            result += tag.toString() + " " + text.toString() + '\n';
        }
        return result;
    }

    @Override
    public boolean equals(Object o){
        boolean result=false;
//if ((o!=null)&&(this!=null)) {
    Node node = (Node) o;


    if ((o == null) && ((tag == null) || (text == null) && (linkedList == null))) {
        result = true;

    }
    else if (((node.linkedList.size()==0)&&(linkedList.size()==0))&& (node.tag == tag) && (node.text == text))
    { result =  true;
    } else if( ((node.tag == tag) && (node.text == text))&&(linkedList.equals(node.linkedList)))
    {result=true;
        }

        return result;
    }

    public void setAtributes(List<String> atributes) {
    }

    //public void add(Node node) {
      //  linkedList.add(node);
    //}

    // public static void main(String[] args) {

     /*  Node node2=null;
        Node node3=null;
       boolean is=node3.equals(node2);
       System.out.print("kl"+node2.equals(node3));
        String tag = "<breakfast>";
        String text = "egg";
       Node  node = new Node(tag, text);
       Node node1= new Node(tag,text);
       System.out.print("kl2"+node.equals(node1));
        String tag1 = "<breakfast1>";
        String text1 = "egg1";
        node.add(tag1, text1);


        String tag2 = "<breakfast2>";
        String text2 = "egg2";
        node.add(tag2, text2);

        String tag3 = "<breakfast3>";
        String text3 = "egg3";
        node.add(tag3, text3);

        String tag4 = "<breakfast4>";
        String text4 = "egg4";
        node.add(tag4, text4);
        String tag5 = "<breakfast5>";
        String text5 = "egg5";
        node.add(tag5, text5);


       //  System.out.println(node.getLinkedList());
String t= (String) node.get("<breakfast3>");
//);
        //LinkedList<Node> linkedList2;
        //linkedList2=node.getChildren();
       System.out.println("(:"+t);
       node.print();
//System.out.println(node.getLinkedList().getLast());

    }
*/
}




