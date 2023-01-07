package Servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import StudentClass.Student;
import Threads.ServerThread;

public class Server2 {
    public static void main(String[] args) {
        try {
            ServerSocket server2 = new ServerSocket(2002);
            Socket Manager = server2.accept();
            System.out.println("Manager is connected");

            ArrayList<Student> students2 = new ArrayList<>();


            DataInputStream managerInput =  new DataInputStream(Manager.getInputStream());
            DataOutputStream managerOutput = new DataOutputStream(Manager.getOutputStream());



            for(int i = 0; i < 5; i++) {
                String name = managerInput.readUTF();
                int id = managerInput.readInt();
                int grade = managerInput.readInt();
                String gender = managerInput.readUTF();

                students2.add(new Student(name, id, grade, gender));
            }


            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    for (Student std: students2) {
                        std.setGrade(std.getGrade() + 2);
                    }

                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (Student std: students2) {
                        std.setGrade(std.getGrade() - 2);
                    }
                }
            }, 0, 15000);



            for (int i =0 ; i<24 ; i++){
                ServerThread s1 = new ServerThread(managerInput.readUTF(), students2, managerOutput, managerInput.readInt());
                s1.start();
                ServerThread s2 = new ServerThread(managerInput.readUTF(), students2, managerOutput, managerInput.readInt());
                s2.start();
                ServerThread s3 = new ServerThread(managerInput.readUTF(), students2, managerOutput, managerInput.readInt());
                s3.start();
                ServerThread s4 = new ServerThread(managerInput.readUTF(), students2, managerOutput, managerInput.readInt());
                s4.start();
                ServerThread s5 = new ServerThread(managerInput.readUTF(), students2, managerOutput, managerInput.readInt());
                s5.start();

                    s5.join();
                }

            timer.cancel();

            managerInput.close();
            managerOutput.close();
            Manager.close();
            server2.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
