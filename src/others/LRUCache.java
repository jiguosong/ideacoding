package others;

import java.util.*;

class Node {
	int key;
	int value;
	Node left, right;
	
	Node() {
		this.left = this;
		this.right = this;
	}	
}

public class LRUCache {
	private int capacity;
	private Node head;
	private Node tail;
	private int size;
	private Map<Integer, Node> hashmap = new HashMap<Integer, Node>();
	
	LRUCache(int capacity){
		this.capacity = capacity;
		this.head = new Node();
		this.tail = new Node();
		this.head.right = tail;
		this.tail.left = head;
		this.size = 0;
	}
	
	public void print_cache_order() {
		Node tmp = head.right;
		while (tmp != tail) {
			System.out.print(tmp.key + " ");
			tmp = tmp.right;
		}
	}
	
	public int get(int key) {
		if (hashmap.containsKey(key)) {
			Node tmp = hashmap.get(key);
			
			// update the cache
			remove_node_fromList(tmp);
			add_node_toList(tmp);
			return tmp.value;
		}
		return Integer.MIN_VALUE; // does not exist		
	}
	
	public void set(int key, int value) {
		if (this.get_capacity() == 0) return;
		if (hashmap.containsKey(key)) {
			Node tmp = hashmap.get(key);
			tmp.value = value;			
			remove_node_fromList(tmp);
			add_node_toList(tmp);
		} else {
			Node newone = new Node();
			newone.key = key;
			newone.key = value;
			hashmap.put(key, newone);
			add_node_toList(newone);
		}
	}
	
	private void add_node_toList(Node node) {
		size++;
		if (head.right == tail) {   // empty
			head.right = node;
			node.left = head;
			node.right = tail;
			tail.left = node;
		} else {
			Node tmp = head.right;
			node.right = tmp;
			tmp.left = node;
			head.right = node;
			node.left = head;
			if (size > capacity) remove_node_fromList(tail.left);
		}
	}
	
	private void remove_node_fromList(Node node) {
		size--;
		Node prev = node.left;
		Node next = node.right;
		
		prev.right = next;
		next.left = prev;
		node.left = node;
		node.right = node;
	}
	

	private int get_capacity() {
		return this.capacity;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LRUCache testcache = new LRUCache(10);
		testcache.set(1, 100);
		testcache.set(2, 101);
		testcache.set(3, 102);
		testcache.set(4, 103);
		testcache.get(2);
		testcache.set(5, 104);
		testcache.set(6, 105);
		testcache.set(7, 106);
		testcache.set(8, 107);
		testcache.set(9, 108);
		testcache.get(6);
		testcache.set(10, 109);
		testcache.get(7);
		testcache.set(12, 111);
		testcache.print_cache_order();
		

	}

}
