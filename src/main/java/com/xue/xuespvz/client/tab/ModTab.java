package com.xue.xuespvz.client.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * 创造模式物品栏标签
 *
 * @Author xueyuntong
 * @Date 2023/4/23 15:53
 */
public class ModTab {
    public static final CreativeModeTab MODE_TAB = new CreativeModeTab("xuespvz") {
        @Override
        public ItemStack makeIcon() {
            return null;
        }
    };
}
