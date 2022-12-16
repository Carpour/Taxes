package me.prism3.taxes.commands.subcommands;

import me.prism3.taxes.Main;
import me.prism3.taxes.commands.SubCommand;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class SetPrison implements SubCommand {

    @Override
    public String getName() { return "setprison"; }

    @Override
    public String getDescription() { return "Sets the Prison Location."; }

    @Override
    public String getSyntax() { return "/taxes setprison"; }

    @Override
    public void perform(CommandSender commandSender, String[] args) {

        final Main main = Main.getInstance();

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command can only be executed in-game.");
            return;
        }

        final Player player = (Player) commandSender;
        final World worldName = player.getWorld();
        final double x = player.getLocation().getX();
        final double y = player.getLocation().getY();
        final double z = player.getLocation().getZ();


        main.getConfig().set("Prison.Coords.World-Name", worldName);
        main.getConfig().set("Prison.Coords.X", x);
        main.getConfig().set("Prison.Coords.Y", y);
        main.getConfig().set("Prison.Coords.Z", z);
        main.saveConfig();

        player.sendMessage("Done");
    }

    @Override
    public List<String> getSubCommandsArgs(CommandSender commandSender, String[] args) { return Collections.emptyList(); }
}
