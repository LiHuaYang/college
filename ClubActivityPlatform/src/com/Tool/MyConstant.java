package com.Tool;

public class MyConstant {
	
	
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����04:32:45
	 *�������� ActivityState
	 *���ܣ��״̬����
	 *������
	 *����ֵ��
	 */
	public static final class ActivityState{
		public static final int SCHEME_STAGE=0;//�߻��׶�
		public static final int SCHEME_AUDIT_STAGE=1;//��˲߻��׶�
		public static final int PLANNING_STAGE=2;//�ƶ����񷽰��׶�
		public static final int PLANNING_AUDIT_STAGE=3;//������񷽰��׶�
		public static final int GOING_STAGE=4;//����н׶�
		public static final int SUMMARY_STAGE=5;//��ܽ�׶�
		public static final int END_STAGE=6;//������׶�
	}
	
	public static final class ActivityType{
		public static final int IN=1;//����
		public static final int	out=0;//����
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����04:31:36
	 *��������BelongType
	 *���ܣ���������
	 *������
	 *����ֵ��
	 */
	public static final class BelongType{
		public static final int ORGANIZATION=2;//��֯
		public static final int DEPARTMENT=0;//����
		public static final int COROORATION=1;//����
	}
	
	public static final class GradeType{
		public static final int MEMBER=1;//��Ա
		public static final int CADRE=2;//�������Ǹ�
		public static final int DEPUTY=3;//���������糤
		public static final int	MINISTER=4;//�������糤
		public static final int	VICE_CHAIRMAN=5;//����ϯ
		public static final int	CHAIRMAN=6;//��ϯ
		public static final int	NOTICE_MANAGER=10;//�������Ա
		public static final int	BULLETIN_MANAGER=11;//�����Ա
		public static final int	EQUIPMENY_MANAGER=12;//���Ĺ���Ա
		public static final int	ECONOMICS_MANAGER=13;//�ʽ����Ա
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����04:33:10
	 *��������MissionType
	 *���ܣ������ܽ�״̬
	 *������
	 *����ֵ��
	 */
	public static final class MissionType{
		public static final int ON=1;//Ҫд
		public static final int	OFF=0;//��Ҫд
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����04:33:37
	 *��������EconomicsRecordType
	 *���ܣ��ʽ��¼״̬
	 *������
	 *����ֵ��
	 */
	public static final class EconomicsRecordType{
		public static final int EXPENDITURE=0;//����
		public static final int INCOME=1;//����
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����04:33:37
	 *��������EquipmentType
	 *���ܣ��ʽ��¼״̬
	 *������
	 *����ֵ��
	 */
	public static final class EquipmentType{
		public static final int LEND=0;//���
		public static final int RETURN=1;//����
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����04:34:49
	 *��������FileType
	 *���ܣ��ļ�״̬
	 *������
	 *����ֵ��
	 */
	public static final class FileType{
		public static final int SCHEME=0;//��߻�
		public static final int APPLICATION=1;//����������
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����04:06:32
	 *��������������
	 *���ܣ�TODO
	 *������
	 *����ֵ��
	 */
	public static final class ExamineType{
		public static final int SUCCESS=0;//�ɹ�
		public static final int FAIL=1;//ʧ��
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����04:08:28
	 *����������Ϣ����
	 *���ܣ�TODO
	 *������
	 *����ֵ��
	 */
	public static final class INFORMATIONCONTENT{
		public static final String JOINPARTSUCCESS="���Ѿ��ɹ�������?����ϲ���Ϊ���ǵ�һԱ��";//���벿�Ż����ųɹ�����֯���� /���� ����
		public static final String JOINPARTFAIL="���ź����㲢û��ͨ�����ǵ���ˣ������Ŭ��������?";//���벿�Ż�����ʧ�ܣ���֯���� /���� ����
		
