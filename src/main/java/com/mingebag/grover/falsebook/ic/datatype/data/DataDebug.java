package com.mingebag.grover.falsebook.ic.datatype.data;

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

public class DataDebug extends BaseDataChip {

    public DataDebug() {
        this.ICName = "Debug";
        this.ICNumber = "ic.data.debug";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Probe", "", "");
        this.chipState.setOutputs("", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Shows value.";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() != previousInputs.isInputOneHigh()) {
            BaseData data = this.getData(signBlock);

            if (data == null) {
                signBlock.setLine(1, currentInputs.isInputOneHigh() ? "true" : "false");
                signBlock.setLine(2, "");
                signBlock.setLine(3, "");
            } else if (data.getType() == DataTypes.NUMBER) {
                NumberData nData = (NumberData) data;
                signBlock.setLine(1, "n=" + nData.getInt());
                signBlock.setLine(2, "");
                signBlock.setLine(3, "");
            } else if (data.getType() == DataTypes.STRING) {
                StringData sData = (StringData) data;
                String str = "s=" + sData.getString();
                int len = str.length();

                signBlock.setLine(1, str.substring(0, len));
                if (len > 15) {
                	if (len > 30) {
                		signBlock.setLine(3, str.substring(30, len));
                	} else {
                		signBlock.setLine(2, str.substring(15, len));
                	}
                } else {
                    signBlock.setLine(2, "");
                    signBlock.setLine(3, "");
                }
            } else if (data.getType() == DataTypes.PLAYER) {
                PlayerData nData = (PlayerData) data;
                signBlock.setLine(1, "p=" + nData.getPlayer().getName());
                signBlock.setLine(2, "");
                signBlock.setLine(3, "");
            } else if (data.getType() == DataTypes.ITEM) {
                ItemData iData = (ItemData) data;
                signBlock.setLine(1, "item=" + iData.getItem().getType().toString());
                signBlock.setLine(2, "");
                signBlock.setLine(3, "");
            }

            signBlock.update(true);
        }
    }
}
