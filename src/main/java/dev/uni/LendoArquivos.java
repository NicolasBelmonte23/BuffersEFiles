package dev.uni;

import java.io.*;

public class LendoArquivos {
    public static void main(String[] args) {
        String filename = "produtos.txt";
        int linhas = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);
            String line = in.readLine();
            while(line != null){
                System.out.println("Total de linhas[" + linhas++ +"] "+line);
                String sep[] = line.split("\\*");
                for(String s : sep){
                    System.out.println(s.trim());
                }
                line = in.readLine();
            }
            in.close();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo/ " + filename + " /não existe ");
        }catch(IOException E){
            System.out.println("Erro ao ler o arquivo/ " + filename);
        }
    }
}
