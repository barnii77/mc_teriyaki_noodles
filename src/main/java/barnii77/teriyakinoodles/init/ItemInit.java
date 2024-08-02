package barnii77.teriyakinoodles.init;

import barnii77.teriyakinoodles.TeriyakiNoodles;
import barnii77.teriyakinoodles.list.FoodList;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ItemInit {
    public static final Item XXL_TERIYAKI_NOODLES = register("xxl_teriyaki_noodles", new Item(new Item.Settings().food(FoodList.XXL_TERIYAKI_NOODLES_COMPONENT).maxCount(64)));
    public static final Item TERIYAKI_NOODLES = register("teriyaki_noodles", new Item(new Item.Settings().food(FoodList.TERIYAKI_NOODLES_COMPONENT).maxCount(64)));
    public static final Item FRIED_NOODLES = register("fried_noodles", new Item(new Item.Settings().food(FoodList.FRIED_NOODLES_COMPONENT).maxCount(64)));
    public static final Item RAW_NOODLES = register("raw_noodles", new Item(new Item.Settings().food(FoodList.RAW_NOODLES_COMPONENT).maxCount(64)));
    public static final Item SALT = register("salt", new Item(new Item.Settings().maxCount(64)));
    public static final Item PIG_FAT = register("pig_fat", new Item(new Item.Settings().food(FoodList.PIG_FAT_COMPONENT).maxCount(64)));
    public static final float PIG_FAT_CHANCE = 0.25f;
    public static final float SALT_CHANCE = 0.05f;

    public static void load() {}

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, TeriyakiNoodles.id(name), item);
    }
}
