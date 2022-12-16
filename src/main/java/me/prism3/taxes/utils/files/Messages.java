package me.prism3.taxes.utils.files;

import me.prism3.taxes.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Messages {

    private File messagesFile;
    private FileConfiguration file;

    public void setup() {

        this.messagesFile = new File(Main.getInstance().getDataFolder(), "messages.yml");

        if (!this.messagesFile.exists())
            Bukkit.getServer().getPluginManager().getPlugin("Taxes").saveResource("messages.yml", false);

        this.file = YamlConfiguration.loadConfiguration(this.messagesFile);
    }

    public FileConfiguration get() { return this.file; }

    public void reload() { this.file = YamlConfiguration.loadConfiguration(this.messagesFile); }
}