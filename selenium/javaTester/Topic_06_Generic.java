package javaTester;

import java.util.ArrayList;

public class Topic_06_Generic {
    public static void main(String[] args){

        // non-generic
        ArrayList studentName = new ArrayList();
        studentName.add("Trinh TT");
        studentName.add("Trinhtt");
        studentName.add(18);

        // generic <Type>
        ArrayList<String> students = new ArrayList<>();
        students.add("Trinh TT");
        //students.add(18);
    }
}
