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
import java.util.List;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassSimpleAvControlV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_SIMPLE_AV_CONTROL</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSimpleAvControlV1LoopbackTest {
    /**
     * Performs an in/out test of the SIMPLE_AV_CONTROL_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param sequenceNumber {@link Integer}
     * @param keyAttributes {@link Integer}
     * @param itemId {@link Integer}
     */
    public static void testSimpleAvControlSetLoopback(Integer sequenceNumber, Integer keyAttributes, Integer itemId) {
        byte[] testPayload = CommandClassSimpleAvControlV1.getSimpleAvControlSet(sequenceNumber, keyAttributes, itemId);

        Map<String, Object> response = CommandClassSimpleAvControlV1.handleSimpleAvControlSet(testPayload);
        assertEquals(sequenceNumber, (Integer) response.get("SEQUENCE_NUMBER"));
        assertEquals(keyAttributes, (Integer) response.get("KEY_ATTRIBUTES"));
        assertEquals(itemId, (Integer) response.get("ITEM_ID"));
    }

    /**
     * Performs an in/out test of the SIMPLE_AV_CONTROL_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param numberOfReports {@link Integer}
     */
    public static void testSimpleAvControlReportLoopback(Integer numberOfReports) {
        byte[] testPayload = CommandClassSimpleAvControlV1.getSimpleAvControlReport(numberOfReports);

        Map<String, Object> response = CommandClassSimpleAvControlV1.handleSimpleAvControlReport(testPayload);
        assertEquals(numberOfReports, (Integer) response.get("NUMBER_OF_REPORTS"));
    }

    /**
     * Performs an in/out test of the SIMPLE_AV_CONTROL_SUPPORTED_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param reportNo {@link Integer}
     */
    public static void testSimpleAvControlSupportedGetLoopback(Integer reportNo) {
        byte[] testPayload = CommandClassSimpleAvControlV1.getSimpleAvControlSupportedGet(reportNo);

        Map<String, Object> response = CommandClassSimpleAvControlV1.handleSimpleAvControlSupportedGet(testPayload);
        assertEquals(reportNo, (Integer) response.get("REPORT_NO"));
    }

    /**
     * Performs an in/out test of the SIMPLE_AV_CONTROL_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param reportNo {@link Integer}
     * @param bitMask {@link List<Integer>}
     */
    public static void testSimpleAvControlSupportedReportLoopback(Integer reportNo, List<Integer> bitMask) {
        byte[] testPayload = CommandClassSimpleAvControlV1.getSimpleAvControlSupportedReport(reportNo, bitMask);

        Map<String, Object> response = CommandClassSimpleAvControlV1.handleSimpleAvControlSupportedReport(testPayload);
        assertEquals(reportNo, (Integer) response.get("REPORT_NO"));
        assertEquals(bitMask, (List<Integer>) response.get("BIT_MASK"));
    }

}
