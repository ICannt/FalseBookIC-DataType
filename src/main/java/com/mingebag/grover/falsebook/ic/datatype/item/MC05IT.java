package com.mingebag.grover.falsebook.ic.datatype.item;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.bukkit.gemo.utils.SignUtils;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.ItemData;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.inventory.ItemStack;

public class MC05IT extends BaseDataChip {
	public MC05IT() {
		this.ICName = "BLOCK SENSOR";
		this.ICNumber = "[MC05IT]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Clock", "", "");
		this.chipState.setOutputs("Item", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "Checks item at x,y,z offset.";
	}
    
    public void checkCreation(SignChangeEvent event) {
        String line = event.getLine(3);
        
        String[] numbers = line.split(",");
        
        if(numbers.length > 3) {
            SignUtils.cancelSignCreation(event, "Must be upto 3 numbers in the format: x,y,z");
        }
        
        try {
            int x = 0, y = 0, z = 0;
            if(numbers.length >= 1)
                x = Integer.parseInt(numbers[0]);
            if(numbers.length >= 2)
                y = Integer.parseInt(numbers[1]);
            if(numbers.length == 3)
                z = Integer.parseInt(numbers[2]);
            
            if(Math.abs(x) > 16 ||
               Math.abs(y) > 16 ||
               Math.abs(z) > 16) {
                SignUtils.cancelSignCreation(event, "x,y and z cannont be larger than +/-16");
            }
            
            event.setLine(2, String.format("%1$d,%2$d,%3$d", x, y, z));
        }
        catch(Exception e) {
            SignUtils.cancelSignCreation(event, "Must be upto 3 numbers in the format: x,y,z");
        }
    }

	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			String[] numbers = signBlock.getLine(0).split(",");
            
            int x = 0, y = 0, z = 0;
            if(numbers.length >= 1)
                x = Integer.parseInt(numbers[0]);
            if(numbers.length >= 2)
                y = Integer.parseInt(numbers[1]);
            if(numbers.length >= 3)
                z = Integer.parseInt(numbers[2]);
            
            Location probe = getICBlock(signBlock);
            probe = probe.add(x, y, z);
            
            Block block = probe.getBlock();
            Iterator<ItemStack> stack = block.getDrops().iterator();
            
            if(stack.hasNext()) {
                ItemData data = new ItemData(stack.next());
                this.outputData(data, signBlock, 2);
            }
		}
	}
}
