/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl.loopback;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassGroupingNameV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_GROUPING_NAME</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassGroupingNameV1LoopbackTest {
    /**
     * Performs an in/out test of the GROUPING_NAME_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     * @param charPresentation {@link Integer}
     * @param groupingName {@link byte[]}
     */
    public static void testGroupingNameSetLoopback(Integer groupingIdentifier, Integer charPresentation,
            byte[] groupingName) {
        byte[] testPayload = CommandClassGroupingNameV1.getGroupingNameSet(groupingIdentifier, charPresentation,
                groupingName);

        Map<String, Object> response = CommandClassGroupingNameV1.handleGroupingNameSet(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
        assertEquals(charPresentation, (Integer) response.get("CHAR_PRESENTATION"));
        assertEquals(groupingName, (byte[]) response.get("GROUPING_NAME"));
    }

    /**
     * Performs an in/out test of the GROUPING_NAME_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     */
    public static void testGroupingNameGetLoopback(Integer groupingIdentifier) {
        byte[] testPayload = CommandClassGroupingNameV1.getGroupingNameGet(groupingIdentifier);

        Map<String, Object> response = CommandClassGroupingNameV1.handleGroupingNameGet(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
    }

    /**
     * Performs an in/out test of the GROUPING_NAME_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     * @param charPresentation {@link Integer}
     * @param groupingName {@link byte[]}
     */
    public static void testGroupingNameReportLoopback(Integer groupingIdentifier, Integer charPresentation,
            byte[] groupingName) {
        byte[] testPayload = CommandClassGroupingNameV1.getGroupingNameReport(groupingIdentifier, charPresentation,
                groupingName);

        Map<String, Object> response = CommandClassGroupingNameV1.handleGroupingNameReport(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
        assertEquals(charPresentation, (Integer) response.get("CHAR_PRESENTATION"));
        assertEquals(groupingName, (byte[]) response.get("GROUPING_NAME"));
    }

}
