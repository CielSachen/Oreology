package net.ciel.oreology.client.model;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class GoldenCrownModel extends HumanoidModel<LivingEntity> {
    public GoldenCrownModel(ModelPart part, Function<ResourceLocation, RenderType> renderType) {
        super(part, renderType);
    }

    public GoldenCrownModel(ModelPart part) {
        this(part, RenderType::entityCutoutNoCull);
    }

    public static LayerDefinition createLayer() {
        CubeListBuilder head = CubeListBuilder.create();
        CubeDeformation deformation = new CubeDeformation(2.3F);

        head
            .texOffs(0, 0)
            .addBox(-3.0F, -10.2F, -3.0F, 6, 4, 6, deformation);

        return createInitialLayer(head);
    }

    private static LayerDefinition createInitialLayer(CubeListBuilder head) {
        MeshDefinition mesh = createMesh(CubeDeformation.NONE, 0);

        mesh.getRoot().addOrReplaceChild("head", head, PartPose.ZERO);

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of();
    }
}
