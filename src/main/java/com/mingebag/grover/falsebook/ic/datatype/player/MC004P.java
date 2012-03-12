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
import com.grover.mingebag.ic.StringData;

public class MC004P extends BaseDataChip {
	public MC004P() {
		this.ICName = "PLAYER MESSAGE";
		this.ICNumber = "[MC004P]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(false, true, true, "", "player", "string");
		this.chipState.setOutputs("", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This sends a message to the player";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if((currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow() || currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow())) {
			BaseData basePlayer = getDataLeft(signBlock);
			BaseData baseString = getDataRight(signBlock);
			
			if(basePlayer == null || baseString == null)
				return;
			
			if(basePlayer.getType() != DataTypes.PLAYER || baseString.getType() != DataTypes.STRING)
				return;
			
			PlayerData player = (PlayerData) basePlayer;
			StringData string = (StringData) baseString;
			
			if(player.getPlayer() != null && string.getString().length() > 0) {
				player.getPlayer().sendMessage(string.getString());
			}

		}
	}
}
