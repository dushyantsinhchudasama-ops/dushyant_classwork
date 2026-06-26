package com.tss.services;

import com.tss.model.Equipment;

import java.util.ArrayList;
import java.util.List;


public class EquipmentManagementService
{
    private List<Equipment> equipments;

    public EquipmentManagementService()
    {
        equipments = new ArrayList<>();
    }

    public void addEquipment(Equipment equipment)
    {
        equipments.add(equipment);
    }

    public void removeEquipment(String equipmentId)
    {
        equipments.removeIf(
                equipment -> equipment.getEquipmentId().equals(equipmentId));
    }

    public Equipment findEquipmentById(String equipmentId)
    {
        for (Equipment equipment : equipments)
        {
            if (equipment.getEquipmentId().equals(equipmentId))
                return equipment;
        }
        return null;
    }

    public void displayAllEquipments()
    {
        for (Equipment equipment : equipments)
        {
            System.out.println(equipment);
        }
    }
}