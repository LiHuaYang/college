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

	// ---------1.新建地区---------
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

	// ----------2.删除地区(按地区号删除)-----------
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

	// ----------3.查找所有地区-----------
	@SuppressWarnings("unchecked")
	public List<Address> QueryAllAddress() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		addresses = session.createQuery("from Address").list();
		session.getTransaction().commit();
		return addresses;
	}

	// ----------4.查询单个地区(通过AddressId查找)-----------
	public Address QuerySingelAddress(int AddressId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		address = (Address) session.createQuery(
				"from Address A where A.addressId =" + AddressId)
				.uniqueResult();
		session.getTransaction().commit();
		return address;
	}

	// ---------------5.修改地区-------------
	public boolean UpdateAddress(Address address) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			session.update(address);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.err.println("修改失败");
			return false;
		}
		return true;
	}

	// -------6通过地址详细信息查找到address---------
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

	// -------7通过模糊村庄名来查找地区信息---------
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
