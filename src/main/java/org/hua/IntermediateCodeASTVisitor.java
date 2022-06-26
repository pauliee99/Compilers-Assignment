/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import org.hua.threeaddr.AssignInstr;
import org.hua.threeaddr.BinaryOpInstr;
import org.hua.threeaddr.CondJumpInstr;
import org.hua.threeaddr.GotoInstr;
import org.hua.threeaddr.LabelInstr;
import org.hua.threeaddr.PrintInstr;
import org.hua.threeaddr.Program;
import org.hua.threeaddr.UnaryOpInstr;

import java_cup.lalr_item;

import org.hua.ast.ASTUtils;
import org.hua.ast.ASTVisitor;
import org.hua.ast.ASTVisitorException;
import org.hua.ast.AssignmentStatement;
import org.hua.ast.BinaryExpression;
import org.hua.ast.BooleanLiteralExpression;
import org.hua.ast.BreakStatement;
import org.hua.ast.CharacterLiteralExpression;
import org.hua.ast.CompUnit;
import org.hua.ast.CompoundStatement;
import org.hua.ast.DoubleLiteralExpression;
import org.hua.ast.ExprEqExpr;
import org.hua.ast.Expression;
import org.hua.ast.FunctionDefinition;
import org.hua.ast.IdentifierExpression;
import org.hua.ast.IfStatement;
import org.hua.ast.IntegerLiteralExpression;
import org.hua.ast.ParameterDeclaration;
import org.hua.ast.ParenthesisExpression;
import org.hua.ast.PrintStatement;
import org.hua.ast.ReturnStatement;
import org.hua.ast.Specifiers;
import org.hua.ast.Statement;
import org.hua.ast.StringLiteralExpression;
import org.hua.ast.StructDefinition;
import org.hua.ast.UnaryExpression;
import org.hua.ast.VarDeclarationStatement;
import org.hua.ast.VariableDefinition;
import org.hua.ast.VariableDefinitionStatement;
import org.hua.ast.WhileStatement;
import org.apache.commons.lang3.StringEscapeUtils;
import org.hua.ast.ContinueStatement;
import org.hua.ast.Definitions;
import org.hua.ast.DoWhileStatement;
import org.hua.ast.IfElseStatement;

public class IntermediateCodeASTVisitor implements ASTVisitor {

    private final Program program;
    private final Deque<String> stack;
    private int temp;

    public IntermediateCodeASTVisitor() {
        program = new Program();
        stack = new ArrayDeque<String>();
        temp = 0;
    }

    private String createTemp() {
        return "t" + Integer.toString(temp++);
    }

    public Program getProgram() {
        return program;
    }

    @Override
    public void visit(CompUnit node) throws ASTVisitorException {
        Definitions s = null;
        Definitions ps;
        Iterator<Definitions> it = node.getDefinitions().iterator();
        while (it.hasNext()) {
            ps = s;
            s = it.next();

            if (ps != null && !ASTUtils.getNextList(ps).isEmpty()) {
                Program.backpatch(ASTUtils.getNextList(ps), program.addNewLabel());
            }

            s.accept(this);

            if (!ASTUtils.getBreakList(s).isEmpty()) {
                ASTUtils.error(s, "Break detected without a loop.");
            }

            if (!ASTUtils.getContinueList(s).isEmpty()) {
                ASTUtils.error(s, "Continue detected without a loop.");
            }
        }
        if (s != null && !ASTUtils.getNextList(s).isEmpty()) {
            Program.backpatch(ASTUtils.getNextList(s), program.addNewLabel());
        }
    }

    @Override
    public void visit(AssignmentStatement node) throws ASTVisitorException {

        // throw new UnsupportedOperationException("FIXME");

        // run recursively for expression
        // acquire temporary name from stack 
        // add AssignInstr into the program

        node.getExpression().accept(this);
        String t = stack.pop();
        program.add(new AssignInstr(t, node.getIdentifier()));

    }

    @Override
    public void visit(PrintStatement node) throws ASTVisitorException {

        // throw new UnsupportedOperationException("FIXME");

        // run recursively for expression
        // acquire temporary name from stack 
        // add PrintInstr into the program

        node.getExpression().accept(this);
        String t = stack.pop();
        PrintInstr instr = new PrintInstr(t);
        program.add(instr);

    }

