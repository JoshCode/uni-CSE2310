package nl.codefox.tudelft.cse2310.greedy.ex11;

import java.util.*;

public class PlanningStoreLocations {
	
	/**
	 * @param n      the number of houses
	 * @param k      the number of stores to place
	 * @param houses the houses, indexed 0 to n (with ids 0 to n)
	 * @return the places to put the stores.
	 */
	public static Set<Store> donutTime(int n, int k, List<House> houses) {
		int m = n * (n - 1) / 2;
		List<Distance> distances = new ArrayList<>(m);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				distances.add(new Distance(houses.get(i), houses.get(j)));
			}
		}
		
		Collection<List<House>> clusters = clustering(n, k, houses, distances);
		Set<Store> result = new HashSet<>();
		
		for (List<House> cluster : clusters) {
			int xSum = 0;
			int ySum = 0;
			for (House h : cluster) {
				xSum += h.x;
				ySum += h.y;
			}
			double xAvg = (double) xSum / cluster.size();
			double yAvg = (double) ySum / cluster.size();
			
			result.add(new Store(xAvg, yAvg));
		}
		
		return result;
	}
	
	private static Collection<List<House>> clustering(int n, int k, List<House> houses, List<Distance> distances) {
		if (k == 1) {
			Map<Integer, List<House>> map = new HashMap<>();
			map.put(0, new ArrayList<>());
			for (House house : houses) {
				map.get(0).add(house);
			}
			return map.values();
		}
		
		UnionFind unionFind = new UnionFind(houses);
		distances.sort(Comparator.comparingLong(d -> d.distance));
		int clusters = n;
		
		for (Distance d : distances) {
			if (clusters == k)
				break;
			
			if (unionFind.join(d.a, d.b)) {
				clusters--;
			}
		}
		
		return unionFind.clusters();
	}
	
}

class House {
	
	int id, x, y;
	
	public House(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		House house = (House) o;
		return id == house.id && x == house.x && y == house.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, x, y);
	}
}

class Distance {
	
	House a, b;
	
	long distance;
	
	public Distance(House a, House b) {
		this.a = a;
		this.b = b;
		// Square Euclidean distance, to avoid floating-point errors
		this.distance = (long) (a.x - b.x) * (a.x - b.x) + (long) (a.y - b.y) * (a.y - b.y);
	}
}

class UnionFind {
	
	private final List<House> houses;
	
	private final int[] parent;
	
	private final int[] rank;
	
	UnionFind(List<House> houses) {
		this.houses = houses;
		int n = houses.size();
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
	}
	
	/**
	 * Joins two disjoint sets together, if they are not already joined.
	 *
	 * @return false if x and y are in same set, true if the sets of x and y are now joined.
	 */
	boolean join(House x, House y) {
		int xrt = find(x.id);
		int yrt = find(y.id);
		if (rank[xrt] > rank[yrt])
			parent[yrt] = xrt;
		else if (rank[xrt] < rank[yrt])
			parent[xrt] = yrt;
		else if (xrt != yrt)
			rank[parent[yrt] = xrt]++;
		return xrt != yrt;
	}
	
	/**
	 * @return The house that is indicated as the "root" of the set of house h.
	 */
	House find(House h) {
		return houses.get(find(h.id));
	}
	
	private int find(int x) {
		return parent[x] == x ? x : (parent[x] = find(parent[x]));
	}
	
	/**
	 * @return All clusters of houses
	 */
	Collection<List<House>> clusters() {
		Map<Integer, List<House>> map = new HashMap<>();
		for (int i = 0; i < parent.length; i++) {
			int root = find(i);
			if (!map.containsKey(root))
				map.put(root, new ArrayList<>());
			map.get(root).add(houses.get(i));
		}
		return map.values();
	}
}

class Store {
	
	double x, y;
	
	public Store(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Store store = (Store) o;
		return Math.abs(store.x - x) <= 1e-4 && Math.abs(store.y - y) <= 1e-4;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Math.floor(x), Math.floor(y));
	}
	
	@Override
	public String toString() {
		return "Store{" + "x=" + x + ", y=" + y + '}';
	}
}
