package net.hermite.chatrp.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.hermite.chatrp.chatrp.ListeEspion;
import static net.hermite.chatrp.chatrp.StopChat;

public class stopChatCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("stopchat").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("on").executes(stopChatCommand::runOn)));
        dispatcher.register(CommandManager.literal("stopchat").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("off").executes(stopChatCommand::runOff)));
    }

    private static int runOn(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity p = context.getSource().getPlayer();
        p.sendMessage(Text.of("StopChat : Activ�"));
        StopChat = true;
        return 1;
    }

    private static int runOff(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity p = context.getSource().getPlayer();
        p.sendMessage(Text.of("StopChat : D�sactiv�"));
        StopChat = false;
        return 1;
    }
}
