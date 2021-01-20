package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomEquipment {
	private	int	RoomEquipmentId	;//	�����豸��
	private	int	Necessities	;//	�������Ʒ
	private	int	TV	;//	����
	private	int	AirConditioner	;//	�յ�
	private	int	Heating	;//	ů��
	private	int	Kitchen	;//	����
	private	int	Network	;//	����
	private	int	HotTub	;//	��ˮԡ��
	private	int	WashingMachine	;//	ϴ�»�
	private	int	SwimmingPool	;//	��Ӿ��
	private	int	DryingMachine	;//	��ɻ�
	private	int	Breakfast	;//	���
	private	int	CoatHanger	;//	�¼�
	private	int	Iron	;//	�ٶ�
	private	int	IndoorFirePlace	;//	���ڱ�¯
	private	int	WheelchairAccessible	;//	���ϰ���ʩ
	private	int	PETFacilities	;//	������ʩ
	private	int	WorkingSpace	;//	��������
	
	public RoomEquipment(){};
	
	public RoomEquipment(int Breakfast, int AirConditioner, int CoatHanger, int DryingMachine, int Heating, int HotTub, int IndoorFirePlace, int Iron, int Kitchen, int Necessities, int Network, int PETFacilities, int SwimmingPool, int TV, int WashingMachine, int WheelchairAccessible, int WorkingSpace){
		this.AirConditioner = AirConditioner; 
		this.Breakfast = Breakfast;
		this.CoatHanger = CoatHanger;
		this.DryingMachine = DryingMachine;
		this.Heating = Heating;
		this.HotTub = HotTub;
		this.IndoorFirePlace = IndoorFirePlace;
		this.Iron = Iron;
		this.Kitchen = Kitchen;
		this.Necessities = Necessities;
		this.Network = Network;
		this.PETFacilities = PETFacilities;
		this.SwimmingPool = SwimmingPool;
		this.TV = TV;
		this.WashingMachine = WashingMachine;
		this.WheelchairAccessible = WheelchairAccessible;
		this.WorkingSpace = WorkingSpace;
	}
	public RoomEquipment(int Breakfast, int AirConditioner, int CoatHanger,
			int DryingMachine, int Heating, int HotTub,
			int IndoorFirePlace, int Iron, int Kitchen, int Necessities,
			int Network, int PETFacilities, int SwimmingPool, int TV,
			int WashingMachine, int WheelchairAccessible, int WorkingSpace,
			int RoomEquipmentId) {
		this.AirConditioner = AirConditioner; 
		this.Breakfast = Breakfast;
		this.CoatHanger = CoatHanger;
		this.DryingMachine = DryingMachine;
		this.Heating = Heating;
		this.HotTub = HotTub;
		this.IndoorFirePlace = IndoorFirePlace;
		this.Iron = Iron;
		this.Kitchen = Kitchen;
		this.Necessities = Necessities;
		this.Network = Network;
		this.PETFacilities = PETFacilities;
		this.SwimmingPool = SwimmingPool;
		this.TV = TV;
		this.WashingMachine = WashingMachine;
		this.WheelchairAccessible = WheelchairAccessible;
		this.WorkingSpace = WorkingSpace;
		this.RoomEquipmentId = RoomEquipmentId;
	}

	@Id
	@GeneratedValue
	public int getRoomEquipmentId() {
		return RoomEquipmentId;
	}
	public void setRoomEquipmentId(int roomEquipmentId) {
		RoomEquipmentId = roomEquipmentId;
	}
	public int getNecessities() {
		return Necessities;
	}
	public void setNecessities(int necessities) {
		Necessities = necessities;
	}
	public int getTV() {
		return TV;
	}
	public void setTV(int tV) {
		TV = tV;
	}
	public int getAirConditioner() {
		return AirConditioner;
	}
	public void setAirConditioner(int airConditioner) {
		AirConditioner = airConditioner;
	}
	public int getHeating() {
		return Heating;
	}
	public void setHeating(int heating) {
		Heating = heating;
	}
	public int getKitchen() {
		return Kitchen;
	}
	public void setKitchen(int kitchen) {
		Kitchen = kitchen;
	}
	public int getNetwork() {
		return Network;
	}
	public void setNetwork(int network) {
		Network = network;
	}
	public int getHotTub() {
		return HotTub;
	}
	public void setHotTub(int hotTub) {
		HotTub = hotTub;
	}
	public int getWashingMachine() {
		return WashingMachine;
	}
	public void setWashingMachine(int washingMachine) {
		WashingMachine = washingMachine;
	}
	public int getSwimmingPool() {
		return SwimmingPool;
	}
	public void setSwimmingPool(int swimmingPool) {
		SwimmingPool = swimmingPool;
	}
	public int getDryingMachine() {
		return DryingMachine;
	}
	public void setDryingMachine(int dryingMachine) {
		DryingMachine = dryingMachine;
	}
	public int getBreakfast() {
		return Breakfast;
	}
	public void setBreakfast(int breakfast) {
		Breakfast = breakfast;
	}
	public int getCoatHanger() {
		return CoatHanger;
	}
	public void setCoatHanger(int coatHanger) {
		CoatHanger = coatHanger;
	}
	public int getIron() {
		return Iron;
	}
	public void setIron(int iron) {
		Iron = iron;
	}
	public int getIndoorFirePlace() {
		return IndoorFirePlace;
	}
	public void setIndoorFirePlace(int indoorFirePlace) {
		IndoorFirePlace = indoorFirePlace;
	}
	public int getWheelchairAccessible() {
		return WheelchairAccessible;
	}
	public void setWheelchairAccessible(int wheelchairAccessible) {
		WheelchairAccessible = wheelchairAccessible;
	}
	public int getPETFacilities() {
		return PETFacilities;
	}
	public void setPETFacilities(int pETFacilities) {
		PETFacilities = pETFacilities;
	}
	public int getWorkingSpace() {
		return WorkingSpace;
	}
	public void setWorkingSpace(int workingSpace) {
		WorkingSpace = workingSpace;
	}
	@Override
	public String toString() {
		return "RoomEquipment [AirConditioner=" + AirConditioner
				+ ", Breakfast=" + Breakfast + ", CoatHanger=" + CoatHanger
				+ ", DryingMachine=" + DryingMachine + ", Heating=" + Heating
				+ ", HotTub=" + HotTub + ", IndoorFirePlace=" + IndoorFirePlace
				+ ", Iron=" + Iron + ", Kitchen=" + Kitchen + ", Necessities="
				+ Necessities + ", Network=" + Network + ", PETFacilities="
				+ PETFacilities + ", RoomEquipmentId=" + RoomEquipmentId
				+ ", SwimmingPool=" + SwimmingPool
				+ ", TV=" + TV + ", WashingMachine=" + WashingMachine
				+ ", WheelchairAccessible=" + WheelchairAccessible
				+ ", WorkingSpace=" + WorkingSpace + "]";
	}

	
	
}
