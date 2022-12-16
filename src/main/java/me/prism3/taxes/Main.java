package me.prism3.taxes;

import me.prism3.taxes.events.PlayerJoin;
import me.prism3.taxes.utils.Data;
import me.prism3.taxes.utils.files.Interactions;
import me.prism3.taxes.utils.Log;
import me.prism3.taxes.utils.files.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Messages messages;

    @Override
    public void onEnable() {

        instance = this;

        this.saveDefaultConfig();

        Log.setup(this.getLogger());

        this.initializer(new Data());

        this.messages = new Messages();
        this.messages.setup();
        this.messages.get().options().copyDefaults(true);

        final Interactions interactionFile = new Interactions();
        interactionFile.createFile();

        this.eventInitializer();

        Log.info("Loaded successfully");
    }

    @Override
    public void onDisable() { Log.info("Unloaded successfully"); }

    public void initializer(Data data) {

        data.initializeStrings();
        data.initializeIntegers();
        data.initializeDoubles();
        data.initializeBooleans();
        data.initializePermissions();
        data.initializeCommands();
    }
    private void eventInitializer() {

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    public static Main getInstance() { return instance; }

    public Messages getMessages() { return this.messages; }
}
