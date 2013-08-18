package darkshadow.mos.block;


import java.util.Random;

import darkshadow.mos.ModOStuff;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.block.material.Material;


public class BlockOstuff extends Block {

	public BlockOstuff (int id, Material material) {
		super(id, material);
	}
	
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon("mos:OStuff");
	}
	
	public int idDropped(int par1, Random random, int par2) {
		return ModOStuff.Ostuff.blockID;      
	}


}