		public static final String FRIENDSUCCESS="?��������ĺ�������";//�Ӻ��ѳɹ����û�����
		public static final String FRIENDFAIL="?�ܾ�����ĺ�������";//�Ӻ���ʧ�ܣ��û�����
		
		public static final String SELECTACTIVITYPLANCREATOR="��ϲ���Ϊ?����Ϊ@�����񷽰��ƶ��ˣ�";//?��֯��  @����
		public static final String SELECTACTIVITYPLOTTER="?�»�����������Ϊ?����ϲ���Ϊ�»�Ļ�߻��ˣ�";//?��֯��  @����
		
		public static final String CREATESCHEME="?�ı��Ϊ@�Ļ�Ļ�߻��Ѿ��ύ�������գ�";//�ύ�߻���?��֯�� @���ţ�
		public static final String SCHEMESUCCESS="����д��?�ı��Ϊ@�Ļ�Ļ�߻����ͨ����";//�߻����ͨ����?��֯�� @���ţ�
		public static final String SCHEMEFAIL="����д��?�ı��Ϊ@�Ļ�Ļ�߻����δͨ������ȴ��ϼ�ָʾ��";//�߻�δ���ͨ����?��֯�� @���ţ�
		
		public static final String CREATEPLAN="?�ı��Ϊ@�Ļ�����񷽰��Ѿ��ύ�������գ�";//�ύ���񷽰���?��֯�� @���ţ�
		public static final String PLANSUCCESS="����д��?�ı��Ϊ@�Ļ�����񷽰����ͨ����";//���񷽰����ͨ����?��֯�� @���ţ�
		public static final String PLANEFAIL="����д��?�ı��Ϊ@�Ļ�����񷽰����δͨ������ȴ��ϼ�ָʾ��";//���񷽰�δ���ͨ����?��֯�� @���ţ�
		
		public static final String PARTCATIVITYSUCCESS="��ϲ�㣬�ɹ�����?�,�ȴ�������Ϣ";//�ɹ�������?�����
		public static final String ACTIVITYMESSAGE="?����@�����Ա";//���Ϣ,(?��Ϣ����  @���)
		
		public static final String ACTIVITYRESULT="������ܽ�״̬�����ύ��ܽᡣ����?�����Ա��";//��ܽ����ѣ�?�����
		
		public static final String APPLYCORPORATION="?�����������ţ�������";//�������ţ�?��֯����
		public static final String APPLYCORPORATIONSUCCESS="������?���ųɹ�";//�������ţ�?��������
		
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����04:12:00
	 *����������������
	 *���ܣ�TODO
	 *������
	 *����ֵ��
	 */
	public static final class HotNum{
		public static final int HOTACTIVITYNUM=5;//���Ż����
		public static final int HOTCORPORATION=10;//������������
		public static final int HOTNOTICE=5;//���Ų�������
		
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����10:44:13
	 *����������������״̬
	 *���ܣ�TODO
	 *������
	 *����ֵ��
	 */
	public static final class chatbelongType{
		public static final int PEOPLE=0;
		public static final int	MANYPEOPLE=1;
		
	}
	//��֯
	public static final class OrganizeType{
		public static final int STUDENTUNION=1;//ѧ����
		public static final int	FEDERATION=3;//����
		public static final int	YOUTH=2;//��ί
		
		
	}
	public static final class UploadType{
		public static final int USER=0;
		public static final int ACTIVITY=1;
		public static final int CORPORATION=2;
		public static final int DEPARTMENT=3;
		public static final int GRADE=4;
		public static final int NOTICE=5;
		public static final int ORGANIZE=6;
	}
	public static final class UploadUrl{
		public static final String USERURL="img/user/";
		public static final String ACTIVITYURL="img/activity/";
		public static final String CORPORATIONURL="img/corporation/";
		public static final String DEPARTMENTURL="img/department/";
		public static final String GRADEURL="img/gradepic/";
		public static final String NOTICEURL="img/notice/";
		public static final String ORGANIZEURL="img/organize/";
	}
	
}
