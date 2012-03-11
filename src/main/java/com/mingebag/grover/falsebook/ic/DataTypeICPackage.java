package com.mingebag.grover.falsebook.ic;

import com.bukkit.gemo.FalseBook.IC.ICs.ExternalICPackage;
import com.mingebag.grover.falsebook.ic.datatype.data.*;
import com.mingebag.grover.falsebook.ic.datatype.number.*;
import com.mingebag.grover.falsebook.ic.datatype.string.*;

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
    addIC(MC003I.class);
    addIC(MC004I.class);
    addIC(MC005I.class);
    addIC(MC006I.class);
    addIC(MC007I.class);
    addIC(MC008I.class);
    addIC(MC009I.class);
    addIC(MC010I.class);
    
    // String IC's
    addIC(MC001S.class);
    addIC(MC300S.class);
    addIC(MC301S.class);
    
  }
}