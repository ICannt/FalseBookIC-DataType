package com.mingebag.grover.falsebook.ic.datatype.player;

import org.bukkit.block.Sign;
import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.bukkit.gemo.FalseBook.IC.ICs.InputState;
import com.grover.mingebag.ic.BaseData;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.DataTypes;
import com.grover.mingebag.ic.PlayerData;
import com.grover.mingebag.ic.StringData;

public class MC002P extends BaseDataChip {
	public MC002P() {
		this.ICName = "PLAYER NAME";
		this.ICNumber = "[MC002P]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Player", "", "");
		this.chipState.setOutputs("String", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "This pulses the players name (String)";
	}


	public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
		if(currentInputs.isInputOneHigh() && previousInputs.isInputOneLow()) {
			BaseData data = getData(signBlock);
			if(data.getType() == DataTypes.PLAYER) {
				PlayerData player = (PlayerData) data;
				this.outputData(new StringData(player.getPlayer().getDisplayName()), signBlock, 2);
			}

		}
	}
}
