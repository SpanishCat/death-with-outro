package net.spanishcat.arrowlauncher;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.spanishcat.arrowlauncher.entity.ModEntities;
import net.spanishcat.client.ExplosiveArrowEntityRenderer;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Entities
        EntityRendererRegistry.register(ModEntities.EXPLOSIVE_ARROW, ExplosiveArrowEntityRenderer::new);
    }
}
