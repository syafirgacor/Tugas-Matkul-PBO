/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;
/**
 *
 * @author user
 */
public class InputHelper {
    private final  Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public int bacaInt(String pesan) {
        System.out.print(pesan);
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka!");
            scanner.next();
            System.out.print(pesan);
        }
        int hasil = scanner.nextInt();
        scanner.nextLine();
        return hasil;
    }

    public String bacaString(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine();
    }

    public void tutupScanner() {
        scanner.close();
    }
}
