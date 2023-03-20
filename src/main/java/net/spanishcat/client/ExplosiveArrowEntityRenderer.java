package net.spanishcat.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.spanishcat.arrowlauncher.entity.custom.ExplosiveArrowEntity;

public class ExplosiveArrowEntityRenderer extends EntityRenderer<ExplosiveArrowEntity> {

    public static final ItemStack STACK = new ItemStack(Items.ARROW);
    public static final Identifier TEXTURE = new Identifier("textures/entity/projectiles/arrow.png");
    public static final Identifier TIPPED_TEXTURE = new Identifier("textures/entity/projectiles/tipped_arrow.png");

    public ExplosiveArrowEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(ExplosiveArrowEntity entity) {
        return entity.getColor() > 0 ? TIPPED_TEXTURE : TEXTURE;
    }


//    @Override
//    public void render(ExplosiveArrowEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
//        MinecraftClient.getInstance().getItemRenderer().renderItem(
//                STACK,
//                ModelTransformationMode.FIXED,
//                light,
//                OverlayTexture.DEFAULT_UV,
//                matrices,
//                vertexConsumers,
//                entity.world,
//                0
//        );
//        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
//    }


//    @Override
//    public Identifier getTexture(ExplosiveArrowEntity entity) {
//        return null;
//    }

//    public Identifier getTexture(ArrowEntity arrowEntity) {
//        return arrowEntity.getColor() > 0 ? TIPPED_TEXTURE : TEXTURE;
//    }
}
