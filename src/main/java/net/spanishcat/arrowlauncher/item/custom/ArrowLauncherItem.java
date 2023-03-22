package net.spanishcat.arrowlauncher.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.spanishcat.arrowlauncher.Mod;

public class ArrowLauncherItem extends Item {
    public ArrowLauncherItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        ItemStack itemStack = user.getProjectileType(stack);

        // Summon arrow
        if (!world.isClient){
//            ArrowItem arrowItem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
//            PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);
            ArrowEntity arrow = new ArrowEntity(world, user);
            world.spawnEntity(arrow);
            arrow.setVelocity(user, user.getPitch(), user.getYaw(), user.getRoll(), Mod.LAUNCH_SPEED, Mod.LAUNCH_DIVERGENCE);

            // Creative pickup
            if (user.isCreative())
                arrow.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;

            user.getItemCooldownManager().set(this, Mod.LAUNCH_COOLDOWN);

            // Sound
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS,
                6.0F, 15F);
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS,
                    6.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F));

        }

        return super.use(world, user, hand);
    }
}
