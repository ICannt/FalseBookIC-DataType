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
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class DataDebugMsg extends BaseDataChip {

    public DataDebugMsg() {
        this.ICName = "Debug";
        this.ICNumber = "ic.data.debugm";
        setICGroup(ICGroup.CUSTOM_0);
        this.chipState = new BaseChip(true, false, false, "Probe", "", "");
        this.chipState.setOutputs("", "", "");
        this.chipState.setLines("", "");
        this.ICDescription = "Shows value.";
    }

    public void checkCreation(SignChangeEvent event) {
        event.setLine(2, event.getPlayer().getName());
        event.setLine(3, "");
    }

    public void Execute(Sign signBlock, InputState currentInputs, InputState previousInputs) {
        if (currentInputs.isInputOneHigh() != previousInputs.isInputOneHigh()) {
            BaseData data = this.getData(signBlock);

            List<Player> players = signBlock.getWorld().getPlayers();
            Player player = null;
            for (Player p : players) {
                if (p.getName().compareToIgnoreCase(signBlock.getLine(2)) == 0) {
                    player = p;
                }
            }

            if (player == null) {
                return;
            }

            if (data == null) {
                player.sendMessage(ChatColor.GOLD
                        + signBlock.getLine(1)
                        + ": b "
                        + (currentInputs.isInputOneHigh() ? "true" : "false"));
            } else if (data.getType() == DataTypes.NUMBER) {
                NumberData nData = (NumberData) data;
                player.sendMessage(ChatColor.GOLD
                        + signBlock.getLine(1)
                        + ": n "
                        + nData.getInt());
            } else if (data.getType() == DataTypes.STRING) {
                StringData sData = (StringData) data;
                player.sendMessage(ChatColor.GOLD
                        + signBlock.getLine(1)
                        + ": s "
                        + sData.getString());
            } else if (data.getType() == DataTypes.PLAYER) {
                PlayerData nData = (PlayerData) data;
                player.sendMessage(ChatColor.GOLD
                        + signBlock.getLine(1)
                        + ": p "
                        + nData.getPlayer().getName());
            } else if (data.getType() == DataTypes.ITEM) {
                ItemData iData = (ItemData) data;
                player.sendMessage(ChatColor.GOLD
                        + signBlock.getLine(1)
                        + ": i "
                        + iData.getItem().getType().toString());
            }
        }
    }
}
