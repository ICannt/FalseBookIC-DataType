package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.NumberData;
import com.grover.mingebag.ic.StringData;
import org.bukkit.block.Sign;

public class MC001I extends BaseDataChip {
    public MC001I() {
        this.ICName = "INT OUTPUT";
        this.ICNumber = "[MC001I]";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Clock", "", "");
        this.chipState.setOutputs("String", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "This pulses an int when clocked.";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            
            int value = 0;
            try {
                value = Integer.parseInt(signBlock.getLine(2));
            }
            catch(Exception e) {
            }
            
            NumberData data = new NumberData(value);
            this.outputData(data, signBlock, 2, 2);
        }
    }
}
