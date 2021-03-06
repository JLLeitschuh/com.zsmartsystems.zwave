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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassSecurityPanelModeV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_SECURITY_PANEL_MODE</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSecurityPanelModeV1LoopbackTest {
    /**
     * Performs an in/out test of the SECURITY_PANEL_MODE_SUPPORTED_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param supportedModeBitMask {@link Integer}
     */
    public static void testSecurityPanelModeSupportedReportLoopback(Integer supportedModeBitMask) {
        byte[] testPayload = CommandClassSecurityPanelModeV1.getSecurityPanelModeSupportedReport(supportedModeBitMask);

        Map<String, Object> response = CommandClassSecurityPanelModeV1.handleSecurityPanelModeSupportedReport(testPayload);
        assertEquals(supportedModeBitMask, (Integer) response.get("SUPPORTED_MODE_BIT_MASK"));
    }

    /**
     * Performs an in/out test of the SECURITY_PANEL_MODE_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param mode {@link String}
     */
    public static void testSecurityPanelModeReportLoopback(String mode) {
        byte[] testPayload = CommandClassSecurityPanelModeV1.getSecurityPanelModeReport(mode);

        Map<String, Object> response = CommandClassSecurityPanelModeV1.handleSecurityPanelModeReport(testPayload);
        assertEquals(mode, (String) response.get("MODE"));
    }

    /**
     * Performs an in/out test of the SECURITY_PANEL_MODE_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param mode {@link String}
     */
    public static void testSecurityPanelModeSetLoopback(String mode) {
        byte[] testPayload = CommandClassSecurityPanelModeV1.getSecurityPanelModeSet(mode);

        Map<String, Object> response = CommandClassSecurityPanelModeV1.handleSecurityPanelModeSet(testPayload);
        assertEquals(mode, (String) response.get("MODE"));
    }

}
