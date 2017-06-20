package sorting.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javafx.util.Pair;

/**
 * @author Murali
 * Helper class to modularize controller
 *
 */
public class Helper {
	
	/**
	 * @param arr array
	 * @return int with minimum number of swaps required to sort.
	 */
	public static int minSwaps(Integer[] arr) {

	   int n = arr.length;
	   ArrayList <Pair <Integer, Integer> > arrpos =
	             new ArrayList <Pair <Integer, Integer> > ();
	   for (int i = 0; i < n; i++)
	        arrpos.add(new Pair <Integer, Integer> (arr[i], i));

	   Collections.sort(arrpos,new Comparator<Pair<Integer, Integer>>() {

	       @Override
	       public int compare(Pair<Integer, Integer> o1,
	                          Pair<Integer, Integer> o2) {

	           if (o1.getValue() > o2.getValue())
	               return -1;

	           else if (o1.getValue().equals(o2.getValue()))
	               return 0;

	           else
	               return 1;
	       }
	   });

	   Boolean[] vis = new Boolean[n];
	   Arrays.fill(vis, false);
	   int ans = 0;
	   for (int i = 0; i < n; i++) {

	       if (vis[i] || arrpos.get(i).getValue() == i)
	           continue;
	       int cycle_size = 0;
	       int j = i;
	       while (!vis[j]) {
	           vis[j] = true;
	           j = arrpos.get(j).getValue();
	           cycle_size++;
	       }
	       ans += (cycle_size - 1);
	   }

	   return ans;
	}

}
