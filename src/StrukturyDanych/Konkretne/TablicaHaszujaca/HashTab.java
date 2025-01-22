package StrukturyDanych.Konkretne.TablicaHaszujaca;

import java.util.LinkedList;

public class HashTab {
    private final LinkedList<Integer>[] buckets;
    private final int nBuckets;
    private int size = 0;

    public HashTab(int nBuckets) {
        this.buckets = new LinkedList[nBuckets];
        this.nBuckets = nBuckets;
        for (int i = 0; i < nBuckets; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
//        int nElem = 10;
//        Random random = new Random();
//        HashTab hashTab = new HashTab(8);
//        for (int i = 0; i < nElem; i++) {
//           hashTab.add(random.nextInt(10,20));
//        }
//
//        hashTab.add(5);
//        hashTab.add(20);
//        hashTab.add(30);
//        hashTab.add(30);
//
//        System.out.println(hashTab.contains(11));
//        hashTab.remove(1);
//        System.out.println(hashTab);
//        System.out.println(hashTab.hashSize());


        HashTab set1 = new HashTab(8);
        HashTab set2 = new HashTab(8);

        set1.add(10);
        set1.add(20);
        set1.add(30);

        set2.add(20);
        set2.add(30);
        set2.add(40);


        HashTab unionHash = set1.union(set2);
        HashTab intersectionHash = set1.intersection(set2);
        HashTab differenceHash = set1.difference(set2);
        System.out.println(unionHash);
        System.out.println(intersectionHash);
        System.out.println(differenceHash);
    }

    private int hashIndex(int value) {
        return Math.abs(value % this.nBuckets);
    }

    public boolean add(int value) {
        int index = hashIndex(value);
        LinkedList<Integer> bucket = buckets[index];

        if (bucket.contains(value)) return false;

        bucket.add(value);
        this.size++;
        return true;
    }

    public boolean contains(int value) {
        int index = hashIndex(value);
        LinkedList<Integer> bucket = buckets[index];
        return bucket.contains(value);

    }

    public void remove(int value) {
        int index = hashIndex(value);
        LinkedList<Integer> bucket = buckets[index];
        if (bucket.remove((Integer) value)) {
            this.size--;
        }
    }

    // suma zbiorow
    public HashTab union(HashTab otherTab) {
        HashTab unionHash = new HashTab(Math.max(this.nBuckets, otherTab.nBuckets));

        for (LinkedList<Integer> bucket : this.buckets) {
            for (int value : bucket) unionHash.add(value);
        }

        for (LinkedList<Integer> bucket : otherTab.buckets) {
            for (int value : bucket) unionHash.add(value);
        }

        return unionHash;
    }

    // czesc wspolna
    public HashTab intersection(HashTab otherTab) {
        HashTab intersectionHash = new HashTab(Math.max(this.nBuckets, otherTab.nBuckets));

        for (LinkedList<Integer> bucket : this.buckets) {
            for (int value : bucket) {
                if (otherTab.contains(value)) {
                    intersectionHash.add(value);
                }
            }
        }
        return intersectionHash;
    }

    public HashTab difference(HashTab otherTab) {
        HashTab differenceHash = new HashTab(Math.max(this.nBuckets, otherTab.nBuckets));

        for (LinkedList<Integer> bucket : this.buckets) {
            for (int value : bucket) {
                if (!otherTab.contains(value)) {
                    differenceHash.add(value);
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
        for (LinkedList<Integer> bucket : this.buckets) {
            result.append(bucket).append(" ");
            result.append("\n");
        }
        return result + " ";
    }
}
