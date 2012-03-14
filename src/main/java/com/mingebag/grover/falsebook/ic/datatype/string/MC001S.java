package com.mingebag.grover.falsebook.ic.datatype.string;

import java.util.ArrayList;

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
        this.setICSignDepth((byte) 5);
    }

    public void Execute(ArrayList<Sign> signBlocks, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            Sign ic = signBlocks.get(0);
            signBlocks.remove(0);
            String string = ic.getLine(3);

            for (int i = 0; i < signBlocks.size(); i++) {
                Sign sign = signBlocks.get(i);
                string += sign.getLine(0);
                string += sign.getLine(1);
                string += sign.getLine(2);
                string += sign.getLine(3);
            }

            StringData data = new StringData(string);
            this.outputData(data, ic, 2);
        }
    }
}
