package task3.entity;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Node<T1, T2, T3> {//abstract?
    private T1 tag;
    private T2 text;
    private T3 tag2;
   private int size;
    //  private Node<T1, T2> child;
    // private Node<T1, T2> parent;
    private LinkedList<Node> linkedList = new LinkedList<>();
    public void setLinkedList(LinkedList<Node> linkedList) {
        this.linkedList=linkedList;

    }

    public LinkedList<Node> getLinkedList() {
        /*LinkedList<Node> linkedList2 = new LinkedList<>();
        for (Node node : linkedList) {
            System.out.println(node.getText());
            linkedList2.add(node);
        }
        linkedList2.add(new Node(getTag(), getText()));*/
        return linkedList;
    }

    public Node() {
        this.tag = null;
        this.text = null;
      //  this.linkedList = new LinkedList<>();
       // linkedList.add(null);
    }

    public Node(T1 tag, T2 text, T3 tag2) {
      //  this.linkedList = new LinkedList<>();
        this.tag = tag;
        this.text = text;
        this.tag2=tag2;

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

    public void setTag2(T3 tag2){
        this.tag2=tag2;
    }

    public  T3 getTag2(){
        return tag2;
    }
    public void print() {
        LinkedList<Node> linkedList2 = (LinkedList<Node>) this.getLinkedList().clone();
        for (Node node : linkedList2) {
            System.out.println(node.getTag() + " " + node.getText()+ "" +node.getTag2());
        }



        //System.out.println(getTag() + " " + getText() + "" +getTag2());
    }
    public void printText(){
        LinkedList<Node> linkedList2 = (LinkedList<Node>) this.getLinkedList().clone();
        for (Node node : linkedList2) {
            if (node.text.toString().contains("<")!=true)
            System.out.print(" "+ node.getText()+ " \n" );
        }



    }


    public void print(int[] index) {
        LinkedList<Node> linkedList2 = (LinkedList<Node>) this.getLinkedList().clone();
        ArrayList<String> arrayList = new ArrayList<>();
        int j = 0;
        for (Node node : linkedList2) {
            arrayList.add(node.text.toString());
        }
        String[] array = {}; // конвертируем ArrayList в массив
        array = arrayList.toArray(new String[arrayList.size()]);
        HashMap<Integer, String> hashMapText = new HashMap<>();
        if (index.length <= size) {
            for (Integer i : index) {
                hashMapText.put(i, array[i]);
            }
            System.out.println(hashMapText);
            //for (Node node : linkedList2) {
            //arrayList

            //  System.out.println(node.getTag() + " " + node.getText()+ "" +node.getTag2());
        }
    }

   public T2 get(T1 k) {
        ArrayList<String> arrayList=new ArrayList<>();
        //arrayList=getLinkedList().toArray();
       LinkedList<Node>list=linkedList;
       list.peekLast();//.peekFirst();
     //  list.
        T2 result = null;
        for (Node node : list) {
            if (node.tag == k)
                result = (T2) node.text;
        }
        return result;
    }

    public T2 getWithDelete(T1 k) {
        ArrayList<String> arrayList=new ArrayList<>();
        //arrayList=getLinkedList().toArray();
        LinkedList<Node>list=new LinkedList<>();
        list=linkedList;
        list.peekLast();//.peekFirst();
        //  list.
        T2 result = null;
        for (Node node : list) {
            if (node.tag == k){
                result = (T2) node.text;
            list.remove(result);}
        }
        this.linkedList=list;
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

    public void add(T1 k, T2 v, T3 t) {
        setTag(k);
        setText(v);
        setTag2(t);
        Node node = new Node(getTag(), getText(),getTag2());

        linkedList.add(node);
        size++;
    }

    @Override
    public String toString() {
        LinkedList<Node> linkedList2 = (LinkedList<Node>) this.getLinkedList().clone();
        String result = "";
        for (Node node : linkedList2) {
            result += tag.toString() + " " + text.toString() + tag2.toString() +'\n';
        }
        return result;
    }

    @Override //дописать с учетом 3 параметра
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

     public static void main(String[] args) {
         Node  node = new Node("", "","");
     Node node2=null;
        Node node3=null;
       //boolean is=node3.equals(node2);
       //System.out.print("kl"+node2.equals(node3));
        String tag = "<breakfast>";
        String text = "egg";
       //Node  node = new Node(tag, text);
         node.add(tag,text,"");
    //   Node node1= new Node(tag,text);
   //    System.out.print("kl2"+node.equals(node1));
        String tag1 = "<breakfast1>";
        String text1 = "egg1";
        node.add(tag1, text1,"");


        String tag2 = "<breakfast2>";
        String text2 = "egg2";
        node.add(tag2, text2,"");

        String tag3 = "<breakfast3>";
        String text3 = "egg3";
        node.add(tag3, text3,"");

        String tag4 = "<breakfast4>";
        String text4 = "egg4";
        node.add(tag4, text4,"");
        String tag5 = "<breakfast5>";
        String text5 = "egg5";
        node.add(tag5, text5,"");


       //  System.out.println(node.getLinkedList());
String t= (String) node.get("<breakfast3>");
//);
        //LinkedList<Node> linkedList2;
        //linkedList2=node.getChildren();
       System.out.println("(:"+t);
       node.print();
//System.out.println(node.getLinkedList().getLast());

    }

}





