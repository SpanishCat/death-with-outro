package net.spanishcat.deathwithoutro.sound;

import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.spanishcat.deathwithoutro.Mod;
import java.util.Objects;

public class OutroMovingSound extends MovingSoundInstance {
    PlayerEntity player;

    double targetX;
    double targetY;
    double targetZ;

    public OutroMovingSound(PlayerEntity entity, Random random) {
        super(ModSounds.OUTRO, SoundCategory.NEUTRAL, random);

        this.volume = .3f;
        player = entity;
    }

    boolean check = false;
    @Override
    public void tick() {
        check = !check;

        World world = player.getWorld();
        PlayerEntity foundPlayer = null;


        try{
            for (PlayerEntity listedPlayer : world.getPlayers())
            {
                if (Objects.equals(listedPlayer.getName().toString(), listedPlayer.getName().toString()))
                {
                    foundPlayer = listedPlayer;
                    player.sendMessage(Text.literal(foundPlayer.getName().toString()));
                }
            }

            if (foundPlayer != null)
            {
                targetX = foundPlayer.getPos().x;
                targetY = foundPlayer.getPos().y;
                targetZ = foundPlayer.getPos().z;

                player.sendMessage(Text.literal(foundPlayer.getPos().toString()));
            }

//            player.sendMessage(Text.literal(world.getPlayers().get(0).getPos().toString()));
            Mod.LOGGER.info(world.getPlayers().get(0).getPos().toString());
        }

        catch (Exception exception){
            player.sendMessage(Text.literal(exception.toString()));
            Mod.LOGGER.info(exception.toString());
        }

        this.x = targetX;
        this.y = targetY;
        this.z = targetZ;
    }
}
