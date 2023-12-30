package net.ciel.oreology.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.client.CuriosLayerDefinitions;
import net.ciel.oreology.client.model.GoldenCrownModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class GoldenCrownRenderer implements ICurioRenderer {
    private static final ResourceLocation GOLDEN_CROWN_TEXTURE = new ResourceLocation(Oreology.MOD_ID, "textures/entity/curios/golden_crown.png");

    private final HumanoidModel<LivingEntity> model;

    public GoldenCrownRenderer() {
        this.model = new GoldenCrownModel(Minecraft.getInstance().getEntityModels().bakeLayer(CuriosLayerDefinitions.GOLDEN_CROWN));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource rendBufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        this.model.prepareMobModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);

        ICurioRenderer.followBodyRotations(slotContext.entity(), this.model);

        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(rendBufferSource, this.model.renderType(GOLDEN_CROWN_TEXTURE), false, stack.hasFoil());

        this.model.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
