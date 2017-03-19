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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassScheduleV2;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_SCHEDULE</b> version <b>2</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassScheduleV2LoopbackTest {
    /**
     * Performs an in/out test of the SCHEDULE_SUPPORTED_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleIdBlock {@link Integer}
     */
    public static void testScheduleSupportedGetLoopback(Integer scheduleIdBlock) {
        byte[] testPayload = CommandClassScheduleV2.getScheduleSupportedGet(scheduleIdBlock);

        Map<String, Object> response = CommandClassScheduleV2.handleScheduleSupportedGet(testPayload);
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param numberOfSupportedScheduleId {@link Integer}
     * @param startTimeSupport {@link Integer}
     * @param fallbackSupport {@link Boolean}
     * @param supportEnableDisable {@link Boolean}
     * @param numberOfSupportedCc {@link Integer}
     * @param supportedOverrideTypes {@link Integer}
     * @param overrideSupport {@link Boolean}
     * @param scheduleIdBlock {@link Integer}
     * @param numberOfSupportedScheduleBlocks {@link Integer}
     */
    public static void testScheduleSupportedReportLoopback(Integer numberOfSupportedScheduleId, Integer startTimeSupport,
            Boolean fallbackSupport, Boolean supportEnableDisable, Integer numberOfSupportedCc,
            Integer supportedOverrideTypes, Boolean overrideSupport, Integer scheduleIdBlock,
            Integer numberOfSupportedScheduleBlocks) {
        byte[] testPayload = CommandClassScheduleV2.getScheduleSupportedReport(numberOfSupportedScheduleId,
                startTimeSupport, fallbackSupport, supportEnableDisable, numberOfSupportedCc, supportedOverrideTypes,
                overrideSupport, scheduleIdBlock, numberOfSupportedScheduleBlocks);

        Map<String, Object> response = CommandClassScheduleV2.handleScheduleSupportedReport(testPayload);
        assertEquals(numberOfSupportedScheduleId, (Integer) response.get("NUMBER_OF_SUPPORTED_SCHEDULE_ID"));
        assertEquals(startTimeSupport, (Integer) response.get("START_TIME_SUPPORT"));
        assertEquals(fallbackSupport, (Boolean) response.get("FALLBACK_SUPPORT"));
        assertEquals(supportEnableDisable, (Boolean) response.get("SUPPORT_ENABLE_DISABLE"));
        assertEquals(numberOfSupportedCc, (Integer) response.get("NUMBER_OF_SUPPORTED_CC"));
        assertEquals(supportedOverrideTypes, (Integer) response.get("SUPPORTED_OVERRIDE_TYPES"));
        assertEquals(overrideSupport, (Boolean) response.get("OVERRIDE_SUPPORT"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
        assertEquals(numberOfSupportedScheduleBlocks, (Integer) response.get("NUMBER_OF_SUPPORTED_SCHEDULE_BLOCKS"));
    }

    /**
     * Performs an in/out test of the COMMAND_SCHEDULE_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDayOfMonth {@link Integer}
     * @param startWeekday {@link Integer}
     * @param startHour {@link Integer}
     * @param durationType {@link Integer}
     * @param startMinute {@link Integer}
     * @param durationByte {@link Integer}
     * @param reportsToFollow {@link Integer}
     * @param numberOfCmdToFollow {@link Integer}
     */
    public static void testCommandScheduleSetLoopback(Integer scheduleId, Integer scheduleIdBlock, Integer startYear,
            Integer startMonth, Integer startDayOfMonth, Integer startWeekday, Integer startHour, Integer durationType,
            Integer startMinute, Integer durationByte, Integer reportsToFollow, Integer numberOfCmdToFollow) {
        byte[] testPayload = CommandClassScheduleV2.getCommandScheduleSet(scheduleId, scheduleIdBlock, startYear,
                startMonth, startDayOfMonth, startWeekday, startHour, durationType, startMinute, durationByte,
                reportsToFollow, numberOfCmdToFollow);

        Map<String, Object> response = CommandClassScheduleV2.handleCommandScheduleSet(testPayload);
        assertEquals(scheduleId, (Integer) response.get("SCHEDULE_ID"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(startDayOfMonth, (Integer) response.get("START_DAY_OF_MONTH"));
        assertEquals(startWeekday, (Integer) response.get("START_WEEKDAY"));
        assertEquals(startHour, (Integer) response.get("START_HOUR"));
        assertEquals(durationType, (Integer) response.get("DURATION_TYPE"));
        assertEquals(startMinute, (Integer) response.get("START_MINUTE"));
        assertEquals(durationByte, (Integer) response.get("DURATION_BYTE"));
        assertEquals(reportsToFollow, (Integer) response.get("REPORTS_TO_FOLLOW"));
        assertEquals(numberOfCmdToFollow, (Integer) response.get("NUMBER_OF_CMD_TO_FOLLOW"));
    }

    /**
     * Performs an in/out test of the COMMAND_SCHEDULE_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     */
    public static void testCommandScheduleGetLoopback(Integer scheduleId, Integer scheduleIdBlock) {
        byte[] testPayload = CommandClassScheduleV2.getCommandScheduleGet(scheduleId, scheduleIdBlock);

        Map<String, Object> response = CommandClassScheduleV2.handleCommandScheduleGet(testPayload);
        assertEquals(scheduleId, (Integer) response.get("SCHEDULE_ID"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
    }

    /**
     * Performs an in/out test of the COMMAND_SCHEDULE_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param activeId {@link Integer}
     * @param startDayOfMonth {@link Integer}
     * @param startWeekday {@link Integer}
     * @param startHour {@link Integer}
     * @param durationType {@link Integer}
     * @param startMinute {@link Integer}
     * @param durationByte {@link Integer}
     * @param reportsToFollow {@link Integer}
     * @param numberOfCmdToFollow {@link Integer}
     */
    public static void testCommandScheduleReportLoopback(Integer scheduleId, Integer scheduleIdBlock, Integer startYear,
            Integer startMonth, Integer activeId, Integer startDayOfMonth, Integer startWeekday, Integer startHour,
            Integer durationType, Integer startMinute, Integer durationByte, Integer reportsToFollow,
            Integer numberOfCmdToFollow) {
        byte[] testPayload = CommandClassScheduleV2.getCommandScheduleReport(scheduleId, scheduleIdBlock, startYear,
                startMonth, activeId, startDayOfMonth, startWeekday, startHour, durationType, startMinute, durationByte,
                reportsToFollow, numberOfCmdToFollow);

        Map<String, Object> response = CommandClassScheduleV2.handleCommandScheduleReport(testPayload);
        assertEquals(scheduleId, (Integer) response.get("SCHEDULE_ID"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(activeId, (Integer) response.get("ACTIVE_ID"));
        assertEquals(startDayOfMonth, (Integer) response.get("START_DAY_OF_MONTH"));
        assertEquals(startWeekday, (Integer) response.get("START_WEEKDAY"));
        assertEquals(startHour, (Integer) response.get("START_HOUR"));
        assertEquals(durationType, (Integer) response.get("DURATION_TYPE"));
        assertEquals(startMinute, (Integer) response.get("START_MINUTE"));
        assertEquals(durationByte, (Integer) response.get("DURATION_BYTE"));
        assertEquals(reportsToFollow, (Integer) response.get("REPORTS_TO_FOLLOW"));
        assertEquals(numberOfCmdToFollow, (Integer) response.get("NUMBER_OF_CMD_TO_FOLLOW"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_REMOVE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     */
    public static void testScheduleRemoveLoopback(Integer scheduleId, Integer scheduleIdBlock) {
        byte[] testPayload = CommandClassScheduleV2.getScheduleRemove(scheduleId, scheduleIdBlock);

        Map<String, Object> response = CommandClassScheduleV2.handleScheduleRemove(testPayload);
        assertEquals(scheduleId, (Integer) response.get("SCHEDULE_ID"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_STATE_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleId {@link Integer}
     * @param scheduleState {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     */
    public static void testScheduleStateSetLoopback(Integer scheduleId, Integer scheduleState, Integer scheduleIdBlock) {
        byte[] testPayload = CommandClassScheduleV2.getScheduleStateSet(scheduleId, scheduleState, scheduleIdBlock);

        Map<String, Object> response = CommandClassScheduleV2.handleScheduleStateSet(testPayload);
        assertEquals(scheduleId, (Integer) response.get("SCHEDULE_ID"));
        assertEquals(scheduleState, (Integer) response.get("SCHEDULE_STATE"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_STATE_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param scheduleIdBlock {@link Integer}
     */
    public static void testScheduleStateGetLoopback(Integer scheduleIdBlock) {
        byte[] testPayload = CommandClassScheduleV2.getScheduleStateGet(scheduleIdBlock);

        Map<String, Object> response = CommandClassScheduleV2.handleScheduleStateGet(testPayload);
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_STATE_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param numberOfSupportedScheduleId {@link Integer}
     * @param override {@link Boolean}
     * @param reportsToFollow {@link Integer}
     * @param activeId1 {@link Integer}
     * @param activeId2 {@link Integer}
     * @param activeId3 {@link Integer}
     * @param activeIdN {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     */
    public static void testScheduleStateReportLoopback(Integer numberOfSupportedScheduleId, Boolean override,
            Integer reportsToFollow, Integer activeId1, Integer activeId2, Integer activeId3, Integer activeIdN,
            Integer scheduleIdBlock) {
        byte[] testPayload = CommandClassScheduleV2.getScheduleStateReport(numberOfSupportedScheduleId, override,
                reportsToFollow, activeId1, activeId2, activeId3, activeIdN, scheduleIdBlock);

        Map<String, Object> response = CommandClassScheduleV2.handleScheduleStateReport(testPayload);
        assertEquals(numberOfSupportedScheduleId, (Integer) response.get("NUMBER_OF_SUPPORTED_SCHEDULE_ID"));
        assertEquals(override, (Boolean) response.get("OVERRIDE"));
        assertEquals(reportsToFollow, (Integer) response.get("REPORTS_TO_FOLLOW"));
        assertEquals(activeId1, (Integer) response.get("ACTIVE_ID1"));
        assertEquals(activeId2, (Integer) response.get("ACTIVE_ID2"));
        assertEquals(activeId3, (Integer) response.get("ACTIVE_ID3"));
        assertEquals(activeIdN, (Integer) response.get("ACTIVE_ID_N"));
        assertEquals(scheduleIdBlock, (Integer) response.get("SCHEDULE_ID_BLOCK"));
    }

}
