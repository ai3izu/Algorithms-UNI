package StrukturyDanych.Abstrakcyjne.Zbior;


import java.util.LinkedList;

public class CustomSet<T> {
    private final LinkedList<T> list;

    public CustomSet() {
        this.list = new LinkedList();
    }

    public void addElem(T element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }

    public void removeElem(T element) {
        list.remove(element);
    }

    public boolean containsElem(T elem) {
        if (list.contains(elem)) {
            return list.contains(elem);
        } else {
            return false;
        }
    }

    public int size(){return list.size();}

    // suma zbiorow
    public CustomSet<T> union(CustomSet<T> otherSet){
        CustomSet<T> unionSet = new CustomSet<>();
        for(T elem : this.list){
            unionSet.addElem(elem);
        }
        for(T elem : otherSet.list){
            unionSet.addElem(elem);
        }
        return unionSet;
    }

    // czesc wspolna
    public CustomSet<T> intersection(CustomSet<T> otherSet) {
        CustomSet<T> intersectionSet = new CustomSet<>();
        for(T elem : this.list){
            if (otherSet.containsElem(elem)){
                intersectionSet.addElem(elem);
            }
        }
        return intersectionSet;
    }

    // roznica
    public CustomSet<T> difference(CustomSet<T> otherSet){
        CustomSet<T> diffSet = new CustomSet<>();
        for(T elem : this.list){
            if(!otherSet.containsElem(elem)){
                diffSet.addElem(elem);
            }
        }
        return diffSet;
    }

    // roznica symetryczna jest tylko w a i tylko w b
    public CustomSet<T> symmetricDifference(CustomSet<T> otherSet){
        CustomSet<T> symmetricDifference = new CustomSet<>();
        for(T elem : this.list){
            if (!otherSet.containsElem(elem)) symmetricDifference.addElem(elem);
        }
        for(T elem : otherSet.list){
            if(!this.containsElem(elem)) symmetricDifference.addElem(elem);
        }
        return symmetricDifference;
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        CustomSet<String> set1 = new CustomSet<>();
        CustomSet<String> set2= new CustomSet<>();

        set1.addElem("Jan Kowlaski");
        set2.addElem("Jan Kowlaski");
        set1.addElem("Jurek Adamczyk");
        set2.addElem("Bogumil Kowlaski");
        set1.addElem("Adam Babab");
        set2.addElem("Meow Kowlaski");


        CustomSet<String> unionSet = set1.union(set2);
        System.out.println(unionSet);


        CustomSet<String> diffSet = set1.difference(set2);
        System.out.println(diffSet);


        CustomSet<String> intersectionSet = set1.intersection(set2);
        System.out.println(intersectionSet);


        CustomSet<String> symmetricDiffSet = set1.symmetricDifference(set2);
        System.out.println(symmetricDiffSet);
    }
}
