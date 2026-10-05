class Solution {
    Set<Integer> visited = new HashSet<>();
    Set<Node> originNodes = new HashSet<>();
    Node[] nodes;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);
        nodes = new Node[visited.size() + 1];

        for (Node n : originNodes) {
            nodes[n.val] = new Node(n.val);
        }

        for (Node n : originNodes) {
            List<Node> neighbors = nodes[n.val].neighbors;

            for (Node originNeighbor : n.neighbors) {
                neighbors.add(nodes[originNeighbor.val]);
            }
        }

        return nodes[1];
    }

    public void dfs(Node node) {
        visited.add(node.val);    
        originNodes.add(node);

        for (Node next : node.neighbors) {
            if (visited.contains(next.val)) continue;
            dfs(next);
        }

    }
}
