package com.mingebag.grover.falsebook.ic.datatype.data;

import org.bukkit.block.Sign;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.bukkit.gemo.FalseBook.IC.ICs.Lever;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;

public class MC001D extends BaseDataChip {
	public MC001D() {
		this.ICName = "DATATYPE TOGGLE";
		this.ICNumber = "[MC001D]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "DataType", "", "");
		this.chipState.setOutputs("Input Data", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This keep the datatype active until a new one arrives.";
	}


	
	public void Execute(final Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			this.switchLever(Lever.BACK, signBlock, false);
			if(this.getData(signBlock) == null) {
				return;
			}
			final BaseData data = getData(signBlock);
			this.core.getServer().getScheduler().scheduleSyncDelayedTask(this.core, new Runnable() {
			    public void run() {
			    	outputData(data, signBlock, 2, 0);
			    }
			}, 2);
			
		}
	}
}
