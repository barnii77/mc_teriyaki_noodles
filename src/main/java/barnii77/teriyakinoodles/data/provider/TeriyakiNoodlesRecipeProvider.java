package barnii77.teriyakinoodles.data.provider;

import barnii77.teriyakinoodles.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TeriyakiNoodlesRecipeProvider extends FabricRecipeProvider {
    public TeriyakiNoodlesRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.TERIYAKI_NOODLES)
                .input('C', Items.CARROT)
                .input('N', ItemInit.FRIED_NOODLES)
                .input('P', Items.PAPER)
                .pattern(" C ")
                .pattern("PNP")
                .pattern(" P ")
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(ItemInit.FRIED_NOODLES), conditionsFromItem(ItemInit.FRIED_NOODLES))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.XXL_TERIYAKI_NOODLES)
                .input('C', Items.CARROT)
                .input('N', ItemInit.FRIED_NOODLES)
                .input('B', Items.PAPER)
                .input('M', Items.COOKED_PORKCHOP)
                .input('P', Items.BAKED_POTATO)
                .pattern("MCP")
                .pattern("BNB")
                .pattern(" B ")
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(ItemInit.FRIED_NOODLES), conditionsFromItem(ItemInit.FRIED_NOODLES))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(Items.COOKED_PORKCHOP), conditionsFromItem(Items.COOKED_PORKCHOP))
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.RAW_NOODLES)
                .input(Items.WHEAT)
                .input(Items.WHEAT)
                .input(ItemInit.SALT)
                .input(ItemInit.PIG_FAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .criterion(hasItem(ItemInit.SALT), conditionsFromItem(ItemInit.SALT))
                .criterion(hasItem(ItemInit.PIG_FAT), conditionsFromItem(ItemInit.PIG_FAT))
                .offerTo(exporter);

        RecipeProvider.offerSmelting(exporter, List.of(ItemInit.RAW_NOODLES), RecipeCategory.FOOD, ItemInit.FRIED_NOODLES, 0.35f, 20 * 30, "teriyaki_noodles");
    }
}
