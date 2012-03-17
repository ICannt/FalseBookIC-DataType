package com.mingebag.grover.falsebook.ic;

import com.bukkit.gemo.FalseBook.IC.ICs.ExternalICPackage;
import com.mingebag.grover.falsebook.ic.datatype.data.*;
import com.mingebag.grover.falsebook.ic.datatype.number.*;
import com.mingebag.grover.falsebook.ic.datatype.string.*;
import com.mingebag.grover.falsebook.ic.datatype.player.*;
import com.mingebag.grover.falsebook.ic.datatype.item.*;

public class DataTypeICPackage extends ExternalICPackage {

    public DataTypeICPackage() {
        setAPI_VERSION("1.1");
        setShowImportMessages(false);

        // DataType IC's
        addIC(DataCompare.class);
        addIC(DataDebug.class);
        addIC(DataDebugMsg.class);
        addIC(DataDelay.class);
        addIC(DataPulse.class);
        addIC(DataRepeat.class);


        // Number IC's
        addIC(IntAdd.class);
        addIC(IntBinaryAnd.class);
        addIC(IntBinaryOr.class);
        addIC(IntBinaryXOR.class);
        addIC(IntCast.class);
        addIC(IntDivide.class);
        addIC(IntMod.class);
        addIC(IntMultiply.class);
        addIC(IntOut.class);
        addIC(IntRandom.class);
        addIC(IntSign.class);
        addIC(IntSub.class);


        // String IC's
        addIC(StringCast.class);
        addIC(StringColour.class);
        addIC(StringCombine.class);
        addIC(StringNote.class);
        addIC(StringOut.class);
        addIC(StringSub.class);
        addIC(StringSwitch.class);


        // Player IC's
        addIC(PlayerHand.class);
        addIC(PlayerMessage.class);
        addIC(PlayerName.class);
        addIC(PlayerRightClick.class);
        addIC(PlayerValueInt.class);

        // Item IC's
        addIC(ItemAmount.class);
        addIC(ItemBlockSensor.class);
        addIC(ItemDurability.class);
        addIC(ItemID.class);
        addIC(ItemName.class);

    }
}