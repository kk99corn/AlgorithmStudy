package section07;

/*
section: 07-05
title: 이진트리순회(DFS)
*/
class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int n) {
        data = n;
    }
}

public class Q05DFS {
    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Q05DFS t = new Q05DFS();
        t.root = new Node(1);
        t.root.lt = new Node(2);
        t.root.rt = new Node(3);
        t.root.lt.lt = new Node(4);
        t.root.lt.rt = new Node(5);
        t.root.rt.lt = new Node(6);
        t.root.rt.rt = new Node(7);

        t.DFS(t.root);
    }
}