package com.mingebag.grover.falsebook.ic.datatype.player;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import com.bukkit.gemo.FalseBook.IC.ICs.BaseChip;
import com.bukkit.gemo.FalseBook.IC.ICs.ICGroup;
import com.grover.mingebag.ic.BaseDataChip;
import com.grover.mingebag.ic.PlayerData;

public class MC001P extends BaseDataChip {
	
	public MC001P() {
		this.ICName = "RIGHT CLICK";
		this.ICNumber = "[MC001P]";
		setICGroup(ICGroup.CUSTOM_0);
		this.chipState = new BaseChip(true, false, false, "Clock", "", "");
		this.chipState.setOutputs("Player", "", "");
		this.chipState.setLines("", "");
		this.ICDescription = "Gets the player who right clicked on the IC";
	}

	public void onRightClick(Player player, Sign signBlock) {
		this.outputData(new PlayerData(player), signBlock, 2, 2);
	}

}
