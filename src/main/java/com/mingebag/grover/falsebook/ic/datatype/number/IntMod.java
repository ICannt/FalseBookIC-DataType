package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.*;
import org.bukkit.block.Sign;

public class IntMod extends BaseDataChip {

    public IntMod() {
        this.ICName = "Mod";
        this.ICNumber = "ic.int.mod";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(false, true, true, "", "A", "B");
        this.chipState.setOutputs("Value", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Left mod Right.";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {

        if ((currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow())
                || currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow()) {
            BaseData dataA = this.getDataLeft(signBlock);
            BaseData dataB = this.getDataRight(signBlock);

            if (dataA != null && dataB != null
                    && dataA.getType() == DataTypes.NUMBER
                    && dataB.getType() == DataTypes.NUMBER) {
                int a = ((NumberData) dataA).getInt();
                int b = ((NumberData) dataB).getInt();

                try {
                    int c = a % b;
                    NumberData output = new NumberData(c);

                    this.outputData(output, signBlock, 2);
                } catch (Exception e) {
                    StringData output = new StringData("Bad number.");

                    this.outputData(output, signBlock, 2);
                }
            }
        }
    }
}
