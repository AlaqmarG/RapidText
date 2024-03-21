public class node {
    String item;
    node next, prev;

    public node(String i, node p, node n) {
        item = i;
        prev = p;
        next = n;
    }
}
