package day1;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3843/
public class UnionFindWIthPathCompressionUnionByRank {
    private int rank[];
    private int root[];
	public UnionFindWIthPathCompressionUnionByRank(int size) {
		root = new int[size];
		rank = new int[size];
		for(int i=0;i<size;i++) {
			rank[i] = i;
			root[i] = i;
		}
	}
	
	public int find(int x) {
		if(x == root[x]) {
			return x;
		}
		return find(root[x]);
	}
	
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX != rootY) {
			if(rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			}
			else if (rank[rootX]  < rank[rootY] ) {
				root[rootX ] = rootY;
			}
			else {
				root[rootY] = rootX;
				root[rootX]++;
			}
		}
	}
	
	public boolean connected(int x, int y ) {
		return root[x] == root[y];
			
		
	}
	
	public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
