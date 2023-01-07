import Threads.ClientThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static int counter = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Client

        Socket client1 = new Socket("localhost", 2005);
        Socket client2 = new Socket("localhost", 2005);
        Socket client3 = new Socket("localhost", 2005);
        Socket client4 = new Socket("localhost", 2005);
        Socket client5 = new Socket("localhost", 2005);


        DataOutputStream out1 = new DataOutputStream(client1.getOutputStream());
        DataInputStream in1 = new DataInputStream(client1.getInputStream());

        DataOutputStream out2 = new DataOutputStream(client2.getOutputStream());
        DataInputStream in2 = new DataInputStream(client2.getInputStream());

        DataOutputStream out3 = new DataOutputStream(client3.getOutputStream());
        DataInputStream in3 = new DataInputStream(client3.getInputStream());

        DataOutputStream out4 = new DataOutputStream(client4.getOutputStream());
        DataInputStream in4 = new DataInputStream(client4.getInputStream());

        DataOutputStream out5 = new DataOutputStream(client5.getOutputStream());
        DataInputStream in5 = new DataInputStream(client5.getInputStream());




        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(++counter);
                ClientThread t1 = new ClientThread(out1, in1, "Grade", 1);
                ClientThread t2 = new ClientThread(out2, in2, "Gender", 3);
                ClientThread t3 = new ClientThread(out3, in3, "Grade", 2);
                ClientThread t4 = new ClientThread(out4, in4, "Gender", 5);
                ClientThread t5 = new ClientThread(out5, in5, "Grade", 4);

                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();

            }
        }, 0, 5000);



        Thread.sleep(120000);
        timer.cancel();

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                t1.start();
//                t2.start();
//                t3.start();
//                t4.start();
//                t5.start();
//            }
//        };
//
//        executor.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
//    }

//
//        Timer tim
//            t1.start();
//            t2.start();
//            t3.start();
//            t4.start();
//            t5.start();
//
//            Thread.sleep(5000);
//        }


        in1.close();
        out1.close();
        in2.close();
        out2.close();
        in3.close();
        out3.close();
        in4.close();
        out4.close();
        in5.close();
        out5.close();
        client1.close();
        client2.close();
        client3.close();
        client4.close();
        client5.close();



    }
    }
    //initializing clients sockets


