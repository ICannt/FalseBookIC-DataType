package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.*;
import org.bukkit.block.Sign;

public class IntSign extends BaseDataChip {

    public IntSign() {
        this.ICName = "Int Sign";
        this.ICNumber = "ic.int.sign";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Other", "", "");
        this.chipState.setOutputs("Int", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Outputs the sign of the input number. -1 or 1.";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {

        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = this.getData(signBlock);

            if (data == null) {
                return;
            }

            if (data.getType() == DataTypes.NUMBER) {
                int sign = 1;
                if (((NumberData) data).getInt() < 0) {
                    sign = -1;
                }
                outputData(new NumberData(sign), signBlock, 2);
            }
        }
    }
}
