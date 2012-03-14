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
        addIC(DataDelay.class);
        addIC(DataPulse.class);
        addIC(DataRepeat.class);


        // Number IC's
        addIC(IntOut.class);
        addIC(IntBinaryOr.class);
        addIC(IntBinaryAnd.class);
        addIC(IntBinaryXOR.class);
        addIC(IntAdd.class);
        addIC(IntSub.class);
        addIC(IntMultiply.class);
        addIC(IntDivide.class);
        addIC(IntMod.class);
        addIC(IntCast.class);
        addIC(IntRandom.class);
        addIC(IntSign.class);

        // String IC's
        addIC(MC001S.class);
        addIC(MC002S.class);
        addIC(MC003S.class);
        addIC(MC300S.class);
        addIC(MC301S.class);

        // Player IC's
        addIC(PlayerRightClick.class);
        addIC(PlayerName.class);
        addIC(PlayerHand.class);
        addIC(PlayerMessage.class);
        addIC(PlayerValueInt.class);

        // Item IC's
        addIC(ItemID.class);
        addIC(ItemName.class);
        addIC(ItemDurability.class);
        addIC(ItemAmount.class);
        addIC(ItemBlockSensor.class);
    }
}