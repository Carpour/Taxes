package me.prism3.taxes.utils.files;

import me.prism3.taxes.Main;
import me.prism3.taxes.utils.Log;

import java.io.File;
import java.io.IOException;

public class Interactions {

    File interaction;

    public void createFile() {

        this.interaction = new File(Main.getInstance().getDataFolder(), "interactions.txt");

        try {

            if (!this.interaction.exists())
                this.interaction.createNewFile();

        } catch (IOException exception) {

            Log.severe("An error occurred while creating the interactions file. If the issue persists, contact the Author!");
            exception.printStackTrace();
        }
    }

    public File getInteraction() { return this.interaction; }
}
