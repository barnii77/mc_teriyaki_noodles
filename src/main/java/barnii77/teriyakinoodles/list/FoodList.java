package barnii77.teriyakinoodles.list;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FoodList {
    public static final FoodComponent XXL_TERIYAKI_NOODLES_COMPONENT = new FoodComponent.Builder()
            .nutrition(20)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 10, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 30, 1), 1)
            .build();
    public static final FoodComponent TERIYAKI_NOODLES_COMPONENT = new FoodComponent.Builder()
            .nutrition(10)
            .alwaysEdible()
            .build();
    public static final FoodComponent FRIED_NOODLES_COMPONENT = new FoodComponent.Builder()
            .nutrition(4)
            .alwaysEdible()
            .build();
    public static final FoodComponent RAW_NOODLES_COMPONENT = new FoodComponent.Builder()
            .nutrition(1)
            .alwaysEdible()
            .build();
    public static final FoodComponent PIG_FAT_COMPONENT = new FoodComponent.Builder()
            .nutrition(0)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 60, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 10, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20 * 15, 1), 1)
            .build();
}