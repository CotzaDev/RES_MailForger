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
        /**
         * VAR
         */
        String s;
        Scanner sc = new Scanner(System.in);
        ListOfVicitim lstv = new ListOfVicitim();
        ArrayList<GroupOfVictim> groups = new ArrayList<>();
        ListOfMessage lstm = new ListOfMessage();
        Mail mail = new Mail();
        JSONParser parser = new JSONParser();


        System.out.println("SMTP PRANK");
        System.out.println("==========");


        /**
         * GET LIST MAIL
         */
        System.out.println("Enter the name of file where the list of email is  : ");
        s = sc.nextLine();

        try {
            Object obj = parser.parse(new FileReader(s));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray person = (JSONArray) jsonObject.get("person");
            Iterator<JSONObject> iterator = person.iterator();
            while (iterator.hasNext()) {
                lstv.addVictim((String) (iterator.next().get("mail")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * GET & SET THE GROUPS
         */
        int groupMax = lstv.getNbrVictim() / 3;
        int nbGroup = 0;


        while (nbGroup == 0 || nbGroup > groupMax) {
            System.out.println(String.format("How many groups ? [Max %d]: ", groupMax));
            s = sc.nextLine();
            nbGroup = Integer.parseInt(s);
        }

        int nbMembers = lstv.getNbrVictim() / nbGroup;
        int supMembers = lstv.getNbrVictim() - nbMembers * nbGroup;


        for (int i = 0; i < supMembers * (nbMembers + 1); i += nbMembers + 1) {
            GroupOfVictim g = new GroupOfVictim();
            g.setRecipient(lstv.getASublist(i, i + nbMembers));
            g.setSender(lstv.getOneVictim(i + nbMembers));

            groups.add(g);
        }

        for (int i = supMembers * (nbMembers + 1); i < lstv.getNbrVictim(); i += nbMembers) {
            GroupOfVictim g = new GroupOfVictim();
            g.setRecipient(lstv.getASublist(i, i + nbMembers - 1));
            g.setSender(lstv.getOneVictim(i + nbMembers - 1));

            groups.add(g);
        }


        /**
         * GET THE MESSAGE
         */
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


        /**
         * CHOOSE GROUP
         */
        for (int i = 0; i < groups.size(); i++) {
            System.out.print(i + ") Recipient : ");
            for (String str : groups.get(i).getRecipient())
                System.out.print(str + ",");
            System.out.print("Sender : " + groups.get(i).getSender());
            System.out.println();
        }

        System.out.println("Choose the group :");
        s = sc.nextLine();

        mail.setTo(groups.get(Integer.parseInt(s)).getRecipient());
        mail.setFrom(groups.get(Integer.parseInt(s)).getSender());

        /**
         * CHOOSE MESSAGE
         */
        for (int i = 0; i < lstm.getMessage().size(); i++) {
            System.out.print(i + ") " + lstm.getMessage().get(i));
            System.out.println();
        }

        System.out.println("Choose the message");
        s = sc.nextLine();

        mail.setMsg(lstm.getMessage().get(Integer.parseInt(s)));


        /**
         * SEND MAIL
         */
        try {
            JSONObject conf = (JSONObject) parser.parse(new FileReader("conf.json"));
            JSONObject smtpConf = (JSONObject) conf.get("smtp");
            SMTPClient client = new SMTPClient((String) smtpConf.get("address"),
                    ((Long) smtpConf.get("port")).intValue(), (String) smtpConf.get("hostname"));


            System.out.println("Are you sure you want to send those mails ? [Y/N]: ");
            s = sc.nextLine().toLowerCase();
            if (s.compareTo("y") == 0) {
                client.sendMail(mail);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("Press ENTER to exit: ");
        sc.nextLine();
    }
}
