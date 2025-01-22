package StrukturyDanych.Konkretne.DrzewoBinarne;

public class BSTree {
    private Node root;
    public void add(Book book) {
        root = addRecursive(root, book);
    }

    private Node addRecursive(Node current, Book book) {
        if (current == null) {
            return new Node(book);
        }

        if (compareBooks(book, current.book) < 0) {
            current.left = addRecursive(current.left, book);
        } else if (compareBooks(book, current.book) > 0) {
            current.right = addRecursive(current.right, book);
        }

        return current;
    }
    public void remove(Book book) {
        root = removeRecursive(root, book);
    }
    private Node removeRecursive(Node current, Book book) {
        if (current == null) {
            return null;
        }

        if (compareBooks(book, current.book) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            Book smallest = findMin(current.right);
            current.book = smallest;
            current.right = removeRecursive(current.right, smallest);
            return current;
        }

        if (compareBooks(book, current.book) < 0) {
            current.left = removeRecursive(current.left, book);
        } else {
            current.right = removeRecursive(current.right, book);
        }

        return current;
    }

    public Book getMin() {
        if (root == null) {
            throw new IllegalStateException("Drzewo jest puste!");
        }
        return findMin(root);
    }
    private Book findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.book;
    }

    public int getHeight() {
        return calculateHeight(root);
    }
    private int calculateHeight(Node current) {
        if (current == null) {
            return 0;
        }
        int leftHeight = calculateHeight(current.left);
        int rightHeight = calculateHeight(current.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }
    private void inOrderRecursive(Node current) {
        if (current != null) {
            inOrderRecursive(current.left);
            System.out.println(current.book);
            inOrderRecursive(current.right);
        }
    }
    private int compareBooks(Book b1, Book b2) {
        if (b1.getRokWydania() != b2.getRokWydania()) {
            return Integer.compare(b1.getRokWydania(), b2.getRokWydania());
        }
        int titleComparison = b1.getTytuł().compareTo(b2.getTytuł());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return b1.getAutor().compareTo(b2.getAutor());
    }
    public static void main(String[] args) {
        BSTree bst = new BSTree();

        bst.add(new Book(2005, "Harry Potter", "J.K. Rowling"));
        bst.add(new Book(1997, "The Book Thief", "Markus Zusak"));
        bst.add(new Book(2005, "Harry Potter", "A. New Author"));
        bst.add(new Book(2020, "The Midnight Library", "Matt Haig"));
        bst.add(new Book(2005, "The Midnight Library", "Another Author"));

        System.out.println("Książki w drzewie (in-order traversal):");
        bst.inOrderTraversal();

        System.out.println("\nMinimalna książka: " + bst.getMin());

        System.out.println("\nWysokość drzewa: " + bst.getHeight());

        bst.remove(new Book(2005, "Harry Potter", "J.K. Rowling"));
        System.out.println("\nDrzewo po usunięciu książki:");
        bst.inOrderTraversal();
    }
}
