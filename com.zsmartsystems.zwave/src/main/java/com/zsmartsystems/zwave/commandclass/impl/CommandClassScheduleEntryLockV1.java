/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCHEDULE_ENTRY_LOCK</b> version <b>1</b>.
 * <p>
 * Command Class Schedule Entry Lock
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x4E.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassScheduleEntryLockV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassScheduleEntryLockV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SCHEDULE_ENTRY_LOCK
     */
    public final static int COMMAND_CLASS_KEY = 0x4E;

    /**
     * Schedule Entry Lock Enable Set Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_ENABLE_SET = 0x01;
    /**
     * Schedule Entry Lock Enable All Set Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET = 0x02;
    /**
     * Schedule Entry Lock Week Day Set Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET = 0x03;
    /**
     * Schedule Entry Lock Week Day Get Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET = 0x04;
    /**
     * Schedule Entry Lock Week Day Report Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT = 0x05;
    /**
     * Schedule Entry Lock Year Day Set Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET = 0x06;
    /**
     * Schedule Entry Lock Year Day Get Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET = 0x07;
    /**
     * Schedule Entry Lock Year Day Report Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT = 0x08;
    /**
     * Schedule Entry Type Supported Get Command Constant
     */
    public final static int SCHEDULE_ENTRY_TYPE_SUPPORTED_GET = 0x09;
    /**
     * Schedule Entry Type Supported Report Command Constant
     */
    public final static int SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT = 0x0A;

    /**
     * Map holding constants for ScheduleEntryLockYearDaySetSetAction
     */
    private static Map<Integer, String> constantScheduleEntryLockYearDaySetSetAction = new HashMap<Integer, String>();

    /**
     * Map holding constants for ScheduleEntryLockEnableSetEnabled
     */
    private static Map<Integer, String> constantScheduleEntryLockEnableSetEnabled = new HashMap<Integer, String>();

    /**
     * Map holding constants for ScheduleEntryLockWeekDaySetSetAction
     */
    private static Map<Integer, String> constantScheduleEntryLockWeekDaySetSetAction = new HashMap<Integer, String>();

    /**
     * Map holding constants for ScheduleEntryLockEnableAllSetEnabled
     */
    private static Map<Integer, String> constantScheduleEntryLockEnableAllSetEnabled = new HashMap<Integer, String>();

    static {
        // Constants for ScheduleEntryLockYearDaySetSetAction
        constantScheduleEntryLockYearDaySetSetAction.put(0x00, "ERASE");
        constantScheduleEntryLockYearDaySetSetAction.put(0x01, "MODIFY");

        // Constants for ScheduleEntryLockEnableSetEnabled
        constantScheduleEntryLockEnableSetEnabled.put(0x00, "DISABLED");
        constantScheduleEntryLockEnableSetEnabled.put(0x01, "ENABLED");

        // Constants for ScheduleEntryLockWeekDaySetSetAction
        constantScheduleEntryLockWeekDaySetSetAction.put(0x00, "ERASE");
        constantScheduleEntryLockWeekDaySetSetAction.put(0x01, "MODIFY");

        // Constants for ScheduleEntryLockEnableAllSetEnabled
        constantScheduleEntryLockEnableAllSetEnabled.put(0x00, "DISABLED");
        constantScheduleEntryLockEnableAllSetEnabled.put(0x01, "ENABLED");
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_ENABLE_SET command.
     * <p>
     * Schedule Entry Lock Enable Set
     *
     * @param userIdentifier {@link Integer}
     * @param enabled {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>DISABLED
     *            <li>ENABLED
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockEnableSet(Integer userIdentifier, String enabled) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_ENABLE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_ENABLE_SET);

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Enabled'
        boolean foundEnabled = false;
        for (Integer entry : constantScheduleEntryLockEnableSetEnabled.keySet()) {
            if (constantScheduleEntryLockEnableSetEnabled.get(entry).equals(enabled)) {
                outputData.write(entry);
                foundEnabled = true;
                break;
            }
        }
        if (!foundEnabled) {
            throw new IllegalArgumentException("Unknown constant value '" + enabled + "' for enabled");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_ENABLE_SET command.
     * <p>
     * Schedule Entry Lock Enable Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>ENABLED {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>DISABLED
     * <li>ENABLED
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockEnableSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Enabled'
        response.put("ENABLED", constantScheduleEntryLockEnableSetEnabled.get(payload[3] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET command.
     * <p>
     * Schedule Entry Lock Enable All Set
     *
     * @param enabled {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>DISABLED
     *            <li>ENABLED
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockEnableAllSet(String enabled) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET);

        // Process 'Enabled'
        boolean foundEnabled = false;
        for (Integer entry : constantScheduleEntryLockEnableAllSetEnabled.keySet()) {
            if (constantScheduleEntryLockEnableAllSetEnabled.get(entry).equals(enabled)) {
                outputData.write(entry);
                foundEnabled = true;
                break;
            }
        }
        if (!foundEnabled) {
            throw new IllegalArgumentException("Unknown constant value '" + enabled + "' for enabled");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET command.
     * <p>
     * Schedule Entry Lock Enable All Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>ENABLED {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>DISABLED
     * <li>ENABLED
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockEnableAllSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Enabled'
        response.put("ENABLED", constantScheduleEntryLockEnableAllSetEnabled.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET command.
     * <p>
     * Schedule Entry Lock Week Day Set
     *
     * @param setAction {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>ERASE
     *            <li>MODIFY
     *            </ul>
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param dayOfWeek {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockWeekDaySet(String setAction, Integer userIdentifier, Integer scheduleSlotId,
            Integer dayOfWeek, Integer startHour, Integer startMinute, Integer stopHour, Integer stopMinute) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET);

        // Process 'Set Action'
        boolean foundSetAction = false;
        for (Integer entry : constantScheduleEntryLockWeekDaySetSetAction.keySet()) {
            if (constantScheduleEntryLockWeekDaySetSetAction.get(entry).equals(setAction)) {
                outputData.write(entry);
                foundSetAction = true;
                break;
            }
        }
        if (!foundSetAction) {
            throw new IllegalArgumentException("Unknown constant value '" + setAction + "' for setAction");
        }

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Schedule Slot ID'
        outputData.write(scheduleSlotId);

        // Process 'Day of Week'
        outputData.write(dayOfWeek);

        // Process 'Start Hour'
        outputData.write(startHour);

        // Process 'Start Minute'
        outputData.write(startMinute);

        // Process 'Stop Hour'
        outputData.write(stopHour);

        // Process 'Stop Minute'
        outputData.write(stopMinute);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET command.
     * <p>
     * Schedule Entry Lock Week Day Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SET_ACTION {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>ERASE
     * <li>MODIFY
     * </ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>SCHEDULE_SLOT_ID {@link Integer}
     * <li>DAY_OF_WEEK {@link Integer}
     * <li>START_HOUR {@link Integer}
     * <li>START_MINUTE {@link Integer}
     * <li>STOP_HOUR {@link Integer}
     * <li>STOP_MINUTE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockWeekDaySet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Set Action'
        response.put("SET_ACTION", constantScheduleEntryLockWeekDaySetSetAction.get(payload[2] & 0xff));

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[3]));

        // Process 'Schedule Slot ID'
        response.put("SCHEDULE_SLOT_ID", Integer.valueOf(payload[4]));

        // Process 'Day of Week'
        response.put("DAY_OF_WEEK", Integer.valueOf(payload[5]));

        // Process 'Start Hour'
        response.put("START_HOUR", Integer.valueOf(payload[6]));

        // Process 'Start Minute'
        response.put("START_MINUTE", Integer.valueOf(payload[7]));

        // Process 'Stop Hour'
        response.put("STOP_HOUR", Integer.valueOf(payload[8]));

        // Process 'Stop Minute'
        response.put("STOP_MINUTE", Integer.valueOf(payload[9]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET command.
     * <p>
     * Schedule Entry Lock Week Day Get
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockWeekDayGet(Integer userIdentifier, Integer scheduleSlotId) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET);

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Schedule Slot ID'
        outputData.write(scheduleSlotId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET command.
     * <p>
     * Schedule Entry Lock Week Day Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>SCHEDULE_SLOT_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockWeekDayGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Schedule Slot ID'
        response.put("SCHEDULE_SLOT_ID", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT command.
     * <p>
     * Schedule Entry Lock Week Day Report
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param dayOfWeek {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockWeekDayReport(Integer userIdentifier, Integer scheduleSlotId,
            Integer dayOfWeek, Integer startHour, Integer startMinute, Integer stopHour, Integer stopMinute) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT);

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Schedule Slot ID'
        outputData.write(scheduleSlotId);

        // Process 'Day of Week'
        outputData.write(dayOfWeek);

        // Process 'Start Hour'
        outputData.write(startHour);

        // Process 'Start Minute'
        outputData.write(startMinute);

        // Process 'Stop Hour'
        outputData.write(stopHour);

        // Process 'Stop Minute'
        outputData.write(stopMinute);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT command.
     * <p>
     * Schedule Entry Lock Week Day Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>SCHEDULE_SLOT_ID {@link Integer}
     * <li>DAY_OF_WEEK {@link Integer}
     * <li>START_HOUR {@link Integer}
     * <li>START_MINUTE {@link Integer}
     * <li>STOP_HOUR {@link Integer}
     * <li>STOP_MINUTE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockWeekDayReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Schedule Slot ID'
        response.put("SCHEDULE_SLOT_ID", Integer.valueOf(payload[3]));

        // Process 'Day of Week'
        response.put("DAY_OF_WEEK", Integer.valueOf(payload[4]));

        // Process 'Start Hour'
        response.put("START_HOUR", Integer.valueOf(payload[5]));

        // Process 'Start Minute'
        response.put("START_MINUTE", Integer.valueOf(payload[6]));

        // Process 'Stop Hour'
        response.put("STOP_HOUR", Integer.valueOf(payload[7]));

        // Process 'Stop Minute'
        response.put("STOP_MINUTE", Integer.valueOf(payload[8]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET command.
     * <p>
     * Schedule Entry Lock Year Day Set
     *
     * @param setAction {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>ERASE
     *            <li>MODIFY
     *            </ul>
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
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockYearDaySet(String setAction, Integer userIdentifier, Integer scheduleSlotId,
            Integer startYear, Integer startMonth, Integer startDay, Integer startHour, Integer startMinute,
            Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHour, Integer stopMinute) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET);

        // Process 'Set Action'
        boolean foundSetAction = false;
        for (Integer entry : constantScheduleEntryLockYearDaySetSetAction.keySet()) {
            if (constantScheduleEntryLockYearDaySetSetAction.get(entry).equals(setAction)) {
                outputData.write(entry);
                foundSetAction = true;
                break;
            }
        }
        if (!foundSetAction) {
            throw new IllegalArgumentException("Unknown constant value '" + setAction + "' for setAction");
        }

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Schedule Slot ID'
        outputData.write(scheduleSlotId);

        // Process 'Start Year'
        outputData.write(startYear);

        // Process 'Start Month'
        outputData.write(startMonth);

        // Process 'Start Day'
        outputData.write(startDay);

        // Process 'Start Hour'
        outputData.write(startHour);

        // Process 'Start Minute'
        outputData.write(startMinute);

        // Process 'Stop Year'
        outputData.write(stopYear);

        // Process 'Stop Month'
        outputData.write(stopMonth);

        // Process 'Stop Day'
        outputData.write(stopDay);

        // Process 'Stop Hour'
        outputData.write(stopHour);

        // Process 'Stop Minute'
        outputData.write(stopMinute);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET command.
     * <p>
     * Schedule Entry Lock Year Day Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SET_ACTION {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>ERASE
     * <li>MODIFY
     * </ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>SCHEDULE_SLOT_ID {@link Integer}
     * <li>START_YEAR {@link Integer}
     * <li>START_MONTH {@link Integer}
     * <li>START_DAY {@link Integer}
     * <li>START_HOUR {@link Integer}
     * <li>START_MINUTE {@link Integer}
     * <li>STOP_YEAR {@link Integer}
     * <li>STOP_MONTH {@link Integer}
     * <li>STOP_DAY {@link Integer}
     * <li>STOP_HOUR {@link Integer}
     * <li>STOP_MINUTE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockYearDaySet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Set Action'
        response.put("SET_ACTION", constantScheduleEntryLockYearDaySetSetAction.get(payload[2] & 0xff));

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[3]));

        // Process 'Schedule Slot ID'
        response.put("SCHEDULE_SLOT_ID", Integer.valueOf(payload[4]));

        // Process 'Start Year'
        response.put("START_YEAR", Integer.valueOf(payload[5]));

        // Process 'Start Month'
        response.put("START_MONTH", Integer.valueOf(payload[6]));

        // Process 'Start Day'
        response.put("START_DAY", Integer.valueOf(payload[7]));

        // Process 'Start Hour'
        response.put("START_HOUR", Integer.valueOf(payload[8]));

        // Process 'Start Minute'
        response.put("START_MINUTE", Integer.valueOf(payload[9]));

        // Process 'Stop Year'
        response.put("STOP_YEAR", Integer.valueOf(payload[10]));

        // Process 'Stop Month'
        response.put("STOP_MONTH", Integer.valueOf(payload[11]));

        // Process 'Stop Day'
        response.put("STOP_DAY", Integer.valueOf(payload[12]));

        // Process 'Stop Hour'
        response.put("STOP_HOUR", Integer.valueOf(payload[13]));

        // Process 'Stop Minute'
        response.put("STOP_MINUTE", Integer.valueOf(payload[14]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET command.
     * <p>
     * Schedule Entry Lock Year Day Get
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockYearDayGet(Integer userIdentifier, Integer scheduleSlotId) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET);

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Schedule Slot ID'
        outputData.write(scheduleSlotId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET command.
     * <p>
     * Schedule Entry Lock Year Day Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>SCHEDULE_SLOT_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockYearDayGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Schedule Slot ID'
        response.put("SCHEDULE_SLOT_ID", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT command.
     * <p>
     * Schedule Entry Lock Year Day Report
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
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockYearDayReport(Integer userIdentifier, Integer scheduleSlotId,
            Integer startYear, Integer startMonth, Integer startDay, Integer startHour, Integer startMinute,
            Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHour, Integer stopMinute) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT);

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Schedule Slot ID'
        outputData.write(scheduleSlotId);

        // Process 'Start Year'
        outputData.write(startYear);

        // Process 'Start Month'
        outputData.write(startMonth);

        // Process 'Start Day'
        outputData.write(startDay);

        // Process 'Start Hour'
        outputData.write(startHour);

        // Process 'Start Minute'
        outputData.write(startMinute);

        // Process 'Stop Year'
        outputData.write(stopYear);

        // Process 'Stop Month'
        outputData.write(stopMonth);

        // Process 'Stop Day'
        outputData.write(stopDay);

        // Process 'Stop Hour'
        outputData.write(stopHour);

        // Process 'Stop Minute'
        outputData.write(stopMinute);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT command.
     * <p>
     * Schedule Entry Lock Year Day Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>SCHEDULE_SLOT_ID {@link Integer}
     * <li>START_YEAR {@link Integer}
     * <li>START_MONTH {@link Integer}
     * <li>START_DAY {@link Integer}
     * <li>START_HOUR {@link Integer}
     * <li>START_MINUTE {@link Integer}
     * <li>STOP_YEAR {@link Integer}
     * <li>STOP_MONTH {@link Integer}
     * <li>STOP_DAY {@link Integer}
     * <li>STOP_HOUR {@link Integer}
     * <li>STOP_MINUTE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockYearDayReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'User Identifier'
        response.put("USER_IDENTIFIER", Integer.valueOf(payload[2]));

        // Process 'Schedule Slot ID'
        response.put("SCHEDULE_SLOT_ID", Integer.valueOf(payload[3]));

        // Process 'Start Year'
        response.put("START_YEAR", Integer.valueOf(payload[4]));

        // Process 'Start Month'
        response.put("START_MONTH", Integer.valueOf(payload[5]));

        // Process 'Start Day'
        response.put("START_DAY", Integer.valueOf(payload[6]));

        // Process 'Start Hour'
        response.put("START_HOUR", Integer.valueOf(payload[7]));

        // Process 'Start Minute'
        response.put("START_MINUTE", Integer.valueOf(payload[8]));

        // Process 'Stop Year'
        response.put("STOP_YEAR", Integer.valueOf(payload[9]));

        // Process 'Stop Month'
        response.put("STOP_MONTH", Integer.valueOf(payload[10]));

        // Process 'Stop Day'
        response.put("STOP_DAY", Integer.valueOf(payload[11]));

        // Process 'Stop Hour'
        response.put("STOP_HOUR", Integer.valueOf(payload[12]));

        // Process 'Stop Minute'
        response.put("STOP_MINUTE", Integer.valueOf(payload[13]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_TYPE_SUPPORTED_GET command.
     * <p>
     * Schedule Entry Type Supported Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryTypeSupportedGet() {
        logger.debug("Creating command message SCHEDULE_ENTRY_TYPE_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_TYPE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_TYPE_SUPPORTED_GET command.
     * <p>
     * Schedule Entry Type Supported Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryTypeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT command.
     * <p>
     * Schedule Entry Type Supported Report
     *
     * @param numberOfSlotsWeekDay {@link Integer}
     * @param numberOfSlotsYearDay {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryTypeSupportedReport(Integer numberOfSlotsWeekDay, Integer numberOfSlotsYearDay) {
        logger.debug("Creating command message SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT);

        // Process 'Number of Slots Week Day'
        outputData.write(numberOfSlotsWeekDay);

        // Process 'Number of Slots Year Day'
        outputData.write(numberOfSlotsYearDay);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT command.
     * <p>
     * Schedule Entry Type Supported Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>NUMBER_OF_SLOTS_WEEK_DAY {@link Integer}
     * <li>NUMBER_OF_SLOTS_YEAR_DAY {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryTypeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Number of Slots Week Day'
        response.put("NUMBER_OF_SLOTS_WEEK_DAY", Integer.valueOf(payload[2]));

        // Process 'Number of Slots Year Day'
        response.put("NUMBER_OF_SLOTS_YEAR_DAY", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }
}
