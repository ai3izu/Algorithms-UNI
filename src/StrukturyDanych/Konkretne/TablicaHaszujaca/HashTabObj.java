package StrukturyDanych.Konkretne.TablicaHaszujaca;

import java.util.LinkedList;

public class HashTabObj {
    private final LinkedList<Square>[] buckets;
    private final int nBuckets;
    private int size = 0;

    public HashTabObj(int nBuckets) {
        this.buckets = new LinkedList[nBuckets];
        this.nBuckets = nBuckets;
        for (int i = 0; i < nBuckets; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        HashTabObj set1 = new HashTabObj(8);
        HashTabObj set2 = new HashTabObj(8);

        Square square1 = new Square(2, 5);
        Square square2 = new Square(3, 6);
        Square square3 = new Square(2, 5);
        Square square4 = new Square(10, 5);
        set1.add(square1);
        set1.add(square2);
        set2.add(square3);
        set2.add(square4);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println("=====================");
        System.out.println(set1.contains(square1));
        System.out.println(set2.hashSize());
        System.out.println("=====================");
        HashTabObj unionHash = set1.union(set2);
        System.out.println(unionHash);
        System.out.println("=====================");
        HashTabObj intersectionHash = set1.intersection(set2);
        System.out.println(intersectionHash);
        System.out.println("=====================");
        HashTabObj differenceHash = set1.difference(set2);
        System.out.println(differenceHash);
    }

    private int hashIndex(Square square) {
        return Math.abs(square.hashCode() % this.nBuckets);
    }

    public boolean add(Square square) {
        int index = hashIndex(square);
        LinkedList<Square> bucket = buckets[index];

        if (bucket.contains(square)) return false;

        bucket.add(square);
        this.size++;
        return true;
    }

    public boolean contains(Square square) {
        int index = hashIndex(square);
        LinkedList<Square> bucket = buckets[index];
        return bucket.contains(square);

    }

    public void remove(Square square) {
        int index = hashIndex(square);
        LinkedList<Square> bucket = buckets[index];
        if (bucket.remove(square)) {
            this.size--;
        }
    }

    // suma zbiorow
    public HashTabObj union(HashTabObj otherTab) {
        HashTabObj unionHash = new HashTabObj(Math.max(this.nBuckets, otherTab.nBuckets));

        for (LinkedList<Square> bucket : this.buckets) {
            for (Square square : bucket) unionHash.add(square);
        }

        for (LinkedList<Square> bucket : otherTab.buckets) {
            for (Square square : bucket) unionHash.add(square);
        }

        return unionHash;
    }

    // czesc wspolna
    public HashTabObj intersection(HashTabObj otherTab) {
        HashTabObj intersectionHash = new HashTabObj(Math.max(this.nBuckets, otherTab.nBuckets));

        for (LinkedList<Square> bucket : this.buckets) {
            for (Square square : bucket) {
                if (otherTab.contains(square)) {
                    intersectionHash.add(square);
                }
            }
        }
        return intersectionHash;
    }

    public HashTabObj difference(HashTabObj otherTab) {
        HashTabObj differenceHash = new HashTabObj(Math.max(this.nBuckets, otherTab.nBuckets));

        for (LinkedList<Square> bucket : this.buckets) {
            for (Square square : bucket) {
                if (!otherTab.contains(square)) {
                    differenceHash.add(square);
                }
            }
        }
        return differenceHash;
    }

    public int hashSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<Square> bucket : this.buckets) {
            result.append(bucket).append(" ");
            result.append("\n");
        }

        return result + " ";
    }
}
