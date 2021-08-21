package com.frogastudios.nomorescore.mixin;

import com.frogastudios.nomorescore.NoMoreScore;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.ShulkerBoxSlot;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DeathScreen.class)
public abstract class MixinDeathScreen
{
    @Shadow private Text scoreText;

    @Redirect(method = "init", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/screen/DeathScreen;scoreText:Lnet/minecraft/text/Text;", opcode = Opcodes.PUTFIELD))
    private void doNotSetScoreText(DeathScreen deathScreen, Text value) {
        this.scoreText = Text.of("");
    }
}