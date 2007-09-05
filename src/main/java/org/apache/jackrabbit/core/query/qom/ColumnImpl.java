/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.core.query.qom;

import org.apache.jackrabbit.name.QName;
import org.apache.jackrabbit.name.NamePathResolver;

import org.apache.jackrabbit.core.query.jsr283.qom.Column;

/**
 * <code>ColumnImpl</code>...
 */
public class ColumnImpl extends AbstractQOMNode implements Column {

    /**
     * The name of the selector.
     */
    private final QName selectorName;

    /**
     * The name of the property.
     */
    private final QName propertyName;

    /**
     * The name of the column.
     */
    private final QName columnName;

    ColumnImpl(NamePathResolver resolver,
               QName selectorName,
               QName propertyName,
               QName columnName) {
        super(resolver);
        this.selectorName = selectorName;
        this.propertyName = propertyName;
        this.columnName = columnName;
    }

    /**
     * Gets the name of the selector.
     *
     * @return the selector name; non-null
     */
    public QName getSelectorQName() {
        return selectorName;
    }

    /**
     * Gets the name of the property.
     *
     * @return the property name, or null to include a column for each
     *         single-value non-residual property of the selector's node type
     */
    public QName getPropertyQName() {
        return propertyName;
    }

    /**
     * Gets the column name.
     * <p/>
     *
     * @return the column name; must be null if <code>getPropertyName</code> is
     *         null and non-null otherwise
     */
    public QName getColumnQName() {
        return columnName;
    }


    //---------------------------< Column >-------------------------------------

    /**
     * Gets the name of the selector.
     *
     * @return the selector name; non-null
     */
    public String getSelectorName() {
        return getJCRName(selectorName);
    }

    /**
     * Gets the name of the property.
     *
     * @return the property name, or null to include a column for each
     *         single-value non-residual property of the selector's node type
     */
    public String getPropertyName() {
        return getJCRName(propertyName);
    }

    /**
     * Gets the column name.
     * <p/>
     *
     * @return the column name; must be null if <code>getPropertyName</code> is
     *         null and non-null otherwise
     */
    public String getColumnName() {
        return getJCRName(columnName);
    }

    //------------------------< AbstractQOMNode >-------------------------------

    /**
     * Accepts a <code>visitor</code> and calls the appropriate visit method
     * depending on the type of this QOM node.
     *
     * @param visitor the visitor.
     */
    public void accept(QOMTreeVisitor visitor, Object data) {
        visitor.visit(this, data);
    }
}