    @Override
    public void visit(BinaryExpression node) throws ASTVisitorException {
        node.getExpression1().accept(this);
        String t1 = stack.pop();
        node.getExpression2().accept(this);
        String t2 = stack.pop();

        if (ASTUtils.isBooleanExpression(node)) {
            if (!node.getOperator().isRelational()) {
                ASTUtils.error(node, "Expression must be boolean.");
            }
            
            // throw new UnsupportedOperationException("FIXME");
            // create new CondJumpInstr with null target
            // create new GotoInstr with null target
            // add both to program
            // add first instruction into truelist of node
            // add second instruction into falselist of node

            CondJumpInstr condJumpInstr = new CondJumpInstr(node.getOperator(), t1, t2);
            GotoInstr gotoInstr = new GotoInstr();
            program.add(condJumpInstr);
            program.add(gotoInstr);
            ASTUtils.getTrueList(node).add(condJumpInstr);
            ASTUtils.getFalseList(node).add(gotoInstr);

        } else {
            // throw new UnsupportedOperationException("FIXME");

            // create new temporary
            // add binary operation instruction
            // add new temporary in stack
            String t = createTemp();
            stack.push(t);
            BinaryOpInstr instr = new BinaryOpInstr(node.getOperator(), t1, t2, t);
            program.add(instr);
        }
    }

    @Override
    public void visit(UnaryExpression node) throws ASTVisitorException {
        node.getExpression().accept(this);
        String t1 = stack.pop();
        String t = createTemp();
        stack.push(t);
        program.add(new UnaryOpInstr(node.getOperator(), t1, t));
    }

    @Override
    public void visit(IdentifierExpression node) throws ASTVisitorException {
        stack.push(node.getIdentifier());
    }

    @Override
    public void visit(DoubleLiteralExpression node) throws ASTVisitorException {
        if (ASTUtils.isBooleanExpression(node)) {
            if (node.getLiteral() != 0d) {
                GotoInstr i = new GotoInstr();
                program.add(i);
                ASTUtils.getTrueList(node).add(i);
            } else {
                GotoInstr i = new GotoInstr();
                program.add(i);
                ASTUtils.getFalseList(node).add(i);
            }
        } else {
            String t = createTemp();
            stack.push(t);
            program.add(new AssignInstr(node.getLiteral().toString(), t));
        }
    }

    @Override
    public void visit(IntegerLiteralExpression node) throws ASTVisitorException {
        if (ASTUtils.isBooleanExpression(node)) {
            if (node.getLiteral() != 0) {
                GotoInstr i = new GotoInstr();
                program.add(i);
                ASTUtils.getTrueList(node).add(i);
            } else {
                GotoInstr i = new GotoInstr();
                program.add(i);
                ASTUtils.getFalseList(node).add(i);
            }
        } else {

            // throw new UnsupportedOperationException("FIXME");
            // create new temporary
            // add AssignInstr to program
            // add new temporary in stack
            String t = createTemp();
            stack.push(t);
            program.add(new AssignInstr(String.valueOf(node.getLiteral()), t));

        }
    }

    @Override
    public void visit(StringLiteralExpression node) throws ASTVisitorException {
        if (ASTUtils.isBooleanExpression(node)) {
            ASTUtils.error(node, "Strings cannot be used as boolean expressions");
        } else {
            String t = createTemp();
            stack.push(t);
            program.add(new AssignInstr("\"" + StringEscapeUtils.escapeJava(node.getLiteral()) + "\"", t));
        }
    }

    @Override
    public void visit(ParenthesisExpression node) throws ASTVisitorException {
        node.getExpression().accept(this);
        String t1 = stack.pop();
        String t = createTemp();
        stack.push(t);
        program.add(new AssignInstr(t1, t));
    }

    @Override
    public void visit(WhileStatement node) throws ASTVisitorException {
        ASTUtils.setBooleanExpression(node.getExpression(), true);

        // throw new UnsupportedOperationException("FIXME");
        // create beginLabel 
        // see Program class for details
        // produce code for expression
        // create beginStmtLabel
        // backpatch truelist of expression with beginStmtLabel
        // produce code for statement
        // backpatch nextlist of statement with beginLabel
        // backpatch continuelist of statement with beginLabel
        // add GotoInstr to beginLabel 
        // append falselist of expression into nextlist of node
        // append breaklist of statement into nextlist of node

        LabelInstr beginLabel = program.addNewLabel();
        node.getExpression().accept(this);
        LabelInstr beginStmtLabel = program.addNewLabel();
        Program.backpatch(ASTUtils.getTrueList(node.getExpression()), beginStmtLabel);
        node.getStatement().accept(this);
        program.add(new GotoInstr(beginLabel));
        Program.backpatch(ASTUtils.getNextList(node.getStatement()), beginLabel);
        Program.backpatch(ASTUtils.getContinueList(node.getStatement()), beginLabel);
        ASTUtils.getNextList(node).addAll(ASTUtils.getFalseList(node.getExpression()));
        ASTUtils.getNextList(node).addAll(ASTUtils.getBreakList(node.getStatement()));

    }

