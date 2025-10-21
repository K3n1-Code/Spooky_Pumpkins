package net.mcreator.spookypumpkins.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.spookypumpkins.entity.PumpKinEntity;
import net.mcreator.spookypumpkins.client.model.Modelskeleton;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PumpKinRenderer extends MobRenderer<PumpKinEntity, Modelskeleton<PumpKinEntity>> {
	public PumpKinRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton<PumpKinEntity>(context.bakeLayer(Modelskeleton.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<PumpKinEntity, Modelskeleton<PumpKinEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("spooky_pumpkins:textures/entities/pump_kin_overlay_normal.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PumpKinEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				EntityModel model = new Modelskeleton(Minecraft.getInstance().getEntityModels().bakeLayer(Modelskeleton.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PumpKinEntity entity) {
		return ResourceLocation.parse("spooky_pumpkins:textures/entities/pump_kin_under.png");
	}
}