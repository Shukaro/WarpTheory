package shukaro.warptheory.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import shukaro.warptheory.WarpTheory;
import shukaro.warptheory.items.WarpItems;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.util.ArrayList;

public class WarpRecipes
{
    public static ArrayList<ItemStack> meats = new ArrayList<ItemStack>();

    private static void initMeats()
    {
        meats.add(new ItemStack(Items.chicken));
        meats.add(new ItemStack(Items.beef));
        meats.add(new ItemStack(Items.porkchop));
        meats.add(new ItemStack(Items.fish));
    }

    public static void initRecipes()
    {
        initMeats();
        if (!WarpTheory.wussMode)
        {
            ThaumcraftApi.addInfusionCraftingRecipe("WARPCLEANSER", new ItemStack(WarpItems.itemCleanser), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(Items.nether_star),
                    new ItemStack[]{ItemApi.getItem("itemResource", 14), new ItemStack(Items.ghast_tear), new ItemStack(Items.diamond), new ItemStack(Items.quartz),
                            ItemApi.getItem("itemResource", 14), new ItemStack(Items.ghast_tear), new ItemStack(Items.diamond), new ItemStack(Items.quartz)});

            ThaumcraftApi.addInfusionCraftingRecipe("WARPAMULET", new ItemStack(WarpItems.itemAmulet), 10, new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 64), ItemApi.getItem("itemBaubleBlanks", 0),
                    new ItemStack[]{new ItemStack(WarpItems.itemCleanser), new ItemStack(Items.gold_ingot), new ItemStack(Items.diamond), ItemApi.getItem("itemResource", 14),
                            new ItemStack(WarpItems.itemCleanser), new ItemStack(Items.gold_ingot), new ItemStack(Items.diamond), ItemApi.getItem("itemResource", 14)});

            for (ItemStack meat : meats)
                ThaumcraftApi.addCrucibleRecipe("WARPSOMETHING", new ItemStack(WarpItems.itemSomething), meat, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 8));
            ThaumcraftApi.addWarpToItem(new ItemStack(WarpItems.itemSomething), 1);

            ThaumcraftApi.addShapelessArcaneCraftingRecipe("WARPPAPER", new ItemStack(WarpItems.itemPaper), new AspectList().add(Aspect.WATER, 8),
                    ItemApi.getItem("itemResource", 14), new ItemStack(Items.paper), ItemApi.getItem("itemResource", 14));
        }
        else
        {
            ThaumcraftApi.addInfusionCraftingRecipe("WARPCLEANSER", new ItemStack(WarpItems.itemCleanser), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(Items.ghast_tear),
                    new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 14), new ItemStack(Items.quartz), new ItemStack(Items.quartz)});

            ThaumcraftApi.addInfusionCraftingRecipe("WARPAMULET", new ItemStack(WarpItems.itemAmulet), 10, new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 64), ItemApi.getItem("itemBaubleBlanks", 0),
                    new ItemStack[]{new ItemStack(WarpItems.itemCleanser), new ItemStack(Items.gold_ingot), new ItemStack(WarpItems.itemCleanser), new ItemStack(Items.gold_ingot)});

            for (ItemStack meat : meats)
                ThaumcraftApi.addCrucibleRecipe("WARPSOMETHING", new ItemStack(WarpItems.itemSomething), meat, new AspectList().add(Aspect.ELDRITCH, 8));
            ThaumcraftApi.addWarpToItem(new ItemStack(WarpItems.itemSomething), 1);

            ThaumcraftApi.addShapelessArcaneCraftingRecipe("WARPPAPER", new ItemStack(WarpItems.itemPaper), new AspectList().add(Aspect.WATER, 4),
                    new ItemStack(Items.paper), ItemApi.getItem("itemResource", 14));
        }
    }
}
