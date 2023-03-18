class BrowserHistory {
    class Node{
        String page;
        Node next;
        Node prev;
        Node(String page) {
            this.page = page;
        }
    }
    Node root;
    Node tail;
    public BrowserHistory(String homepage) {
        root = new Node(homepage);
        tail = root;
    }
    
    public void visit(String url) {
        Node temp = new Node(url);
        tail.next = temp;
        temp.prev = tail;
        tail = tail.next;
    }
    
    public String back(int steps) {
        while(tail.prev != null && steps > 0) {
            System.out.println(tail.page);
            tail = tail.prev;
            steps -= 1;
        }
        return tail.page;
    }
    
    public String forward(int steps) {
        while(tail.next != null && steps-->0) {
            tail = tail.next;
        }
        return tail.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */