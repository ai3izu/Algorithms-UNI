package StrukturyDanych.Konkretne.DrzewoBinarne;

public class Node {
    Book book;
    Node left, right;

    public Node(Book book) {
        this.book = book;
        this.left = null;
        this.right = null;
    }
}
