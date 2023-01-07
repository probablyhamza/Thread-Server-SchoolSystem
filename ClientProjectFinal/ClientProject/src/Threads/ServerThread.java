package Threads;

import Servers.Server1;
import StudentClass.Student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ServerThread extends Thread {

    private DataOutputStream output;
    private String request;
    private int grade;
    private String gender;
    private int id;
    private ArrayList<Student> students;


    @Override
    public void run() {
        synchronized (this) {

                switch (request) {
                    case "Grade": {
                        for (Student stds: students) {
                            if(stds.getId() == id){
                                grade = stds.getGrade();
                                break;
                            }
                        }
                        System.out.println(grade);
                        System.out.println("Run: " + grade + " " + System.currentTimeMillis());
                        try {
                            output.writeInt(grade);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                    case "Gender": {
                        for (Student stds: students) {
                            if(stds.getId() == id){
                                gender = stds.getGender();
                                break;
                            }
                        }
                        System.out.println(gender);
                        System.out.println("Run: " + grade + " " + System.currentTimeMillis());
                        try {
                            output.writeUTF(gender);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;



            }



        }
    }

    public ServerThread(String request, ArrayList<Student> students, DataOutputStream output, int id){

        synchronized (this) {
            System.out.println("Const");
            this.request = request;
            this.students = students;
            this.output = output;
            this.id = id;
            this.grade = 10;
            this.gender = "";
            //deepCopy(students);
        }
    }

//    public synchronized void  deepCopy(ArrayList<Student> stds){
//        for (Student std: stds) {
//            this.students.add(new Student(std.getName(), std.getId(), std.getGrade(),  std.getGender()));
//        }
//    }

//    public synchronized int getGrade() {
//        System.out.println("getgrade: " + grade + " " + System.currentTimeMillis());
//        return grade;
//    }
}
