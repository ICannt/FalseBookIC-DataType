package com.mingebag.grover.falsebook.ic;

import com.bukkit.gemo.FalseBook.IC.ICs.ExternalICPackage;
import com.mingebag.grover.falsebook.ic.datatype.data.*;
import com.mingebag.grover.falsebook.ic.datatype.number.*;
import com.mingebag.grover.falsebook.ic.datatype.string.*;
import com.mingebag.grover.falsebook.ic.datatype.player.*;
import com.mingebag.grover.falsebook.ic.datatype.item.*;

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
    addIC(MC011I.class);
    addIC(MC012I.class);
    
    // String IC's
    addIC(MC001S.class);
    addIC(MC002S.class);
    addIC(MC003S.class);
    addIC(MC300S.class);
    addIC(MC301S.class);
    
    // Player IC's
    addIC(MC001P.class);
    addIC(MC002P.class);
    addIC(MC003P.class);
    addIC(MC004P.class);
    addIC(MC005P.class);
    
    // Item IC's
    addIC(MC01IT.class);
    addIC(MC02IT.class);
    addIC(MC03IT.class);
    addIC(MC04IT.class);
    addIC(MC05IT.class);
  }
}