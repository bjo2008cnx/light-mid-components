/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.utils;

import static org.apache.dubbo.common.constants.CommonConstants.COMMA_SEPARATOR;
import static org.apache.dubbo.common.constants.CommonConstants.COMMA_SPLIT_PATTERN;
import static org.apache.dubbo.common.constants.CommonConstants.DOT_REGEX;
import static org.apache.dubbo.common.constants.CommonConstants.GROUP_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.HIDE_KEY_PREFIX;
import static org.apache.dubbo.common.constants.CommonConstants.INTERFACE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.SEPARATOR_REGEX;
import static org.apache.dubbo.common.constants.CommonConstants.UNDERLINE_SEPARATOR;
import static org.apache.dubbo.common.constants.CommonConstants.VERSION_KEY;

import com.sun.tools.javac.util.ArrayUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;

/**
 * StringUtils
 */

public final class StringUtils {

    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);
    private static final Pattern KVP_PATTERN = Pattern.compile("([_.a-zA-Z0-9][-_.a-zA-Z0-9]*)[=](.*)"); //key value pair pattern.
    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
    private static final int PAD_LIMIT = 8192;

    private StringUtils() {
    }


  public static String camelToSplitName(String camelName, String split) {
    if (isEmpty(camelName)) {
      return camelName;
    }
    StringBuilder buf = null;
    for (int i = 0; i < camelName.length(); i++) {
      char ch = camelName.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        if (buf == null) {
          buf = new StringBuilder();
          if (i > 0) {
            buf.append(camelName.substring(0, i));
          }
        }
        if (i > 0) {
          buf.append(split);
        }
        buf.append(Character.toLowerCase(ch));
      } else if (buf != null) {
        buf.append(ch);
      }
    }
    return buf == null ? camelName : buf.toString();
  }

  /**
   * is empty string.
   *
   * @param str source string.
   * @return is empty.
   */
  public static boolean isEmpty(String str) {
    return str == null || str.isEmpty();
  }

  /**
   * is not empty string.
   *
   * @param str source string.
   * @return is not empty.
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  /**
   * @param s1
   * @param s2
   * @return equals
   */
  public static boolean isEquals(String s1, String s2) {
    if (s1 == null && s2 == null) {
      return true;
    }
    if (s1 == null || s2 == null) {
      return false;
    }
    return s1.equals(s2);
  }

}
