package com.mingebag.grover.falsebook.ic.datatype.player;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.ItemData;
import com.grover.mingebag.ic.PlayerData;

public class MC003P extends BaseDataChip {
	public MC003P() {
		this.ICName = "PLAYER ITEM IN HAND";
		this.ICName = "PLAYER MESSAGE";
		this.ICNumber = "[MC003P]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Player", "", "");
		this.chipState.setOutputs("Item", "", "");
		this.chipState = new BaseChip(false, true, true, "", "player", "string");
		this.chipState.setOutputs("", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This pulses the item the player has in his hand";
		this.ICDescription = "This sends a message to the player";
	}

		 

		 

	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			BaseData data = getData(signBlock);
			if(data.getType() == DataTypes.PLAYER) {
			PlayerData player = (PlayerData) data;
			this.outputData(new ItemData(player.getPlayer().getItemInHand()), signBlock, 2);
			}
		}
	}
		
}
