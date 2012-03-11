package com.mingebag.grover.falsebook.ic.datatype.data;

import org.bukkit.block.Sign;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseDataChip;

public class MC002D extends BaseDataChip {
	public MC002D() {
		this.ICName = "DATATYPE PULSER";
		this.ICNumber = "[MC002D]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "DataType", "", "");
		this.chipState.setOutputs("Input Data", "", "");
		this.chipState.setLines("delay", "");
		this.ICDescription = "This pulses the datatype";
	}


	
	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			if(this.getData(signBlock) == null) {
				return;
			}
			int pulse = 20;
			if(!signBlock.getLine(2).equals("")) {
				try {
					pulse = Integer.parseInt(signBlock.getLine(2));
				} catch (Exception e) {
				}
			}
			this.outputData(this.getData(signBlock), this.getData(signBlock).getType(), signBlock, 2, pulse);
		}
	}
}
