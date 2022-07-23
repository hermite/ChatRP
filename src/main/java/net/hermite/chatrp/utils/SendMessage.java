package net.hermite.chatrp.utils;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import static net.hermite.chatrp.chatrp.ListeEspion;

public class SendMessage {
    public static void Send(String msg, Integer type, String color, Integer distance, World w, ServerPlayerEntity p)
    {

        Text msg_final = null;
        String code_color;
        int NbJoueur = w.getPlayers().size();
        code_color = MinecraftColorCode.getColorCode(color);

        msg_final = Text.of(code_color + msg);

        for (int i=0; i < NbJoueur;i++)
        {
            if ( type == 0)//au joueur dans la zone
            {

                if ( w.getPlayers().get(i).distanceTo(p) <= distance || ListeEspion.contains(w.getPlayers().get(i).getName().getString()))
                {
                    w.getPlayers().get(i).sendMessage(msg_final);
                }
            }
            else if (type == 1)// SUPPORT au personne OP
            {
                if (w.getPlayers().get(i).hasPermissionLevel(4) || w.getPlayers().get(i).getName() == p.getName())
                {
                    w.getPlayers().get(i).sendMessage(msg_final);
                }
            }
            else if (type == 2 )// A tout le monde
            {
                if (p.hasPermissionLevel(4))
                {
                    w.getPlayers().get(i).sendMessage(msg_final);
                }
            }
            else
            {


            }
        }

    }
}
