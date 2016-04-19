package com.res;

import sun.net.smtp.SmtpClient;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        ListOfVicitim lstv = new ListOfVicitim();
        ArrayList<GroupOfVictim> groups = new ArrayList<>();
        ListOfMessage lstm = new ListOfMessage();
        Mail mail = new Mail();


        System.out.println("SMTP PRANK");
        System.out.println("==========");
        System.out.println("Enter a list of email [Separate by ;] : ");
        s = sc.nextLine();
        lstv.fetchAdrStringBySep(s,';');

        System.out.println("How many groups ? : ");
        s = sc.nextLine();

        //#TODO verification du nbr de victimes par rapport au groupe
        int z = lstv.getNbrVictim()/Integer.parseInt(s);

        for(int i=0;i < z;i++){
            GroupOfVictim g = new GroupOfVictim();
            g.addRecipient(lstv.getASublist(i*z,z-1));
            g.addSender(lstv.getOneVictim(i*z));

            groups.add(g);
        }


        System.out.println("Enter a list of message [Separate by ;] : ");
        s = sc.nextLine();
        lstm.fetchMsgStringBySep(s,';');


        for(GroupOfVictim grp : groups){

        }
        System.out.println("Choose the group :");
        s = sc.nextLine();

        mail.setTo();
        mail.setFrom();

        for(String msg : lstm.getMessage()){

        }
        System.out.println("Choose the message");
        s = sc.nextLine();

        mail.setMsg();

        //#TODO choisir les parametres serveur
        SMTPClient client = new SMTPClient("10.192.95.2",1025,"prank.com");

        //#TODO demander une confirmation
        client.sendMail(mail);


        sc.nextLine();
    }
}
