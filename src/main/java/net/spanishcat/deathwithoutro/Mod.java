package net.spanishcat.deathwithoutro;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.spanishcat.deathwithoutro.event.PlayerDeathHandler;
import net.spanishcat.deathwithoutro.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer
{
	public static final String MOD_ID = "deathwithoutro";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize()
	{
		ServerLivingEntityEvents.AFTER_DEATH.register(new PlayerDeathHandler());
		ModSounds.registerModSoundEvents();
	}
}