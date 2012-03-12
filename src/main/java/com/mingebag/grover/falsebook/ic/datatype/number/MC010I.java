package com.mingebag.grover.falsebook.ic.datatype.number;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.*;
import org.bukkit.block.Sign;

public class MC010I extends BaseDataChip {
    public MC010I() {
        this.ICName = "CAST";
        this.ICNumber = "[MC010I]";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(false, true, true, "Other", "", "");
        this.chipState.setOutputs("Value", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Tries to cast to Int.";
    }
    
    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        
        if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = this.getData(signBlock);
            
            NumberData output = null;
            if(data != null) {
                try {
                    if(data.getType() == DataTypes.NUMBER) {
                        output = new NumberData(((NumberData)data).getInt());
                    }
                    else if(data.getType() == DataTypes.STRING) {
                        String str = ((StringData)data).getString();
                        output = new NumberData(Integer.parseInt(str));
                    }
                    else if(data.getType() == DataTypes.PLAYER) {
                        PlayerData pData = (PlayerData)data;
                        output = new NumberData(pData.getPlayer().getEntityId());
                    }
                    else if(data.getType() == DataTypes.ITEM) {
                        ItemData iData = (ItemData)data;
                        output = new NumberData(iData.getItem().getTypeId());
                    }
                }
                catch (Exception e) {
                    output = new NumberData(1);
                }
            }
            else {
                output = new NumberData(1);
            }
            this.outputData(output, signBlock, 2);
        }
    }
}
