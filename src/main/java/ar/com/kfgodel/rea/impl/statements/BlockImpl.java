package ar.com.kfgodel.rea.impl.statements;

import ar.com.kfgodel.nary.api.Nary;
import ar.com.kfgodel.rea.api.statements.Block;
import ar.com.kfgodel.rea.api.statements.Statement;
import ar.com.kfgodel.rea.api.statements.StatementContext;
import ar.com.kfgodel.rea.impl.variables.ReturnStatementImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation
 * Created by kfgodel on 07/07/17.
 */
public class BlockImpl implements Block {

  private List<Statement> statements;

  public static BlockImpl create(Statement... statements) {
    BlockImpl bloque = create();
    Nary.create(statements)
      .forEach(bloque::add);
    return bloque;
  }


  public static BlockImpl create() {
    BlockImpl block = new BlockImpl();
    block.statements = new ArrayList<>();
    return block;
  }

  @Override
  public void executeOn(StatementContext context) {
    for (Statement statement : statements) {
      statement.executeOn(context);
      if(context.binding().hasValueFor(ReturnStatementImpl.RETURN_PSEUDO_VARIABLE)){
        break;
      }
    }
  }

  @Override
  public Nary<Statement> statements() {
    return Nary.create(statements);
  }

  @Override
  public Block add(Statement nextStatement) {
    statements.add(nextStatement);
    return this;
  }
}
