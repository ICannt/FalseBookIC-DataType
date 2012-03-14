package com.mingebag.grover.falsebook.ic.datatype.string;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.ItemData;
import com.grover.mingebag.ic.NumberData;
import com.grover.mingebag.ic.PlayerData;
import com.grover.mingebag.ic.StringData;

public class MC003S extends BaseDataChip {

    public MC003S() {
        this.ICName = "CAST STRING";
        this.ICNumber = "[MC003S]";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Datatype", "", "");
        this.chipState.setOutputs("String", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "This takes a datatype and attempts to cast it to a string";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = getData(signBlock);
            String out = null;

            if (data.getType() == DataTypes.NUMBER) {
                NumberData nData = (NumberData) data;
                out = Integer.toString(nData.getInt());
            }

            if (data.getType() == DataTypes.ITEM) {
                ItemData iData = (ItemData) data;
                out = iData.getItem().getType().name();
            }

            if (data.getType() == DataTypes.PLAYER) {
                PlayerData pData = (PlayerData) data;
                out = pData.getPlayer().getName();
            }

            if (out != null) {
                this.outputData(new StringData(out), signBlock, 2);
            }
        }
    }
}
