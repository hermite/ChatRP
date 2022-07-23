package net.hermite.chatrp.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.hermite.chatrp.utils.MinecraftColorCode;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class chatListCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("chatlist").executes(chatListCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity p = context.getSource().getPlayer();
        p.sendMessage(Text.of("Liste des Chats : "));
        p.sendMessage(Text.of("§c@  | Message au Support"));
        p.sendMessage(Text.of("§5&  | Chuchoter"));
        p.sendMessage(Text.of("§b*  | Emote"));
        p.sendMessage(Text.of("§3&* | Emote discr�te"));
        p.sendMessage(Text.of("§7(  | HRP"));
        p.sendMessage(Text.of("§e!  | Crier"));

        if (p.hasPermissionLevel(2))
        {
            p.sendMessage(Text.of("§2=  | Evenement de zone (MJ)"));
            p.sendMessage(Text.of("§2!= | Evenement Global (MJ)"));
            p.sendMessage(Text.of("§6+  | Message MJ (MJ)"));
            p.sendMessage(Text.of("§c/m [Nom dest] [message]  | Message Priv� (MJ)"));
            p.sendMessage(Text.of("/chatespion ON | Activer Mode Espion"));
            p.sendMessage(Text.of("/chatespion OFF | Desactive Mode Espion"));
        }

        return 1;
    }


}
