/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.storage

import java.io.File

/**
 * References a particular segment of a file (potentially the entire file),
 * based off offset, length and record number.
 */
private[spark] class FileSegment(
    val file: File,
    val offset: Long,
    val length: Long,
    val record: Long) {
  require(offset >= 0, s"File segment offset cannot be negative (got $offset)")
  require(length >= 0, s"File segment length cannot be negative (got $length)")
  require(record >= 0, s"File segment record cannot be negative (got $record)")
  override def toString: String = {
    "(name=%s, offset=%d, length=%d, record=%d)".format(file.getName, offset, length, record)
  }
}
