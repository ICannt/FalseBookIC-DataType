package com.mingebag.grover.falsebook.ic.datatype.string;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.block.SignChangeEvent;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.bukkit.gemo.utils.SignUtils;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.StringData;

public class StringCast extends BaseDataChip {

    public StringCast() {
        this.ICName = "Colour String";
        this.ICNumber = "ic.s.colour";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Datatype", "", "");
        this.chipState.setOutputs("String", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "This takes a string and colours it";
    }
    
    public void checkCreation(SignChangeEvent event) {
    	if(ChatColor.valueOf(event.getLine(2)) == null) {
    		SignUtils.cancelSignCreation(event);
    	}
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
            BaseData data = getData(signBlock);
            
            ChatColor colour = ChatColor.valueOf(signBlock.getLine(2));
            if(colour == null)
            	return;
            			
            if (data.getType() != DataTypes.STRING)
                return;

            this.outputData(new StringData(colour + ((StringData) data).getString()), signBlock, 2);
        }
    }
}
