package com.InfinityRaider.YouShallNotStack;

import net.fybertech.meddle.Meddle;
import net.fybertech.meddle.MeddleMod;

import java.io.*;
import java.util.Arrays;

public class ConfigurationHandler {
    private static String directory;

    public static void init() {
        directory = Meddle.getConfigDir().toString();
        loadConfiguration();
    }

    private static void loadConfiguration() {
        YouShallNotStack.rawData = IOHelper.getLinesArrayFromData(readStackSizes());
    }

    private static String readStackSizes() {
        File file = new File(directory, YouShallNotStack.modId+".txt");
        if(file.exists() && !file.isDirectory()) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] input = new byte[(int) file.length()];
                try {
                    inputStream.read(input);
                    inputStream.close();
                    return new String(input, "UTF-8");
                } catch (IOException e) {
                    LogHelper.error(Arrays.toString(e.getStackTrace()));
                }
            } catch(FileNotFoundException e) {
                LogHelper.error(Arrays.toString(e.getStackTrace()));
            }
        }
        else {
            LogHelper.debug("Generating new file");
            String defaultData = IOHelper.getInstructions();
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                try {
                    writer.write(defaultData);
                    writer.close();
                    return defaultData;
                }
                catch(IOException e) {
                    LogHelper.debug("Caught IOException");
                    LogHelper.error(Arrays.toString(e.getStackTrace()));
                }
            }
            catch(IOException e) {
                LogHelper.error(Arrays.toString(e.getStackTrace()));
            }
        }
        return null;
    }
}
