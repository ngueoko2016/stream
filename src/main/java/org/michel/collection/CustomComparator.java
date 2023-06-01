package org.michel.collection;

import java.util.Comparator;

public class CustomComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {

        if(s2!=null) {
            if (s1.id == s2.id)
                return s1.name.compareTo(s2.name);
            return s1.id - s2.id;
        }
        return 0;
    }
}
