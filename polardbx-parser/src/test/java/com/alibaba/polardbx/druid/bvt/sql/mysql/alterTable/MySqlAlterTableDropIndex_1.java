/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.polardbx.druid.bvt.sql.mysql.alterTable;

import com.alibaba.polardbx.druid.DbType;
import com.alibaba.polardbx.druid.sql.SQLUtils;
import com.alibaba.polardbx.druid.sql.ast.SQLStatement;
import com.alibaba.polardbx.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.polardbx.druid.sql.parser.Token;
import com.alibaba.polardbx.druid.sql.visitor.SchemaStatVisitor;
import junit.framework.TestCase;
import org.junit.Assert;

public class MySqlAlterTableDropIndex_1 extends TestCase {

    public void test_alter_first() throws Exception {
        String sql = "ALTER TABLE `test`.`tb1` DROP INDEX `ix`, DROP INDEX `ix2` ;";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        SQLStatement stmt = parser.parseStatementList().get(0);
        parser.match(Token.EOF);
        
        Assert.assertEquals("ALTER TABLE `test`.`tb1`" + //
                            "\n\tDROP INDEX `ix`," + //
                            "\n\tDROP INDEX `ix2`;", SQLUtils.toMySqlString(stmt));
        
        Assert.assertEquals("alter table `test`.`tb1`" + //
                "\n\tdrop index `ix`," + //
                "\n\tdrop index `ix2`;", SQLUtils.toMySqlString(stmt, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION));
    }

    public void test_1() throws Exception {
        String sql = "ALTER TABLE customer DROP INDEX account_Index, DROP INDEX index_name , ADD INDEX guid (guid) USING BTREE;";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        SQLStatement stmt = parser.parseStatementList().get(0);
        parser.match(Token.EOF);

        assertEquals("ALTER TABLE customer\n" +
                "\tDROP INDEX account_Index,\n" +
                "\tDROP INDEX index_name,\n" +
                "\tADD INDEX guid USING BTREE (guid);", SQLUtils.toMySqlString(stmt));

        assertEquals("alter table customer\n" +
                "\tdrop index account_Index,\n" +
                "\tdrop index index_name,\n" +
                "\tadd index guid using BTREE (guid);", SQLUtils.toMySqlString(stmt, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION));

        SchemaStatVisitor v = SQLUtils.createSchemaStatVisitor(DbType.mysql);
        stmt.accept(v);
        v.getFunctions();
    }

    public void test_overflow() throws Exception {
        Long l = Long.MIN_VALUE;
        System.out.println(l);
        float v = l.floatValue();
        System.out.println(v);
    }
}