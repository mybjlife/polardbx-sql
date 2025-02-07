/*
 * Copyright [2013-2021], Alibaba Group Holding Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.polardbx.executor.partitionvisualizer.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author ximing.yd
 * @date 2021/12/20 上午11:13
 */
@Data
public class PartitionHeatInfo implements Serializable {

    private static final long serialVersionUID = 3791945189188397815L;

    private String schemaName;
    private String logicalTable;
    private String partitionName;

    /**
     * DN Id
     */
    private String storageInstId;

    private Integer partitionSeq;

    private Long tableRows;

    private Long rowsRead;
    /**
     * rowsWritten = rowsInserted + rowsUpdated
     */
    private Long rowsWritten;

    private Long rowsReadWritten;

}
