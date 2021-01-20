package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomEquipment {
	private	int	RoomEquipmentId	;//	房间设备号
	private	int	Necessities	;//	生活必需品
	private	int	TV	;//	电视
	private	int	AirConditioner	;//	空调
	private	int	Heating	;//	暖气
	private	int	Kitchen	;//	厨房
	private	int	Network	;//	网络
	private	int	HotTub	;//	热水浴缸
	private	int	WashingMachine	;//	洗衣机
	private	int	SwimmingPool	;//	游泳池
	private	int	DryingMachine	;//	烘干机
	private	int	Breakfast	;//	早餐
	private	int	CoatHanger	;//	衣架
	private	int	Iron	;//	熨斗
	private	int	IndoorFirePlace	;//	室内壁炉
	private	int	WheelchairAccessible	;//	无障碍设施
	private	int	PETFacilities	;//	宠物设施
	private	int	WorkingSpace	;//	工作区域
	
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
