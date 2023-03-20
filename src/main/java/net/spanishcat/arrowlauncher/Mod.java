package net.spanishcat.arrowlauncher;

import net.fabricmc.api.ModInitializer;
import net.spanishcat.arrowlauncher.entity.ModEntities;
import net.spanishcat.arrowlauncher.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String MOD_ID = "arrowlauncher";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Constant parameters
	public static final float LAUNCH_SPEED = 5f;
	public static final float LAUNCH_DIVERGENCE = 2f;
	public static final byte LAUNCH_COOLDOWN = 60;

	@Override
	public void onInitialize()
	{
		ModItems.RegisterModItems();


		ModEntities.RegisterModEntities();
//		FabricDefaultAttributeRegistry.register(ModEntities.EXPLOSIVE_ARROW, ExplosiveArrowEntity.setAttributes());
	}
}
