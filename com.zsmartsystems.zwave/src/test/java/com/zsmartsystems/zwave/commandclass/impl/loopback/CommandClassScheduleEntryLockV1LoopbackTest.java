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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassScheduleEntryLockV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_SCHEDULE_ENTRY_LOCK</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassScheduleEntryLockV1LoopbackTest {
    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_ENABLE_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param userIdentifier {@link Integer}
     * @param enabled {@link String}
     */
    public static void testScheduleEntryLockEnableSetLoopback(Integer userIdentifier, String enabled) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockEnableSet(userIdentifier, enabled);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockEnableSet(testPayload);
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(enabled, (String) response.get("ENABLED"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param enabled {@link String}
     */
    public static void testScheduleEntryLockEnableAllSetLoopback(String enabled) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockEnableAllSet(enabled);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockEnableAllSet(testPayload);
        assertEquals(enabled, (String) response.get("ENABLED"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param setAction {@link String}
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param dayOfWeek {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     */
    public static void testScheduleEntryLockWeekDaySetLoopback(String setAction, Integer userIdentifier,
            Integer scheduleSlotId, Integer dayOfWeek, Integer startHour, Integer startMinute, Integer stopHour,
            Integer stopMinute) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockWeekDaySet(setAction, userIdentifier,
                scheduleSlotId, dayOfWeek, startHour, startMinute, stopHour, stopMinute);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockWeekDaySet(testPayload);
        assertEquals(setAction, (String) response.get("SET_ACTION"));
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(scheduleSlotId, (Integer) response.get("SCHEDULE_SLOT_ID"));
        assertEquals(dayOfWeek, (Integer) response.get("DAY_OF_WEEK"));
        assertEquals(startHour, (Integer) response.get("START_HOUR"));
        assertEquals(startMinute, (Integer) response.get("START_MINUTE"));
        assertEquals(stopHour, (Integer) response.get("STOP_HOUR"));
        assertEquals(stopMinute, (Integer) response.get("STOP_MINUTE"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     */
    public static void testScheduleEntryLockWeekDayGetLoopback(Integer userIdentifier, Integer scheduleSlotId) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockWeekDayGet(userIdentifier,
                scheduleSlotId);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockWeekDayGet(testPayload);
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(scheduleSlotId, (Integer) response.get("SCHEDULE_SLOT_ID"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param dayOfWeek {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     */
    public static void testScheduleEntryLockWeekDayReportLoopback(Integer userIdentifier, Integer scheduleSlotId,
            Integer dayOfWeek, Integer startHour, Integer startMinute, Integer stopHour, Integer stopMinute) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockWeekDayReport(userIdentifier,
                scheduleSlotId, dayOfWeek, startHour, startMinute, stopHour, stopMinute);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockWeekDayReport(testPayload);
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(scheduleSlotId, (Integer) response.get("SCHEDULE_SLOT_ID"));
        assertEquals(dayOfWeek, (Integer) response.get("DAY_OF_WEEK"));
        assertEquals(startHour, (Integer) response.get("START_HOUR"));
        assertEquals(startMinute, (Integer) response.get("START_MINUTE"));
        assertEquals(stopHour, (Integer) response.get("STOP_HOUR"));
        assertEquals(stopMinute, (Integer) response.get("STOP_MINUTE"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param setAction {@link String}
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     */
    public static void testScheduleEntryLockYearDaySetLoopback(String setAction, Integer userIdentifier,
            Integer scheduleSlotId, Integer startYear, Integer startMonth, Integer startDay, Integer startHour,
            Integer startMinute, Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHour,
            Integer stopMinute) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockYearDaySet(setAction, userIdentifier,
                scheduleSlotId, startYear, startMonth, startDay, startHour, startMinute, stopYear, stopMonth, stopDay,
                stopHour, stopMinute);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockYearDaySet(testPayload);
        assertEquals(setAction, (String) response.get("SET_ACTION"));
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(scheduleSlotId, (Integer) response.get("SCHEDULE_SLOT_ID"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(startDay, (Integer) response.get("START_DAY"));
        assertEquals(startHour, (Integer) response.get("START_HOUR"));
        assertEquals(startMinute, (Integer) response.get("START_MINUTE"));
        assertEquals(stopYear, (Integer) response.get("STOP_YEAR"));
        assertEquals(stopMonth, (Integer) response.get("STOP_MONTH"));
        assertEquals(stopDay, (Integer) response.get("STOP_DAY"));
        assertEquals(stopHour, (Integer) response.get("STOP_HOUR"));
        assertEquals(stopMinute, (Integer) response.get("STOP_MINUTE"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     */
    public static void testScheduleEntryLockYearDayGetLoopback(Integer userIdentifier, Integer scheduleSlotId) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockYearDayGet(userIdentifier,
                scheduleSlotId);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockYearDayGet(testPayload);
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(scheduleSlotId, (Integer) response.get("SCHEDULE_SLOT_ID"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     */
    public static void testScheduleEntryLockYearDayReportLoopback(Integer userIdentifier, Integer scheduleSlotId,
            Integer startYear, Integer startMonth, Integer startDay, Integer startHour, Integer startMinute,
            Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHour, Integer stopMinute) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryLockYearDayReport(userIdentifier,
                scheduleSlotId, startYear, startMonth, startDay, startHour, startMinute, stopYear, stopMonth, stopDay,
                stopHour, stopMinute);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryLockYearDayReport(testPayload);
        assertEquals(userIdentifier, (Integer) response.get("USER_IDENTIFIER"));
        assertEquals(scheduleSlotId, (Integer) response.get("SCHEDULE_SLOT_ID"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(startDay, (Integer) response.get("START_DAY"));
        assertEquals(startHour, (Integer) response.get("START_HOUR"));
        assertEquals(startMinute, (Integer) response.get("START_MINUTE"));
        assertEquals(stopYear, (Integer) response.get("STOP_YEAR"));
        assertEquals(stopMonth, (Integer) response.get("STOP_MONTH"));
        assertEquals(stopDay, (Integer) response.get("STOP_DAY"));
        assertEquals(stopHour, (Integer) response.get("STOP_HOUR"));
        assertEquals(stopMinute, (Integer) response.get("STOP_MINUTE"));
    }

    /**
     * Performs an in/out test of the SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param numberOfSlotsWeekDay {@link Integer}
     * @param numberOfSlotsYearDay {@link Integer}
     */
    public static void testScheduleEntryTypeSupportedReportLoopback(Integer numberOfSlotsWeekDay,
            Integer numberOfSlotsYearDay) {
        byte[] testPayload = CommandClassScheduleEntryLockV1.getScheduleEntryTypeSupportedReport(numberOfSlotsWeekDay,
                numberOfSlotsYearDay);

        Map<String, Object> response = CommandClassScheduleEntryLockV1.handleScheduleEntryTypeSupportedReport(testPayload);
        assertEquals(numberOfSlotsWeekDay, (Integer) response.get("NUMBER_OF_SLOTS_WEEK_DAY"));
        assertEquals(numberOfSlotsYearDay, (Integer) response.get("NUMBER_OF_SLOTS_YEAR_DAY"));
    }

}
