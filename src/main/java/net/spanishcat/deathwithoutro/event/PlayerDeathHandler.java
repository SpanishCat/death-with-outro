package net.spanishcat.deathwithoutro.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.spanishcat.deathwithoutro.sound.OutroMovingSound;

public class PlayerDeathHandler implements ServerLivingEntityEvents.AfterDeath
{
    MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {
        if (entity.isPlayer())
        {
            PlayerEntity player = (PlayerEntity) entity;

            player.sendMessage(Text.literal("Died at " + player.getX() + " " + player.getY() + " " + player.getZ()));

            client.getSoundManager().play(new OutroMovingSound(player, SoundInstance.createRandom()));
        }
    }
}
