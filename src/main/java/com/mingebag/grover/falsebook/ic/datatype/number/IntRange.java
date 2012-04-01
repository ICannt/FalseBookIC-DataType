package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.bukkit.gemo.utils.SignUtils;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.NumberData;
import org.bukkit.block.Sign;
import org.bukkit.event.block.SignChangeEvent;

public class IntRange extends BaseDataChip {

    public IntRange() {
        this.ICName = "Range";
        this.ICNumber = "ic.int.range";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "", "A", "B");
        this.chipState.setOutputs("Value", "", "");
        this.chipState.setLines("Range start", "Range end");
        this.ICDescription = "Outputs the input if in range.";
    }

    public void checkCreation(SignChangeEvent event) {
        try {
            Integer.parseInt(event.getLine(2));
            Integer.parseInt(event.getLine(3));
        } catch (Exception e) {
            SignUtils.cancelSignCreation(event, "Line 3 and 4 must be integers.");
        }
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {

        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = this.getData(signBlock);

            if (data == null) {
                return;
            }

            if (data.getType() != DataTypes.NUMBER) {
                return;
            }

            int value = ((NumberData) data).getInt();
            int start;
            int end;

            try {
                start = Integer.parseInt(signBlock.getLine(2));
                end = Integer.parseInt(signBlock.getLine(3));
            } catch (Exception e) {
                return;
            }

            if (value >= start && value <= end) {
                this.outputData(new NumberData(value), signBlock, 2);
            }

        }
    }
}
