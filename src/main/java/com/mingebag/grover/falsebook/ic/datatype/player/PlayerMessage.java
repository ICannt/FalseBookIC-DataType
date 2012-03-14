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

public class PlayerMessage extends BaseDataChip {

    public PlayerMessage() {
        this.ICName = "Player Message";
        this.ICNumber = "ic.player.message";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, true, true, "player/string", "player/string", "player/string");
        this.chipState.setOutputs("", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "This sends a message to the player. Order of inputs do not matter aslong as a player and string is provided.";
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if ((currentInputs.isInputOneHigh() && previousInputs.isInputOneLow() || currentInputs.isInputTwoHigh() && previousInputs.isInputTwoLow() || currentInputs.isInputThreeHigh() && previousInputs.isInputThreeLow())) {
            BaseData base = getData(signBlock);
            BaseData baseLeft = getDataLeft(signBlock);
            BaseData baseRight = getDataRight(signBlock);
            PlayerData player = null;
            StringData message = null;

            if (base != null) {
                if (base.getType() == DataTypes.PLAYER) {
                    player = (PlayerData) base;
                }
                if (base.getType() == DataTypes.STRING) {
                    message = (StringData) base;
                }
            }

            if (baseLeft != null) {
                if (baseLeft.getType() == DataTypes.PLAYER) {
                    player = (PlayerData) baseLeft;
                }
                if (baseLeft.getType() == DataTypes.STRING) {
                    message = (StringData) baseLeft;
                }
            }

            if (baseRight != null) {
                if (baseRight.getType() == DataTypes.PLAYER) {
                    player = (PlayerData) baseRight;
                }
                if (baseRight.getType() == DataTypes.STRING) {
                    message = (StringData) baseRight;
                }
            }

            if (player == null || message == null) {
                return;
            }

            if (player.getPlayer() != null && message.getString().length() > 0) {
                player.getPlayer().sendMessage(message.getString());
            }

        }
    }
}
