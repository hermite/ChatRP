package net.hermite.chatrp.handlers;

import java.io.*;

public class FileHandler {
    public static String[] read(String fichier){
        String[] contenu_fichier = new String [100000];
        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            int i = 0;
            while ((ligne=br.readLine())!=null){
                contenu_fichier[i] = ligne;
                i++;
            }
            br.close();
        }
        catch (Exception exp){
            System.out.println(exp.toString());
        }
        return contenu_fichier;
    }

    public static void write(String chaine, String fichier, boolean reecrire){
        try{
            FileWriter fw = new FileWriter(fichier, reecrire);
            BufferedWriter output = new BufferedWriter(fw);
            output.write(chaine);
            output.newLine();
            output.flush();
            output.close();
        }
        catch (Exception exp){
            System.out.println(exp.toString());
        }
    }

}
