/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.avmfritz.internal.ahamodel;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * See {@link DevicelistModel}.
 *
 * @author Robert Bausdorf - Initial contribution
 * @author Christoph Weitkamp - Added channel 'voltage'
 */
@XmlRootElement(name = "powermeter")
@XmlType(propOrder = { "voltage", "power", "energy" })
public class PowerMeterModel {
    public static final BigDecimal VOLTAGE_FACTOR = new BigDecimal("0.001");
    public static final BigDecimal POWER_FACTOR = new BigDecimal("0.001");

    private BigDecimal voltage;
    private BigDecimal power;
    private BigDecimal energy;

    public BigDecimal getVoltage() {
        return voltage != null ? VOLTAGE_FACTOR.multiply(voltage) : BigDecimal.ZERO;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getPower() {
        return power != null ? POWER_FACTOR.multiply(power) : BigDecimal.ZERO;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public BigDecimal getEnergy() {
        return energy != null ? energy : BigDecimal.ZERO;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("voltage", getVoltage()).append("power", this.getPower())
                .append("energy", this.getEnergy()).toString();
    }
}
