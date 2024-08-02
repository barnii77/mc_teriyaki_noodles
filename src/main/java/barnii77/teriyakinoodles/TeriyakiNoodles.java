package barnii77.teriyakinoodles;

import barnii77.teriyakinoodles.init.ItemInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeriyakiNoodles implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("teriyakinoodles");
    public static final String MOD_ID = "teriyakinoodles";

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Cooking Teriyaki Noodles...");
        ItemInit.load();
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
            ResourceManagerHelper.registerBuiltinResourcePack(TeriyakiNoodles.id("data"), modContainer, ResourcePackActivationType.ALWAYS_ENABLED);
        });
        Random rng = Random.create();
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            source.getWeaponStack().getEnchantments();
            if (entity.getType() == EntityType.PIG && rng.nextFloat() < ItemInit.PIG_FAT_CHANCE) {
                BlockPos pos = entity.getBlockPos();
                ServerWorld world = (ServerWorld) entity.getWorld();
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.PIG_FAT)));
            }
        });
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
            if (state.getBlock() == Blocks.STONE && rng.nextFloat() < ItemInit.SALT_CHANCE) {
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.SALT)));
            }
        });
    }
}