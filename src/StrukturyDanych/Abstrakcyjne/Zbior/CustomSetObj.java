package StrukturyDanych.Abstrakcyjne.Zbior;

import java.util.LinkedList;

public class CustomSetObj {
    private final LinkedList<Ziutek> list;

    public CustomSetObj() {
        this.list = new LinkedList<>();
    }

    public void addElem(Ziutek element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }

    public void removeElem(Ziutek element) {
        list.remove(element);
    }

    public boolean containsElem(Ziutek elem) {
        if (list.contains(elem)) {
            return list.contains(elem);
        } else {
            return false;
        }
    }

    public int size(){return list.size();}

    // suma zbiorow
    public CustomSetObj union(CustomSetObj otherSet){
        CustomSetObj unionSet = new CustomSetObj();
        for(Ziutek elem : this.list){
            unionSet.addElem(elem);
        }
        for(Ziutek elem : otherSet.list){
            unionSet.addElem(elem);
        }
        return unionSet;
    }

    // czesc wspolna
    public CustomSetObj intersection(CustomSetObj otherSet) {
        CustomSetObj intersectionSet = new CustomSetObj();
        for(Ziutek elem : this.list){
            if (otherSet.containsElem(elem)){
                intersectionSet.addElem(elem);
            }
        }
        return intersectionSet;
    }

    // roznica
    public CustomSetObj difference(CustomSetObj otherSet){
        CustomSetObj diffSet = new CustomSetObj();
        for(Ziutek elem : this.list){
            if(!otherSet.containsElem(elem)){
                diffSet.addElem(elem);
            }
        }
        return diffSet;
    }

    // roznica symetryczna jest tylko w a i tylko w b
    public CustomSetObj symmetricDifference(CustomSetObj otherSet){
        CustomSetObj symmetricDifference = new CustomSetObj();
        for(Ziutek elem : this.list){
            if (!otherSet.containsElem(elem)) symmetricDifference.addElem(elem);
        }
        for(Ziutek elem : otherSet.list){
            if(!this.containsElem(elem)) symmetricDifference.addElem(elem);
        }
        return symmetricDifference;
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        CustomSetObj set1 = new CustomSetObj();
        CustomSetObj set2= new CustomSetObj();

        Ziutek ziutek1 = new Ziutek("Jan", "Kowalski");
        Ziutek ziutek2 = new Ziutek("Jurek", "Adamczyk");
        Ziutek ziutek3 = new Ziutek("Adam ", "Babab");
        Ziutek ziutek4 = new Ziutek("Bogumił ", "Kowalski");
        Ziutek ziutek5 = new Ziutek("Meow ", "Kowalski");

        set1.addElem(ziutek1);
        set1.addElem(ziutek2);
        set1.addElem(ziutek3);

        set2.addElem(ziutek1);
        set2.addElem(ziutek4);
        set2.addElem(ziutek5);

        CustomSetObj unionSet = set1.union(set2);
        System.out.println("suma zbiorow: " + unionSet);

        CustomSetObj diffSet = set1.difference(set2);
        System.out.println("roznica zbiorow: " + diffSet);

        CustomSetObj intersectionSet = set1.intersection(set2);
        System.out.println("piotr pusz (czesc wspolna): " + intersectionSet);

        CustomSetObj symmetricDiffSet = set1.symmetricDifference(set2);
        System.out.println("(roznica symetryczna): " + symmetricDiffSet);

    }
}
