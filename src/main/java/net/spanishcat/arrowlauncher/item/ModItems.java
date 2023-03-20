package net.spanishcat.arrowlauncher.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spanishcat.arrowlauncher.Mod;
import net.spanishcat.arrowlauncher.item.custom.ArrowLauncherItem;
import net.spanishcat.arrowlauncher.item.custom.ExplosiveArrowLauncherItem;

public class ModItems {
    // Register Items
    public static final Item ARROW_LAUNCHER = RegisterItem("arrow_launcher", new ArrowLauncherItem(new FabricItemSettings().maxCount(1)), ItemGroups.COMBAT);
    public static final Item EXPLOSIVE_ARROW_LAUNCHER = RegisterItem("explosive_arrow_launcher", new ExplosiveArrowLauncherItem(new FabricItemSettings().maxCount(1)), ItemGroups.COMBAT);

    // Functions
    public static Item RegisterItem(String name, Item item, ItemGroup group){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(Mod.MOD_ID, name), item);
    }

    public static void RegisterModItems(){
        Mod.LOGGER.info("Registering ModItems for " + Mod.MOD_ID);
    }
}
