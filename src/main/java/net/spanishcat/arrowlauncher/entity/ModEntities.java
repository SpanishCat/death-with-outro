package net.spanishcat.arrowlauncher.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spanishcat.arrowlauncher.Mod;
import net.spanishcat.arrowlauncher.entity.custom.ExplosiveArrowEntity;

public class ModEntities {
    // Register Entities
    public static final EntityType<ExplosiveArrowEntity> EXPLOSIVE_ARROW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Mod.MOD_ID, "explosive_arrow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ExplosiveArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(.1f, .1f)).build());

    public static void RegisterModEntities() {
        Mod.LOGGER.info("Registering ModEntities for " + Mod.MOD_ID);
    }
}
