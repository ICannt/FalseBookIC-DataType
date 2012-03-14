package com.mingebag.grover.falsebook.ic.datatype.number;

import java.util.Random;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.*;
import org.bukkit.block.Sign;

public class MC011I extends BaseDataChip {

    public MC011I() {
        this.ICName = "RANDOM";
        this.ICNumber = "[MC011I]";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Other", "", "");
        this.chipState.setOutputs("Int", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Generates a random number between 0 and the input";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {

        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = this.getData(signBlock);

            if (data == null) {
                return;
            }

            if (data.getType() == DataTypes.NUMBER) {
                int rand = new Random().nextInt(((NumberData) data).getInt());
                outputData(new NumberData(rand), signBlock, 2);
            }
        }
    }
}
