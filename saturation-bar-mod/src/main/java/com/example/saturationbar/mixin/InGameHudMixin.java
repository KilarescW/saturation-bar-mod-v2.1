package com.example.saturationbar.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.HungerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "renderStatusBars", at = @At("RETURN"))
    private void onRenderStatusBars(DrawContext context, ClientPlayerEntity player, CallbackInfo ci) {
        if (player == null) return;

        HungerManager hungerManager = player.getHungerManager();
        float saturation = hungerManager.getSaturation();

        // The food bar is approximately 90 pixels wide (10 icons * 9px)
        // It is centered horizontally: width/2 - 91 to width/2 - 1
        int width = context.getScaledWindowWidth();
        int height = context.getScaledWindowHeight();

        int foodBarX = width / 2 - 91;
        int foodBarY = height - 39;

        // Calculate the saturation glow width
        // Max saturation typically around 20, but can be higher.
        // We map 0-20 saturation to 0-90 pixels.
        int glowWidth = (int) (saturation * 4.5f);
        if (glowWidth > 90) glowWidth = 90;
        if (glowWidth < 0) glowWidth = 0;

        if (glowWidth > 0) {
            // Draw a semi-transparent yellow glow around the hunger bar
            // Yellow color: 0xAAFFFF00 (Alpha, R, G, B)
            // We draw a slightly larger rectangle to create the "glow" effect

            // Top border
            context.fill(foodBarX - 1, foodBarY - 1, foodBarX + glowWidth + 1, foodBarY, 0xAAFFFF00);
            // Bottom border
            context.fill(foodBarX - 1, foodBarY + 10, foodBarX + glowWidth + 1, foodBarY + 11, 0xAAFFFF00);
            // Left border
            context.fill(foodBarX - 1, foodBarY - 1, foodBarX, foodBarY + 11, 0xAAFFFF00);
            // Right border (only up to the current saturation level)
            context.fill(foodBarX + glowWidth, foodBarY - 1, foodBarX + glowWidth + 1, foodBarY + 11, 0xAAFFFF00);
        }
    }
}
