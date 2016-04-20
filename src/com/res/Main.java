package com.res;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        ListOfVicitim lstv = new ListOfVicitim();
        ArrayList<GroupOfVictim> groups = new ArrayList<>();
        ListOfMessage lstm = new ListOfMessage();
        Mail mail = new Mail();
        JSONParser parser = new JSONParser();


        System.out.println("SMTP PRANK");
        System.out.println("==========");
        System.out.println("Enter the name of file where the list of email is  : ");
        s = sc.nextLine();

        try {
            Object obj = parser.parse(new FileReader(s));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray msg = (JSONArray) jsonObject.get("mail");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                lstv.addVictim(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("How many groups ? : ");
        s = sc.nextLine();

        //#TODO verification du nbr de victimes par rapport au groupe
        int z = lstv.getNbrVictim() / Integer.parseInt(s);

        for (int i = 0; i < z; i++) {
            GroupOfVictim g = new GroupOfVictim();
            g.setRecipient(lstv.getASublist(i * z, z - 1));
            g.setSender(lstv.getOneVictim(i * z));

            groups.add(g);
        }


        System.out.println("Enter a the name of the file where the message are : ");
        s = sc.nextLine();

        try {
            Object obj = parser.parse(new FileReader(s));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                lstm.addMessage(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        for(int i=0;i < groups.size();i++){
            System.out.print(i+") ");
            for(String str : groups.get(i).getRecipient())
                System.out.print(str+";");
        }


        System.out.println("Choose the group :");
        s = sc.nextLine();

        mail.setTo();
        mail.setFrom();

        for (String msg : lstm.getMessage()) {

        }

        System.out.println("Choose the message");
        s = sc.nextLine();

        mail.setMsg(s);

        //#TODO choisir les parametres serveur
        SMTPClient client = new SMTPClient("10.192.95.233", 1025, "prank.com");

        //#TODO demander une confirmation
        client.sendMail(mail);


        sc.nextLine();
    }
}
