package net.hermite.chatrp.handlers;

import java.io.File;

public class PermissionSenderHandler {
    private static String[] ListeJoueurAutorise = new String [10000];
    public static boolean PermissionOfSend(String PlayerName)
    {
        String path = System.getProperty("user.dir" );
        File RepPlugins= new File(path + "/mods/ChatRP");
        ListeJoueurAutorise = FileHandler.read(RepPlugins + "/ListeJoueur.txt");
        Boolean autorise = false;
        int i = 0;
        while(ListeJoueurAutorise[i] != null)
        {
            String Ligne = ListeJoueurAutorise[i];
            if(Ligne.equalsIgnoreCase(PlayerName))
            {
                autorise = true;
            }
            i++;
        }

        return autorise ;
    }
}
