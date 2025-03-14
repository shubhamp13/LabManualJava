package com.advance;

import java.util.ArrayList;
import java.util.List;

//7. Write a Java Program to store student names in ArrayList. Provide the list of students
//whose name begins with “S”. Also implement the add, remove, removeAll, removeIf,
//retainAll, equals methods of ArrayList. Also perform validations like ArrayList is empty.
public class Question7
{
    private static ArrayList<String>students=new ArrayList<>();
    public List<String>studentNameBeginWith(String start)
    {
        List<String>s1=new ArrayList<>();
        students.forEach((name)->{
            if(name.startsWith(start))
            {
                s1.add(name);
            }
        });
        return s1;

    }
    public  static boolean addStudent(String studentName)
    {
        return students.add(studentName);
    }
    public  static boolean removeStudent(String studentName)
    {
        if(students.isEmpty())
        {
            System.out.println("Student list is empty");
            return false;
        }
        return students.remove(studentName);
    }
    public static boolean removeStudents(List<String>students)
    {
        if(students.isEmpty())
        {
            System.out.println("Student list is empty");
            return false;
        }
        return Question7.students.removeAll(students);
    }
    public  static boolean removeIf (int length)
    {
        if(students.isEmpty())
        {
            System.out.println("Student list is empty");
            return false;
        }
        return students.removeIf(s->s.length() < length);
    }
    public  static boolean retainAll(List<String> students)
    {
        if(students.isEmpty())
        {
            System.out.println("Student list is empty");
            return false;
        }
        return Question7.students.retainAll(students);
    }

    public static void main(String[] args) {
        students.add("Shubham");
        students.add("Amit");
        students.add("Sonia");
        students.add("Rahul");
        students.add("Suresh");
        students.add("Neha");
        students.add("Mary");
        students.add("James");
        students.add("Bob");
        removeIf(6);
        System.out.println(students);
     }

}
