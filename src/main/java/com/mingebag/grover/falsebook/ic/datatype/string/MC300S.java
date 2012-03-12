package com.mingebag.grover.falsebook.ic.datatype.string;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.*;

public class MC300S extends BaseDataChip {
    public MC300S() {
        this.ICName = "SUB STRING";
        this.ICNumber = "[MC300S]";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, true, true, "String", "Index", "Count");
        this.chipState.setOutputs("String", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "This pulses a substring when clocked.";
    }
    
    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        boolean hasChanged = previousInputs.isInputOneLow() && currentInputs.isInputOneHigh();
        hasChanged = hasChanged || (previousInputs.isInputTwoLow() && currentInputs.isInputTwoHigh());
        hasChanged = hasChanged || (previousInputs.isInputThreeLow() && currentInputs.isInputThreeHigh());
        
        if(hasChanged) {
            
            BaseData baseCenter = this.getData(signBlock);
            BaseData baseLeft = this.getDataLeft(signBlock);
            BaseData baseRight = this.getDataRight(signBlock);
            
            // Check types.
            if(baseCenter != null && baseCenter.getType() == DataTypes.STRING &&
                baseLeft != null && baseLeft.getType() == DataTypes.NUMBER &&
                baseRight != null && baseRight.getType() == DataTypes.NUMBER) {
                
                StringData center = (StringData)baseCenter;
                NumberData left = (NumberData)baseLeft;
                NumberData right = (NumberData)baseRight;
                
                String str = center.getString();
                
                // Sanity checks
                if(str == null || str.length() == 0)
                    return;
                
                int offset = left.getInt();
                if(offset < 0)
                    offset = 0;
                
                int strLen = str.length();
                if(offset > strLen)
                    offset = strLen;
                
                int count = right.getInt();
                if(count < 0)
                    count = 0;
                
                int end = offset + count;
                if(end > strLen)
                    end = strLen;
                
                // Substr
                str = str.substring(offset, end);
                
                StringData data = new StringData(str);
                this.outputData(data, signBlock, 2, 2);
            }
        }
    }
}
