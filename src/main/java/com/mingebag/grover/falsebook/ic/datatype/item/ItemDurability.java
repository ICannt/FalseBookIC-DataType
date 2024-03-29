package com.mingebag.grover.falsebook.ic.datatype.item;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.ItemData;
import com.grover.mingebag.ic.NumberData;

public class ItemDurability extends BaseDataChip {

    public ItemDurability() {
        this.ICName = "Item Durability";
        this.ICNumber = "ic.item.durab";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Item", "", "");
        this.chipState.setOutputs("Int", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "This pulses the item durability";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = getData(signBlock);
            if (data.getType() == DataTypes.ITEM) {
                ItemData item = (ItemData) data;

                if (item.getItem() == null) {
                    return;
                }

                this.outputData(new NumberData(item.getItem().getDurability()), signBlock, 2);
            }
        }
    }
}
