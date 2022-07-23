package net.hermite.chatrp.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.MessageArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Collection;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.command.argument.EntityArgumentType.getPlayers;
import static net.minecraft.command.argument.MessageArgumentType.getMessage;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class privateMessageCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(literal("msg").requires(source -> source.hasPermissionLevel(2)).then(argument("target", EntityArgumentType.players())).then(argument("message", MessageArgumentType.message()).executes(ctx -> {
            return run(ctx.getSource(), getPlayers(ctx, "target"), getMessage(ctx, "message"));
        })));
    }

    private static int run(ServerCommandSource source, Collection<ServerPlayerEntity> target, Text message) {
        for (ServerPlayerEntity p : target)
        {
            p.sendMessage(message);
        }
        return 1;
    }


}
