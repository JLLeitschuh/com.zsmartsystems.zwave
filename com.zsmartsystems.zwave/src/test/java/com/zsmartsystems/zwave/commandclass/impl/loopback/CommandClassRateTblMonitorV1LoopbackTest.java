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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassRateTblMonitorV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_RATE_TBL_MONITOR</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassRateTblMonitorV1LoopbackTest {
    /**
     * Performs an in/out test of the RATE_TBL_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param ratesSupported {@link Integer}
     * @param parameterSetSupportedBitMask {@link Integer}
     */
    public static void testRateTblSupportedReportLoopback(Integer ratesSupported, Integer parameterSetSupportedBitMask) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblSupportedReport(ratesSupported,
                parameterSetSupportedBitMask);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblSupportedReport(testPayload);
        assertEquals(ratesSupported, (Integer) response.get("RATES_SUPPORTED"));
        assertEquals(parameterSetSupportedBitMask, (Integer) response.get("PARAMETER_SET_SUPPORTED_BIT_MASK"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     */
    public static void testRateTblGetLoopback(Integer rateParameterSetId) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblGet(rateParameterSetId);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblGet(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     * @param rateType {@link Integer}
     * @param rateCharacter {@link byte[]}
     * @param startHourLocalTime {@link Integer}
     * @param startMinuteLocalTime {@link Integer}
     * @param durationMinute {@link Integer}
     * @param consumptionScale {@link Integer}
     * @param consumptionPrecision {@link Integer}
     * @param minConsumptionValue {@link Long}
     * @param maxConsumptionValue {@link Long}
     * @param maxDemandScale {@link Integer}
     * @param maxDemandPrecision {@link Integer}
     * @param maxDemandValue {@link Long}
     * @param dcpRateId {@link Integer}
     */
    public static void testRateTblReportLoopback(Integer rateParameterSetId, Integer rateType, byte[] rateCharacter,
            Integer startHourLocalTime, Integer startMinuteLocalTime, Integer durationMinute, Integer consumptionScale,
            Integer consumptionPrecision, Long minConsumptionValue, Long maxConsumptionValue, Integer maxDemandScale,
            Integer maxDemandPrecision, Long maxDemandValue, Integer dcpRateId) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblReport(rateParameterSetId, rateType, rateCharacter,
                startHourLocalTime, startMinuteLocalTime, durationMinute, consumptionScale, consumptionPrecision,
                minConsumptionValue, maxConsumptionValue, maxDemandScale, maxDemandPrecision, maxDemandValue, dcpRateId);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblReport(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(rateType, (Integer) response.get("RATE_TYPE"));
        assertEquals(rateCharacter, (byte[]) response.get("RATE_CHARACTER"));
        assertEquals(startHourLocalTime, (Integer) response.get("START_HOUR_LOCAL_TIME"));
        assertEquals(startMinuteLocalTime, (Integer) response.get("START_MINUTE_LOCAL_TIME"));
        assertEquals(durationMinute, (Integer) response.get("DURATION_MINUTE"));
        assertEquals(consumptionScale, (Integer) response.get("CONSUMPTION_SCALE"));
        assertEquals(consumptionPrecision, (Integer) response.get("CONSUMPTION_PRECISION"));
        assertEquals(minConsumptionValue, (Long) response.get("MIN_CONSUMPTION_VALUE"));
        assertEquals(maxConsumptionValue, (Long) response.get("MAX_CONSUMPTION_VALUE"));
        assertEquals(maxDemandScale, (Integer) response.get("MAX_DEMAND_SCALE"));
        assertEquals(maxDemandPrecision, (Integer) response.get("MAX_DEMAND_PRECISION"));
        assertEquals(maxDemandValue, (Long) response.get("MAX_DEMAND_VALUE"));
        assertEquals(dcpRateId, (Integer) response.get("DCP_RATE_ID"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_ACTIVE_RATE_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     */
    public static void testRateTblActiveRateReportLoopback(Integer rateParameterSetId) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblActiveRateReport(rateParameterSetId);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblActiveRateReport(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_CURRENT_DATA_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param rateParameterSetId {@link Integer}
     */
    public static void testRateTblCurrentDataGetLoopback(Integer rateParameterSetId) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblCurrentDataGet(rateParameterSetId);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblCurrentDataGet(testPayload);
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_CURRENT_DATA_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param reportsToFollow {@link Integer}
     * @param rateParameterSetId {@link Integer}
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourLocalTime {@link Integer}
     * @param minuteLocalTime {@link Integer}
     * @param secondLocalTime {@link Integer}
     */
    public static void testRateTblCurrentDataReportLoopback(Integer reportsToFollow, Integer rateParameterSetId,
            Integer year, Integer month, Integer day, Integer hourLocalTime, Integer minuteLocalTime,
            Integer secondLocalTime) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblCurrentDataReport(reportsToFollow,
                rateParameterSetId, year, month, day, hourLocalTime, minuteLocalTime, secondLocalTime);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblCurrentDataReport(testPayload);
        assertEquals(reportsToFollow, (Integer) response.get("REPORTS_TO_FOLLOW"));
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(year, (Integer) response.get("YEAR"));
        assertEquals(month, (Integer) response.get("MONTH"));
        assertEquals(day, (Integer) response.get("DAY"));
        assertEquals(hourLocalTime, (Integer) response.get("HOUR_LOCAL_TIME"));
        assertEquals(minuteLocalTime, (Integer) response.get("MINUTE_LOCAL_TIME"));
        assertEquals(secondLocalTime, (Integer) response.get("SECOND_LOCAL_TIME"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_HISTORICAL_DATA_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param maximumReports {@link Integer}
     * @param rateParameterSetId {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param startDay {@link Integer}
     * @param startHourLocalTime {@link Integer}
     * @param startMinuteLocalTime {@link Integer}
     * @param startSecondLocalTime {@link Integer}
     * @param stopYear {@link Integer}
     * @param stopMonth {@link Integer}
     * @param stopDay {@link Integer}
     * @param stopHourLocalTime {@link Integer}
     * @param stopMinuteLocalTime {@link Integer}
     * @param stopSecondLocalTime {@link Integer}
     */
    public static void testRateTblHistoricalDataGetLoopback(Integer maximumReports, Integer rateParameterSetId,
            Integer startYear, Integer startMonth, Integer startDay, Integer startHourLocalTime,
            Integer startMinuteLocalTime, Integer startSecondLocalTime, Integer stopYear, Integer stopMonth,
            Integer stopDay, Integer stopHourLocalTime, Integer stopMinuteLocalTime, Integer stopSecondLocalTime) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblHistoricalDataGet(maximumReports, rateParameterSetId,
                startYear, startMonth, startDay, startHourLocalTime, startMinuteLocalTime, startSecondLocalTime,
                stopYear, stopMonth, stopDay, stopHourLocalTime, stopMinuteLocalTime, stopSecondLocalTime);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblHistoricalDataGet(testPayload);
        assertEquals(maximumReports, (Integer) response.get("MAXIMUM_REPORTS"));
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(startYear, (Integer) response.get("START_YEAR"));
        assertEquals(startMonth, (Integer) response.get("START_MONTH"));
        assertEquals(startDay, (Integer) response.get("START_DAY"));
        assertEquals(startHourLocalTime, (Integer) response.get("START_HOUR_LOCAL_TIME"));
        assertEquals(startMinuteLocalTime, (Integer) response.get("START_MINUTE_LOCAL_TIME"));
        assertEquals(startSecondLocalTime, (Integer) response.get("START_SECOND_LOCAL_TIME"));
        assertEquals(stopYear, (Integer) response.get("STOP_YEAR"));
        assertEquals(stopMonth, (Integer) response.get("STOP_MONTH"));
        assertEquals(stopDay, (Integer) response.get("STOP_DAY"));
        assertEquals(stopHourLocalTime, (Integer) response.get("STOP_HOUR_LOCAL_TIME"));
        assertEquals(stopMinuteLocalTime, (Integer) response.get("STOP_MINUTE_LOCAL_TIME"));
        assertEquals(stopSecondLocalTime, (Integer) response.get("STOP_SECOND_LOCAL_TIME"));
    }

    /**
     * Performs an in/out test of the RATE_TBL_HISTORICAL_DATA_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param reportsToFollow {@link Integer}
     * @param rateParameterSetId {@link Integer}
     * @param year {@link Integer}
     * @param month {@link Integer}
     * @param day {@link Integer}
     * @param hourLocalTime {@link Integer}
     * @param minuteLocalTime {@link Integer}
     * @param secondLocalTime {@link Integer}
     */
    public static void testRateTblHistoricalDataReportLoopback(Integer reportsToFollow, Integer rateParameterSetId,
            Integer year, Integer month, Integer day, Integer hourLocalTime, Integer minuteLocalTime,
            Integer secondLocalTime) {
        byte[] testPayload = CommandClassRateTblMonitorV1.getRateTblHistoricalDataReport(reportsToFollow,
                rateParameterSetId, year, month, day, hourLocalTime, minuteLocalTime, secondLocalTime);

        Map<String, Object> response = CommandClassRateTblMonitorV1.handleRateTblHistoricalDataReport(testPayload);
        assertEquals(reportsToFollow, (Integer) response.get("REPORTS_TO_FOLLOW"));
        assertEquals(rateParameterSetId, (Integer) response.get("RATE_PARAMETER_SET_ID"));
        assertEquals(year, (Integer) response.get("YEAR"));
        assertEquals(month, (Integer) response.get("MONTH"));
        assertEquals(day, (Integer) response.get("DAY"));
        assertEquals(hourLocalTime, (Integer) response.get("HOUR_LOCAL_TIME"));
        assertEquals(minuteLocalTime, (Integer) response.get("MINUTE_LOCAL_TIME"));
        assertEquals(secondLocalTime, (Integer) response.get("SECOND_LOCAL_TIME"));
    }

}