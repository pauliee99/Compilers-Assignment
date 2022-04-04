
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Apr 04 18:14:54 EEST 2022
//----------------------------------------------------

import java_cup.runtime.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Apr 04 18:14:54 EEST 2022
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\002\004\000\002\005\002\000\002\005" +
    "\003\000\002\004\003\000\002\004\004\000\002\003\007" +
    "\000\002\003\006\000\002\003\003\000\002\003\011\000" +
    "\002\003\007\000\002\006\004\000\002\006\005\000\002" +
    "\002\003\000\002\002\003\000\002\002\003\000\002\002" +
    "\003\000\002\002\005\000\002\002\005\000\002\002\005" +
    "\000\002\002\005\000\002\002\005\000\002\002\005\000" +
    "\002\002\005\000\002\002\005\000\002\002\005\000\002" +
    "\002\005\000\002\002\005\000\002\002\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\075\000\016\002\000\004\011\005\010\006\013\007" +
    "\004\037\012\001\002\000\004\017\074\001\002\000\016" +
    "\002\uffff\004\011\005\010\006\013\007\004\037\012\001" +
    "\002\000\020\002\ufffe\004\ufffe\005\ufffe\006\ufffe\007\ufffe" +
    "\037\ufffe\040\ufffe\001\002\000\020\002\ufffa\004\ufffa\005" +
    "\ufffa\006\ufffa\007\ufffa\037\ufffa\040\ufffa\001\002\000\004" +
    "\017\070\001\002\000\004\022\065\001\002\000\016\004" +
    "\011\005\010\006\013\007\004\037\012\040\062\001\002" +
    "\000\014\004\011\005\010\006\013\007\004\037\012\001" +
    "\002\000\004\002\015\001\002\000\004\002\001\001\002" +
    "\000\004\007\017\001\002\000\004\017\020\001\002\000" +
    "\016\004\024\017\026\027\025\050\021\051\022\052\027" +
    "\001\002\000\032\020\ufff5\021\ufff5\023\ufff5\024\ufff5\026" +
    "\ufff5\027\ufff5\031\ufff5\032\ufff5\033\ufff5\034\ufff5\035\ufff5" +
    "\036\ufff5\001\002\000\032\020\ufff4\021\ufff4\023\ufff4\024" +
    "\ufff4\026\ufff4\027\ufff4\031\ufff4\032\ufff4\033\ufff4\034\ufff4" +
    "\035\ufff4\036\ufff4\001\002\000\030\020\057\023\042\024" +
    "\040\026\035\027\031\031\043\032\037\033\036\034\033" +
    "\035\032\036\034\001\002\000\032\020\ufff2\021\ufff2\023" +
    "\ufff2\024\ufff2\026\ufff2\027\ufff2\031\ufff2\032\ufff2\033\ufff2" +
    "\034\ufff2\035\ufff2\036\ufff2\001\002\000\016\004\024\017" +
    "\026\027\025\050\021\051\022\052\027\001\002\000\016" +
    "\004\024\017\026\027\025\050\021\051\022\052\027\001" +
    "\002\000\032\020\ufff3\021\ufff3\023\ufff3\024\ufff3\026\ufff3" +
    "\027\ufff3\031\ufff3\032\ufff3\033\ufff3\034\ufff3\035\ufff3\036" +
    "\ufff3\001\002\000\030\020\041\023\042\024\040\026\035" +
    "\027\031\031\043\032\037\033\036\034\033\035\032\036" +
    "\034\001\002\000\016\004\024\017\026\027\025\050\021" +
    "\051\022\052\027\001\002\000\016\004\024\017\026\027" +
    "\025\050\021\051\022\052\027\001\002\000\016\004\024" +
    "\017\026\027\025\050\021\051\022\052\027\001\002\000" +
    "\016\004\024\017\026\027\025\050\021\051\022\052\027" +
    "\001\002\000\016\004\024\017\026\027\025\050\021\051" +
    "\022\052\027\001\002\000\016\004\024\017\026\027\025" +
    "\050\021\051\022\052\027\001\002\000\016\004\024\017" +
    "\026\027\025\050\021\051\022\052\027\001\002\000\016" +
    "\004\024\017\026\027\025\050\021\051\022\052\027\001" +
    "\002\000\032\020\ufff1\021\ufff1\023\ufff1\024\ufff1\026\ufff1" +
    "\027\ufff1\031\ufff1\032\ufff1\033\ufff1\034\ufff1\035\ufff1\036" +
    "\ufff1\001\002\000\016\004\024\017\026\027\025\050\021" +
    "\051\022\052\027\001\002\000\016\004\024\017\026\027" +
    "\025\050\021\051\022\052\027\001\002\000\032\020\uffec" +
    "\021\uffec\023\042\024\040\026\035\027\031\031\uffec\032" +
    "\uffec\033\uffec\034\uffec\035\uffec\036\uffec\001\002\000\032" +
    "\020\uffee\021\uffee\023\uffee\024\uffee\026\uffee\027\uffee\031" +
    "\uffee\032\uffee\033\uffee\034\uffee\035\uffee\036\uffee\001\002" +
    "\000\032\020\uffed\021\uffed\023\uffed\024\uffed\026\uffed\027" +
    "\uffed\031\uffed\032\uffed\033\uffed\034\uffed\035\uffed\036\uffed" +
    "\001\002\000\032\020\uffeb\021\uffeb\023\042\024\040\026" +
    "\035\027\031\031\uffeb\032\uffeb\033\uffeb\034\uffeb\035\uffeb" +
    "\036\uffeb\001\002\000\032\020\uffea\021\uffea\023\042\024" +
    "\040\026\035\027\031\031\uffea\032\uffea\033\uffea\034\uffea" +
    "\035\uffea\036\uffea\001\002\000\032\020\ufff0\021\ufff0\023" +
    "\042\024\040\026\ufff0\027\ufff0\031\ufff0\032\ufff0\033\ufff0" +
    "\034\ufff0\035\ufff0\036\ufff0\001\002\000\032\020\uffe7\021" +
    "\uffe7\023\042\024\040\026\035\027\031\031\043\032\037" +
    "\033\036\034\033\035\uffe7\036\uffe7\001\002\000\032\020" +
    "\uffe9\021\uffe9\023\042\024\040\026\035\027\031\031\uffe9" +
    "\032\uffe9\033\uffe9\034\uffe9\035\uffe9\036\uffe9\001\002\000" +
    "\032\020\uffe8\021\uffe8\023\042\024\040\026\035\027\031" +
    "\031\043\032\037\033\036\034\033\035\uffe8\036\uffe8\001" +
    "\002\000\032\020\uffef\021\uffef\023\042\024\040\026\uffef" +
    "\027\uffef\031\uffef\032\uffef\033\uffef\034\uffef\035\uffef\036" +
    "\uffef\001\002\000\032\020\uffe6\021\uffe6\023\uffe6\024\uffe6" +
    "\026\uffe6\027\uffe6\031\uffe6\032\uffe6\033\uffe6\034\uffe6\035" +
    "\uffe6\036\uffe6\001\002\000\004\021\060\001\002\000\020" +
    "\002\ufff9\004\ufff9\005\ufff9\006\ufff9\007\ufff9\037\ufff9\040" +
    "\ufff9\001\002\000\016\004\011\005\010\006\013\007\004" +
    "\037\012\040\064\001\002\000\020\002\ufff7\004\ufff7\005" +
    "\ufff7\006\ufff7\007\ufff7\037\ufff7\040\ufff7\001\002\000\020" +
    "\002\ufffd\004\ufffd\005\ufffd\006\ufffd\007\ufffd\037\ufffd\040" +
    "\ufffd\001\002\000\020\002\ufff6\004\ufff6\005\ufff6\006\ufff6" +
    "\007\ufff6\037\ufff6\040\ufff6\001\002\000\016\004\024\017" +
    "\026\027\025\050\021\051\022\052\027\001\002\000\030" +
    "\021\067\023\042\024\040\026\035\027\031\031\043\032" +
    "\037\033\036\034\033\035\032\036\034\001\002\000\020" +
    "\002\ufffb\004\ufffb\005\ufffb\006\ufffb\007\ufffb\037\ufffb\040" +
    "\ufffb\001\002\000\016\004\024\017\026\027\025\050\021" +
    "\051\022\052\027\001\002\000\030\020\072\023\042\024" +
    "\040\026\035\027\031\031\043\032\037\033\036\034\033" +
    "\035\032\036\034\001\002\000\004\021\073\001\002\000" +
    "\020\002\ufffc\004\ufffc\005\ufffc\006\ufffc\007\ufffc\037\ufffc" +
    "\040\ufffc\001\002\000\016\004\024\017\026\027\025\050" +
    "\021\051\022\052\027\001\002\000\030\020\076\023\042" +
    "\024\040\026\035\027\031\031\043\032\037\033\036\034" +
    "\033\035\032\036\034\001\002\000\014\004\011\005\010" +
    "\006\013\007\004\037\012\001\002\000\020\002\ufff8\004" +
    "\ufff8\005\ufff8\006\ufff8\007\ufff8\037\ufff8\040\ufff8\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\075\000\012\003\005\004\004\005\013\006\006\001" +
    "\001\000\002\001\001\000\006\003\062\006\006\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\003\005\004\060\006\006\001\001" +
    "\000\006\003\015\006\006\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\002\022\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\002\055\001\001" +
    "\000\004\002\027\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\002\054\001\001\000\004\002\053\001\001" +
    "\000\004\002\052\001\001\000\004\002\051\001\001\000" +
    "\004\002\050\001\001\000\004\002\047\001\001\000\004" +
    "\002\046\001\001\000\004\002\045\001\001\000\002\001" +
    "\001\000\004\002\044\001\001\000\004\002\043\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\003\062\006\006\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\002\065\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\002\070\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\002\074\001\001\000\002\001\001\000\006\003" +
    "\076\006\006\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private static final Logger LOGGER = LoggerFactory.getLogger(parser.class);

    /** Report a non fatal error (or warning).
     *
     * @param message an error message.
     * @param info    an extra object reserved for use by specialized subclasses.
     */
    public void report_error(String message, Object info)
    {
        String error = "";
        if (!(info instanceof Symbol))
            info = cur_token;
        if(info instanceof Symbol) {
            int line = ((Symbol)info).left;
            int column = ((Symbol)info).right;
            error = line  + ":" + column;
        }
        error += ": " + message;
        LOGGER.error(error);
    }

    /** Report a fatal error.
     *
     * @param message an error message.
     * @param info    an extra object reserved for use by specialized subclasses.
     */
    public void report_fatal_error(String   message, Object   info) throws java.lang.Exception
    {
        /* stop parsing (not really necessary since we throw an exception, but) */
        done_parsing();

        /* use the normal error message reporting to put out the message */
        report_error(message, info);

        /* throw an exception */
        throw new Exception("Can't recover from previous error(s)");
    }

    public int getLine() {
        Symbol symbol = (Symbol) cur_token;
        return symbol.left;
    }

    public int getColumn() {
        Symbol symbol = (Symbol) cur_token;
        return symbol.right;
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // Expr ::= MINUS Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // Expr ::= Expr NEQ Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Expr ::= Expr EQEQ Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Expr ::= Expr GE Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // Expr ::= Expr LE Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Expr ::= Expr GT Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Expr ::= Expr LT Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Expr ::= Expr DIVISION Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Expr ::= Expr TIMES Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Expr ::= Expr MINUS Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Expr ::= Expr PLUS Expr 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // Expr ::= LPAREN Expr RPAREN 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // Expr ::= IDENTIFIER 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Expr ::= STRING_LITERAL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Expr ::= DOUBLE_LITERAL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // Expr ::= INTEGER_LITERAL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expr",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // CompoundStmt ::= LCURLY StmtList RCURLY 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CompoundStmt",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // CompoundStmt ::= LCURLY RCURLY 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CompoundStmt",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Stmt ::= WHILE LPAREN Expr RPAREN Stmt 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Stmt",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Stmt ::= DO Stmt WHILE LPAREN Expr RPAREN SEMICOLON 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Stmt",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Stmt ::= CompoundStmt 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Stmt",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Stmt ::= IDENTIFIER EQ Expr SEMICOLON 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Stmt",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Stmt ::= PRINT LPAREN Expr RPAREN SEMICOLON 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("Stmt",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // StmtList ::= StmtList Stmt 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("StmtList",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // StmtList ::= Stmt 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("StmtList",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // CompUnit ::= StmtList 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CompUnit",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // CompUnit ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CompUnit",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= CompUnit EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

