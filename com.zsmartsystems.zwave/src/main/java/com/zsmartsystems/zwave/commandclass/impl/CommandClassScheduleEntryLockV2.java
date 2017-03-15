/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCHEDULE_ENTRY_LOCK</b> version <b>2</b>.<br>
 *
 * Command Class Schedule Entry Lock<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassScheduleEntryLockV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassScheduleEntryLockV2.class);

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
     * Schedule Entry Lock Time Offset Get Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_TIME_OFFSET_GET = 0x0B;
    /**
     * Schedule Entry Lock Time Offset Report Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_TIME_OFFSET_REPORT = 0x0C;
    /**
     * Schedule Entry Lock Time Offset Set Command Constant
     */
    public final static int SCHEDULE_ENTRY_LOCK_TIME_OFFSET_SET = 0x0D;

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_ENABLE_SET command.<br>
     *
     * Schedule Entry Lock Enable Set<br>
     *
     *
     * @param userIdentifier {@link Integer}
     * @param enabled {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockEnableSet(Integer userIdentifier, Integer enabled) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_ENABLE_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_ENABLE_SET);

        // Process 'User Identifier'
        outputData.write(userIdentifier);

        // Process 'Enabled'
        outputData.write(enabled);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_ENABLE_SET command<br>
     *
     * Schedule Entry Lock Enable Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>USER_IDENTIFIER {@link Integer}
     * <li>ENABLED {@link Integer}
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
        switch ((int) payload[3]) {
            case 0x00:
                response.put("ENABLED", "DISABLED");
                break;
            case 0x01:
                response.put("ENABLED", "ENABLED");
                break;
            default:
                logger.debug("");
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET command.<br>
     *
     * Schedule Entry Lock Enable All Set<br>
     *
     *
     * @param enabled {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockEnableAllSet(Integer enabled) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET);

        // Process 'Enabled'
        outputData.write(enabled);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_ENABLE_ALL_SET command<br>
     *
     * Schedule Entry Lock Enable All Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ENABLED {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockEnableAllSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Enabled'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("ENABLED", "DISABLED");
                break;
            case 0x01:
                response.put("ENABLED", "ENABLED");
                break;
            default:
                logger.debug("");
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET command.<br>
     *
     * Schedule Entry Lock Week Day Set<br>
     *
     *
     * @param setAction {@link Integer}
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @param dayOfWeek {@link Integer}
     * @param startHour {@link Integer}
     * @param startMinute {@link Integer}
     * @param stopHour {@link Integer}
     * @param stopMinute {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockWeekDaySet(Integer setAction, Integer userIdentifier,
            Integer scheduleSlotId, Integer dayOfWeek, Integer startHour, Integer startMinute, Integer stopHour,
            Integer stopMinute) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET);

        // Process 'Set Action'
        outputData.write(setAction);

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
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_SET command<br>
     *
     * Schedule Entry Lock Week Day Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SET_ACTION {@link Integer}
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
        switch ((int) payload[2]) {
            case 0x00:
                response.put("SET_ACTION", "ERASE");
                break;
            case 0x01:
                response.put("SET_ACTION", "MODIFY");
                break;
            default:
                logger.debug("");
                break;
        }

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
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET command.<br>
     *
     * Schedule Entry Lock Week Day Get<br>
     *
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockWeekDayGet(Integer userIdentifier, Integer scheduleSlotId) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET version 2");

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
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_GET command<br>
     *
     * Schedule Entry Lock Week Day Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
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
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT command.<br>
     *
     * Schedule Entry Lock Week Day Report<br>
     *
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
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT version 2");

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
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_WEEK_DAY_REPORT command<br>
     *
     * Schedule Entry Lock Week Day Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
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
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET command.<br>
     *
     * Schedule Entry Lock Year Day Set<br>
     *
     *
     * @param setAction {@link Integer}
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
    static public byte[] getScheduleEntryLockYearDaySet(Integer setAction, Integer userIdentifier,
            Integer scheduleSlotId, Integer startYear, Integer startMonth, Integer startDay, Integer startHour,
            Integer startMinute, Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHour,
            Integer stopMinute) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET);

        // Process 'Set Action'
        outputData.write(setAction);

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
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_SET command<br>
     *
     * Schedule Entry Lock Year Day Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SET_ACTION {@link Integer}
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
        switch ((int) payload[2]) {
            case 0x00:
                response.put("SET_ACTION", "ERASE");
                break;
            case 0x01:
                response.put("SET_ACTION", "MODIFY");
                break;
            default:
                logger.debug("");
                break;
        }

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
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET command.<br>
     *
     * Schedule Entry Lock Year Day Get<br>
     *
     *
     * @param userIdentifier {@link Integer}
     * @param scheduleSlotId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockYearDayGet(Integer userIdentifier, Integer scheduleSlotId) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET version 2");

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
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_GET command<br>
     *
     * Schedule Entry Lock Year Day Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
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
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT command.<br>
     *
     * Schedule Entry Lock Year Day Report<br>
     *
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
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT version 2");

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
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_YEAR_DAY_REPORT command<br>
     *
     * Schedule Entry Lock Year Day Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
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
     * Creates a new message with the SCHEDULE_ENTRY_TYPE_SUPPORTED_GET command.<br>
     *
     * Schedule Entry Type Supported Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryTypeSupportedGet() {
        logger.debug("Creating command message SCHEDULE_ENTRY_TYPE_SUPPORTED_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_TYPE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_TYPE_SUPPORTED_GET command<br>
     *
     * Schedule Entry Type Supported Get<br>
     *
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
     * Creates a new message with the SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT command.<br>
     *
     * Schedule Entry Type Supported Report<br>
     *
     *
     * @param numberOfSlotsWeekDay {@link Integer}
     * @param numberOfSlotsYearDay {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryTypeSupportedReport(Integer numberOfSlotsWeekDay, Integer numberOfSlotsYearDay) {
        logger.debug("Creating command message SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT version 2");

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
     * Processes a received frame with the SCHEDULE_ENTRY_TYPE_SUPPORTED_REPORT command<br>
     *
     * Schedule Entry Type Supported Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
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

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_TIME_OFFSET_GET command.<br>
     *
     * Schedule Entry Lock Time Offset Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockTimeOffsetGet() {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_TIME_OFFSET_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_TIME_OFFSET_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_TIME_OFFSET_GET command<br>
     *
     * Schedule Entry Lock Time Offset Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockTimeOffsetGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_TIME_OFFSET_REPORT command.<br>
     *
     * Schedule Entry Lock Time Offset Report<br>
     *
     *
     * @param hourTzo {@link Integer}
     * @param signTzo {@link Boolean}
     * @param minuteTzo {@link Integer}
     * @param minuteOffsetDst {@link Integer}
     * @param signOffsetDst {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockTimeOffsetReport(Integer hourTzo, Boolean signTzo, Integer minuteTzo,
            Integer minuteOffsetDst, Boolean signOffsetDst) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_TIME_OFFSET_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_TIME_OFFSET_REPORT);

        // Process 'Level'
        int valLevel = 0;
        valLevel |= hourTzo & 0x7F;
        valLevel |= signTzo ? 0x80 : 0;
        outputData.write(valLevel);

        // Process 'Minute TZO'
        outputData.write(minuteTzo);

        // Process 'Level2'
        int valLevel2 = 0;
        valLevel2 |= minuteOffsetDst & 0x7F;
        valLevel2 |= signOffsetDst ? 0x80 : 0;
        outputData.write(valLevel2);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_TIME_OFFSET_REPORT command<br>
     *
     * Schedule Entry Lock Time Offset Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>HOUR_TZO {@link Integer}
     * <li>SIGN_TZO {@link Boolean}
     * <li>MINUTE_TZO {@link Integer}
     * <li>MINUTE_OFFSET_DST {@link Integer}
     * <li>SIGN_OFFSET_DST {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockTimeOffsetReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("HOUR_TZO", Integer.valueOf(payload[2] & 0x7F));
        response.put("SIGN_TZO", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Minute TZO'
        response.put("MINUTE_TZO", Integer.valueOf(payload[3]));

        // Process 'Level2'
        response.put("MINUTE_OFFSET_DST", Integer.valueOf(payload[4] & 0x7F));
        response.put("SIGN_OFFSET_DST", Boolean.valueOf((payload[4] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_ENTRY_LOCK_TIME_OFFSET_SET command.<br>
     *
     * Schedule Entry Lock Time Offset Set<br>
     *
     *
     * @param hourTzo {@link Integer}
     * @param signTzo {@link Boolean}
     * @param minuteTzo {@link Integer}
     * @param minuteOffsetDst {@link Integer}
     * @param signOffsetDst {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleEntryLockTimeOffsetSet(Integer hourTzo, Boolean signTzo, Integer minuteTzo,
            Integer minuteOffsetDst, Boolean signOffsetDst) {
        logger.debug("Creating command message SCHEDULE_ENTRY_LOCK_TIME_OFFSET_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_ENTRY_LOCK_TIME_OFFSET_SET);

        // Process 'Level'
        int valLevel = 0;
        valLevel |= hourTzo & 0x7F;
        valLevel |= signTzo ? 0x80 : 0;
        outputData.write(valLevel);

        // Process 'Minute TZO'
        outputData.write(minuteTzo);

        // Process 'Level2'
        int valLevel2 = 0;
        valLevel2 |= minuteOffsetDst & 0x7F;
        valLevel2 |= signOffsetDst ? 0x80 : 0;
        outputData.write(valLevel2);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_ENTRY_LOCK_TIME_OFFSET_SET command<br>
     *
     * Schedule Entry Lock Time Offset Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>HOUR_TZO {@link Integer}
     * <li>SIGN_TZO {@link Boolean}
     * <li>MINUTE_TZO {@link Integer}
     * <li>MINUTE_OFFSET_DST {@link Integer}
     * <li>SIGN_OFFSET_DST {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleEntryLockTimeOffsetSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("HOUR_TZO", Integer.valueOf(payload[2] & 0x7F));
        response.put("SIGN_TZO", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Minute TZO'
        response.put("MINUTE_TZO", Integer.valueOf(payload[3]));

        // Process 'Level2'
        response.put("MINUTE_OFFSET_DST", Integer.valueOf(payload[4] & 0x7F));
        response.put("SIGN_OFFSET_DST", Boolean.valueOf((payload[4] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }

}
