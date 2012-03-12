package com.mingebag.grover.falsebook.ic.datatype.data;

import org.bukkit.block.Sign;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;


public class MC003D extends BaseDataChip {
	public MC003D() {
		this.ICName = "DATATYPE COMPARE";
		this.ICNumber = "[MC003D]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(false, true, true, "", "DataType", "DataType");
		this.chipState.setOutputs("", "DataType if true", "DataType if false");
		this.chipState.setLines("comparison", "if/else");
		this.ICDescription = "Compares left input to right input; if condition is true the left input is outputted";
	}

	
	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow() || currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow()) {
			BaseData input1 = this.getDataLeft(signBlock);
			BaseData input2 = this.getDataRight(signBlock);

			if(input1 == null || input2 == null) {
				return;
			}
			
			// Comparisons
			if(input1.compare(input2, signBlock.getLine(2))) {
					this.outputData(input1, signBlock, 2, 2);
			}
			
		}
	}
	

	
	
}
