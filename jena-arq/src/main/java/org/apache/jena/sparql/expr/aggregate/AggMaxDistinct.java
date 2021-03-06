/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.sparql.expr.aggregate;

import java.util.Objects;

import org.apache.jena.sparql.expr.Expr ;
import org.apache.jena.sparql.expr.ExprList ;

public class AggMaxDistinct extends AggMaxBase
{
    // ---- MAX( DISTINCT expr)
    public AggMaxDistinct(Expr expr) { super(expr, true) ; } 
    @Override
    public Aggregator copy(ExprList expr) { return new AggMaxDistinct(expr.get(0)) ; }

    @Override
    public int hashCode()   { return HC_AggMaxDistinct ^ getExpr().hashCode() ; }
    
    @Override
    public boolean equals(Object other)
    {
        if ( this == other ) return true ; 
        if ( ! ( other instanceof AggMaxDistinct ) )
            return false ;
        AggMaxDistinct agg = (AggMaxDistinct)other ;
        return Objects.equals(exprList, agg.exprList) ;
    }

}
