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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassSwitchColorV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_SWITCH_COLOR</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchColorV1LoopbackTest {
    /**
     * Performs an in/out test of the SWITCH_COLOR_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param colorComponentMask {@link Integer}
     */
    public static void testSwitchColorSupportedReportLoopback(Integer colorComponentMask) {
        byte[] testPayload = CommandClassSwitchColorV1.getSwitchColorSupportedReport(colorComponentMask);

        Map<String, Object> response = CommandClassSwitchColorV1.handleSwitchColorSupportedReport(testPayload);
        assertEquals(colorComponentMask, (Integer) response.get("COLOR_COMPONENT_MASK"));
    }

    /**
     * Performs an in/out test of the SWITCH_COLOR_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param colorComponentId {@link Integer}
     */
    public static void testSwitchColorGetLoopback(Integer colorComponentId) {
        byte[] testPayload = CommandClassSwitchColorV1.getSwitchColorGet(colorComponentId);

        Map<String, Object> response = CommandClassSwitchColorV1.handleSwitchColorGet(testPayload);
        assertEquals(colorComponentId, (Integer) response.get("COLOR_COMPONENT_ID"));
    }

    /**
     * Performs an in/out test of the SWITCH_COLOR_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param colorComponentId {@link Integer}
     * @param value {@link Integer}
     */
    public static void testSwitchColorReportLoopback(Integer colorComponentId, Integer value) {
        byte[] testPayload = CommandClassSwitchColorV1.getSwitchColorReport(colorComponentId, value);

        Map<String, Object> response = CommandClassSwitchColorV1.handleSwitchColorReport(testPayload);
        assertEquals(colorComponentId, (Integer) response.get("COLOR_COMPONENT_ID"));
        assertEquals(value, (Integer) response.get("VALUE"));
    }

    /**
     * Performs an in/out test of the SWITCH_COLOR_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param colorComponentCount {@link Integer}
     */
    public static void testSwitchColorSetLoopback(Integer colorComponentCount) {
        byte[] testPayload = CommandClassSwitchColorV1.getSwitchColorSet(colorComponentCount);

        Map<String, Object> response = CommandClassSwitchColorV1.handleSwitchColorSet(testPayload);
        assertEquals(colorComponentCount, (Integer) response.get("COLOR_COMPONENT_COUNT"));
    }

    /**
     * Performs an in/out test of the SWITCH_COLOR_START_LEVEL_CHANGE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param res1 {@link Integer}
     * @param ignoreStartState {@link Boolean}
     * @param upDown {@link Boolean}
     * @param res2 {@link Boolean}
     * @param colorComponentId {@link Integer}
     * @param startLevel {@link Integer}
     */
    public static void testSwitchColorStartLevelChangeLoopback(Integer res1, Boolean ignoreStartState, Boolean upDown,
            Boolean res2, Integer colorComponentId, Integer startLevel) {
        byte[] testPayload = CommandClassSwitchColorV1.getSwitchColorStartLevelChange(res1, ignoreStartState, upDown,
                res2, colorComponentId, startLevel);

        Map<String, Object> response = CommandClassSwitchColorV1.handleSwitchColorStartLevelChange(testPayload);
        assertEquals(res1, (Integer) response.get("RES1"));
        assertEquals(ignoreStartState, (Boolean) response.get("IGNORE_START_STATE"));
        assertEquals(upDown, (Boolean) response.get("UP_DOWN"));
        assertEquals(res2, (Boolean) response.get("RES2"));
        assertEquals(colorComponentId, (Integer) response.get("COLOR_COMPONENT_ID"));
        assertEquals(startLevel, (Integer) response.get("START_LEVEL"));
    }

    /**
     * Performs an in/out test of the SWITCH_COLOR_STOP_LEVEL_CHANGE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param colorComponentId {@link Integer}
     */
    public static void testSwitchColorStopLevelChangeLoopback(Integer colorComponentId) {
        byte[] testPayload = CommandClassSwitchColorV1.getSwitchColorStopLevelChange(colorComponentId);

        Map<String, Object> response = CommandClassSwitchColorV1.handleSwitchColorStopLevelChange(testPayload);
        assertEquals(colorComponentId, (Integer) response.get("COLOR_COMPONENT_ID"));
    }

}
