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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_TARIFF_TBL_MONITOR</b> version <b>1</b>.
 * <p>
 * Command Class Tariff Tbl Monitor
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x4B.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassTariffTblMonitorV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassTariffTblMonitorV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_TARIFF_TBL_MONITOR
     */
    public final static int COMMAND_CLASS_KEY = 0x4B;

    /**
     * Tariff Tbl Supplier Get Command Constant
     */
    public final static int TARIFF_TBL_SUPPLIER_GET = 0x01;
    /**
     * Tariff Tbl Supplier Report Command Constant
     */
    public final static int TARIFF_TBL_SUPPLIER_REPORT = 0x02;
    /**
     * Tariff Tbl Get Command Constant
     */
    public final static int TARIFF_TBL_GET = 0x03;
    /**
     * Tariff Tbl Report Command Constant
     */
    public final static int TARIFF_TBL_REPORT = 0x04;
    /**
     * Tariff Tbl Cost Get Command Constant
     */
    public final static int TARIFF_TBL_COST_GET = 0x05;
    /**
     * Tariff Tbl Cost Report Command Constant
     */
    public final static int TARIFF_TBL_COST_REPORT = 0x06;


    /**
     * Creates a new message with the TARIFF_TBL_SUPPLIER_GET command.
     * <p>
     * Tariff Tbl Supplier Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblSupplierGet() {
        logger.debug("Creating command message TARIFF_TBL_SUPPLIER_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_SUPPLIER_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_SUPPLIER_GET command.
     * <p>
     * Tariff Tbl Supplier Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblSupplierGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_SUPPLIER_REPORT command.
     * <p>
     * Tariff Tbl Supplier Report
     *
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourLocalTime {@link Integer}
     * @param minuteLocalTime {@link Integer}
     * @param secondLocalTime {@link Integer}
     * @param standingChargePeriod {@link Integer}
     * @param standingChargePrecision {@link Integer}
     * @param standingChargeValue {@link Long}
     * @param supplierCharacter {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblSupplierReport(Integer year, Integer month, Integer day, Integer hourLocalTime,
            Integer minuteLocalTime, Integer secondLocalTime, Integer standingChargePeriod,
            Integer standingChargePrecision, Long standingChargeValue, byte[] supplierCharacter) {
        logger.debug("Creating command message TARIFF_TBL_SUPPLIER_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_SUPPLIER_REPORT);

        // Process 'Year'
        outputData.write((year >> 8) & 0xff);
        outputData.write(year & 0xff);

        // Process 'Month'
        outputData.write(month);

        // Process 'Day'
        outputData.write(day);

        // Process 'Hour Local Time'
        outputData.write(hourLocalTime);

        // Process 'Minute Local Time'
        outputData.write(minuteLocalTime);

        // Process 'Second Local Time'
        outputData.write(secondLocalTime);

        // Process 'Currency'

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= standingChargePeriod & 0x1F;
        valProperties1 |= ((standingChargePrecision << 5) & 0xE0);
        outputData.write(valProperties1);

        // Process 'Standing Charge Value'
        outputData.write((byte) ((standingChargeValue >> 24) & 0xff));
        outputData.write((byte) ((standingChargeValue >> 16) & 0xff));
        outputData.write((byte) ((standingChargeValue >> 8) & 0xff));
        outputData.write((byte) (standingChargeValue & 0xff));

        // Process 'Properties2'
        // Number of Supplier Characters is used by 'Supplier Character'
        int numberOfSupplierCharacters = supplierCharacter.length;
        outputData.write(numberOfSupplierCharacters & 0x1F);

        // Process 'Supplier Character'
        if (supplierCharacter != null) {
            try {
                outputData.write(supplierCharacter);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_SUPPLIER_REPORT command.
     * <p>
     * Tariff Tbl Supplier Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>YEAR {@link Integer}
     * <li>MONTH {@link Integer}
     * <li>DAY {@link Integer}
     * <li>HOUR_LOCAL_TIME {@link Integer}
     * <li>MINUTE_LOCAL_TIME {@link Integer}
     * <li>SECOND_LOCAL_TIME {@link Integer}
     * <li>STANDING_CHARGE_PERIOD {@link Integer}
     * <li>STANDING_CHARGE_PRECISION {@link Integer}
     * <li>STANDING_CHARGE_VALUE {@link Long}
     * <li>SUPPLIER_CHARACTER {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblSupplierReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Year'
        response.put("YEAR", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Process 'Month'
        response.put("MONTH", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Day'
        response.put("DAY", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Hour Local Time'
        response.put("HOUR_LOCAL_TIME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Minute Local Time'
        response.put("MINUTE_LOCAL_TIME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Second Local Time'
        response.put("SECOND_LOCAL_TIME", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Currency'
        msgOffset += 3;

        // Process 'Properties1'
        response.put("STANDING_CHARGE_PERIOD", Integer.valueOf(payload[msgOffset] & 0x1F));
        response.put("STANDING_CHARGE_PRECISION", Integer.valueOf(payload[msgOffset] & 0xE0 >> 5));
        msgOffset += 1;

        // Process 'Standing Charge Value'
        response.put("STANDING_CHARGE_VALUE", Long.valueOf((payload[msgOffset] << 24) + (payload[msgOffset + 1] << 16) + (payload[msgOffset + 2] << 8) + payload[msgOffset + 3]));
        msgOffset += 4;

        // Process 'Properties2'
        // Number of Supplier Characters is used by 'Supplier Character'
        int varNumberOfSupplierCharacters = payload[msgOffset] & 0x1F;
        msgOffset += 1;

        // Process 'Supplier Character'
        ByteArrayOutputStream valSupplierCharacter = new ByteArrayOutputStream();
        for (int cntSupplierCharacter = 0; cntSupplierCharacter < varNumberOfSupplierCharacters; cntSupplierCharacter++) {
            valSupplierCharacter.write(payload[msgOffset + cntSupplierCharacter]);
        }
        response.put("SUPPLIER_CHARACTER", valSupplierCharacter.toByteArray());
        msgOffset += varNumberOfSupplierCharacters;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_GET command.
     * <p>
     * Tariff Tbl Get
     *
     * @param rateParameterSetId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblGet(Integer rateParameterSetId) {
        logger.debug("Creating command message TARIFF_TBL_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_GET);

        // Process 'Rate Parameter Set ID'
        outputData.write(rateParameterSetId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_GET command.
     * <p>
     * Tariff Tbl Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>RATE_PARAMETER_SET_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Rate Parameter Set ID'
        response.put("RATE_PARAMETER_SET_ID", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_REPORT command.
     * <p>
     * Tariff Tbl Report
     *
     * @param rateParameterSetId {@link Integer}
     * @param tariffPrecision {@link Integer}
     * @param tariffValue {@link Long}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblReport(Integer rateParameterSetId, Integer tariffPrecision, Long tariffValue) {
        logger.debug("Creating command message TARIFF_TBL_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_REPORT);

        // Process 'Rate Parameter Set ID'
        outputData.write(rateParameterSetId);

        // Process 'Properties1'
        outputData.write(((tariffPrecision << 5) & 0xE0));

        // Process 'Tariff Value'
        outputData.write((byte) ((tariffValue >> 24) & 0xff));
        outputData.write((byte) ((tariffValue >> 16) & 0xff));
        outputData.write((byte) ((tariffValue >> 8) & 0xff));
        outputData.write((byte) (tariffValue & 0xff));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_REPORT command.
     * <p>
     * Tariff Tbl Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>RATE_PARAMETER_SET_ID {@link Integer}
     * <li>TARIFF_PRECISION {@link Integer}
     * <li>TARIFF_VALUE {@link Long}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Rate Parameter Set ID'
        response.put("RATE_PARAMETER_SET_ID", Integer.valueOf(payload[2]));

        // Process 'Properties1'
        response.put("TARIFF_PRECISION", Integer.valueOf(payload[3] & 0xE0 >> 5));

        // Process 'Tariff Value'
        response.put("TARIFF_VALUE", Long.valueOf((payload[4] << 24) + (payload[5] << 16) + (payload[6] << 8) + payload[7]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_COST_GET command.
     * <p>
     * Tariff Tbl Cost Get
     *
     * @param rateParameterSetId {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHourLocalTime {@link Integer}
     * @param startMinuteLocalTime {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHourLocalTime {@link Integer}
     * @param stopMinuteLocalTime {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblCostGet(Integer rateParameterSetId, Integer startYear, Integer startMonth,
            Integer startDay, Integer startHourLocalTime, Integer startMinuteLocalTime, Integer stopYear,
            Integer stopMonth, Integer stopDay, Integer stopHourLocalTime, Integer stopMinuteLocalTime) {
        logger.debug("Creating command message TARIFF_TBL_COST_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_COST_GET);

        // Process 'Rate Parameter Set ID'
        outputData.write(rateParameterSetId);

        // Process 'Start Year'
        outputData.write((startYear >> 8) & 0xff);
        outputData.write(startYear & 0xff);

        // Process 'Start Month'
        outputData.write(startMonth);

        // Process 'Start Day'
        outputData.write(startDay);

        // Process 'Start Hour Local Time'
        outputData.write(startHourLocalTime);

        // Process 'Start Minute Local Time'
        outputData.write(startMinuteLocalTime);

        // Process 'Stop Year'
        outputData.write((stopYear >> 8) & 0xff);
        outputData.write(stopYear & 0xff);

        // Process 'Stop Month'
        outputData.write(stopMonth);

        // Process 'Stop Day'
        outputData.write(stopDay);

        // Process 'Stop Hour Local Time'
        outputData.write(stopHourLocalTime);

        // Process 'Stop Minute Local Time'
        outputData.write(stopMinuteLocalTime);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_COST_GET command.
     * <p>
     * Tariff Tbl Cost Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>RATE_PARAMETER_SET_ID {@link Integer}
     * <li>START_YEAR {@link Integer}
     * <li>START_MONTH {@link Integer}
     * <li>START_DAY {@link Integer}
     * <li>START_HOUR_LOCAL_TIME {@link Integer}
     * <li>START_MINUTE_LOCAL_TIME {@link Integer}
     * <li>STOP_YEAR {@link Integer}
     * <li>STOP_MONTH {@link Integer}
     * <li>STOP_DAY {@link Integer}
     * <li>STOP_HOUR_LOCAL_TIME {@link Integer}
     * <li>STOP_MINUTE_LOCAL_TIME {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblCostGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Rate Parameter Set ID'
        response.put("RATE_PARAMETER_SET_ID", Integer.valueOf(payload[2]));

        // Process 'Start Year'
        response.put("START_YEAR", Integer.valueOf(((payload[3] & 0xff) << 8) + (payload[4] & 0xff)));

        // Process 'Start Month'
        response.put("START_MONTH", Integer.valueOf(payload[5]));

        // Process 'Start Day'
        response.put("START_DAY", Integer.valueOf(payload[6]));

        // Process 'Start Hour Local Time'
        response.put("START_HOUR_LOCAL_TIME", Integer.valueOf(payload[7]));

        // Process 'Start Minute Local Time'
        response.put("START_MINUTE_LOCAL_TIME", Integer.valueOf(payload[8]));

        // Process 'Stop Year'
        response.put("STOP_YEAR", Integer.valueOf(((payload[9] & 0xff) << 8) + (payload[10] & 0xff)));

        // Process 'Stop Month'
        response.put("STOP_MONTH", Integer.valueOf(payload[11]));

        // Process 'Stop Day'
        response.put("STOP_DAY", Integer.valueOf(payload[12]));

        // Process 'Stop Hour Local Time'
        response.put("STOP_HOUR_LOCAL_TIME", Integer.valueOf(payload[13]));

        // Process 'Stop Minute Local Time'
        response.put("STOP_MINUTE_LOCAL_TIME", Integer.valueOf(payload[14]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the TARIFF_TBL_COST_REPORT command.
     * <p>
     * Tariff Tbl Cost Report
     *
     * @param rateParameterSetId {@link Integer}
     * @param rateType {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHourLocalTime {@link Integer}
     * @param startMinuteLocalTime {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHourLocalTime {@link Integer}
     * @param stopMinuteLocalTime {@link Integer}
     * @param costPrecision {@link Integer}
     * @param costValue {@link Long}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getTariffTblCostReport(Integer rateParameterSetId, Integer rateType, Integer startYear,
            Integer startMonth, Integer startDay, Integer startHourLocalTime, Integer startMinuteLocalTime,
            Integer stopYear, Integer stopMonth, Integer stopDay, Integer stopHourLocalTime, Integer stopMinuteLocalTime,
            Integer costPrecision, Long costValue) {
        logger.debug("Creating command message TARIFF_TBL_COST_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(TARIFF_TBL_COST_REPORT);

        // Process 'Rate Parameter Set ID'
        outputData.write(rateParameterSetId);

        // Process 'Properties1'
        outputData.write(rateType & 0x03);

        // Process 'Start Year'
        outputData.write((startYear >> 8) & 0xff);
        outputData.write(startYear & 0xff);

        // Process 'Start Month'
        outputData.write(startMonth);

        // Process 'Start Day'
        outputData.write(startDay);

        // Process 'Start Hour Local Time'
        outputData.write(startHourLocalTime);

        // Process 'Start Minute Local Time'
        outputData.write(startMinuteLocalTime);

        // Process 'Stop Year'
        outputData.write((stopYear >> 8) & 0xff);
        outputData.write(stopYear & 0xff);

        // Process 'Stop Month'
        outputData.write(stopMonth);

        // Process 'Stop Day'
        outputData.write(stopDay);

        // Process 'Stop Hour Local Time'
        outputData.write(stopHourLocalTime);

        // Process 'Stop Minute Local Time'
        outputData.write(stopMinuteLocalTime);

        // Process 'Currency'

        // Process 'Properties2'
        outputData.write(((costPrecision << 5) & 0xE0));

        // Process 'Cost Value'
        outputData.write((byte) ((costValue >> 24) & 0xff));
        outputData.write((byte) ((costValue >> 16) & 0xff));
        outputData.write((byte) ((costValue >> 8) & 0xff));
        outputData.write((byte) (costValue & 0xff));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the TARIFF_TBL_COST_REPORT command.
     * <p>
     * Tariff Tbl Cost Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>RATE_PARAMETER_SET_ID {@link Integer}
     * <li>RATE_TYPE {@link Integer}
     * <li>START_YEAR {@link Integer}
     * <li>START_MONTH {@link Integer}
     * <li>START_DAY {@link Integer}
     * <li>START_HOUR_LOCAL_TIME {@link Integer}
     * <li>START_MINUTE_LOCAL_TIME {@link Integer}
     * <li>STOP_YEAR {@link Integer}
     * <li>STOP_MONTH {@link Integer}
     * <li>STOP_DAY {@link Integer}
     * <li>STOP_HOUR_LOCAL_TIME {@link Integer}
     * <li>STOP_MINUTE_LOCAL_TIME {@link Integer}
     * <li>COST_PRECISION {@link Integer}
     * <li>COST_VALUE {@link Long}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleTariffTblCostReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Rate Parameter Set ID'
        response.put("RATE_PARAMETER_SET_ID", Integer.valueOf(payload[2]));

        // Process 'Properties1'
        response.put("RATE_TYPE", Integer.valueOf(payload[3] & 0x03));

        // Process 'Start Year'
        response.put("START_YEAR", Integer.valueOf(((payload[4] & 0xff) << 8) + (payload[5] & 0xff)));

        // Process 'Start Month'
        response.put("START_MONTH", Integer.valueOf(payload[6]));

        // Process 'Start Day'
        response.put("START_DAY", Integer.valueOf(payload[7]));

        // Process 'Start Hour Local Time'
        response.put("START_HOUR_LOCAL_TIME", Integer.valueOf(payload[8]));

        // Process 'Start Minute Local Time'
        response.put("START_MINUTE_LOCAL_TIME", Integer.valueOf(payload[9]));

        // Process 'Stop Year'
        response.put("STOP_YEAR", Integer.valueOf(((payload[10] & 0xff) << 8) + (payload[11] & 0xff)));

        // Process 'Stop Month'
        response.put("STOP_MONTH", Integer.valueOf(payload[12]));

        // Process 'Stop Day'
        response.put("STOP_DAY", Integer.valueOf(payload[13]));

        // Process 'Stop Hour Local Time'
        response.put("STOP_HOUR_LOCAL_TIME", Integer.valueOf(payload[14]));

        // Process 'Stop Minute Local Time'
        response.put("STOP_MINUTE_LOCAL_TIME", Integer.valueOf(payload[15]));

        // Process 'Currency'

        // Process 'Properties2'
        response.put("COST_PRECISION", Integer.valueOf(payload[19] & 0xE0 >> 5));

        // Process 'Cost Value'
        response.put("COST_VALUE", Long.valueOf((payload[20] << 24) + (payload[21] << 16) + (payload[22] << 8) + payload[23]));

        // Return the map of processed response data;
        return response;
    }
}
