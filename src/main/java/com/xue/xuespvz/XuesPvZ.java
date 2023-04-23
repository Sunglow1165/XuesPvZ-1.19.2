package com.xue.xuespvz;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * 主类
 *
 * @Author xueyuntong
 * @Date 2023/4/23 15:49
 */
@Mod(XuesPvZ.MOD_ID)
public class XuesPvZ {

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "xuespvz";

    public XuesPvZ() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    }
}
