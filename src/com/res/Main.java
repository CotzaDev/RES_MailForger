package com.res;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        ListOfVicitim lst = new ListOfVicitim();

        System.out.println("SMTP PRANK");
        System.out.println("==========");
        System.out.println("Enter a list of email [Separate by ;] : ");
        s = sc.nextLine();
        lst.fetchAdrStringBySep(s,';');

        System.out.println("How many groups ? : ");
        s = sc.nextLine();

        System.out.println("Enter a list of message [Separate by ;] : ");
        s = sc.nextLine();

        sc.nextLine();
    }
}
