package com.tss.model;

import com.tss.test.EquipmentStatus;

public abstract class Equipment
{
    private String equipmentId;
    private String equipmentName;
    private EquipmentStatus status;

    public Equipment(String equipmentId, String equipmentName,
                     EquipmentStatus status)
    {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.status = status;
    }

    public String getEquipmentId()
    {
        return equipmentId;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }

    public EquipmentStatus getStatus()
    {
        return status;
    }

    public void setStatus(EquipmentStatus status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Equipment ID = " + equipmentId +
                ", Name = " + equipmentName +
                ", Status = " + status;
    }
}
