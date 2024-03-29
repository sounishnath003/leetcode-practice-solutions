class Solution {
	private static class UnionFind {
		private int[] parents;
		private int vertices;

		public UnionFind(int vertices) {
			super();
			this.vertices = vertices;
			this.parents = new int[vertices + 1];
			for (int i = 0; i < vertices; i++)
				parents[i] = i;
		}

		@Override
		public String toString() {
			return "UnionFind [parents=" + Arrays.toString(parents) + ", vertices=" + vertices + "]";
		}

		public void union(int u, int v) {
			if (u != v) {
				int pa = find(u);
				int pb = find(v);
				parents[pb] = pa;
			}
		}

		private int find(int u) {
			// TODO Auto-generated method stub
			int x = u;
			while (x != parents[x]) {
				x = parents[x];
			}
			parents[u] = x;
			return x;
		}

		public boolean areConnected(int u, int v) {
			return find(u) == find(v);
		}
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
//			return DFSTraversalMethod(n, edges, source, destination);
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			uf.union(u, v);
		}
		return uf.areConnected(source, destination);
	}

	private boolean DFSTraversalMethod(int n, int[][] edges, int source, int destination) {
		try {
			Map<Integer, List<Integer>> graph = buildGraph(edges);

			boolean[] visitedVertices = new boolean[n];
			Stack<Integer> stack = new Stack<>();

			markAsVisited(source, visitedVertices, stack);
			while (!stack.isEmpty()) {
				int node = stack.pop();
				for (int neighbour : graph.get(node)) {
					if (neighbour == destination)
						return true;
					if (!visitedVertices[neighbour]) {
						markAsVisited(neighbour, visitedVertices, stack);
					}
				}
			}

			return false;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			graph.putIfAbsent(u, new ArrayList<>());
			graph.putIfAbsent(v, new ArrayList<>());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		return graph;
	}

	private void markAsVisited(int source, boolean[] visitedVertices, Stack<Integer> stack) {
		visitedVertices[source] = true;
		stack.add(source);
	}
}
