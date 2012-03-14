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
        this.chipState.setLines("", "");
        this.ICDescription = "This pulses the datatype";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {

            if (this.getData(signBlock) == null) {
                return;
            }

            this.outputData(this.getData(signBlock), signBlock, 2);
        }
    }
}
