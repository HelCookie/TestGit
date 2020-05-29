package com.hq.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huqi
 * @creat 2020-03-24 21:19
 * @description
 */
public class studentSystem {

    List<Student> slist=new ArrayList<>();

    public  void addtofile(Student stu) throws Exception {
        File file = new File("Student.txt");
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        slist.add(new Student("1","tom",56,78));
        slist.add(new Student("2","jj",56,78));
        for (int i = 0; i <slist.size() ; i++) {
            oout.writeObject(slist.get(i));

        }


        oout.close();
    }

    public  void readfromfile() throws Exception {
        File file = new File("Student.txt");
        FileInputStream is = new FileInputStream(file);
        ObjectInputStream oin = new ObjectInputStream(is);
        slist.clear();
       try {
           while(true) {
               Student s = (Student) oin.readObject();
               slist.add(s);
           }
       }catch (EOFException e){
           oin.close();
       }

    }


    public static void main(String[] args) {
        try {
            studentSystem sym=new studentSystem();
            sym.addtofile(new Student());
            sym. readfromfile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
