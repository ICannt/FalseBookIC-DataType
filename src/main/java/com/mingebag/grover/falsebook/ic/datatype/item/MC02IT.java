package com.mingebag.grover.falsebook.ic.datatype.item;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.ItemData;
import com.grover.mingebag.ic.StringData;

public class MC02IT extends BaseDataChip {
	public MC02IT() {
		this.ICName = "ITEM NAME";
		this.ICNumber = "[MC02IT]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Item", "", "");
		this.chipState.setOutputs("String", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This pulses the item name";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			BaseData data = getData(signBlock);
			if(data.getType() == DataTypes.ITEM) {
				ItemData item = (ItemData) data;
				
				if(item.getItem() == null)
					return;
				
				this.outputData(new StringData(item.getItem().getType().name()), signBlock, 2);
			}
		}
	}
}
