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
		this.chipState = new BaseChip(true, true, true, "String", "String", "String");
		this.chipState.setOutputs("String", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This combines strings from left to right.";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if((currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) || (currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow()) || (currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow())) {
			BaseData dataLeft = getDataLeft(signBlock);
			BaseData dataMiddle = getData(signBlock);
			BaseData dataRight = getDataRight(signBlock);
			String out = "";
			
			if(dataRight != null)
				if(dataRight.getType() == DataTypes.STRING)
					out += ((StringData) dataRight).getString();
			
			if(dataMiddle != null)
				if(dataMiddle.getType() == DataTypes.STRING)
					out += ((StringData) dataMiddle).getString();
			
			if(dataLeft != null)
				if(dataLeft.getType() == DataTypes.STRING)
					out += ((StringData) dataLeft).getString();
			
			this.outputData(new StringData(out), signBlock, 2, 2);
		}
	}
}
