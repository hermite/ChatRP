package net.hermite.chatrp.utils;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.hermite.chatrp.command.chatListCommand;
import net.hermite.chatrp.command.privateMessageCommand;
import net.hermite.chatrp.command.spyChatCommand;
import net.hermite.chatrp.command.stopChatCommand;

public class ModRegistries {

    public static void registerModStuffs(){
        registerCommands();
    }
    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(chatListCommand::register);
        CommandRegistrationCallback.EVENT.register(spyChatCommand::register);
        CommandRegistrationCallback.EVENT.register(stopChatCommand::register);
        CommandRegistrationCallback.EVENT.register(privateMessageCommand::register);
    }
}
