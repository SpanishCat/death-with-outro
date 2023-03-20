package net.spanishcat.arrowlauncher.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;

public class ExplosiveArrowEntity extends ArrowEntity {
    public ExplosiveArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) { super(entityType, world); }
//    public ExplosiveArrowEntity(World world, double x, double y, double z) { super(EntityType.ARROW, x, y, z, world); }
//    public ExplosiveArrowEntity(World world, LivingEntity owner) { super(world, owner); }

//    CowEntity cow = new CowEntity(EntityType.COW, world);

//    @Override
//    public boolean isOnGround() {
//
//        return super.isOnGround();
//    }

    public void explode(){
        TntEntity tnt = new TntEntity(EntityType.TNT, world);
        tnt.setPos(this.getX(), this.getY(), this.getZ());
        world.spawnEntity(tnt);
        this.kill();
    }

    @Override
    public void baseTick() {
        if (this.inGround)
        {
            explode();
        }

        super.baseTick();
    }

    @Override
    public void onHit(LivingEntity target) {
        explode();
//        world.createExplosion(target, 3, 3, 3, 4f, World.ExplosionSourceType.TNT);

        super.onHit(target);
    }

//    @Override
//    protected void initDataTracker() {}

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        PacketByteBuf packet = new PacketByteBuf(Unpooled.buffer());
//
//        // Entity pos
//        packet.writeDouble(getX());
//        packet.writeDouble(getY());
//        packet.writeDouble(getZ());
//
//        // Entity ID & UUID
//        packet.writeString(getSavedEntityId());
//        packet.writeUuid(getUuid());
//
//        return ToPacket
//                ServerSidePacketRegistry.toPacket;
//    }
}
