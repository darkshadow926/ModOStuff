package darkshadow.mos;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import darkshadow.mos.block.BlockOstuff;
import darkshadow.mos.lib.Reference;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class ModOStuff {

	public final static Block Ostuff = 
			new BlockOstuff(254, Material.rock)
				.setHardness(1.5F)
				.setResistance(10.0F)
				.setLightValue(0.5F)
				.setCreativeTab(CreativeTabs.tabBlock)
				.setUnlocalizedName("Ostuff")
				.func_111022_d("mos:OStuff");
	
	// The instance of your mod that Forge uses.
	@Instance(Reference.MOD_ID)
	public static ModOStuff instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="darkshadow.mos.client.ClientProxy", serverSide="darkshadow.mos.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		// Basic Blocks
		LanguageRegistry.addName(Ostuff, "Block O'Stuff");
		MinecraftForge.setBlockHarvestLevel(Ostuff, "pickaxe", 1);
		GameRegistry.registerBlock(Ostuff, "Ostuff");
		// End Basic Blocks
		

		GameRegistry.registerWorldGenerator(new ModOStuffWorldGenerator());

		ItemStack leatherStack = new ItemStack(Item.leather);
		ItemStack ironStack = new ItemStack(Item.ingotIron);
		ItemStack goldStack = new ItemStack(Item.ingotGold);
		ItemStack diamondStack = new ItemStack(Item.diamond);
		ItemStack greyWoolStack = new ItemStack(Block.cloth, 64, 7);
		ItemStack brownWoolStack = new ItemStack(Block.cloth, 64, 12);
		ItemStack cyanWoolStack = new ItemStack(Block.cloth, 64, 9);

		GameRegistry.addRecipe(new ItemStack(Item.saddle), "xxx", "xyx", "y y",
                'x', leatherStack, 'y', ironStack);
		GameRegistry.addRecipe(new ItemStack(Item.field_111215_ce), "  x", "xyx", "xxx",
                'x', ironStack, 'y', greyWoolStack);
		GameRegistry.addRecipe(new ItemStack(Item.field_111216_cf), "  x", "xyx", "xxx",
                'x', goldStack, 'y', brownWoolStack);
		GameRegistry.addRecipe(new ItemStack(Item.field_111213_cg), "  x", "xyx", "xxx",
                'x', diamondStack, 'y', cyanWoolStack);
		
//		GameRegistry.addShapelessRecipe(brownWoolStack, new ItemStack(Block.dirt));
		
		proxy.registerRenderers();
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
	
}
