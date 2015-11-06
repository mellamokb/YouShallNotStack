package com.InfinityRaider.YouShallNotStack;

import net.fybertech.meddle.MeddleMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

@MeddleMod(id=YouShallNotStack.modId, name=YouShallNotStack.modId, version="1.2", author="mellamokb")
public class YouShallNotStack {
    public static final String modId = "YouShallNotStack";
    public static String[] rawData;

    public static YouShallNotStack instance;

    public void init()
	{
    	ConfigurationHandler.init();
    	postInit();
	}
    
    public static void postInit() {
        for (int i = 0; i < rawData.length; i++) {
            String data[] = IOHelper.getData(rawData[i]);
            Item item = (Item) Item.itemRegistry.getObject(new ResourceLocation(data[0]));
            Block block = (Block) Block.blockRegistry.getObject(new ResourceLocation(data[0]));
            int size = Integer.parseInt(data[1]) <= 0 ? 0 : Integer.parseInt(data[1]) >= 64 ? 64 : Integer.parseInt(data[1]);
            if (item != null) {
                item.setMaxStackSize(size);
                LogHelper.info("Setting stacksize of " + Item.itemRegistry.getNameForObject(item) + " to " + size);
            } else if (block != null) {
                Item.getItemFromBlock(block).setMaxStackSize(size);
                LogHelper.info("Setting stacksize of " + Block.blockRegistry.getNameForObject(block) + " to " + size);
            } else {
                LogHelper.info("Something went wrong on line " + i + ": " + data[0] + "," + data[1]);
            }
        }
        rawData = null;
    }

}
