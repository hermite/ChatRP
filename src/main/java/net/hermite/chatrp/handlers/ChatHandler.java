package net.hermite.chatrp.handlers;

import net.hermite.chatrp.utils.SendMessage;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.filter.FilteredMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import static net.hermite.chatrp.chatrp.StopChat;
import static net.hermite.chatrp.chatrp.ListeEspion;

public class ChatHandler {
    public static void ChatRP(FilteredMessage<SignedMessage> message, ServerPlayerEntity sender){
        ServerPlayerEntity p = sender;
        String msg = message.raw().getContent().getString();

        if ( !StopChat || PermissionSenderHandler.PermissionOfSend(p.getEntityName())==true)
        {

            World w = p.getWorld();
            if (msg != "")
            {
                if (msg.length()<2)
                {
                    msg = msg + " ";
                }
                switch (msg.substring(0,2))
                {
				/*case "!!":
					msg = p.getEntityName() + " hurle : " + msg.substring(2);
					SendMessage.Send(msg,"Rouge",30,w,p);
				break;*/
                    case "&*":
                        msg = p.getEntityName() + " " + msg.substring(2);
                        SendMessage.Send(msg,0,"AquatiqueSombre",3,w,p);
                        break;

                    case "!=":
                        if (p.hasPermissionLevel(4))// Seulement pour les MJ
                        {
                            msg = msg.substring(2);
                            SendMessage.Send(msg,2,"VertFonce",0,w,p);
                        }
                        else
                        {
                            msg = p.getEntityName() + " dit : " + msg;
                            SendMessage.Send(msg,0,"",8,w,p);
                        }
                        break;


                    default :
                        if(msg.length() > 1)
                        {
                            switch (msg.substring(0,1))
                            {
                                case "@":
                                    if (msg.length() > 1)
                                    {
                                        msg = "[SUPPORT] " + p.getEntityName() + " (" + p.getName() +  ") : " + msg.substring(1);
                                    }
                                    else
                                    {
                                        msg = "[SUPPORT] " + p.getEntityName() + " (" + p.getName() +  ") : ";
                                    }
                                    SendMessage.Send(msg,1,"Rouge",5,w,p);
                                    break;

                                case "*":
                                    msg = p.getEntityName() + " " + msg.substring(1);
                                    SendMessage.Send(msg,0,"Aquatique",15,w,p);
                                    break;

                                case "&":
                                    msg = p.getEntityName() + " chuchote : " + msg.substring(1);
                                    SendMessage.Send(msg,0,"RoseFonce",2,w,p);
                                    break;

                                case "(":
                                    msg = p.getEntityName() + " (HRP) : " + msg.substring(1);
                                    SendMessage.Send(msg,0,"Gris",8,w,p);
                                    break;

                                case "!":
                                    msg = p.getEntityName() + " crie : " + msg.substring(1);
                                    SendMessage.Send(msg,0,"Jaune",35,w,p);
                                    break;

                                case "=":
                                    if (p.hasPermissionLevel(4))// Seulement pour les MJ
                                    {
                                        msg = msg.substring(1);
                                        SendMessage.Send(msg,0,"VertFonce",15,w,p);
                                    }
                                    else
                                    {
                                        msg = p.getEntityName() + " dit : " + msg;
                                        SendMessage.Send(msg,0,"",8,w,p);
                                    }
                                    break;

                                case "+":
                                    if (p.hasPermissionLevel(4))// Seulement pour les MJ
                                    {
                                        msg = "[Annonce] " + msg.substring(1);
                                        SendMessage.Send(msg,2,"Dore",15,w,p);
                                    }
                                    else
                                    {
                                        msg = p.getEntityName() + " dit : " + msg;
                                        SendMessage.Send(msg,0,"",8,w,p);
                                    }
                                    break;
                                default:
                                    msg = p.getEntityName() + " dit : " + msg;
                                    SendMessage.Send(msg,0,"",8,w,p);
                                    break;

                            }
                        }
                        break;
                }

            }


        }
    }
}
