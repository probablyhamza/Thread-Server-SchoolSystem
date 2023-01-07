package Threads;

import Servers.Server1;
import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;


public class ClientThread extends Thread {
    private final DataOutputStream managerOutput;
    private final DataInputStream managerInput;
    private String request;
    private int id;


    public ClientThread(DataOutputStream o, DataInputStream i, String request, int id) {
        synchronized (this){
            this.managerOutput = o;
            this.managerInput = i;
            this.request = request;
            this.id = id;
        }
    }


    public void run() {
        synchronized (this) {

                try {
                    managerOutput.writeUTF(request);
                    managerOutput.writeInt(id);
                    managerOutput.flush();

                    System.out.println("ID-" + id + ": " +  managerInput.readUTF());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

