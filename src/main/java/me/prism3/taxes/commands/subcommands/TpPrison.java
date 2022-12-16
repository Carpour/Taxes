package me.prism3.taxes.commands.subcommands;

import me.prism3.taxes.Main;
import me.prism3.taxes.commands.SubCommand;
import me.prism3.taxes.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class TpPrison implements SubCommand {

    @Override
    public String getName() { return "tpprison"; }

    @Override
    public String getDescription() { return "Teleports you to the location of the Prison if set."; }

    @Override
    public String getSyntax() { return "/taxes tpprison"; }

    @Override
    public void perform(CommandSender commandSender, String[] args) {

        if (!(commandSender instanceof Player)) {

            Log.severe("This command can only be run in-game!");
            return;
        }

        final Main main = Main.getInstance();

        final Player player = (Player) commandSender;
        final Location prisonLocation = new Location(Bukkit.getWorld(main.getConfig().getString("Prison.Coords.World-Name")), main.getConfig().getDouble("Prison.Coords.X"), main.getConfig().getDouble("Prison.Coords.Y"), main.getConfig().getDouble("Prison.Coords.Z"));

        if (prisonLocation != null) {
            player.teleport(prisonLocation);
            player.sendMessage("You have been teleported!");
        } else {
            player.sendMessage("No Prison location has been set. Execute /taxes setprison to set it's location.");
        }
    }

    @Override
    public List<String> getSubCommandsArgs(CommandSender commandSender, String[] args) { return Collections.emptyList(); }
}
