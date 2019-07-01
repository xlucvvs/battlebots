package br.ifb.tsi.poo.robot.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	public static void reader(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
}
