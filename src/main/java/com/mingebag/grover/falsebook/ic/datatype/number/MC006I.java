package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.NumberData;
import org.bukkit.block.Sign;

public class MC006I extends BaseDataChip {
    public MC006I() {
        this.ICName = "SUB";
        this.ICNumber = "[MC006I]";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(false, true, true, "", "A", "B");
        this.chipState.setOutputs("Value", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Left subtract Right.";
    }
    
    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        
        if((currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow()) || 
                currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow()) {
            BaseData dataA = this.getDataLeft(signBlock);
            BaseData dataB = this.getDataRight(signBlock);
            
            if(dataA != null && dataB != null &&
                    dataA.getType() == DataTypes.NUMBER &&
                    dataB.getType() == DataTypes.NUMBER) {
                int a = ((NumberData)dataA).getInt();
                int b = ((NumberData)dataB).getInt();
                
                int c = a - b;
                NumberData output = new NumberData(c);
                
                this.outputData(output, signBlock, 2);
            }
        }
    }
}
