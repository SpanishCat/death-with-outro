package net.spanishcat.deathwithoutro.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.spanishcat.deathwithoutro.Mod;

public class ModSounds
{
    public static final SoundEvent OUTRO = registerSoundEvent("outro");

    public static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = new Identifier(Mod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSoundEvents()
    {
        Mod.LOGGER.info("Registering ModSounds for " + Mod.MOD_ID);
    }
}
