package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

//竞赛表
public class Competition {

	private	int	CompetitionId	;//	竞赛id
	private	String	CompetitionName	;//	竞赛名称
	private	int	CompetitionSession	;//	竞赛届数
	private	String	CompetitionInfo	;//	竞赛简介
	private	String	Competitiondetails	;//	竞赛详情
	private String CommitteeName;// 主委会名字
	private String CommitteePhone;// 主委会名字
	private String CommitteeAddress;// 主委会名字
	private String CompetitionSponsor;//主办方
	private	int	ParticularYear	;//	年份
	private	String	CompetitionTimeDescribe	;//	赛事时间说明
	private	String	CompetitionPrize	;//	奖项
	private	String	CompetitionObjectDescribe	;//	参赛对象描述
	private	String	CompetitionPriceDescribe	;//	报名费用说明
	private String CompetitionPicture;           //竞赛图片 200x250
	private String CompetitionPictureBig; // 大赛大图片 1920x480
	

	private String ContestPropaganda;     //宣传语
	private	String	CompetitionEnrollStartTime	;//	赛事开始报名时间
	private	String	CompetitionEnrollEndTime	;//	竞赛结束报名时间
	private int CompetitionState;// 大赛的状态


	public int getCompetitionState() {
		return CompetitionState;
	}

	public void setCompetitionState(int competitionState) {
		CompetitionState = competitionState;
	}

	public Competition(int competitionId, String competitionName,String startTime, 
			String endTime, int competitionSession,String competitionInfo,
			String CommitteeName,String CommitteePhone, String CommitteeAddress, 
			String CompetitionSponsor,int particularYear,String CompetitionTimeDescribe, 
			String CompetitionPrize, String CompetitionObjectDescribe,String CompetitionPriceDescribe) {

		this.CompetitionId = competitionId;
		this.CompetitionName = competitionName;
		this.CompetitionSession = competitionSession;
		this.CompetitionInfo = competitionInfo;
		this.ParticularYear = particularYear;
		this.CommitteeName = CommitteeName;
		this.CommitteePhone = CommitteePhone;
		this.CommitteeAddress = CommitteeAddress;
		this.CompetitionTimeDescribe = CompetitionTimeDescribe;
		this.CompetitionPrize = CompetitionPrize;
		this.CompetitionObjectDescribe = CompetitionObjectDescribe;
		this.CompetitionPriceDescribe = CompetitionPriceDescribe;
	}

	public Competition(String CompetitionName){
		this.CompetitionName=CompetitionName;
	}
	
	public Competition(){}
	
	public Competition(String CompetitionName,String CompetitionInfo){
		this.CompetitionName = CompetitionName;
		this.CompetitionInfo = CompetitionInfo;
	}

	public Competition(int CompetitionId,String CompetitionName,String ContestPropaganda,String CompetitionPicture){
		this.CompetitionId = CompetitionId;
		this.CompetitionName = CompetitionName;
		this.ContestPropaganda = ContestPropaganda;
		this.CompetitionPicture = CompetitionPicture;
	}
	
