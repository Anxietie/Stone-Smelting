package com.mod.melting.datagen;

import com.mod.melting.registry.RecipeTypeRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        String fromSmelting = "_from_smelting";
        for (Item input : Registries.ITEM) {
            Identifier id = Registries.ITEM.getId(input);
            String path = FabricRecipeProvider.getRecipeName(input);
            if (meltable(input, path)) {
                Item output;
                int l = fromSmelting.length();
                int i = path.indexOf(fromSmelting);
                output = Registries.ITEM.get(Identifier.of(id.getNamespace(), path.substring(i + l)));
                offerMelting(exporter, List.of(input), RecipeCategory.BUILDING_BLOCKS, output, 0.1f, 100, path.substring(i));
            }
        }
    }

    public static void offerMelting(Consumer<RecipeJsonProvider> exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
        offerMultipleOptions(exporter, RecipeTypeRegister.MELTING_SERIALIZER, inputs, category, output, experience, cookingTime, group, "_from_melting");
    }

    private boolean meltable(Item item, String path) {
        return !path.isBlank() &&
                FabricRecipeProvider.getBlastingItemPath(item).isBlank() &&
                item instanceof BlockItem;
    }
}
