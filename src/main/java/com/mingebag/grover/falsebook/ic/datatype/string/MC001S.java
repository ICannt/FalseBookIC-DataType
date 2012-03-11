package com.mingebag.grover.falsebook.ic.datatype.string;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.StringData;

public class MC001S extends BaseDataChip {
	public MC001S() {
		this.ICName = "STRING OUTPUT";
		this.ICNumber = "[MC001S]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Clock", "", "");
		this.chipState.setOutputs("String", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This pulses a string when clocked.";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			StringData data = new StringData(signBlock.getLine(2) + signBlock.getLine(3));
			this.outputData(data, data.getType(), signBlock, 2, 2);
		}
	}
}
