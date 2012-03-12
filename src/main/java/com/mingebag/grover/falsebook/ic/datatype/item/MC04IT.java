package com.mingebag.grover.falsebook.ic.datatype.item;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.ItemData;
import com.grover.mingebag.ic.NumberData;

public class MC04IT extends BaseDataChip {
	public MC04IT() {
		this.ICName = "ITEM AMOUNT";
		this.ICNumber = "[MC03IT]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Item", "", "");
		this.chipState.setOutputs("Int", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This pulses the item amount";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			BaseData data = getData(signBlock);
			if(data.getType() == DataTypes.ITEM) {
				ItemData item = (ItemData) data;
				this.outputData(new NumberData(item.getItem().getAmount()), signBlock, 2, 2);
			}
		}
	}
}