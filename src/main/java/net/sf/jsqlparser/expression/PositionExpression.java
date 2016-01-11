/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2013 JSQLParser
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
package net.sf.jsqlparser.expression;

/**
 * Extract value from date/time expression. The name stores the part - name to
 * get from the following date/time expression.
 *
 * @author tw
 */
public class PositionExpression implements Expression {

    private Expression positionExpressionLeft;
    private Expression positionExpressionRight;
    

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    public Expression getPositionExpressionLeft() {
        return positionExpressionLeft;
    }

    public void setPositionExpressionLeft(Expression positionExpressionLeft) {
        this.positionExpressionLeft = positionExpressionLeft;
    }

    public Expression getPositionExpressionRight() {
        return positionExpressionRight;
    }

    public void setPositionExpressionRight(Expression positionExpressionRight) {
        this.positionExpressionRight = positionExpressionRight;
    }

    @Override
    public String toString() {
        return "POSITION(" + positionExpressionLeft + " IN " + positionExpressionRight + ')';
    }
}
