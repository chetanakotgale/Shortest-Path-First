package Week5;

/**
 *  This program is used to find shortest path.
 *  
 * @author chetana.
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Shortest_Path_First {
		  static class Graph {
		    public List<List<Integer>> nodes;
		    
		    public Graph(int numberOfNodes) {
		      nodes = new ArrayList<>();
		      for (int i = 0; i < numberOfNodes; i++) {
		        nodes.add(new ArrayList<Integer>());
		      }
		    }
		  }
		  public static void main(String[] args) {
		    Scanner scan = new Scanner(System.in);
		    int numberOfTestCases = scan.nextInt();
		    for (int i = 0; i < numberOfTestCases; i++) {
		      processTestCase(scan);
		    }
		  }
		  
		  static void processTestCase(Scanner scan) {
		    int numberOfNodes = scan.nextInt();
		    int numberOfEdges = scan.nextInt();
		    Graph graph = new Graph(numberOfNodes);
		    for (int edgeCounter = 0; edgeCounter < numberOfEdges; edgeCounter++) {
		      int nodeOne = scan.nextInt() - 1;
		      int nodeTwo = scan.nextInt() - 1;
		      graph.nodes.get(nodeOne).add(nodeTwo);
		      graph.nodes.get(nodeTwo).add(nodeOne);
		    }
		    int startNode = scan.nextInt() - 1;
		    List<Integer> distances = bfs(graph, startNode);
		    for (int i = 0; i < numberOfNodes; i++) {
		      if (i != startNode) {
		        System.out.print(distances.get(i) + " ");
		      }
		    }
		    System.out.println();
		  }
		  
		  static List<Integer> bfs(Graph graph, int startNode) {
		    List<Integer> distances = new ArrayList<>();
		    for (int i = 0; i < graph.nodes.size(); i++) {
		      distances.add(-1);
		    }
		    Queue<Integer> queue = new LinkedList<>();
		    queue.add(startNode);
		    distances.set(startNode, 0);
		    while (!queue.isEmpty()) {
		      int node = queue.remove();
		      List<Integer> newNodes = graph.nodes.get(node);
		      for (Integer newNode : newNodes) {
		        if (distances.get(newNode) == -1) {
		          queue.add(newNode);
		          distances.set(newNode, distances.get(node) + 6);
		        }
		      }
		    }
		    return distances;
		  }

}
