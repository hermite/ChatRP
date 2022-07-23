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

public class spyChatCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("spychat").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("on").executes(spyChatCommand::runOn)));
        dispatcher.register(CommandManager.literal("spychat").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("off").requires(source -> source.hasPermissionLevel(2)).executes(spyChatCommand::runOff)));
    }

    private static int runOn(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity p = context.getSource().getPlayer();
        ListeEspion.add(p.getName().getString());
        p.sendMessage(Text.of("Mode espion Activ� : " + p.getName().getString()));
        return 1;
    }

    private static int runOff(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity p = context.getSource().getPlayer();
        ListeEspion.remove(p.getName().getString());
        p.sendMessage(Text.of("Mode espion Desactiv� : " + p.getName().getString()));
        return 1;
    }
}
