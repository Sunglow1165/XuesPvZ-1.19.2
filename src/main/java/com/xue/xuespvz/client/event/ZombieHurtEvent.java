package com.xue.xuespvz.client.event;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 僵尸受伤事件
 *
 * @Author xueyuntong
 * @Date 2023/4/14 18:26
 */
@Mod.EventBusSubscriber
public class ZombieHurtEvent {

    //掉头动画
    public static final AnimationDefinition DROP_HEAD = AnimationDefinition.Builder.withLength(0.5f)
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -19f, 15f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(87.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();

    @SubscribeEvent
    public static void hurtEvent(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Zombie) {
            DropType dropType = DropType.byFraction(entity.getHealth() / entity.getMaxHealth());
        }
    }

    public enum DropType {
        NONE(1.0F),
        LOW(0.75F),
        MEDIUM(0.5F),
        HIGH(0.25F);

        private final float fraction;

        DropType(float fraction) {
            this.fraction = fraction;
        }

        //枚举排序后，返回一个不可变的List列表
        private static final List<DropType> BY_DAMAGE =
                Stream.of(values()).sorted(Comparator.comparingDouble((dropType) -> dropType.fraction)).collect(ImmutableList.toImmutableList());

        //根据当前生命值的占比返回枚举值
        public static DropType byFraction(float v) {
            for (DropType zombiehurtevent$droptype : BY_DAMAGE) {
                if (v < zombiehurtevent$droptype.fraction) {
                    return zombiehurtevent$droptype;
                }
            }

            return NONE;
        }
    }

}
