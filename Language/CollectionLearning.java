import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * CollectionLearning
 */
public class CollectionLearning {
    //List
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    Vector<Integer> vector = new Vector<Integer>();
    //Set
    HashSet<Integer> hashSet = new HashSet<Integer>();
    TreeSet<Integer> treeSet = new TreeSet<Integer>();
    //Queue
    //阻塞队列
    ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
    PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
    DelayQueue<Delayed> delayQueue = new DelayQueue<>();
    SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
    LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
    //非阻塞队列
    LinkedList<Integer> linkedList2 = new LinkedList<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    //Map
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public static void main(String[] args) {
        CollectionLearning c = new CollectionLearning();
        c.hashMap.put(11, 1);
        c.hashMap.put(22, 2);
        c.hashMap.put(33, 3);
        System.out.println("dasdasdad".hashCode());

    }

}
