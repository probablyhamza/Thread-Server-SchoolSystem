import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Manager {
    public static void main(String[] args) throws IOException {

        Socket Server1 = new Socket("localhost", 2001);
        Socket Server2 = new Socket("localhost", 2002);
        Socket Server3 = new Socket("localhost", 2004);

        DataOutputStream serverOutput1 = new DataOutputStream(Server1.getOutputStream());
        DataInputStream serverInput1 = new DataInputStream(Server1.getInputStream());

        DataOutputStream serverOutput2 = new DataOutputStream(Server2.getOutputStream());
        DataInputStream serverInput2 = new DataInputStream(Server2.getInputStream());

        DataOutputStream serverOutput3 = new DataOutputStream(Server3.getOutputStream());
        DataInputStream serverInput3 = new DataInputStream(Server3.getInputStream());


        serverOutput1.writeUTF("Mike");
        serverOutput1.writeInt(1);
        serverOutput1.writeInt(90);
        serverOutput1.writeUTF("Male");

        serverOutput2.writeUTF("Mike");
        serverOutput2.writeInt(1);
        serverOutput2.writeInt(90);
        serverOutput2.writeUTF("Male");

        serverOutput3.writeUTF("Mike");
        serverOutput3.writeInt(1);
        serverOutput3.writeInt(90);
        serverOutput3.writeUTF("Male");

        serverOutput1.writeUTF("Hamza");
        serverOutput1.writeInt(2);
        serverOutput1.writeInt(90);
        serverOutput1.writeUTF("Male");

        serverOutput2.writeUTF("Hamza");
        serverOutput2.writeInt(2);
        serverOutput2.writeInt(25);
        serverOutput2.writeUTF("Male");

        serverOutput3.writeUTF("hamza");
        serverOutput3.writeInt(2);
        serverOutput3.writeInt(25);
        serverOutput3.writeUTF("Male");

        serverOutput1.writeUTF("Ahmad");
        serverOutput1.writeInt(3);
        serverOutput1.writeInt(101);
        serverOutput1.writeUTF("Male");

        serverOutput2.writeUTF("Ahmad");
        serverOutput2.writeInt(3);
        serverOutput2.writeInt(101);
        serverOutput2.writeUTF("Male");

        serverOutput3.writeUTF("Ahmad");
        serverOutput3.writeInt(3);
        serverOutput3.writeInt(101);
        serverOutput3.writeUTF("Male");

        serverOutput1.writeUTF("Mohammed");
        serverOutput1.writeInt(4);
        serverOutput1.writeInt(102);
        serverOutput1.writeUTF("Male");

        serverOutput2.writeUTF("Mohammed");
        serverOutput2.writeInt(4);
        serverOutput2.writeInt(102);
        serverOutput2.writeUTF("Male");

        serverOutput3.writeUTF("Mohammed");
        serverOutput3.writeInt(4);
        serverOutput3.writeInt(102);
        serverOutput3.writeUTF("Male");

        serverOutput1.writeUTF("Sara");
        serverOutput1.writeInt(5);
        serverOutput1.writeInt(65);
        serverOutput1.writeUTF("Female");

        serverOutput2.writeUTF("Sara");
        serverOutput2.writeInt(5);
        serverOutput2.writeInt(65);
        serverOutput2.writeUTF("female");

        serverOutput3.writeUTF("Sara");
        serverOutput3.writeInt(5);
        serverOutput3.writeInt(65);
        serverOutput3.writeUTF("female");


        ServerSocket managerServer = new ServerSocket(2005);
        Socket client1 = managerServer.accept();
        Socket client2 = managerServer.accept();
        Socket client3 = managerServer.accept();
        Socket client4 = managerServer.accept();
        Socket client5 = managerServer.accept();

        DataOutputStream clientOutput1 = new DataOutputStream(client1.getOutputStream());
        DataInputStream clientInput1 = new DataInputStream(client1.getInputStream());

        DataOutputStream clientOutput2 = new DataOutputStream(client2.getOutputStream());
        DataInputStream clientInput2 = new DataInputStream(client2.getInputStream());

        DataOutputStream clientOutput3 = new DataOutputStream(client3.getOutputStream());
        DataInputStream clientInput3 = new DataInputStream(client3.getInputStream());

        DataOutputStream clientOutput4 = new DataOutputStream(client4.getOutputStream());
        DataInputStream clientInput4 = new DataInputStream(client4.getInputStream());

        DataOutputStream clientOutput5 = new DataOutputStream(client5.getOutputStream());
        DataInputStream clientInput5 = new DataInputStream(client5.getInputStream());

        for (int i =0; i<24; i++){
            String ans1 = "";
            String ans2 = "";
            String ans3 = "";
            String ans4 = "";
            String ans5 = "";

            int id;
            String request;
            request = clientInput1.readUTF();
            id = clientInput1.readInt();

            switch (request) {
                case "Grade": {
                    System.out.println("yes");
                    int num1 = Grade(serverOutput1, serverInput1, id);
                    int num2 = Grade(serverOutput2, serverInput2, id);
                    int num3 = Grade(serverOutput3, serverInput3, id);
                    System.out.println(num1 + " " + num2 + " " + num3);
                    int count1 = 0;
                    int count2 = 0;


                    if (num1 == num2 && num1 == num3) count1++;
                    else if (num1 == num2 || num1 == num3) count1++;

                    if (num2 == num3) count2++;

                    if (count1 > 0) ans1 = num1 + "";
                    else if (count2 > 0) ans1 = num2 + "";
                    else ans1 = "Numbers don't match" ;
                }
                break;

                case "Gender": {
                    String gender1 = Gender(serverOutput1, serverInput1, id);
                    String gender2 = Gender(serverOutput2, serverInput2, id);
                    String gender3 = Gender(serverOutput3, serverInput3, id);

                    ans1 = gender1;
                }
                break;

//                case "Both": {
//                    int num1 = Grade(serverOutput1, serverInput1);
//                    int num2 = Grade(serverOutput2, serverInput2);
//                    int num3 = Grade(serverOutput3, serverInput3);
//
//
//                    int count1 =0;
//                    int count2 =0;
//
//
//                    if(num1 == num2 && num1 == num3) count1++;
//                    else if(num1 == num2 || num1 == num3) count1++;
//
//                    if(num2 == num3) count2++;
//
//                    if(count1 > 0) ans1 = num1 + "";
//                    else if(count2 > 0) ans1 = num2 + "";
//                    else ans1 = "Numbers don't match";
//
//                    String gender1 = Gender(serverOutput1, serverInput1);
//
//
//                    ans1 = ans1 + " " + gender1;
//                }

            }

            request = clientInput2.readUTF();
            id = clientInput2.readInt();

            switch (request) {
                case "Grade": {
                    int num1 = Grade(serverOutput1, serverInput1, id);
                    int num2 = Grade(serverOutput2, serverInput2, id);
                    int num3 = Grade(serverOutput3, serverInput3, id);

                    int count1 = 0;
                    int count2 = 0;


                    if (num1 == num2 && num1 == num3) count1++;
                    else if (num1 == num2 || num1 == num3) count1++;

                    if (num2 == num3) count2++;

                    if (count1 > 0) ans2 = num1 + "";
                    else if (count2 > 0) ans2 = num2 + "";
                    else ans2 = "Numbers don't match";
                }
                break;

                case "Gender": {
                    String gender1 = Gender(serverOutput1, serverInput1, id);
                    String gender2 = Gender(serverOutput2, serverInput2, id);
                    String gender3 = Gender(serverOutput3, serverInput3, id);


                    ans2 = gender1;
                }
                break;

//                case "Both": {
//                    int num1 = Grade(serverOutput1, serverInput1);
//                    int num2 = Grade(serverOutput2, serverInput2);
//                    int num3 = Grade(serverOutput3, serverInput3);
//
//
//                    int count1 =0;
//                    int count2 =0;
//
//
//                    if(num1 == num2 && num1 == num3) count1++;
//                    else if(num1 == num2 || num1 == num3) count1++;
//
//                    if(num2 == num3) count2++;
//
//                    if(count1 > 0) ans2 = num1 + "";
//                    else if(count2 > 0) ans2 = num2 + "";
//                    else ans2 = "Numbers don't match";
//
//                    String gender1 = Gender(serverOutput1, serverInput1);
//
//
//                    ans2 = ans2 + " " + gender1;
//                }
            }

            request = clientInput3.readUTF();
            id = clientInput3.readInt();

            switch (request) {
                case "Grade": {
                    int num1 = Grade(serverOutput1, serverInput1, id);
                    int num2 = Grade(serverOutput2, serverInput2, id);
                    int num3 = Grade(serverOutput3, serverInput3, id);

                    int count1 = 0;
                    int count2 = 0;


                    if (num1 == num2 && num1 == num3) count1++;
                    else if (num1 == num2 || num1 == num3) count1++;

                    if (num2 == num3) count2++;

                    if (count1 > 0) ans3 = num1 + "";
                    else if (count2 > 0) ans3 = num2 + "";
                    else ans3 = "Numbers don't match";
                }
                break;

                case "Gender": {
                    String gender1 = Gender(serverOutput1, serverInput1, id);
                    String gender2 = Gender(serverOutput2, serverInput2, id);
                    String gender3 = Gender(serverOutput3, serverInput3, id);


                    ans3 = gender1;
                }
                break;
//
//                case "Both": {
//                    int num1 = Grade(clientOutput5, clientInput5, serverOutput1, serverInput1);
//                    int num2 = Grade(clientOutput5, clientInput5, serverOutput2, serverInput2);
//                    int num3 = Grade(clientOutput5, clientInput5, serverOutput3, serverInput3);
//
//
//                    int count1 =0;
//                    int count2 =0;
//
//
//                    if(num1 == num2 && num1 == num3) count1++;
//                    else if(num1 == num2 || num1 == num3) count1++;
//
//                    if(num2 == num3) count2++;
//
//                    if(count1 > 0) ans3 = num1 + "";
//                    else if(count2 > 0) ans3 = num2 + "";
//                    else ans3 = "Numbers don't match";
//
//                    String gender1 = Gender(serverOutput1, serverInput1);
//
//
//                    ans3 = ans3 + " " + gender1;
//                }
             }

                request = clientInput4.readUTF();
                id = clientInput4.readInt();

                switch (request) {
                    case "Grade": {
                        int num1 = Grade(serverOutput1, serverInput1, id);
                        int num2 = Grade(serverOutput2, serverInput2, id);
                        int num3 = Grade(serverOutput3, serverInput3, id);

                        int count1 = 0;
                        int count2 = 0;


                        if (num1 == num2 && num1 == num3) count1++;
                        else if (num1 == num2 || num1 == num3) count1++;

                        if (num2 == num3) count2++;

                        if (count1 > 0) ans4 = num1 + "";
                        else if (count2 > 0) ans4 = num2 + "";
                        else ans4 = "Numbers don't match";
                    }
                    break;

                    case "Gender": {
                        String gender1 = Gender(serverOutput1, serverInput1, id);
                        String gender2 = Gender(serverOutput2, serverInput2, id);
                        String gender3 = Gender(serverOutput3, serverInput3, id);


                        ans4 = gender1;
                    }
                    break;

//                case "Both": {
//                    int num1 = Grade(clientOutput5, clientInput5, serverOutput1, serverInput1);
//                    int num2 = Grade(clientOutput5, clientInput5, serverOutput2, serverInput2);
//                    int num3 = Grade(clientOutput5, clientInput5, serverOutput3, serverInput3);
//
//
//                    int count1 =0;
//                    int count2 =0;
//
//
//                    if(num1 == num2 && num1 == num3) count1++;
//                    else if(num1 == num2 || num1 == num3) count1++;
//
//                    if(num2 == num3) count2++;
//
//                    if(count1 > 0) ans4 = num1 + "";
//                    else if(count2 > 0) ans4 = num2 + "";
//                    else ans4 = "Numbers don't match";
//
//                    String gender1 = Gender(serverOutput1, serverInput1);
//
//
//                    ans4 = ans4 + " " + gender1;
//                }
                }

                request = clientInput5.readUTF();
                id = clientInput5.readInt();

                switch (request) {
                    case "Grade": {
                        int num1 = Grade(serverOutput1, serverInput1, id);
                        int num2 = Grade(serverOutput2, serverInput2, id);
                        int num3 = Grade(serverOutput3, serverInput3, id);


                        int count1 = 0;
                        int count2 = 0;


                        if (num1 == num2 && num1 == num3) count1++;
                        else if (num1 == num2 || num1 == num3) count1++;

                        if (num2 == num3) count2++;

                        if (count1 > 0) ans5 = num1 + "";
                        else if (count2 > 0) ans5 = num2 + "";
                        else ans5 = "Numbers don't match";
                    }
                    break;

                    case "Gender": {
                        String gender1 = Gender(serverOutput1, serverInput1, id);
                        String gender2 = Gender(serverOutput2, serverInput2, id);
                        String gender3 = Gender(serverOutput3, serverInput3, id);



                        ans5 = gender1;
                    }
                    break;

//                case "Both": {
//                    int num1 = Grade(clientOutput5, clientInput5, serverOutput1, serverInput1);
//                    int num2 = Grade(clientOutput5, clientInput5, serverOutput2, serverInput2);
//                    int num3 = Grade(clientOutput5, clientInput5, serverOutput3, serverInput3);
//
//
//                    int count1 =0;
//                    int count2 =0;
//
//
//                    if(num1 == num2 && num1 == num3) count1++;
//                    else if(num1 == num2 || num1 == num3) count1++;
//
//                    if(num2 == num3) count2++;
//
//                    if(count1 > 0) ans5 = num1 + "";
//                    else if(count2 > 0) ans5 = num2 + "";
//                    else ans5 = "Numbers don't match";
//
//                    String gender1 = Gender(serverOutput1, serverInput1);
//
//
//                    ans5 = ans5 + " " + gender1;
//                }
                }

                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                System.out.println(ans4);
                System.out.println(ans5);

                clientOutput1.writeUTF(ans1);
                clientOutput2.writeUTF(ans2);
                clientOutput3.writeUTF(ans3);
                clientOutput4.writeUTF(ans4);
                clientOutput5.writeUTF(ans5);
        }

        clientInput1.close();
        clientOutput1.close();
        clientInput2.close();
        clientOutput2.close();
        clientInput3.close();
        clientOutput3.close();
        clientInput4.close();
        clientOutput4.close();
        clientInput5.close();
        clientOutput5.close();
        serverInput1.close();
        serverOutput1.close();
        serverInput2.close();
        serverOutput2.close();
        serverInput3.close();
        serverOutput3.close();
        client1.close();
        client2.close();
        client3.close();
        client4.close();
        client5.close();
        Server1.close();
        Server2.close();
        Server3.close();
        managerServer.close();


        }


        public static int Grade (DataOutputStream serverOutput1, DataInputStream serverInput1, int id){
            int num = 0;
            System.out.println("before");
            try {
                serverOutput1.writeUTF("Grade");
                serverOutput1.writeInt(id);
                num = serverInput1.readInt();
                System.out.println("after");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return num;
        }

        public static String Gender (DataOutputStream serverOutput1, DataInputStream serverInput1, int id){
            String gender = "";
            try {
                serverOutput1.writeUTF("Gender");
                serverOutput1.writeInt(id);
                gender = serverInput1.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return gender;
        }
    }


