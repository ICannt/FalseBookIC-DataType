package com.mingebag.grover.falsebook.ic.datatype.string;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.StringData;

public class MC002S extends BaseDataChip {
	public MC002S() {
		this.ICName = "STRING COMBINE";
		this.ICNumber = "[MC002S]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(false, true, true, "String", "String", "String");
		this.chipState.setOutputs("String", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This combines strings from left to right.";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		String input1 = null;
		String input2 = null;
		BaseData dataLeft = getDataLeft(signBlock);
		BaseData dataRight = getDataRight(signBlock);
		String out = null;
		
		if(currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow() && dataLeft != null)
			if(dataLeft.getType() == DataTypes.STRING)
				input1 = ((StringData) dataLeft).getString();
		
		if(currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow() && dataRight != null)
			if(dataRight.getType() == DataTypes.STRING)
				input2 = ((StringData) dataRight).getString();
		
		if(input1 != null && input2 != null) {
			out = input1 + input2;
		} else {
			return;
		}
		
		this.outputData(new StringData(out), signBlock, 2);
	}
}
