package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Address;
import com.Test.HibernateUtil;

public class CDaoAddress {
	private Address address = new Address();
	private List<Address> addresses = new ArrayList<Address>();

	// ---------1.�½�����---------
	public boolean CreateAddress(Address address) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(address);
		try {
			session.getTransaction().commit();
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}

	// ----------2.ɾ������(��������ɾ��)-----------
	public boolean DeleteAddress(int addressid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		address = (Address) session.get(Address.class, addressid);
		session.delete(address);
		try {
			session.getTransaction().commit();
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}

	// ----------3.�������е���-----------
	@SuppressWarnings("unchecked")
	public List<Address> QueryAllAddress() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		addresses = session.createQuery("from Address").list();
		session.getTransaction().commit();
		return addresses;
	}

	// ----------4.��ѯ��������(ͨ��AddressId����)-----------
	public Address QuerySingelAddress(int AddressId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		address = (Address) session.createQuery(
				"from Address A where A.addressId =" + AddressId)
				.uniqueResult();
		session.getTransaction().commit();
		return address;
	}

	// ---------------5.�޸ĵ���-------------
	public boolean UpdateAddress(Address address) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			session.update(address);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.err.println("�޸�ʧ��");
			return false;
		}
		return true;
	}

	// -------6ͨ����ַ��ϸ��Ϣ���ҵ�address---------
	public Address queryAddress(String AddressProvince, String AddressCity,
			String AddressVillage) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Address address = null;
		try {
			Query query = session
					.createQuery("from Address where AddressProvince = ? and AddressCity = ? and AddressVillage = ?");
			query.setParameter(0, AddressProvince);
			query.setParameter(1, AddressCity);
			query.setParameter(2, AddressVillage);
			address = (Address) query.uniqueResult();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	// -------7ͨ��ģ����ׯ�������ҵ�����Ϣ---------
	public Address queryAddressByAddressVillage(String addressVillage) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query = session.createQuery("from Address where AddressVillage like '%"
						+ addressVillage + "%'");
		
		address = (Address) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return address;
	}
}
