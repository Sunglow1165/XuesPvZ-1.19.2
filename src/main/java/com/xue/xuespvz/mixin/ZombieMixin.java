package com.xue.xuespvz.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 僵尸mixin
 *
 * @Author xueyuntong
 * @Date 2023/4/27 17:29
 */
@Mixin(Zombie.class)
public class ZombieMixin extends Zombie {

    public ZombieMixin(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "die", at = @At("HEAD"), cancellable = true)
    public void onDie(DamageSource source, CallbackInfo callbackInfo) {
        setPose(Pose.SLEEPING);
    }
}
