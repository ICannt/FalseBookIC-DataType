package com.mingebag.grover.falsebook.ic;

import com.bukkit.gemo.FalseBook.IC.ICs.ExternalICPackage;
import com.mingebag.grover.falsebook.ic.datatype.data.*;
import com.mingebag.grover.falsebook.ic.datatype.number.MC001I;
import com.mingebag.grover.falsebook.ic.datatype.number.MC002I;
import com.mingebag.grover.falsebook.ic.datatype.string.MC001S;
import com.mingebag.grover.falsebook.ic.datatype.string.MC300S;
import com.mingebag.grover.falsebook.ic.datatype.string.MC301S;

public class DataTypeICPackage extends ExternalICPackage
{
  public DataTypeICPackage()
  {
    setAPI_VERSION("1.1");
    setShowImportMessages(false);
    
    // DataType IC's
    addIC(MCDEBUG.class);
    
    addIC(MC000D.class);
    addIC(MC001D.class);
    addIC(MC002D.class);
    addIC(MC003D.class);
    
    // Number IC's
    addIC(MC001I.class);
    addIC(MC002I.class);
    
    // String IC's
    addIC(MC001S.class);
    addIC(MC300S.class);
    addIC(MC301S.class);
    
  }
}