    @Override
    public void visit(DoWhileStatement node) throws ASTVisitorException {
        ASTUtils.setBooleanExpression(node.getExpression(), true); 

        LabelInstr beginLabel = program.addNewLabel();

        node.getStatement().accept(this);
        ASTUtils.getNextList(node).addAll(ASTUtils.getBreakList(node.getStatement()));

        LabelInstr beginExprLabel = program.addNewLabel();
        Program.backpatch(ASTUtils.getNextList(node.getStatement()), beginExprLabel);
        Program.backpatch(ASTUtils.getContinueList(node.getStatement()), beginExprLabel);

        node.getExpression().accept(this);
        ASTUtils.getNextList(node).addAll(ASTUtils.getFalseList(node.getExpression()));
        Program.backpatch(ASTUtils.getTrueList(node.getExpression()), beginLabel);
    }

    @Override
    public void visit(IfStatement node) throws ASTVisitorException {
        ASTUtils.setBooleanExpression(node.getExpression(), true);

        // throw new UnsupportedOperationException("FIXME");
        node.getExpression().accept(this);
        LabelInstr trueLabel = program.addNewLabel();
        node.getStatement().accept(this);
        Program.backpatch(ASTUtils.getTrueList(node.getExpression()), trueLabel);
        ASTUtils.getBreakList(node).addAll(ASTUtils.getBreakList(node.getStatement()));
        ASTUtils.getContinueList(node).addAll(ASTUtils.getContinueList(node.getStatement()));
        ASTUtils.getNextList(node).addAll(ASTUtils.getFalseList(node.getExpression()));
        ASTUtils.getNextList(node).addAll(ASTUtils.getNextList(node.getExpression()));
    }

    @Override
    public void visit(IfElseStatement node) throws ASTVisitorException {
        ASTUtils.setBooleanExpression(node.getExpression(), true);

        // throw new UnsupportedOperationException("FIXME");
        node.getExpression().accept(this);
        LabelInstr stmt1Label = program.addNewLabel();
        node.getStatement1().accept(this);
        GotoInstr nextGoto = new GotoInstr();
        program.add(nextGoto);
        LabelInstr stmt2Label = program.addNewLabel();
        node.getStatement2().accept(this);
        
        Program.backpatch(ASTUtils.getTrueList(node.getExpression()), stmt1Label);
        Program.backpatch(ASTUtils.getFalseList(node.getExpression()), stmt2Label);
        
        ASTUtils.getBreakList(node).addAll(ASTUtils.getBreakList(node.getStatement1()));
        ASTUtils.getBreakList(node).addAll(ASTUtils.getBreakList(node.getStatement2()));

        ASTUtils.getContinueList(node).addAll(ASTUtils.getContinueList(node.getStatement1()));
        ASTUtils.getContinueList(node).addAll(ASTUtils.getContinueList(node.getStatement2()));

        ASTUtils.getNextList(node).addAll(ASTUtils.getNextList(node.getStatement1()));
        ASTUtils.getNextList(node).addAll(ASTUtils.getNextList(node.getStatement2()));
        ASTUtils.getNextList(node).add(nextGoto);
    }

    @Override
    public void visit(BreakStatement node) throws ASTVisitorException {
        // throw new UnsupportedOperationException("FIXME");
        GotoInstr gotoInstr = new GotoInstr();
        program.add(gotoInstr);
        ASTUtils.getBreakList(node).add(gotoInstr);

        // add new GotoInstr to program
        // add instruction to breaklist of node

    }

    @Override
    public void visit(ContinueStatement node) throws ASTVisitorException {
        // throw new UnsupportedOperationException("FIXME");
        GotoInstr gotoInstr = new GotoInstr();
        program.add(gotoInstr);
        ASTUtils.getContinueList(node).add(gotoInstr);

        // add new GotoInstr to program
        // add instruction to continuelist of node

    }

    @Override
    public void visit(CompoundStatement node) throws ASTVisitorException {
        List<GotoInstr> breakList = new ArrayList<GotoInstr>();
        List<GotoInstr> continueList = new ArrayList<GotoInstr>();
        Statement s = null, ps;
        Iterator<Statement> it = node.getStatements().iterator();
        while (it.hasNext()) {
            ps = s;
            s = it.next();
            if (ps != null && !ASTUtils.getNextList(ps).isEmpty()) {
                Program.backpatch(ASTUtils.getNextList(ps), program.addNewLabel());
            }
            s.accept(this);
            breakList.addAll(ASTUtils.getBreakList(s));
            continueList.addAll(ASTUtils.getContinueList(s));
        }
        if (s != null) {
            ASTUtils.setNextList(node, ASTUtils.getNextList(s));
        }
        ASTUtils.setBreakList(node, breakList);
        ASTUtils.setContinueList(node, continueList);
    }

    @Override
    public void visit(VarDeclarationStatement varDeclaration) throws ASTVisitorException {
        // nothing really
    }

    @Override
    public void visit(VariableDefinition node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(FunctionDefinition node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(StructDefinition node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Definitions node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ReturnStatement node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BooleanLiteralExpression node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CharacterLiteralExpression node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ParameterDeclaration node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Expression node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ExprEqExpr node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Specifiers node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(VariableDefinitionStatement node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

}
