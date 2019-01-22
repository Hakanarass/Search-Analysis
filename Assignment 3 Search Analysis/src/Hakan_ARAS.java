import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/* Hakan ARAS, 09 January 2019 */
/* ID: 041701036 */
/* Search Analysis */
/* The program tests the search performance of Array List, Linked List and Binary Search Trees. */

public class Hakan_ARAS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> tempList = new ArrayList<Integer>(); //temp ArrayList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		BST<Integer> bstList = new BST<Integer>();
         
		int size = 1000; //size of Array
		System.out.println(
				"Sequence Size; Array List Search Time; Hash Map Search Time; Linked List Search Time; BST Search Time");
		while (size <= 100000) {

			fillList(tempList, size);
			Collections.shuffle(tempList);
			
			for (int i = 0; i < tempList.size(); i++) { //add variables to lists
				arrayList.add(tempList.get(i));
				linkedList.addLast(tempList.get(i));
				hashMap.put(tempList.get(i), tempList.get(i));
				bstList.insert(tempList.get(i));
			}
			
			long startArrayList = System.nanoTime(); // Take a start time
			for (int i = 0; i < size; i++) {
				arrayList.contains(i);
			}
			long finishArrayList = System.nanoTime(); // Take a finish time
			double elapsedTimeMilliSecondsAL = (finishArrayList - startArrayList) / 1000000.0;

			long startHashMap = System.nanoTime();// Take a start time
			for (int i = 0; i < size; i++) {
				hashMap.containsKey(i);
			}
			long finishHashMap = System.nanoTime(); // Take a finish time
			double elapsedTimeMilliSecondsHM = (finishHashMap - startHashMap) / 1000000.0;

			long startLinked = System.nanoTime();// Take a start time
			for (int i = 0; i < size; i++) {
				linkedList.indexOf(i);
			}
			long finishLinked = System.nanoTime();// Take a finish time
			double elapsedTimeMilliSecondsLL = (finishLinked - startLinked) / 1000000.0;

			long startBST = System.nanoTime();// Take a start time
			for (int i = 0; i < size; i++) {
				bstList.search(i);
			}
			long finishBST = System.nanoTime();// Take a finish time
			double elapsedTimeMilliSecondsBST = (finishBST - startBST) / 1000000.0;
		
			
			System.out.println(size + ";" + String.format("%.2f", elapsedTimeMilliSecondsAL) + ";"
					+ String.format("%.2f", elapsedTimeMilliSecondsHM) + ";"
					+ String.format("%.2f", elapsedTimeMilliSecondsLL) + ";"
					+ String.format("%.2f", elapsedTimeMilliSecondsBST));
			tempList.clear(); //Clear all lists.
			arrayList.clear();
			linkedList.clear();
			hashMap.clear();
			for (int i = 0; i < size+1; i++) { //Clear BST list.
				bstList.delete(i);
			}
			size = size + 1000; // increase to size
		}

	}

	public static void fillList(ArrayList<Integer> arrayList, int size) {
		// Fill the array with random integers with values in the range [0,size]
		for (int i = 1; i < size + 1; i++) {
			arrayList.add(i);
		}
	}
}
