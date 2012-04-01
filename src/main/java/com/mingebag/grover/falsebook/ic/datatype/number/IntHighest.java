package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.NumberData;
import org.bukkit.block.Sign;

public class IntHighest extends BaseDataChip {

    public IntHighest() {
        this.ICName = "Highest";
        this.ICNumber = "ic.int.highest";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(false, true, true, "", "A", "B");
        this.chipState.setOutputs("Value", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Gets the highest value out of the left/right inputs.";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {

        if ((currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow()) || currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow()) {
            BaseData dataLeft = this.getDataLeft(signBlock);
            BaseData dataRight = this.getDataRight(signBlock);
            if (dataLeft == null || dataRight == null) {
                return;
            }

            if (dataLeft.getType() != DataTypes.NUMBER || dataRight.getType() != DataTypes.NUMBER) {
                return;
            }

            int left = ((NumberData) dataLeft).getInt();
            int right = ((NumberData) dataRight).getInt();

            if (left >= right) {
                this.outputData(new NumberData(left), signBlock, 2);
                return;
            }

            if (right > left) {
                this.outputData(new NumberData(right), signBlock, 2);
            }

        }
    }
}
