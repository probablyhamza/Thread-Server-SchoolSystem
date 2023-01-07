package Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ManagerThread extends Thread {

    DataInputStream clientInput, serverInput1, serverInput2, serverInput3;
    DataOutputStream clientOutput, serverOutput1, serverOutput2, serverOutput3;



    public ManagerThread(DataOutputStream out, DataInputStream in, DataOutputStream serverOutput1, DataInputStream inS1, DataOutputStream serverOutput2, DataInputStream inS2, DataOutputStream serverOutput3, DataInputStream inS3){
        this.clientInput = in;
        this.clientOutput = out;
        this.serverInput1 = inS1;
        this.serverOutput1 = serverOutput1;
        this.serverInput2 = inS2;
        this.serverOutput2 = serverOutput2;
        this.serverInput3 = inS3;
        this.serverOutput3 = serverOutput3;
    }


}
