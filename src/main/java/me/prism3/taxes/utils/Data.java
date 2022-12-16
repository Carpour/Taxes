package me.prism3.taxes.utils;

import me.prism3.taxes.Main;
import me.prism3.taxes.commands.CommandManager;

public class Data {

    private final Main main = Main.getInstance();

    public static String pluginVersion;
    public static String serverName;
    public static String pluginPrefix;

    public static int dataBaseDataDeletion;
    public static int sqLiteDataDeletion;

    public static boolean isLogInteractions;
    public static boolean isDatabase;
    public static boolean isSqLite;

    // Permissions
    public static String taxesAdmin;

    public void initializeStrings() {

        pluginVersion = this.main.getDescription().getVersion();
        serverName = this.main.getConfig().getString("Server-Name");
        pluginPrefix = this.main.getConfig().getString("Plugin-Prefix");
    }

    public void initializeIntegers() {

        dataBaseDataDeletion = this.main.getConfig().getInt("Database.Data-Deletion");
        sqLiteDataDeletion = this.main.getConfig().getInt("SQLite.Data-Deletion");
    }

    public void initializeBooleans() {

        isLogInteractions = this.main.getConfig().getBoolean("Log-Interactions");
        isDatabase = this.main.getConfig().getBoolean("Database.Enable");
        isSqLite = this.main.getConfig().getBoolean("SQLite.Enable");
    }

    public void initializePermissions() {

        taxesAdmin = "taxes.admin";
    }

    public void initializeCommands() {

        this.main.getCommand("taxes").setExecutor(new CommandManager());
    }
}
