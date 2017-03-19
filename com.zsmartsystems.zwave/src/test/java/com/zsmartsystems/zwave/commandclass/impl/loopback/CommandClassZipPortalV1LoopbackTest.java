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
import com.zsmartsystems.zwave.commandclass.impl.CommandClassZipPortalV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_ZIP_PORTAL</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassZipPortalV1LoopbackTest {
    /**
     * Performs an in/out test of the GATEWAY_CONFIGURATION_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param lanIpv6Address {@link byte[]}
     * @param lanIpv6PrefixLength {@link Integer}
     * @param portalIpv6Prefix {@link byte[]}
     * @param portalIpv6PrefixLength {@link Integer}
     * @param defaultGatewayIpv6Address {@link byte[]}
     * @param panIpv6Prefix {@link byte[]}
     */
    public static void testGatewayConfigurationSetLoopback(byte[] lanIpv6Address, Integer lanIpv6PrefixLength,
            byte[] portalIpv6Prefix, Integer portalIpv6PrefixLength, byte[] defaultGatewayIpv6Address,
            byte[] panIpv6Prefix) {
        byte[] testPayload = CommandClassZipPortalV1.getGatewayConfigurationSet(lanIpv6Address, lanIpv6PrefixLength,
                portalIpv6Prefix, portalIpv6PrefixLength, defaultGatewayIpv6Address, panIpv6Prefix);

        Map<String, Object> response = CommandClassZipPortalV1.handleGatewayConfigurationSet(testPayload);
        assertEquals(lanIpv6Address, (byte[]) response.get("LAN_IPV6_ADDRESS"));
        assertEquals(lanIpv6PrefixLength, (Integer) response.get("LAN_IPV6_PREFIX_LENGTH"));
        assertEquals(portalIpv6Prefix, (byte[]) response.get("PORTAL_IPV6_PREFIX"));
        assertEquals(portalIpv6PrefixLength, (Integer) response.get("PORTAL_IPV6_PREFIX_LENGTH"));
        assertEquals(defaultGatewayIpv6Address, (byte[]) response.get("DEFAULT_GATEWAY_IPV6_ADDRESS"));
        assertEquals(panIpv6Prefix, (byte[]) response.get("PAN_IPV6_PREFIX"));
    }

    /**
     * Performs an in/out test of the GATEWAY_CONFIGURATION_STATUS command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param status {@link Integer}
     */
    public static void testGatewayConfigurationStatusLoopback(Integer status) {
        byte[] testPayload = CommandClassZipPortalV1.getGatewayConfigurationStatus(status);

        Map<String, Object> response = CommandClassZipPortalV1.handleGatewayConfigurationStatus(testPayload);
        assertEquals(status, (Integer) response.get("STATUS"));
    }

    /**
     * Performs an in/out test of the GATEWAY_CONFIGURATION_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param lanIpv6Address {@link byte[]}
     * @param lanIpv6PrefixLength {@link Integer}
     * @param portalIpv6Prefix {@link byte[]}
     * @param portalIpv6PrefixLength {@link Integer}
     * @param defaultGatewayIpv6Address {@link byte[]}
     * @param panIpv6Prefix {@link byte[]}
     */
    public static void testGatewayConfigurationReportLoopback(byte[] lanIpv6Address, Integer lanIpv6PrefixLength,
            byte[] portalIpv6Prefix, Integer portalIpv6PrefixLength, byte[] defaultGatewayIpv6Address,
            byte[] panIpv6Prefix) {
        byte[] testPayload = CommandClassZipPortalV1.getGatewayConfigurationReport(lanIpv6Address, lanIpv6PrefixLength,
                portalIpv6Prefix, portalIpv6PrefixLength, defaultGatewayIpv6Address, panIpv6Prefix);

        Map<String, Object> response = CommandClassZipPortalV1.handleGatewayConfigurationReport(testPayload);
        assertEquals(lanIpv6Address, (byte[]) response.get("LAN_IPV6_ADDRESS"));
        assertEquals(lanIpv6PrefixLength, (Integer) response.get("LAN_IPV6_PREFIX_LENGTH"));
        assertEquals(portalIpv6Prefix, (byte[]) response.get("PORTAL_IPV6_PREFIX"));
        assertEquals(portalIpv6PrefixLength, (Integer) response.get("PORTAL_IPV6_PREFIX_LENGTH"));
        assertEquals(defaultGatewayIpv6Address, (byte[]) response.get("DEFAULT_GATEWAY_IPV6_ADDRESS"));
        assertEquals(panIpv6Prefix, (byte[]) response.get("PAN_IPV6_PREFIX"));
    }

}
