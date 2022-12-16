package me.prism3.taxes.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface SubCommand {

    String getName();

    String getDescription();

    String getSyntax();

    void perform(CommandSender commandSender, String[] args);

    List<String> getSubCommandsArgs(CommandSender commandSender, String[] args);
}
