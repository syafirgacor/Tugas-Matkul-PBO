/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import util.InputHelper;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        InputHelper input = new InputHelper();
        LayananPerpustakaan layanan = new LayananPerpustakaan();
        
        MenuHandler menu = new MenuHandler(layanan, input);
        menu.jalankan();

        input.tutupScanner();
    }
}
