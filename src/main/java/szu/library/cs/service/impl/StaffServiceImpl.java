package szu.library.cs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import szu.library.cs.dao.StaffMapper;
import szu.library.cs.pojo.Staff;
import szu.library.cs.service.IStaffService;

@Service("staffService")
public class StaffServiceImpl implements IStaffService {

	@Resource
	private StaffMapper staffDao;
	
	public int deleteByPrimaryKey(Integer staffId) {
		return staffDao.deleteByPrimaryKey(staffId);
	}

	
	public int insert(Staff record) {
		return staffDao.insert(record);
	}

	
	public int insertSelective(Staff record) {
		return staffDao.insertSelective(record);
	}
	
	/**
	 * new staff with auto md5 password
	 * @param staff
	 * @return
	 */
	 public int newStaff(Staff staff) {
			// TODO Auto-generated method stub
			// �û�������ʹ��MD5���μ��ܴ����洢
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			// false ��ʾ������32λ��Hex��, ��Ҳ��encodeHashAsBase64��, Acegi Ĭ������; 
			// true��ʾ������24λ��Base64��
			md5.setEncodeHashAsBase64(false);
			return staffDao.insert(staff);
		}
	
	public Staff selectByPrimaryKey(Integer staffId) {
		return staffDao.selectByPrimaryKey(staffId);
	}

	public int updateByPrimaryKeySelective(Staff record) {
		return staffDao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(Staff record) {
		return staffDao.updateByPrimaryKey(record);
	}


	public Staff getByUsername(String username) {
		return staffDao.getByUsername(username);
	}


	public List getAll() {
		return staffDao.getAll();
	}
	
	public List queryByName(String name){
		return staffDao.queryByName(name);
	}
}