	public Competition(ResultSet resultSet) throws SQLException{
		this.CompetitionId=resultSet.getInt("Competition");
		this.CompetitionName=resultSet.getString("CompetitionName");
		this.CompetitionSession=resultSet.getInt("CompetitionSession");
		this.CompetitionInfo=resultSet.getString("CompetitionInfo");
		this.ParticularYear=resultSet.getInt("ParticularYear");
	}

	
	public int getCompetitionId() {
		return CompetitionId;
	}

	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}

	public String getCompetitionName() {
		return CompetitionName;
	}

	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}

	public int getCompetitionSession() {
		return CompetitionSession;
	}

	public void setCompetitionSession(int competitionSession) {
		CompetitionSession = competitionSession;
	}

	public String getCompetitionInfo() {   //竞赛简介
		return CompetitionInfo;
	}

	public void setCompetitionInfo(String competitionBriefInfo) {
		CompetitionInfo = competitionBriefInfo;
	}

	public String getCompetitiondetails() {  //竞赛详情
		return Competitiondetails;
	}

	public void setCompetitiondetails(String competitiondetails) {
		Competitiondetails = competitiondetails;
	}
	
	public String getCommitteeName() {
		return CommitteeName;
	}

	public void setCommitteeName(String committeeName) {
		CommitteeName = committeeName;
	}

	public String getCommitteePhone() {
		return CommitteePhone;
	}

	public void setCommitteePhone(String committeePhone) {
		CommitteePhone = committeePhone;
	}

	public String getCommitteeAddress() {
		return CommitteeAddress;
	}

	public void setCommitteeAddress(String committeeAddress) {
		CommitteeAddress = committeeAddress;
	}

	public String getCompetitionSponsor() {
		return CompetitionSponsor;
	}

	public void setCompetitionSponsor(String competitionSponsor) {
		CompetitionSponsor = competitionSponsor;
	}

	public int getParticularYear() {
		return ParticularYear;
	}

	public void setParticularYear(int particularYear) {
		ParticularYear = particularYear;
	}

	public String getCompetitionTimeDescribe() {
		return CompetitionTimeDescribe;
	}

	public void setCompetitionTimeDescribe(String competitionTimeDescribe) {
		CompetitionTimeDescribe = competitionTimeDescribe;
	}

	public String getCompetitionPrize() {
		return CompetitionPrize;
	}

	public void setCompetitionPrize(String competitionPrize) {
		CompetitionPrize = competitionPrize;
	}

	public String getCompetitionObjectDescribe() {
		return CompetitionObjectDescribe;
	}

	public void setCompetitionObjectDescribe(String competitionObjectDescribe) {
		CompetitionObjectDescribe = competitionObjectDescribe;
	}

	public String getCompetitionPriceDescribe() {
		return CompetitionPriceDescribe;
	}

	public void setCompetitionPriceDescribe(String competitionPriceDescribe) {
		CompetitionPriceDescribe = competitionPriceDescribe;
	}

	public String getCompetitionPicture() {
		return CompetitionPicture;
	}

	public void setCompetitionPicture(String competitionpic) {
		CompetitionPicture = competitionpic;
	}

	public String getContestPropaganda() {
		return ContestPropaganda;
	}

	public void setContestPropaganda(String contestPropaganda) {
		ContestPropaganda = contestPropaganda;
	}

	public String getCompetitionEnrollStartTime() {
		return CompetitionEnrollStartTime;
	}

	public void setCompetitionEnrollStartTime(String competitionEnrollStartTime) {
		CompetitionEnrollStartTime = competitionEnrollStartTime;
	}

	public String getCompetitionEnrollEndTime() {
		return CompetitionEnrollEndTime;
	}
	

	public void setCompetitionEnrollEndTime(String competitionEnrollEndTime) {
		CompetitionEnrollEndTime = competitionEnrollEndTime;
	}
	
	public String getCompetitionPictureBig() {
		return CompetitionPictureBig;
	}

	public void setCompetitionPictureBig(String competitionPictureBig) {
		CompetitionPictureBig = competitionPictureBig;
	}

	@Override
	public String toString() {
		return "Competition [CommitteeAddress=" + CommitteeAddress
				+ ", CommitteeName=" + CommitteeName + ", CommitteePhone="
				+ CommitteePhone + ", CompetitionEnrollEndTime="
				+ CompetitionEnrollEndTime + ", CompetitionEnrollStartTime="
				+ CompetitionEnrollStartTime + ", CompetitionId="
				+ CompetitionId + ", CompetitionInfo=" + CompetitionInfo
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionObjectDescribe=" + CompetitionObjectDescribe
				+ ", CompetitionPriceDescribe=" + CompetitionPriceDescribe
				+ ", CompetitionPrize=" + CompetitionPrize
				+ ", CompetitionSession=" + CompetitionSession
				+ ", CompetitionSponsor=" + CompetitionSponsor
				+ ", CompetitionTimeDescribe=" + CompetitionTimeDescribe
				+ ", CompetitionPicture=" + CompetitionPicture + ", ContestPropaganda="
				+ ContestPropaganda + ", ParticularYear=" + ParticularYear
				+ "]";
	}
}
